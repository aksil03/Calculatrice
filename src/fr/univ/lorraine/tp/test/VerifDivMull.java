package fr.univ.lorraine.tp.test;

public class VerifDivMull {
	    public boolean contientDivisionInvalide(String equation) {
	        // Vérifie si la chaîne commence "/" ou "/9" ou se termine par "9/"
	        return equation.startsWith("/") || equation.contains("*/") || equation.endsWith("/");
	    }
	    public boolean contientMultiplicationInvalide(String equation) {
	        // Vérifie si la chaîne commence par "*" ou "*4" ou se termine par "4*"
	        return equation.startsWith("*") || equation.contains("*-") || equation.endsWith("*");
	    }
	}