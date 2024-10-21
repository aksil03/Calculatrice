package expression;
import java.util.Stack;

public class ShuntingYard {

    public static String infixToNPI(String expression) {
        StringBuilder sortie = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (Character.isDigit(c)) {
                StringBuilder Nbre = new StringBuilder();
                // Accumule les chiffres pour former le nombre
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    Nbre.append(expression.charAt(i));
                    i++;
                }
                sortie.append(Nbre).append(' '); // Ajouter le nombre entier à la sortie
                i--; // Decremente le i pour compenser l'augmentation de i dans la boucle
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sortie.append(stack.pop()).append(' ');
                }
                stack.pop();
            } else { // l'Operateur
                while (!stack.isEmpty() && prioriteOperatoire(c) <= prioriteOperatoire(stack.peek())) {
                    sortie.append(stack.pop()).append(' ');
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            sortie.append(stack.pop()).append(' ');
        }

        return sortie.toString().trim(); //Supprime les espaces en trop
    }
    private static int prioriteOperatoire(char operateur) {
        switch (operateur) {
            case '+':
                return 1;
            case '-':
                return 2;
            case '*':
                 return 3;
            case '/':
                return 4;
            default:
                return 0; // permet de mettre les parentheses comme ayant la plus faible priorité
        }
    }
}