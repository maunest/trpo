package lab1;

import java.util.Objects;

public class FunctionCall implements Expression {
    private String name;
    private Expression arg;

    public FunctionCall(String name, Expression arg) {
        this.name = name;
        this.arg = arg;

        if (!name.equals("sqrt") && !name.equals("abs")) {
            throw new IllegalArgumentException("Unknown function: " + name);
        }
    }

    @Override
    public double evaluate() {
        double argValue = arg.evaluate();

        return switch (name) {
            case "sqrt" -> Math.sqrt(argValue);
            case "abs" -> Math.abs(argValue);
            default -> throw new IllegalArgumentException("Unknown function: " + name);
        };
    }
    @Override
    public Expression transform(Transformer tr) {
        return tr.transformFunctionCall(this);
    }

    public String getName() {
        return name;
    }

    public Expression getArg() {
        return arg;
    }

    @Override
    public String toString(){
        return name +"(" + arg +")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FunctionCall other = (FunctionCall) obj;
        return Objects.equals(name, other.name) &&
                Objects.equals(arg, other.arg);
    }
}
