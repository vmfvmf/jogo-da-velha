package OldGame;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author vi
 */
public class Envio {
    
    public static void enviar(String msg, String ipAddr) throws IOException{
        try {
            InetAddress ippp = null;
            byte msg_envio[] = msg.getBytes();
            DatagramPacket pacotinho;
            DatagramSocket conexao;
                    
            try {
                ippp = InetAddress.getByName(ipAddr);
            } catch (UnknownHostException ex) {
               Logger.getLogger(Envio.class.getName()).log(Level.SEVERE, null, ex);
            }
            conexao = new DatagramSocket();
            pacotinho = new DatagramPacket(msg_envio, msg_envio.length, ippp, 7690);
            try {
                conexao.send(pacotinho);
            } catch (IOException ex) {
                Logger.getLogger(Envio.class.getName()).log(Level.SEVERE, null, ex);
            }
            //JOptionPane.showMessageDialog(null, msg);
            System.out.println("Mensagem enviada: "+msg);
        } catch (SocketException ex) {
            Logger.getLogger(Envio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
