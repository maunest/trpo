package lab1;

public class CopySyntaxTree implements Transformer {
    @Override
    public Expression transformNumber(Number number) {
        Expression exp = new Number(number.getValue());
        return exp;
    }

    @Override
    public Expression transformBinaryOperation(BinaryOperation binop) {
        Expression exp = new BinaryOperation(
                binop.getLeft().transform(this),
                binop.getOperation(),
                binop.getRight().transform(this)
        );
        return exp;
    }

    @Override
    public Expression transformFunctionCall(FunctionCall fcall) {
        Expression exp = new FunctionCall(
                fcall.getName(),
                fcall.getArg().transform(this)
        );
        return exp;
    }

    @Override
    public Expression transformVariable(Variable var) {
        Expression exp = new Variable(var.getName());
        return exp;
    }

}