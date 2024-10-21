package fr.univ.lorraine.tp.test;

public class VerifierSeulementEspace {
    
    public boolean validerSeulementEspaces(String equation) {
        return !equation.contains(" ");
  }
}