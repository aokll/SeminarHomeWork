package Seminar6.View;

import Seminar6.Presenter.Present;

import java.util.Arrays;
import java.util.Scanner;

public class Final {
        private Present present;
        private Scanner scanner;

    public Final() {
        scanner = new Scanner(System.in);
        present = new Present();
    }

    public void start(){
        System.out.println("Привет, я хочу сыграть с тобой в одну игру...");
        System.out.println("есть 3 двери...");
        System.out.println(Arrays.toString(present.getDoor()));
        System.out.println("Выбери одну из них...");
        present.blackBox();

        levelOne();

        levelTwo();
    }

    public void levelOne(){
        present.levelOne();
    }
    public void levelTwo(){
        present.levelTwo();
    }


}
