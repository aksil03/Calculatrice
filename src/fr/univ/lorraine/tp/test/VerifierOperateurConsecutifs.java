package fr.univ.lorraine.tp.test;

public class VerifierOperateurConsecutifs {
    public boolean validerOperateurConsécutif(String equation) {
        for (int i = 0; i < equation.length() - 1; i++) {
            char CharActuel = equation.charAt(i);
            char CharSuivant = equation.charAt(i + 1);
            if (estOperateur(CharActuel) && estOperateur(CharSuivant)) {
                return false;
            }
        }
        return true;
    }
    private boolean estOperateur(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
}