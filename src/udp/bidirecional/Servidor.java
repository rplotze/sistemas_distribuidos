package udp.bidirecional;

import javax.swing.JTextArea;

public class Servidor extends Comunicacao {

    public Servidor(JTextArea txt) {
        super(SERVIDOR_PORTA, txt);
        exibir("Servidor iniciado na porta " + SERVIDOR_PORTA);
    }

}
