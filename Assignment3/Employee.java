package Assignment3;

public class Employee extends Person {
    private int salary;

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Employee(int id, String name, int salary) {
        super(id, name);
        this.salary = salary;
    }

    @Override
    public void toString2() {
        System.out.println("id: "+this.getId()+"\tname: "+this.getName()+"\tsalary: "+this.salary);
    }
}
