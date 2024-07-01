package controllers;

import models.ObserverClass;
import models.SubjectObservable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Controlador {

    int contadorHiloUsuario = 0;
    SubjectObservable sistemaVenta;

    ExecutorService executors = Executors.newSingleThreadExecutor();


    public Controlador(){
        sistemaVenta = new SubjectObservable();
    }

    public void crearHiloUsuario(){
        ObserverClass nuevoUsuario = new ObserverClass(contadorHiloUsuario++);
        executors.submit(nuevoUsuario);
        sistemaVenta.agregarObserver(nuevoUsuario);
    }

    public String listarHiloUsuario(){
        return sistemaVenta.listarConexiones();
    }

    public void comprarTickets(int numeroTickets){
        ObserverClass primerHilo = (ObserverClass) sistemaVenta.getPoolUsuarios().getFirst();
        primerHilo.notificar();
        sistemaVenta.getPoolUsuarios().remove(primerHilo);
        sistemaVenta.setTotalTickets(sistemaVenta.getTotalTickets() - numeroTickets);
    }

    public void evaluarTickets(){
        if(sistemaVenta.getTotalTickets() <= 0){
            sistemaVenta.notificarTodos();
        }
    }

    public int getTotalTickets(){
        return sistemaVenta.getTotalTickets();
    }

}
