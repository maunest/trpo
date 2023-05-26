package lab1.tests;

import lab1.*;
import lab1.Number;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestFoldConstants {

    @Test
    public void testFoldConstantsNumber() {
        System.out.println("Проверка числа \n");

        Number num = new Number(16.0);
        FoldConstants FC = new FoldConstants();
        Expression expr = num.transform(FC);

        assertEquals(num, expr);
    }

    @Test
    public void testFoldConstantsPlus() {
        System.out.println("Проверка сложения \n");

        Number num = new Number(64.0);
        FunctionCall callSqrt = new FunctionCall("sqrt", num);
        Variable var = new Variable("var");
        BinaryOperation plus = new BinaryOperation(callSqrt, BinaryOperation.Operation.PLUS, var);

        FoldConstants FC = new FoldConstants();
        Expression expr = plus.transform(FC);

        BinaryOperation res = new BinaryOperation(new Number(8.0), BinaryOperation.Operation.PLUS, new Variable("var"));
        assertEquals(expr, res);
        System.out.println(plus + "/=/" + expr + "/=/" + res + "\n");

    }

    @Test
    public void testFoldConstantsMinus() {
        System.out.println("Проверка вычитания \n");

        Number num = new Number(64.0);
        FunctionCall callSqrt = new FunctionCall("sqrt", num);
        Variable var = new Variable("var");
        BinaryOperation plus = new BinaryOperation(callSqrt, BinaryOperation.Operation.MINUS, var);

        FoldConstants FC = new FoldConstants();
        Expression expr = plus.transform(FC);

        BinaryOperation res = new BinaryOperation(new Number(8.0), BinaryOperation.Operation.MINUS, new Variable("var"));
        assertEquals(expr, res);
        System.out.println(plus + "/=/" + expr + "/=/" + res + "\n");

    }
}
