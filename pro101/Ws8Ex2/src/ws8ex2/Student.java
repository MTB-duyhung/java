package ws8ex2;

public class Student {

    protected String name;
    protected int age;
    protected float mark;

    public Student(String name, int age, float mark) {
        this.name = name;
        this.age = age;
        this.mark = mark;
    }

    public String GetName() {
        return this.name;
    }

    public void SetName(String name) {
        this.name = name;
    }

    public int GetAge() {
        return this.age;
    }

    public void SetAge(int age) {
        this.age = age;
    }

    public float GetMark() {
        return this.mark;
    }

    public void SetMark(float mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Student's Name: " + name + "\tAge: " + age + "\tMark: " + mark + "\n";
    }
}
