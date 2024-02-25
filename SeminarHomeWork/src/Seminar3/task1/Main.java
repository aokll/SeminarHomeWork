package Seminar3.task1;
/*Написать класс Калькулятор (необобщенный),
который содержит обобщенные статические методы: sum(), multiply(), divide(), subtract().
Параметры этих методов – два числа разного типа, над которыми должна быть произведена операция.*/
public class Main {

    public static <T extends Number> double multiply(T a,T b){
        return a.doubleValue() * b.doubleValue();
    }
    public static <T extends Number> double div (T a,T b){
        return a.doubleValue() / b.doubleValue();
    }
    public static <T extends Number> double sum(T a,T b){
        return a.doubleValue() + b.doubleValue();
    }
    public static <T extends Number> double subtraction(T a,T b){
        return a.doubleValue() + b.doubleValue();
    }
    public static void main(String[] args) {
        System.out.println(multiply(2.1,23));
    }
}
