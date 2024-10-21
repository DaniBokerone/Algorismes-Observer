package com.project;

public class Main {
    public static void main(String[] args) {
        
        Producte p0 = new Producte(0, "Llibre");
        Producte p1 = new Producte(1, "Boli");
        Producte p2 = new Producte(2, "Rotulador");
        Producte p3 = new Producte(3, "Carpeta");
        Producte p4 = new Producte(4, "Motxilla");
 
        
        Entregues entregues = new Entregues();
        Magatzem magatzem = new Magatzem(entregues);
 
        // Aquí afegir els property listeners adequats
        p0.addPropertyChangeListener(evt -> 
        System.out.println("Producte ha canviat el nom de '" + evt.getOldValue() + "' a '" + evt.getNewValue()+"'"));

        p1.addPropertyChangeListener(evt -> 
        System.out.println("Producte ha canviat el nom de '" + evt.getOldValue() + "'' a '" + evt.getNewValue()+"'" ));

        magatzem.addPropertyChangeListener(evt -> {
            if ("magatzemAdd".equals(evt.getPropertyName())) {
                System.out.println("S'ha afegit el producte amb id '" + evt.getNewValue() + "' al magatzem, capacitat: " + magatzem.getCapacitat());
            } else if ("magatzemRemove".equals(evt.getPropertyName())) {
                System.out.println("S'ha mogut el producte amd id '" + evt.getOldValue() + "' del magatzem cap a les entregues");
            } 
        });

        entregues.addPropertyChangeListener(evt -> {
            if ("entreguesAdd".equals(evt.getPropertyName())) {
                System.out.println("S'ha afegit el producte amb id '" + evt.getNewValue() + "' al la llista d'entregues");
            } else if ("entreguesRemove".equals(evt.getPropertyName())) {
                System.out.println("S'ha entregat el producte amb id '" + evt.getOldValue() + "'");
            } 
        });
        
        p0.setId(5);
        p0.setNom("Llibreta");
        p1.setNom("Boli");
 
        magatzem.addProducte(p0);
        magatzem.addProducte(p1);
        magatzem.addProducte(p2);
        magatzem.addProducte(p3);
        magatzem.addProducte(p4);
 
        magatzem.removeProducte(2);
        magatzem.removeProducte(3);
        magatzem.removeProducte(4);
 
        entregues.removeProducte(2);
        entregues.removeProducte(3);
 
        System.out.println(magatzem);
        System.out.println("---------------------------");
        System.out.println(entregues);

    }

   
}
