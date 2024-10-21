package fr.univ.lorraine.tp.test;

public class VerifierParentheseValide {

    public boolean validerParentheses(String equation) {
        int compteur = 0;
        
        for (char c : equation.toCharArray()) {
            if (c == '(') {
                compteur++;
            } else if (c == ')') {
                compteur--;
                if (compteur < 0) {
                    return false;
                }
            }
        }
        return compteur == 0;
    }
}