/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OldGame;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vi
 */
public class Recebimento  implements Runnable{
    Mensagem m;
    Game g;
    Initiater ini;
    Responder resp;
    byte msg_rec[] ;
    
    public Recebimento(GameNetwork g){
              this.g = g;
              ini  = new Initiater();
              resp = new Responder(g);
              ini.addListener(resp);
    }
    
    @Override
    public void run() {
        try {
                   DatagramSocket conexao = new DatagramSocket(7690);
            do{
                    msg_rec= new byte[1000];
                    DatagramPacket pacotinho = new DatagramPacket(msg_rec, msg_rec.length);

                    try {
                                conexao.receive(pacotinho);
                    } catch (IOException ex) {
                                Logger.getLogger(Envio.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    m = new Mensagem(new String(pacotinho.getData()).trim(), 
                      pacotinho.getAddress().toString().split("/")[1]);
                    System.out.println("Mensagem recebida: " + m.getFlag()+m.getMsg());
                    
                    if(!g.getPlayer().isIsPlaying()) 
                              g.getEnemy().setIp(m.getSenderIP());

                    ini.gotMessage(m);
                    
            }while(true);
        } catch (SocketException ex) {
           // Logger.getLogger(Envio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

interface HelloListener {
    public void avisaMsgRecebida(Mensagem msg);
}


class Initiater {
    List<HelloListener> listeners = new ArrayList<>();

    public void addListener(HelloListener toAdd) {
        listeners.add(toAdd);
    }

    public void gotMessage(Mensagem msg) {
        
        // Notify everybody that may be interested.
        for (HelloListener hl : listeners){
                  hl.avisaMsgRecebida(msg);         
        }
    }
    
}


class Responder implements HelloListener {
          private GameNetwork g;
          public Responder(GameNetwork g){
                    this.g = g;
          }
    @Override
    public void avisaMsgRecebida(Mensagem msg) {
                    try {
                              g.trataRecebimento(msg);
                    } catch (IOException ex) {
                              Logger.getLogger(Responder.class.getName()).log(Level.SEVERE, null, ex);
                    }
    }
}
