package fr.univ.lorraine.tp.test;

public class VerifChar {
    public boolean validerChar(String equation) {
        // Définir les caractères autorisés
        String caracteresAutorise = "0123456789()+-*/ ";

        // Parcour chaque caractère de l'équation
        for (char c : equation.toCharArray()) {
            // Vérifie si le caractère n'est pas autorisé
            if (caracteresAutorise.indexOf(c) == -1) {
                return false; // Caractères non autorisés trouvé
            }
        }
        return true; //Aucuns caractères non autorisés trouvé
  }
}