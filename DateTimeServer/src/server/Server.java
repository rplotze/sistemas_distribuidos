package server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import service.IDateTimeService;

public class Server extends UnicastRemoteObject
    implements IDateTimeService{
    
    public Server() throws RemoteException{
        super();
    }

    @Override
    public String getData() throws RemoteException {
        return DateTimeFormatter
            .ofPattern("dd/MM/yyyy").format(LocalDate.now());
    }

    @Override
    public String getHora() throws RemoteException {
        return DateTimeFormatter
            .ofPattern("hh:mm:ss").format(LocalTime.now());
    }

    @Override
    public String getIdade(LocalDate dataNascimento) throws RemoteException {
        Period p = Period.between(dataNascimento, LocalDate.now());
        return String.format("%s anos, %s meses e %s dias",
            p.getYears(),p.getMonths(),p.getDays()
        );
    }
    
    public static void main(String[] args) {
        try {
            IDateTimeService srv = new Server();
            Registry rg = LocateRegistry.createRegistry(
                IDateTimeService.PORTA
            );
            rg.bind(IDateTimeService.NOME, srv);
            System.out.println("Servivor em execução");
            //System.out.println(rg);
        } catch (AlreadyBoundException | RemoteException e) {
            System.err.println("");
        }
    }
    
}
