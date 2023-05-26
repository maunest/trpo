package lab1;

import java.util.Objects;

public class BinaryOperation implements Expression {
    public enum Operation {
        PLUS('+'),
        MINUS('-'),
        DIV('/'),
        MUL('*');

        public char getSymbol() {
            return symbol;
        }

        private final char symbol;

        Operation(char symbol) {
            this.symbol = symbol;
        }

    }

    private final Expression left;
    private final Expression right;
    private final Operation operation;

    public BinaryOperation(Expression left, Operation operation, Expression right) {
        this.left = left;
        this.right = right;
        this.operation = operation;
    }
    @Override
    public double evaluate() {
        double leftValue = left.evaluate();
        double rightValue = right.evaluate();

        return switch (operation) {
            case PLUS -> leftValue + rightValue;
            case MINUS -> leftValue - rightValue;
            case DIV -> leftValue / rightValue;
            case MUL -> leftValue * rightValue;
            default -> throw new IllegalArgumentException("Unknown operation: " + operation);
        };
    }
    @Override
    public Expression transform(Transformer tr) {
        return tr.transformBinaryOperation(this);
    }

    public Expression getLeft() {
        return left;
    }

    public Expression getRight() {
        return right;
    }

    public Operation getOperation() {
        return operation;
    }

    @Override
    public String toString(){
        return "(" + left + " "+ getOperation().getSymbol()+ " " + right +")";
    }

    @Override
    public boolean equals(Object obj) {
        BinaryOperation other = (BinaryOperation) obj;
        return Objects.equals(other.toString(), this.toString());
    }
}