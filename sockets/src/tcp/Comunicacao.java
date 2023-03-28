package tcp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JTextArea;

public class Comunicacao implements IComunicacao {

    protected ObjectInputStream entrada;
    protected ObjectOutputStream saida;
    private final JTextArea txt;

    public Comunicacao(JTextArea txt) {
        this.txt = txt;
    }

    public void exibir(String msg) {
        this.txt.append(msg);
        this.txt.append("\n");
    }

    public void exibir(String msg1, String msg2) {
        this.txt.append(msg1 + "\t" + msg2);
        this.txt.append("\n");
    }
    
    public void enviar(Mensagem obj){
        try {
            saida.writeObject(obj);
            saida.flush();
        } catch (IOException e) {
            System.err.println("ERRO: " + e.getMessage());
        }
    }

}
