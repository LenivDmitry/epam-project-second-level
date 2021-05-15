package entity;

import exceptions.StudentWithoutSubjectException;

import java.util.List;
import java.util.Objects;

public class Student {
    private int id;
    private String name;
    private String surname;
    private String groupNumber;
    private List<Mark> marks;

    public Student(int id, String name, String surname, String groupNumber, List<Mark> marks) throws StudentWithoutSubjectException {
        if (!marks.isEmpty()) {
            this.id = id;
            this.name = name;
            this.surname = surname;
            this.groupNumber = groupNumber;
            this.marks = marks;
        } else {
            throw new StudentWithoutSubjectException();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Mark> getMarks() {
        return marks;
    }

    public void setMarks(List<Mark> marks) {
        this.marks = marks;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                Objects.equals(name, student.name) &&
                Objects.equals(surname, student.surname) &&
                Objects.equals(groupNumber, student.groupNumber) &&
                Objects.equals(marks, student.marks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, groupNumber, marks);
    }
}
