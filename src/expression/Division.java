package expression;

public class Division extends Expression{	
	// Constructeur
	
	public Division(Expression terme_gauche,Expression terme_droite) {
		super(terme_gauche,terme_droite);
	}
	// methode de la classe mére
	
	public double calcul() {
		if(terme_droite.calcul() == 0) {
			throw new ArithmeticException("Division par zero !");
		}
		return terme_gauche.calcul() / terme_droite.calcul();
	}
}