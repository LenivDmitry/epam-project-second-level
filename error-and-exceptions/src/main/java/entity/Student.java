package entity;

import exceptions.StudentWithoutSubjectException;

import java.util.List;

public class Student {
    private int id;
    private String name;
    private String surname;
    private List<Mark> marks;

    public Student(int id, String name, String surname, List<Mark> marks) throws StudentWithoutSubjectException {
        if (!marks.isEmpty()) {
            this.id = id;
            this.name = name;
            this.surname = surname;
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
}
