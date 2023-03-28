package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;


public interface IDateTimeService extends Remote {
    
    public final int PORTA = 1099;
    public final String NOME = "Data e Hora";
    public final String URL = "127.0.0.1";
    
    //Assinaturas dos Métodos
    public abstract String getData() throws RemoteException;
    public abstract String getHora() throws RemoteException;
    public abstract String getIdade(LocalDate dataNascimento) 
            throws RemoteException;
    
}
