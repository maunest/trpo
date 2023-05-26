package lab1;

public interface Expression {
    public double evaluate();
    public Expression transform(Transformer tr);
}