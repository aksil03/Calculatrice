package expression;

import java.util.Stack;

public class NPIcalculator {

    public double evaluerNPI(String expression) {
        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (Character.isDigit(c)) {
                StringBuilder Nbre = new StringBuilder();
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    Nbre.append(expression.charAt(i));
                    i++;
                }
                stack.push(Double.parseDouble(Nbre.toString()));
                i--; // Decremente i pour compenser l'augmentation de i dans la boucle
            } else if (Operateur(c)) {
                double terme_droit = stack.pop();
                double terme_gauche = stack.pop();
                stack.push(AppliquerOperateur(c, terme_gauche, terme_droit));
            }
        }

        return stack.pop();
    }
    
    // Méthode qui permet de désigner les operateurs valides
    private boolean Operateur(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
    
    // Méthode qui permet de faire les operations
    private double AppliquerOperateur(char operateur, double terme_gauche, double terme_droite) {
        switch (operateur) {
            case '+':
                Addition add = new Addition(new Valeur(terme_gauche), new Valeur(terme_droite));
                return add.calcul();
            case '-':
                Soustraction sub = new Soustraction(new Valeur(terme_gauche), new Valeur(terme_droite));
                return sub.calcul();
            case '*':
                Multiplication mull = new Multiplication(new Valeur(terme_gauche), new Valeur(terme_droite));
                return mull.calcul();
            case '/':
                Division div = new Division(new Valeur(terme_gauche), new Valeur(terme_droite));
                return div.calcul();
            default:
                throw new IllegalArgumentException("Operateur invalide: " + operateur);
        }
    }
}