package fr.univ.lorraine.tp.test;

public class VerifierParentheseVide {

    public boolean validerParenthesesVides(String equation) {
        return !equation.contains("()");
    }
}