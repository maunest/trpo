package lab1;

public class FoldConstants implements  Transformer{
    @Override
    public Expression transformNumber(Number number) {
        return new Number(number.getValue());
    }
    @Override
    public Expression transformBinaryOperation(BinaryOperation binop) {
        Expression nleft = binop.getLeft().transform(this);
        Expression nright = binop.getRight().transform(this);
        BinaryOperation.Operation noperation = binop.getOperation();

        BinaryOperation nbinop = new BinaryOperation(nleft, noperation, nright);

        if (nleft instanceof Number && nright instanceof Number) {
            Expression result = new Number(nbinop.evaluate());
            return result;
        } else {
            return nbinop;
        }
    }
    @Override
    public Expression transformFunctionCall(FunctionCall fcall) {
        Expression arg = fcall.getArg().transform(this);
        String name = fcall.getName();

        FunctionCall nfcall = new FunctionCall(name, arg);

        if (arg instanceof Number) {
            Expression result = new Number(nfcall.evaluate());
            return result;
        } else {
            return nfcall;
        }
    }
    @Override
    public Expression transformVariable(Variable var) {
        return new Variable(var.getName());
    }

}
