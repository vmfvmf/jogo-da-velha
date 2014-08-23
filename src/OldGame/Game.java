/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OldGame;

import javax.swing.JOptionPane;

/**
 *
 * @author vi
 */
public class Game {

    protected char tabuleiro[][];
    protected Player player;
    protected PlayerBase enemy;
    protected TelaJogo telaJogo;
    protected  TelaChooseGame tcg;
    
    public void setPlayerNick(String nickname) {
        player.setNick(nickname);
    }

    public PlayerBase getEnemy() {
        return enemy;
    }

    public Player getPlayer() {
        return player;
    }

    /**
     * @return the tabuleiro
     */
    public char[][] getTabuleiro() {
        return tabuleiro;
    }

    public Game(String nick, TelaChooseGame tcg){
        this.player = new Player(nick);
        this.tcg = tcg;
        enemy = new PlayerBase();
    }

    public void start() {
    }

    public void endGame() {
        player.endGame();
        telaJogo.dispose();
        tcg.setVisible(true);
    }

    public void setTabuleiro(Jogada j, char curTag) {
        if (tabuleiro[j.getX()][j.getY()] != player.getTag() && tabuleiro[j.getX()][j.getY()] != enemy.getTag()) {
            tabuleiro[j.getX()][j.getY()] = curTag;
            telaJogo.setTag(j.getX(), j.getY(),
                    String.valueOf(tabuleiro[j.getX()][j.getY()]));
        }
    }

    public boolean checkPosition(Jogada j) {
        if(j.getX() == -1 || j.getY() == -1) return 1 == 2;
        return tabuleiro[j.getX()][j.getY()] != 'x' && tabuleiro[j.getX()][j.getY()] != 'o';
    }


    public void fazerJogada(Jogada j) {
        
    }

    public boolean isEndGame() {
        if (tabuleiro[0][0] == player.getTag() && tabuleiro[0][1] == player.getTag() && tabuleiro[0][2] == player.getTag()
                || tabuleiro[1][0] == player.getTag() && tabuleiro[1][1] == player.getTag() && tabuleiro[1][2] == player.getTag()
                || tabuleiro[2][0] == player.getTag() && tabuleiro[2][1] == player.getTag() && tabuleiro[2][2] == player.getTag()
                || tabuleiro[0][0] == player.getTag() && tabuleiro[1][0] == player.getTag() && tabuleiro[2][0] == player.getTag()
                || tabuleiro[0][1] == player.getTag() && tabuleiro[1][1] == player.getTag() && tabuleiro[2][1] == player.getTag()
                || tabuleiro[0][2] == player.getTag() && tabuleiro[1][2] == player.getTag() && tabuleiro[2][2] == player.getTag()
                || tabuleiro[0][0] == player.getTag() && tabuleiro[1][1] == player.getTag() && tabuleiro[2][2] == player.getTag()
                || tabuleiro[0][2] == player.getTag() && tabuleiro[1][1] == player.getTag() && tabuleiro[2][0] == player.getTag()) {
            JOptionPane.showMessageDialog(telaJogo, "PARABÉNS VOCÊ VENCEU!");
            return true;
        } else if (tabuleiro[0][0] == enemy.getTag() && tabuleiro[0][1] == enemy.getTag() && tabuleiro[0][2] == enemy.getTag()
                || tabuleiro[1][0] == enemy.getTag() && tabuleiro[1][1] == enemy.getTag() && tabuleiro[1][2] == enemy.getTag()
                || tabuleiro[2][0] == enemy.getTag() && tabuleiro[2][1] == enemy.getTag() && tabuleiro[2][2] == enemy.getTag()
                || tabuleiro[0][0] == enemy.getTag() && tabuleiro[1][0] == enemy.getTag() && tabuleiro[2][0] == enemy.getTag()
                || tabuleiro[0][1] == enemy.getTag() && tabuleiro[1][1] == enemy.getTag() && tabuleiro[2][1] == enemy.getTag()
                || tabuleiro[0][2] == enemy.getTag() && tabuleiro[1][2] == enemy.getTag() && tabuleiro[2][2] == enemy.getTag()
                || tabuleiro[0][0] == enemy.getTag() && tabuleiro[1][1] == enemy.getTag() && tabuleiro[2][2] == enemy.getTag()
                || tabuleiro[0][2] == enemy.getTag() && tabuleiro[1][1] == enemy.getTag() && tabuleiro[2][0] == enemy.getTag()) {
            JOptionPane.showMessageDialog(telaJogo, String.format(
                    "Você perdeu, %s venceu... mais sorte na próxima vez...", enemy.getNick()));
            return true;
        }
        for (int i = 0; i < 3; i++) {
            boolean para = false;
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j] != player.getTag() && tabuleiro[i][j] != enemy.getTag()) {
                    para = true;
                    break;
                }
            }
            if (para) {
                break;
            }
            if (i == 2) {
                JOptionPane.showMessageDialog(telaJogo, "AHHhhh... DEU VELHA! Nem você nem " + enemy.getTag() + " venceeram.");
                return true;
            }
        }
        return false;
    }

    protected void tabuleiroStart() {
        tabuleiro = new char[][]{
            {'a', 'a', 'a'}, {'a', 'a', 'a'}, {'a', 'a', 'a'}
        };
    }
}
