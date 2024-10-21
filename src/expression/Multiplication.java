package expression;

public class Multiplication extends Expression {
	
	// Constructeur

    public Multiplication(Expression terme_gauche, Expression terme_droite) {
        super(terme_gauche, terme_droite);
    }   
    // Méthode de la classe mere

    @Override
    protected double calcul() {
        return terme_gauche.calcul() * terme_droite.calcul();
    }
}