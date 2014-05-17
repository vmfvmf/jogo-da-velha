/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OldGame;

/**
 *
 * @author vi
 */
public class Player extends PlayerBase {
          private boolean isWaiting, isPlaying;
          
          public Player(String nick){
                    setNick(nick);
                    isPlaying = false;
          }
          public void setPlayer(char tag, boolean isPTurn, boolean isWaiting, boolean IsPlaying){
                    super.setPlayer(tag, isPTurn);
                    setIsPlaying(isPlaying);
                    setIsWaiting(isWaiting);
          }

          public void endGame(){
                    setIsPlaying(false);
                    setIsWaiting(false);
          }
          /**
           * @return the isWaiting
           */
          public boolean isIsWaiting() {
                    return isWaiting;
          }

          /**
           * @param isWaiting the isWaiting to set
           */
          public void setIsWaiting(boolean isWaiting) {
                    this.isWaiting = isWaiting;
          }

          /**
           * @return the isPlaying
           */
          public boolean isIsPlaying() {
                    return isPlaying;
          }

          /**
           * @param isPlaying the isPlaying to set
           */
          public void setIsPlaying(boolean isPlaying) {
                    this.isPlaying = isPlaying;
          }
}
