package expression;

public class Soustraction extends Expression{
	
	//Constructeur
	public Soustraction(Expression terme_gauche,Expression terme_droite) {
		super(terme_gauche,terme_droite);
	}
	// Méthode de la classe mere
	public double calcul() {
		return terme_gauche.calcul() - terme_droite.calcul();
	}
}