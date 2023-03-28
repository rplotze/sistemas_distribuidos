package udp.bidirecional;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import javax.swing.JTextArea;

/**
 *
 * @author Sistemas Distribuídos
 */
public class Comunicacao implements Runnable, IComunicacao {

    private final JTextArea TXT;
    private final int PORTA;

    public Comunicacao(int PORTA, JTextArea txt) {
        this.TXT = txt;
        this.PORTA = PORTA;
    }

    public void exibir(String msg) {
        this.TXT.append(msg);
        this.TXT.append("\n");
    }

    public void exibir(String msg1, String msg2) {
        this.TXT.append(msg1 + "\t" + msg2);
        this.TXT.append("\n");
    }

    @Override
    public void run() {
        try {
            DatagramSocket s = new DatagramSocket(PORTA);

            while (true) {
                byte[] msg = new byte[256];

                DatagramPacket pct = new DatagramPacket(
                        msg,
                        msg.length
                );
                s.receive(pct);
                String dados = new String(pct.getData()).trim();
                exibir("DE", "MSG");
                exibir(pct.getAddress().getHostAddress(), dados + "\n");
            }

        } catch (IOException e) {
            System.err.println("ERRO: " + e.getMessage());
        }
    }

    @Override
    public void enviar(String msg, String host, int porta) {
        try {
            byte[] dados = msg.getBytes();

            DatagramPacket pct = new DatagramPacket(
                    dados,
                    dados.length,
                    InetAddress.getByName(host),
                    porta
            );
            new DatagramSocket().send(pct);
        } catch (IOException e) {
            System.err.println("ERRO: " + e.getMessage());
        }
    }

}
