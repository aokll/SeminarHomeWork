package Seminar4;

public class Main {
    public static void main(String[] args) throws EmployeeOutreachException {
            EmployeeOutreach employeeOutreach = new EmployeeOutreach();
            employeeOutreach.addingNewEmployees("make",1234, "09067651212",12);
            employeeOutreach.addingNewEmployees("make2",2345, "19067651212",11);
            employeeOutreach.addingNewEmployees("make3",3456, "29067651212",13);

            employeeOutreach.searchByExprinence(11);

            System.out.println(employeeOutreach.phoneNumber("make"));

            employeeOutreach.searchByPersonalNumber(3456);

    }
}
