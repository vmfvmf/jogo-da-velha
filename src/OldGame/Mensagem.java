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
public class Mensagem {
    private String msg, senderIP;
    private char flag;
    
    public Mensagem(String msg, String ipAdds){
        this.msg = msg.substring(1);
        this.flag = msg.charAt(0);
        this.senderIP = ipAdds;
    }
    
    @Override
    public String toString(){
        return      this.getMsg()+"\nSender:"+this.getSenderIP();
    }

          /**
           * @return the msg
           */
          public String getMsg() {
                    return msg;
          }

          /**
           * @param msg the msg to set
           */
          public void setMsg(String msg) {
                    this.msg = msg;
          }

          /**
           * @return the senderIP
           */
          public String getSenderIP() {
                    return senderIP;
          }

          /**
           * @param senderIP the senderIP to set
           */
          public void setSenderIP(String senderIP) {
                    this.senderIP = senderIP;
          }

          /**
           * @return the flag
           */
          public char getFlag() {
                    return flag;
          }

          /**
           * @param flag the flag to set
           */
          public void setFlag(char flag) {
                    this.flag = flag;
          }
}
