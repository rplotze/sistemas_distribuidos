package udp.bidirecional;

import javax.swing.JTextArea;

public class Cliente extends Comunicacao {

    public Cliente(JTextArea txt) {
        super(CLIENTE_PORTA, txt);
        exibir("Cliente iniciado na porta " + CLIENTE_PORTA);
    }

}
