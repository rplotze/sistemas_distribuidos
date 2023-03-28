package tcp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.JTextArea;

public class Cliente extends Comunicacao implements Runnable {

    public Cliente(JTextArea txt) {
        super(txt);
    }

    @Override
    public void run() {
        try {
            Socket con = new Socket(HOST, PORTA);
            exibir("Conectado no servidor na porta " + PORTA);

            saida = new ObjectOutputStream(con.getOutputStream());
            entrada = new ObjectInputStream(con.getInputStream());

            Mensagem obj;
            do {
                obj = (Mensagem) entrada.readObject();
                exibir("Título: ", obj.getTitulo());
                exibir("Corpo: ", obj.getCorpo() + "\n");
            } while (obj.getTipo() != -1);
            entrada.close();
            saida.close();
            con.close();

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("ERRO: " + e.getMessage());
        }
    }

}
