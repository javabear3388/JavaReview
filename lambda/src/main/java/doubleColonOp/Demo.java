package doubleColonOp;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class Demo {

    public static void main(String[] args) {

        //Reference to a static method
        Calculate s1 = (x, y) -> Calculator.findSum(x, y);
        s1.calculate(1, 2);

        Calculate s2 = Calculator::findSum;
        s2.calculate(11,22);

        //Reference to instant method
        Calculate m1 = (x, y) -> new Calculator().findMultiply(x, y);
        m1.calculate(3,5);

        Calculate m2 = new Calculator()::findMultiply;
        m2.calculate(2, 5);

//        Calculate m3 = Calculator::findMultiply2;
        BiFunction<Double, Double, Double> mul2 = new Calculator()::findMultiply2;
        System.out.println(mul2.apply(3.3, 4.4));

        BiFunction<String, Integer, String> fn = (str, i) -> str.substring(i);
        System.out.println(fn.apply("Developer", 6));

        BiFunction<String, Integer, String> fn2 = String::substring; //substring is a INSTANCE method
        System.out.println(fn2.apply("Developer", 5));

        Consumer<Integer> display = i -> System.out.println(i);
        display.accept(20);

        Consumer<Integer> display2 = System.out::println;
        display2.accept(50);


        System.out.println("========================Class call insstance method=================");

        BiFunction<MyClass, Integer, Double> v2 = MyClass::instanceMethod;

        BiFunction<String, String, String> v3 = String::concat;

    }
}
