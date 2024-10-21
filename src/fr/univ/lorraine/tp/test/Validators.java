package fr.univ.lorraine.tp.test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Validators {
    @Test
    public void testParenthesemalEquilibre(){
        assertThrows(ArithmeticException.class, () -> validate("(2+4)*5)"));
    }
    @Test
    public void testCharacterInvalide(){
        assertThrows(ArithmeticException.class, () -> validate("a"));
    } 
    @Test
    public void testParenthesesVides() {
        assertThrows(ArithmeticException.class, () -> validate("()*5"));
    }
    @Test
    public void testDeuxOperateursDeSuite() {
        assertThrows(ArithmeticException.class, () -> validate("(5++5)*9"));
    }
    @Test
    public void testSeulementEspace() {
    	assertThrows(ArithmeticException.class, () -> validate(" "));
    }
    @Test
    public void testOperateursAvantParenthesesFermantes() {
    	assertThrows(ArithmeticException.class, () -> validate("5*(3+2)/)"));
    }
    @Test
    public void testDivInvalide() {
    	assertThrows(ArithmeticException.class, () -> validate("/4"));
    }
    @Test
    public void testMullInvalide() {
    	assertThrows(ArithmeticException.class, () -> validate("*4"));
    }
    @Test
    public void testFinDivInvalide() {
    	assertThrows(ArithmeticException.class, () -> validate("78/"));
    }
    @Test
    public void testFinMullInvalide() {
    	assertThrows(ArithmeticException.class, () -> validate("45*"));
    }
    public static void validate(String equation) throws ArithmeticException {
        VerifierOperateurConsecutifs v1 = new VerifierOperateurConsecutifs();
        VerifierParentheseValide v3 = new VerifierParentheseValide();
        VerifierParentheseVide v4 = new VerifierParentheseVide();
        VerifierSeulementEspace v6 = new VerifierSeulementEspace();
        VerifChar v7 = new VerifChar();
        VerifDivMull v8 = new VerifDivMull();
        
        if (!v1.validerOperateurConsécutif(equation)) {
            throw new ArithmeticException("Deux operateurs consecutifs ont ete trouve");
        }
        if (!v3.validerParentheses(equation)) {
            throw new ArithmeticException("Parenthese mal equilibrees");
        }
        if (!v4.validerParenthesesVides(equation)) {
            throw new ArithmeticException("Parentheses vide");
        }
        if (!v6.validerSeulementEspaces(equation)) {
            throw new ArithmeticException("L'equation ne contient que des espaces");
        }
        if (!v7.validerChar(equation)) {
            throw new ArithmeticException("Caractere non autorisé dans l'équation");
        }
        if (v8.contientDivisionInvalide(equation)) {
            throw new ArithmeticException("L'equation commence ou finit par division");
        }
        if (v8.contientMultiplicationInvalide(equation)) {
            throw new ArithmeticException("L'equation commence ou finit par une multiplication");
        }
        for (int i = 0; i < equation.length() - 1; i++) {
            if ((equation.charAt(i) == '*' || equation.charAt(i) == '/') && equation.charAt(i + 1) == ')') {
                throw new ArithmeticException("Opérateur * ou / avant la parenthèse fermante");
            }
        }
    }
}