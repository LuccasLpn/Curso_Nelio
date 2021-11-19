package entities;

import entities.enums.WorkerLevel;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Worker {

    private String name;
    private WorkerLevel Level;
    private Double baseSalary;
    private Departament department;
    private List<HourContract> contracts = new ArrayList<> ();

    public Worker() {
    }

    public Worker(String name, WorkerLevel Level, Double baseSalary, Departament department) {
        
        this.name = name;
        this.Level = Level;
        this.baseSalary = baseSalary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkerLevel getWorkLevel() {
        return Level;
    }

    public void setWorkLevel(String WorkLevel) {
        this.Level = Level;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Departament getDepartment() {
        return department;
    }

    public void setDepartment(Departament department) {
        this.department = department;
    }

    public List<HourContract> getContracts() {
        return contracts;
    }

    
    public void AddContract(HourContract contract){
      contracts.add(contract);
    }
    
    public void RemoveContract(HourContract contract){
        contracts.remove(contract);
    }
    
    public double income(int year, int month){
     double sum = baseSalary;
     Calendar cal = Calendar.getInstance();
     
     for(HourContract c : contracts){
         cal.setTime(c.getDate());
         int c_year = cal.get(Calendar.YEAR);
         int c_month =  1 + cal.get(Calendar.MONTH);
         if(year == c_year && month == c_month){
             
            sum =+ c.totalValue();
         }
     }return sum;
       
    }
    

}
