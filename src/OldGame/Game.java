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
public class Game {
          private char tabuleiro[][];
          private Player player;
          private PlayerBase enemy;
          private TelaInicial tela;
          private TelaJogo telaJogo;
          private final Recebimento receb;
          private Thread thread;
          
          
          public void setPlayerNick(String nickname){
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
          
          public Game(){
                    receb = new Recebimento(this);                    
          }
          
          public void start(){
                    player = new Player("Player 1");
                    enemy = new PlayerBase();
                    thread = new Thread(receb);
                    thread.start();
                    tela = new TelaInicial(this);
                    tela.setVisible(true);
          }
          public void enviar(String msg) throws IOException{
                    Envio.enviar(msg, enemy.getIp());
                    
          }
          
          public void trataRecebimento(Mensagem msg) throws IOException{
                    switch(msg.getFlag()){
                              case 'C':
                                        if(player.isIsWaiting()){
                                                  enemy.setNick(msg.getMsg());
                                                  if(JOptionPane.showConfirmDialog(telaJogo, 
                                                    String.format("O jogador %s te desafia para uma partida. Aceitar?",enemy.getNick())
                                                    ) == 0){
                                                            enviar(String.format("A%s",player.getNick()));
                                                            player.setPlayer('o', false, false, true);
                                                            enemy.setPlayer('x', true);
                                                            tabuleiroStart();
                                                            tela.setVisible(false);
                                                            telaJogo = new TelaJogo(this);
                                                            telaJogo.setVisible(true);
                                                  }else{
                                                            enviar(String.format("N%s",player.getNick()));
                                                  }
                                        }else if(player.isIsPlaying()){
                                                  enviar(String.format("N%s já está jogando", player.getNick()));
                                        }
                                break;
                               case 'A':
                                        if(msg.getSenderIP().equals(enemy.getIp()) &&
                                          player.isIsWaiting()) return;
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
                                         if(!enemy.isIsPTurn() && msg.getSenderIP().equals(enemy.getIp())) return;
                                         int coordx = Integer.parseInt(msg.getMsg().substring(0, 1)),
                                           coordy = Integer.parseInt(msg.getMsg().substring(1, 2));
                                         setTabuleiro(coordx, coordy, enemy.getTag());
                                         player.setIsPTurn(true);
                                         enemy.setIsPTurn(false);
                                         if(isEndGame()) endGame();
                               break;
                               case 'M':
                                         if(msg.getSenderIP().equals(enemy.getIp()))
                                                   JOptionPane.showMessageDialog(telaJogo, msg.getMsg(), 
                                                            String.format("%s:",enemy.getNick()), 1);
                                         break;
                               case 'F':
                                         if(msg.getSenderIP().equals(enemy.getIp()))
                                                   JOptionPane.showMessageDialog(null, "Você ganhou porque "+ enemy.getNick() +" fugiu como uma galinha", 
                                                            "Vitória!", 1);
                                         endGame();
                                         break;
                    }
                    
          }
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
          public void setTabuleiro(int coordx, int coordy, char curTag){
                    if(tabuleiro[coordx][coordy] != player.getTag() && tabuleiro[coordx][coordy] != enemy.getTag()){
                                                   tabuleiro[coordx][coordy] = curTag;
                                                   telaJogo.setTag(coordx,coordy,
                                                     String.valueOf(tabuleiro[coordx][coordy]));
                                         }
          }
          
          public boolean  checkPosition(int x, int y){
                    return tabuleiro[x][y] != 'x' && tabuleiro[x][y] != 'o';
          }
          public void fazerJogada(int x, int y){
                    if(checkPosition(x,y) && player.isIsPTurn()){
                              try{
                                        player.setIsPTurn(false);
                                        enemy.setIsPTurn(true);
                                        setTabuleiro(x, y, player.getTag());
                                        enviar("J"+String.valueOf(x)+String.valueOf(y));
                              }catch(IOException e){
                                        JOptionPane.showMessageDialog(null, "Houve um erro ao enviar a jogada.");
                              }finally{
                                        if(isEndGame()) endGame();
                              }
                    }else if(!checkPosition(x, y)){
                              JOptionPane.showMessageDialog(null, "Espaço já marcado!");
                    }else{
                              JOptionPane.showMessageDialog(null, "Aguarde o adversário!");
                    }
          }
          
          public boolean isEndGame(){
                    if(tabuleiro[0][0] == player.getTag() && tabuleiro[0][1] == player.getTag() && tabuleiro[0][2] == player.getTag()||
                      tabuleiro[1][0] == player.getTag() && tabuleiro[1][1] == player.getTag() && tabuleiro[1][2] == player.getTag() ||
                      tabuleiro[2][0] == player.getTag() && tabuleiro[2][1] == player.getTag() && tabuleiro[2][2] == player.getTag() ||
                      tabuleiro[0][0] == player.getTag() && tabuleiro[1][0] == player.getTag() && tabuleiro[2][0] == player.getTag() ||
                      tabuleiro[0][1] == player.getTag() && tabuleiro[1][1] == player.getTag() && tabuleiro[2][1] == player.getTag() ||
                      tabuleiro[0][2] == player.getTag() && tabuleiro[1][2] == player.getTag() && tabuleiro[2][2] == player.getTag() ||
                      tabuleiro[0][0] == player.getTag() && tabuleiro[1][1] == player.getTag() && tabuleiro[2][2] == player.getTag() ||
                      tabuleiro[0][2] == player.getTag() && tabuleiro[1][1] == player.getTag() && tabuleiro[2][0] == player.getTag()){
                              JOptionPane.showMessageDialog(telaJogo,"PARABÉNS VOCÊ VENCEU!");
                               return true;
                    }else if(tabuleiro[0][0] == enemy.getTag() && tabuleiro[0][1] == enemy.getTag() && tabuleiro[0][2] == enemy.getTag() ||
                      tabuleiro[1][0] == enemy.getTag() && tabuleiro[1][1] == enemy.getTag() && tabuleiro[1][2] == enemy.getTag() ||
                      tabuleiro[2][0] == enemy.getTag() && tabuleiro[2][1] == enemy.getTag() && tabuleiro[2][2] == enemy.getTag() ||
                      tabuleiro[0][0] == enemy.getTag() && tabuleiro[1][0] == enemy.getTag() && tabuleiro[2][0] == enemy.getTag() ||
                      tabuleiro[0][1] == enemy.getTag() && tabuleiro[1][1] == enemy.getTag() && tabuleiro[2][1] == enemy.getTag() ||
                      tabuleiro[0][2] == enemy.getTag() && tabuleiro[1][2] == enemy.getTag() && tabuleiro[2][2] == enemy.getTag() ||
                      tabuleiro[0][0] == enemy.getTag() && tabuleiro[1][1] == enemy.getTag() && tabuleiro[2][2] == enemy.getTag() ||
                      tabuleiro[0][2] == enemy.getTag() && tabuleiro[1][1] == enemy.getTag() && tabuleiro[2][0] == enemy.getTag()){
                              JOptionPane.showMessageDialog(telaJogo,String.format(
                                "Você perdeu, %s venceu... mais sorte na próxima vez...", enemy.getNick()));
                              return true;
                    }
                    for(int i = 0; i < 3; i++){
                              boolean para = false;
                              for(int j = 0; j < 3; j++){
                                   if(tabuleiro[i][j] != player.getTag() && tabuleiro[i][j] != enemy.getTag()){ 
                                             para = true;
                                             break;
                                   }
                              }
                              if(para)break;
                              if(i==2){
                                        JOptionPane.showMessageDialog(telaJogo,"AHHhhh... DEU VELHA! Nem você nem "+enemy.getTag() +" venceeram.");
                                        return true;
                              } 
                    }
                    return false;
          }

          private void tabuleiroStart() {
                    tabuleiro = new char[][]{
                              {'a','a','a'}, {'a','a','a'}, {'a','a','a'}
                              };
          }

}
