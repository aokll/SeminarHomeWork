package Seminar4;

import java.util.ArrayList;
import java.util.List;

public class EmployeeOutreach {

    private List<Employee> employeeOutreachList;

    public EmployeeOutreach() {
        employeeOutreachList = new ArrayList<>();
    }

    public void addingNewEmployees(String name, int personalNumber, String phoneNumber, int exprience){
        employeeOutreachList.add(new Employee(name,personalNumber,phoneNumber,exprience));
    }
    public void searchByExprinence(int exprience) throws EmployeeOutreachException {
        for (Employee e : employeeOutreachList) {
            if (e.getExprience() == exprience){
                System.out.println(e.getName() + " " + e.getPersonalNumber() + " " + e.getPhoneNumber() + " " + e.getExprience());
            }else  throw new EmployeeOutreachException("Сотрудника с таким стажем нет в списке");
        }
    }
    public String phoneNumber(String name) throws EmployeeOutreachException {
        String number = null;
        for (Employee e : employeeOutreachList) {
            if (name.equals(e.getName())){
                number = e.getPhoneNumber();
            }else throw new EmployeeOutreachException("Сотрудника с таким именем нет в списке");
        }
        return number;
    }
    public void searchByPersonalNumber(int personalNumbers) throws EmployeeOutreachException {
        for (Employee e : employeeOutreachList) {
            if (e.getPersonalNumber() == personalNumbers){
                System.out.println(e.getName() + " " + e.getPersonalNumber() + " " + e.getPhoneNumber() + " " + e.getExprience());
            }else  throw new EmployeeOutreachException("Сотрудника с таким табельным номером нет в списке");
        }
    }


}
