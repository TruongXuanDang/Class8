package Assignment3;

public class Student extends Person {

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student(int id, String name) {
        super(id, name);
    }

    public Student(int id, String name, int age) {
        super(id, name);
        this.age = age;
    }

    @Override
    public void toString2() {
        System.out.println("id: "+this.getId()+"\tname: "+this.getName()+"\tage: "+this.age);
    }
}
