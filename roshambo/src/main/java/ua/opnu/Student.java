package ua.opnu;

public class Student extends Person {
    private String group;
    private String studentId;

    public Student(String lastName, String firstName, int age, String group, String studentId) {
        super(lastName, firstName, age);
        this.group = group;
        this.studentId = studentId;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return String.format("Студент групи %s, %s %s, вік: %d. Номер студентського квитка: %s",
                this.group, getLastName(), getFirstName(), getAge(), this.studentId);
    }
}