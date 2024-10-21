package com.project;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Producte {
    private int id;
    private String nom;
    private PropertyChangeSupport support;


    public Producte(int id, String nom) {
        this.id = id;
        this.nom = nom;
        this.support = new PropertyChangeSupport(this);
    }


    //Setters

    public void setId(int id) {
        int oldId = this.id;
        this.id = id;
        support.firePropertyChange("idProducte", oldId, id);

    }

    public void setNom(String nom) {
        String oldName = this.nom;
        this.nom = nom;
        support.firePropertyChange("nomProducte", oldName, nom);
    }

    //Getters

    public int getId() {
        return this.id ;
    }

    public String getNom() {
        return this.nom ;
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
        sb.append("Id: ").append(this.getId());
        sb.append(" | Nom: ").append(this.getNom());
        return sb.toString();
    }

    
    
}
