package lab1;

public class MainCopySyntaxTree {
    public static void main(String[] args) {
        Expression n32 = new Number(32.0);
        Expression n16 = new Number(16.0);
        Expression minus = new BinaryOperation(n32, BinaryOperation.Operation.MINUS, n16);
        Expression callSqrt = new FunctionCall("sqrt", minus);
        Expression n2 = new Number(2.0);
        Expression mult = new BinaryOperation(n2, BinaryOperation.Operation.MUL, callSqrt);
        Expression callAbs = new FunctionCall("abs", mult);
        System.out.println(callAbs + "=" + callAbs.evaluate());
        Expression newexp = callAbs.transform(new CopySyntaxTree());
        Expression newexpchange = new BinaryOperation(n2, BinaryOperation.Operation.PLUS, newexp);
        System.out.println(newexpchange + "=" + newexpchange.evaluate());
    }
}
