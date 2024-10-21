package fr.univ.lorraine.tp;

import expression.NPIcalculator;
import expression.ShuntingYard;
import fr.univ.lorraine.tp.test.Validators;

public class Calculator {

    public double solve(String equation) throws ArithmeticException {
        
        Validators.validate(equation); // Etape de Validation de l'équation
        
        if (equation.contains("-(-")) {
            equation = equation.replace("(?<![\\d)\\s])-", "+0("); // Si une double négation est trouvée
        }
        
        if (equation.contains("+(+")) {
            equation = equation.replace("+(+", "+0("); // Si un double Plus est trouvée
        }
        char DernierChar = equation.charAt(equation.length() - 1);
        if (DernierChar == '+' || DernierChar == '-') {
            equation += "0"; // Ajoute un "0" après l'opérateur
        }
        if (equation.matches("[+\\-*]") && equation.length() == 1) {
            return 0; // renvoie un "0" si c'est le cas
        }
        if (equation.contains("-")) {
            // Vérifier que "-" n'est pas précédé par un nombre
            equation = equation.replaceAll("(?<!\\d)-", "0-"); //"(?<!\\d)- vérifie que le caractère précédent n'est pas un chiffre 
        }
        try {
            String ExpressionPostfixee = ShuntingYard.infixToNPI(equation);
            // Etape d'évaluation de l'expression NPI
            double resultat = evaluateNPI(ExpressionPostfixee);
            return resultat;
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Equation invalide: " + e.getMessage());
        }
    }
    // Méthode pour évaluer une expression en NPI
    private double evaluateNPI(String expression) {
        NPIcalculator calculateur = new NPIcalculator();
        return calculateur.evaluerNPI(expression);
    }
}