import java.util.Objects;


public class Employee {
    private String fullName;
    private int department;
    private double salary;
    private int id;
    static int nextId=0;

    public Employee(String fullName, int deportment, double salary) {
        nextId++;
        this.id=nextId;
        this.fullName = fullName;
        this.department = deportment;
        this.salary = salary;



    }


    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
    public static int getNextId(){return nextId;}

    public void setDepartment(int department) {
        if (department >=1 && department <=5)
            this.department = department;
        else {
            System.out.println("отдел должен быть от 1 до 5");
        }


    }

    public void setSalary(double salary) {
        if(salary>=50 && salary<=450)
            this.salary = salary;
        else {
            System.out.println("Зарплата должна быть в диапазоне 50-450");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj) return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;

        if (this.salary == other.salary) {
            return true;}

        return false;

    }


    @Override
    public String toString() {
        return "{ Сотрудник id : " +id+","+" Ф.И.О : "+fullName+","+"отдел № :"+ department +","+" зар" +
                "плата :"+salary+" рублей }"; }
    public  void printShortInfo(){
        System.out.println("{ Ф.И.О :"+fullName+", "+" зарплата : "+salary+" рублей }");
    }

    @Override
    public int hashCode() {
        return Objects.hash(salary);
    }
}






