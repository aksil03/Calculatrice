package expression;

public abstract class Expression {
    protected Expression terme_gauche, terme_droite; 
    // Constructeur

    public Expression(Expression terme_gauche, Expression terme_droite) {
        this.terme_gauche = terme_gauche;
        this.terme_droite = terme_droite;
    }   
    // Méthode abstraite

    protected abstract double calcul() throws ArithmeticException;
}