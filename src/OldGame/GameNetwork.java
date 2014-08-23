/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OldGame;

import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author vi
 */
public class GameNetwork extends Game {

    private final Recebimento receb;
    private Thread thread;
    private TelaInicial tela;

    public GameNetwork(String nick, TelaChooseGame tcg) {
        super(nick, tcg);
        receb = new Recebimento(this);
        tela = new TelaInicial(this);
        //tela.
    }

    @Override
    public void start() {
        thread = new Thread(receb);
        thread.start();
        tela.setVisible(true);
    }

    public void enviar(String msg) throws IOException {
        Envio.enviar(msg, enemy.getIp());

    }

    public void trataRecebimento(Mensagem msg) throws IOException {
        switch (msg.getFlag()) {
            case 'C':
                if (player.isIsWaiting()) {
                    enemy.setNick(msg.getMsg());
                    if (JOptionPane.showConfirmDialog(telaJogo,
                            String.format("O jogador %s te desafia para uma partida. Aceitar?", enemy.getNick())
                    ) == 0) {
                        enviar(String.format("A%s", player.getNick()));
                        player.setPlayer('o', false, false, true);
                        enemy.setPlayer('x', true);
                        tabuleiroStart();
                        tela.setVisible(false);
                        telaJogo = new TelaJogo(this);
                        telaJogo.setVisible(true);
                    } else {
                        enviar(String.format("N%s", player.getNick()));
                    }
                } else if (player.isIsPlaying()) {
                    enviar(String.format("N%s já está jogando", player.getNick()));
                }
                break;
            case 'A':
                if (msg.getSenderIP().equals(enemy.getIp())
                        && player.isIsWaiting()) {
                    return;
                }
                tabuleiroStart();
                player.setPlayer('x', true, false, true);
                enemy.setPlayer('o', false);
                enemy.setNick(msg.getMsg());
                tela.setVisible(false);
                telaJogo = new TelaJogo(this);
                telaJogo.setVisible(true);
                break;
            case 'N':
                JOptionPane.showMessageDialog(telaJogo, String.format(
                        "O jogador %s recusou o desafio", msg.getMsg()));
                break;
            case 'J':
                if (!enemy.isIsPTurn() && msg.getSenderIP().equals(enemy.getIp())) {
                    return;
                }
                Jogada j = new Jogada(Integer.parseInt(msg.getMsg().substring(0, 1)),
                        Integer.parseInt(msg.getMsg().substring(1, 2)));
                setTabuleiro(j, enemy.getTag());
                player.setIsPTurn(true);
                enemy.setIsPTurn(false);
                if (isEndGame()) {
                    endGame();
                }
                break;
            case 'M':
                if (msg.getSenderIP().equals(enemy.getIp())) {
                    JOptionPane.showMessageDialog(telaJogo, msg.getMsg(),
                            String.format("%s:", enemy.getNick()), 1);
                }
                break;
            case 'F':
                if (msg.getSenderIP().equals(enemy.getIp())) {
                    JOptionPane.showMessageDialog(null, "Você ganhou porque " + enemy.getNick() + " fugiu como uma galinha",
                            "Vitória!", 1);
                }
                endGame();
                break;
        }

    }

    @Override
    public void endGame(){
                   telaJogo.setVisible(false);
                   player.endGame();
                   tabuleiro = new char[3][3];
                   tela.dispose();
                   tela = new TelaInicial(this);
                   telaJogo.dispose();
                   telaJogo = new TelaJogo(this);
                   tela.setVisible(true);
          }
    
    @Override
    public void fazerJogada(Jogada j) {
        if (checkPosition(j) && player.isIsPTurn()) {
            try {
                player.setIsPTurn(false);
                enemy.setIsPTurn(true);
                setTabuleiro(j, player.getTag());
                enviar("J" + String.valueOf(j.getX()) + String.valueOf(j.getY()));
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Houve um erro ao enviar a jogada.");
            } finally {
                if (isEndGame()) {
                    endGame();
                }
            }
        } else if (!checkPosition(j)) {
            JOptionPane.showMessageDialog(null, "Espaço já marcado!");
        } else {
            JOptionPane.showMessageDialog(null, "Aguarde o adversário!");
        }
    }
}
