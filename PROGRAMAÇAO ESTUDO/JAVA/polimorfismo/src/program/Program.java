package program;

import entities.Employee;
import entities.OutsourcedEmployee;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of employees: ");
        int n = sc.nextInt();
        sc.nextLine();
        List<Employee> list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            System.out.println("Emplooye #"+(i+1)+"data: " );
            System.out.print("Outsourced (y/n)? ");
            char outsorcYorN = sc.next().charAt(0);
            sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("hours: ");
            Integer hours = sc.nextInt();
            sc.nextLine();
            System.out.print("value per hour: ");
            Double valuePerHour = sc.nextDouble();
            System.out.print("additional: ");
            if(outsorcYorN == 'y'){
                Double additionalCharge = sc.nextDouble();
                list.add(new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge));
            }
            else if(outsorcYorN == 'n'){
                list.add(new Employee(name, hours, valuePerHour));
            }
        }
        System.out.println("PAYMENTS: ");
        for(Employee emp : list){
            System.out.println(emp);
        };
        sc.close();
    }
}
