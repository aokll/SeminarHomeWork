package Seminar3.task2;
/*Напишите обобщенный метод compareArrays(),
который принимает два массива и возвращает true, если они одинаковые,
и false в противном случае. Массивы могут быть любого типа данных,
но должны иметь одинаковую длину и содержать элементы одного типа
 по парно по индексам. То есть тип элемента в первом массиве под
 нулевым индексом такой же как тип элемента во втором массиве
 под нулевым индексом (и под всеми остальными индексами аналогично)*/
public class Main {

    public static <T extends Number> boolean compareArrays(T[] arr1, T[] arr2) {
        if (arr1.length == arr2.length) {
            for (int i = 0; i < arr1.length; i++) {
               if (!(arr1[i].getClass().getSimpleName().toString().equals(arr2[i].getClass().getSimpleName().toString()))){return false;}
            }
        }else return false;
        return true;
    }
            public static void main (String[]args){
        Double[] arr = {1.2,1.1,2.3};
        Integer[] arr1 = {1,2,3};

                System.out.println(compareArrays(arr,arr1));
        }
        }