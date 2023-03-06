package udp.bidirecional;

public interface IComunicacao {
    
    public final int SERVIDOR_PORTA = 12345;
    public final String SERVIDOR_HOST = "127.0.0.1";
    
    public final int CLIENTE_PORTA = 12346;
    public final String CLIENTE_HOST = "127.0.0.1";
    
    public abstract void enviar(String msg, String host, int porta);
}
