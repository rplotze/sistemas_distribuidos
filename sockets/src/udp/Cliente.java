
package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class Cliente extends Thread{
    
    private final String HOST = "172.25.3.161";
    private final int PORTA = 12345;
    
    public void enviar(String msg){
        try {
            //converter a mensagem em bytes
            byte[] dados = msg.getBytes();
            
            DatagramPacket pct = new DatagramPacket(
                dados,
                dados.length,
                InetAddress.getByName(HOST),
                PORTA
            );
            new DatagramSocket().send(pct);
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
        }
    }
    
}
