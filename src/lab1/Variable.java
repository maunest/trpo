package lab1;


import java.util.Objects;

public class Variable implements Expression {
    private String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public double evaluate() {
        return 0.0;
    }

    @Override
    public Expression transform(Transformer tr) {
        return tr.transformVariable(this);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        Variable other = (Variable) obj;
        return Objects.equals(other.toString(), this.toString());
    }
}
