package expression;

public class Addition extends Expression {
	// Constructeur
	
	public Addition(Expression terme_gauche, Expression terme_droite) {
		super(terme_gauche, terme_droite);
	}
	// méthode calcul de la classe mére
	
	@Override
	public double calcul() {
		return terme_gauche.calcul() + terme_droite.calcul();
	}
}