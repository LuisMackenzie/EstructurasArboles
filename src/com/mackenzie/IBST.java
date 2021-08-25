package com.mackenzie;

public interface IBST <T extends Comparable>{

    public abstract void insert(T empl);
    public abstract boolean exists(int id);
    public abstract T obtener(int id);
    public abstract boolean esHoja();
    public abstract boolean esVacio();
    public abstract void preorden();
    public abstract void inorden();
    public abstract void postorden();
    public abstract void delete(int id);

}
