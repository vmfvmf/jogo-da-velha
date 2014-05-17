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
public class PlayerBase {
          private char tag;
          private String nick, ip;
          private boolean isPTurn;
          
          
          public void setPlayer(char tag, boolean isPTurn){
                    setTag(tag);
                    setIsPTurn(isPTurn);
          }
          
          public boolean isX(){
                    return tag == 'x';
          }
          
          /**
           * @return the tag
           */
          public char getTag() {
                    return tag;
          }

          /**
           * @param tag the tag to set
           */
          public void setTag(char tag) {
                    this.tag = tag;
          }

          /**
           * @return the nick
           */
          public String getNick() {
                    return nick;
          }

          /**
           * @param nick the nick to set
           */
          public void setNick(String nick) {
                    this.nick = nick;
          }

          /**
           * @return the ip
           */
          public String getIp() {
                    return ip;
          }

          /**
           * @param ip the ip to set
           */
          public void setIp(String ip) {
                    this.ip = ip;
          }

          /**
           * @return the isPTurn
           */
          public boolean isIsPTurn() {
                    return isPTurn;
          }

          /**
           * @param isPTurn the isPTurn to set
           */
          public void setIsPTurn(boolean isPTurn) {
                    this.isPTurn = isPTurn;
          }
}
