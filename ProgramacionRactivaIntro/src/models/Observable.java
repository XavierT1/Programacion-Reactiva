package models;

public interface Observable {

    void notificarTodos ();
    void agregarObserver(Observer observer);
    void removerObserver(Observer observer);
}
