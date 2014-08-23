/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OldGame;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author vi
 */
public class GameCpu extends Game {

    private final CpuIA cpuia;
    private Jogada ultimaJogada;

    public GameCpu(String nick, TelaChooseGame tcg) {
        super(nick, tcg);
        cpuia = new CpuIA(this);
    }

    @Override
    public void start() {
        boolean comeca = new Random().nextInt(2) == 1;
        enemy.setNick("CPU");
        tabuleiroStart();

        player.setPlayer(comeca ? 'x' : 'o', comeca, !comeca, comeca);
        enemy.setPlayer(comeca ? 'o' : 'x', !comeca);
        cpuia.cpuComeca = !comeca;
        telaJogo = new TelaJogo(this);
        telaJogo.setVisible(true);
        if(!comeca) cpuJogada();
    }

    @Override
    public void fazerJogada(Jogada j) {
        if (checkPosition(j) && player.isIsPTurn()) {
            player.setIsPTurn(false);
            enemy.setIsPTurn(true);
            setTabuleiro(j, player.getTag());
            ultimaJogada = j;
        } else if (!checkPosition(j)) {
            JOptionPane.showMessageDialog(null, "Espaço já marcado!");
        } else {
            JOptionPane.showMessageDialog(null, "Aguarde o adversário!");
        }
        if (isEndGame()) {
            endGame();
        }else{
            cpuJogada();
        }
    }

    public void cpuJogada() {
        Jogada j;
        do {
            j = cpuia.cpuTurn();
        } while (!checkPosition(j));
        setTabuleiro(j, enemy.getTag());
        player.setIsPTurn(true);
        enemy.setIsPTurn(false);
        if (isEndGame()) {
            endGame();
        }
    }

    /**
     * @return the ultimaJogada
     */
    public Jogada getUltimaJogada() {
        return ultimaJogada;
    }


}
