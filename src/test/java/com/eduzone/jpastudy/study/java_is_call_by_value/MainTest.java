package com.eduzone.jpastudy.study.java_is_call_by_value;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.*;

public class MainTest {

    @Test
    void valueCopy() {
        HashMap<String, String> map = new HashMap<>();
        map.put("1","14134");

        System.out.println("1 = " + map.hashCode());

        qq(map);

        System.out.println("4 = " + map.hashCode());
    }

    void qq(Map map) {
        System.out.println("2 = " + map.hashCode());

        map = new LinkedHashMap<String, String>();
        map.put("999","9997899");

        System.out.println("3 = " + map.hashCode());
    }

    @Test
    void valueCopy2() {
        HashMap<String, String> map = new HashMap<>();
        map.put("1","14134");

        System.out.println("1 = " + map);

        qq2(map);
        System.out.println("2 = " + map);
    }

    void qq2(Map map) {
        map.put("999","9997899");
    }

    @Test
    void a() {

        boolean test = zzz("z").test("z");
        System.out.println("test = " + test);
    }
    private Predicate<String> zzz(String aa) {
        return x -> x.equals(aa);
    }

    @Test
    void b() {
        Consumer<String> consumer = (String s) -> System.out.println("s = " + s);
        consumer.accept("zzzzzzz");

        Runnable runnable = () -> System.out.println("???");
        runnable.run();

        Supplier<String> s = () -> "zzz";
        System.out.println(" = " + s.get());

        Predicate<String> zz = (x) -> x.equals("AA");
        System.out.println(zz.test("aa"));

        BiFunction<Integer, Integer, Integer> a =  (x,y) -> x>y ? x : y;
        Integer apply = a.apply(1, 2);
        System.out.println("apply = " + apply);


    }




    @Test
    void test() {
        Predicate<Integer> predicate = x -> x.equals(10);
        Function<Integer, String> function = x -> x + "zz";
        Supplier<String> supplier = () -> "zzz";
        Consumer<String> consumer = x -> System.out.println("x = " + x);

        System.out.println(predicate.test(10));
        System.out.println(function.apply(999));
        System.out.println(supplier.get());
        consumer.accept("hello");
    }

    @Test
    void test2() {
        BiFunction<Integer, Double, String> biFunction = (x,y) -> x + ":" + y;
        BiPredicate<String, String> biPredicate = String::equals;
        BiConsumer<Integer, Double> biConsumer = (x,y) -> System.out.println(x + y);

        System.out.println(biFunction.apply(10,20.1));
        System.out.println(biPredicate.test("hi","hi"));
        biConsumer.accept(999, 0.999);
    }

    @Test
    void test3() {
        UnaryOperator<String> unaryOperator = x -> x + "zzz";
        System.out.println("unaryOperator.apply() = " + unaryOperator.apply("ㅇㅅㅇ"));
    }
}