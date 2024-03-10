package Seminar6.Presenter;

import Seminar6.Model.BlackBox;
import Seminar6.Model.Lead;

import java.util.Arrays;
import java.util.Scanner;

public class Present {
    private BlackBox box;
    private Lead lead;
    private Scanner scanner;
    public Present() {
        scanner = new Scanner(System.in);
        box = new BlackBox();
        lead = new Lead();
    }

    public void levelOne(){
        System.out.println("Введите номер двери");
        int x = scanner.nextInt();
        int i = x - 1;
        lead.startThePresentation(box,i);
        System.out.println("Я открыл одну из дверей, как видишь, здесь коза, готов ли ты изменить свой выбор?...");
        System.out.println(Arrays.toString(lead.getGetDoor()));
    }
    public void levelTwo(){
        System.out.println("Введите номер двери");
        int x = scanner.nextInt();
        int i = x - 1;
        lead.finish(box,i);
        System.out.println(Arrays.toString(lead.getGetDoor()));
    }
    public String[] getDoor(){
        return lead.getDoor();
    }
    public void blackBox(){
        box.blackBox();
    }



}
