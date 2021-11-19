package programwork;

import entities.Departament;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class ProgramWork {
    public static void main(String[] args) throws ParseException {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner (System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
        System.out.println("Enter department's name: ");
        String department = sc.next();
        sc.nextLine();
        System.out.println("Enter worker date: ");
        System.out.print("Name: ");
        String workername = sc.nextLine();
        System.out.println("Level: ");
        String workerLevel = sc.nextLine();
        System.out.println("Base Salary: ");
        Double baseSalary = sc.nextDouble();
    
        
        Worker worker = new Worker(workername,WorkerLevel.valueOf(workerLevel),baseSalary, new Departament (department));
        
        System.out.println("How many contracts to this worker: ");
        int n = sc.nextInt();
        sc.nextLine();
        
        for(int i = 1; i<=n; i++){
            
            System.out.println("Enter contract #" + i + " data: ");
            System.out.print("Date (DD/MM/YYYY): ");
            Date contractDate = sdf.parse(sc.next());
            System.out.print("");
            System.out.print("Value per Hour: ");
            double valorPerHour = sc.nextDouble();
            System.out.print("Duration (hours): ");
            int hours = sc.nextInt();
            HourContract contract = new HourContract(contractDate, valorPerHour, hours);
            worker.AddContract(contract);
            
        }
        
        System.out.println();
        System.out.println("Enter month and year to calculate income (MM/YYYY): ");
        String monthAndyear = sc.next();
        int month = Integer.parseInt(monthAndyear.substring(0, 1));
        int year = Integer.parseInt(monthAndyear.substring(3));
        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());
        System.out.println("Income for: " + worker.income(year, month));
        
        
        
        
        

        
        
        
        
        
        
  sc.close();        
}
}
