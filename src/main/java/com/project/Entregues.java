package com.project;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class Entregues {
    private ArrayList<Producte> productes;
    private PropertyChangeSupport support;

    public Entregues (){
        this.productes = new ArrayList<>();
        this.support = new PropertyChangeSupport(this);
    }

    //Setters
    public void addProducte(Producte producte){
        this.productes.add(producte);
        support.firePropertyChange("entreguesAdd", null, producte.getId());
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
            support.firePropertyChange("entreguesRemove", producteToRemove.getId(), null);
        }
    }
    

    //Getters

    public ArrayList<Producte> getProductes() {
        return this.productes ;
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
        sb.append("Entregues:\n");
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
