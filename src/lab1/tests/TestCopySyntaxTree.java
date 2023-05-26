package lab1.tests;

import lab1.BinaryOperation;
import lab1.CopySyntaxTree;
import lab1.Expression;
import lab1.Number;
import lab1.FunctionCall;
import lab1.Variable;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCopySyntaxTree {

    @Test
    public void testCopySyntaxTreeNumber() {
        System.out.println("Копирование числа 666");
        Number num = new Number(666);
        CopySyntaxTree CST = new CopySyntaxTree();
        Expression newExpr = num.transform(CST);

        assertEquals(num, newExpr);
        System.out.println(num + "=" + newExpr + "\n");
    }

    @Test
    public void testCopySyntaxTreeBinaryOperation() {
        System.out.println("Копирование выражения 666 - 228");
        Number num1 = new Number(666);
        Number num2 = new Number(228);
        BinaryOperation minus = new BinaryOperation(num1, BinaryOperation.Operation.MINUS, num2);
        CopySyntaxTree CST = new CopySyntaxTree();
        Expression newExpr = minus.transform(CST);
        assertEquals(minus, newExpr);
        System.out.println( minus + "=" + newExpr + "\n");
    }

    @Test
    public void testCopySyntaxTreeFunctionalCall() {
        System.out.println("Копирование выражения sqrt(16)");
        Number num1 = new Number(16.0);
        FunctionCall callSqrt = new FunctionCall("sqrt", num1);
        CopySyntaxTree CST = new CopySyntaxTree();
        Expression newExpr = callSqrt.transform(CST);
        assertEquals(callSqrt, newExpr);
        System.out.println(callSqrt + "=" + newExpr + "\n");
    }

    @Test
    public void testCopySyntaxTreeVariable() {
        System.out.println("Копирование выражения переменной MOAIS");
        Variable var = new Variable("MOAIS");
        CopySyntaxTree CST = new CopySyntaxTree();
        Expression newExpr = var.transform(CST);
        assertEquals(var, newExpr);
        System.out.println(var + "=" + newExpr + "\n");
    }
}
