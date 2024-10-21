package expression;

public class Valeur extends Expression {
    private double value;

    public Valeur(double value) {
        super(null, null); // Valeur n'a pas de termes gauche ou droit donc appel null
        this.value = value;
    }
    // Getters et setters
    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
    // Methode calcul
    @Override
    protected double calcul() {
        return value;
    }

    // Methode pour les valeurs à partir d'une chaîne
    public static Valeur Chaîne(String str) {
        try {
            double value = Double.parseDouble(str);
            return new Valeur(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Valeur invalide: " + str);
        }
    }
}