package models;

import java.util.ArrayList;
import java.util.List;
import models.Observer;

public class SubjectObservable implements Observable{

    int totalTickets = 100;
    List<Observer> poolObservers = new ArrayList();

    public String listarConexiones(){
        String listado = "";
        for(Observer observer:poolObservers){
            listado = listado + observer.toString() + "\n";
        }
        return listado;
    }


    public SubjectObservable() {
    }

    public int getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }

    public List<Observer> getPoolUsuarios() {
        return poolObservers;
    }


    @Override
    public void agregarObserver(Observer observer) {
        poolObservers.add(observer);
    }

    @Override
    public void removerObserver(Observer observer) {
        poolObservers.remove(observer);
    }

    @Override
    public void notificarTodos() {
        for(Observer observer:poolObservers) {
            observer.notificar();
    }
    }

}

