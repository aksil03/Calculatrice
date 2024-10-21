package fr.univ.lorraine.tp;

import java.util.Scanner;

import fr.univ.lorraine.tp.test.Validators;

public class Main {

    public static void main(String[] args) {
        // Création d'une instance de Calculator
        Calculator calculateur = new Calculator();
        // Equation à résoudre tapé sur la console
        Scanner lectureClavier = new Scanner(System.in);
        System.out.println("Entrez l'equation a resoudre : ");
        String equation = lectureClavier.nextLine();
        try {
        // Validation de l'équation
        Validators.validate(equation);
        
        // Resolution de l'équation
        double result = calculateur.solve(equation);
        // Affichage du resultat
        System.out.println("Resultat de l'equation " + equation + " : " + result);
        } catch (ArithmeticException e) {
            // Gestion des exceptions liées à une équation invalide
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}