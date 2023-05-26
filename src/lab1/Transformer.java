package lab1;

public interface Transformer {
    public Expression transformNumber(Number number);
    public Expression transformBinaryOperation(BinaryOperation binop);
    public Expression transformFunctionCall(FunctionCall fcall);
    public Expression transformVariable(Variable var);
}