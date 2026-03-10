package org.example.test;

import org.example.entities.*;
import org.example.service.*;


import java.util.Date;

public class Test {

    public static void main(String[] args) {
        SalleService ss = new SalleService();
        MachineService ms = new MachineService();

        // Création et insertion de salles
        Salle salle1 = new Salle("A11");
        Salle salle2 = new Salle("B12");
        ss.create(salle1);
        ss.create(salle2);

        // La création + Insertion de machines
        Machine machine1 = new Machine("MachineHp", new Date(), ss.findById(1));
        Machine machine2 = new Machine("MachineLenovo", new Date(), ss.findById(2));
        ms.create(machine1);
        ms.create(machine2);

        // L'affichage des Salles et de leurs Machines
        for(Salle salle : ss.findAll()) {
            System.out.println("Salle: " + salle.getCode());
            for(Machine machine : salle.getMachines()) {
                System.out.println("  Machine: " + machine.getRef());
            }
        }

        // Utilisation de la méthode findBetweenDate()
        Date d1 = new Date(110, 0, 1); // 1er janvier 2010
        Date d2 = new Date(); // Date actuelle
        System.out.println("Les machines achetés entre  " + d1 + " et " + d2 + ":");
        for(Machine m : ms.findBetweenDate(d1, d2)) {
            System.out.println(m.getRef() + " achetée le " + m.getDateAchat());
        }
    }
}