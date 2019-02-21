public class Student implements Comparable<Student> {
    public int Id;
    public String Name;
    public int Age;
    public String Address;
    public double GPA;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public Student(int id, String name, int age, String address, double GPA) {
        Id = id;
        Name = name;
        Age = age;
        Address = address;
        this.GPA = GPA;
    }

    public Student(){

    }

    @Override
    public int compareTo(Student o) {
        return 0;
    }
}
