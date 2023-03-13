package tcp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JTextArea;

public class Servidor extends Comunicacao implements Runnable{
    
    public Servidor(JTextArea txt){
        super(txt);
    }

    @Override
    public void run(){
        try {
            //Servidor do tipo TCP
            ServerSocket srv = new ServerSocket(PORTA);
            exibir("Servidor iniciado na porta " + PORTA);
            
            while(true){
                exibir("Aguardando conexão...");
                Socket con = srv.accept();
                
                //Fluxos de Comunicação
                saida = new ObjectOutputStream(con.getOutputStream());
                entrada = new ObjectInputStream(con.getInputStream());
                exibir("Cliente conectado: " + con.getInetAddress().getHostAddress());
                
                Mensagem obj;
                do{
                    obj = (Mensagem)entrada.readObject();
                    exibir("Título: ", obj.getTitulo());
                    exibir("Corpo: ", obj.getCorpo()  + "\n");
                }while(obj.getTipo() != -1);
                entrada.close();
                saida.close();
                con.close();
            }
            
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("ERRO: " + e.getMessage());
        }     
    }
    
}