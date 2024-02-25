package Seminar4;

public class Employee {
    private String name;
    private int personalNumber;
    private String phoneNumber;
    private int exprience;

    public Employee(String name, int personalNumber, String phoneNumber, int exprience) {
        this.name = name;
        this.personalNumber = personalNumber;
        this.phoneNumber = phoneNumber;
        this.exprience = exprience;
    }

    public String getName() {
        return name;
    }

    public int getPersonalNumber() {
        return personalNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getExprience() {
        return exprience;
    }
}
