package com.project;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class Magatzem {
    private ArrayList<Producte> productes;
    private int capacitat;
    private Entregues entregues;
    private PropertyChangeSupport support;

    public Magatzem (Entregues entregues){
        this.productes = new ArrayList<>(10);
        this.capacitat = 10;
        this.support = new PropertyChangeSupport(this);
        this.entregues = entregues;
    }
    
    //Setters
    public void addProducte(Producte producte){
        if (this.productes.size()+1 <= this.capacitat) {
            this.productes.add(producte);
            setCapacitat(getCapacitat()-1);
            support.firePropertyChange("magatzemAdd", null, producte.getId());
        }
    }

    public void removeProducte(int id){
        
        Producte producteToRemove = null; 
        for (Producte producte : this.productes) {
            if (producte.getId() == id) {
                producteToRemove = producte; 
                break; 
            }
        }

        if (producteToRemove != null) {
            this.productes.remove(producteToRemove);
            setCapacitat(getCapacitat()+1);
            entregues.addProducte(producteToRemove);
            support.firePropertyChange("magatzemRemove", producteToRemove.getId(), null);
        }
    }
    

    public void setCapacitat(int capacitat) {
        int oldCapacitat = this.capacitat;
        this.capacitat = capacitat ;
        support.firePropertyChange("capacitatMagatzem", oldCapacitat, capacitat);
    }    

    //Getters

    public ArrayList<Producte> getProductes() {
        return this.productes ;
    }

    public int getCapacitat() {
        return this.capacitat ;
    }

    //Listeners
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Magatzem:\n");
        sb.append("    Capacitat: ").append(this.capacitat).append("\n");
        sb.append("    Productes: \n");

        if (this.productes.isEmpty()) {
            sb.append("    (Cap producte)\n");
        } else {
            for (Producte producte : this.productes) {
                sb.append("    -").append(producte.toString()).append("\n");
            }
        }

        sb.append("");
        return sb.toString();
    }


}
