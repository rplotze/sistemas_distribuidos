package tcp;

import java.io.Serializable;

public class Mensagem implements Serializable{
    
    private int tipo;
    private String titulo;
    private String corpo;

    public Mensagem() {
    }

    public Mensagem(int tipo, String titulo, String corpo) {
        this.tipo = tipo;
        this.titulo = titulo;
        this.corpo = corpo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCorpo() {
        return corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }

    @Override
    public String toString() {
        return "Mensagem{" + "tipo=" + tipo + ", titulo=" + titulo + ", corpo=" + corpo + '}';
    }
    
}
