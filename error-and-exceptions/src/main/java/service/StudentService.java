package service;

import entity.Mark;
import entity.Student;
import exceptions.MarkOutOfBoundsException;
import exceptions.StudentWithoutSubjectException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static enums.Subject.*;

public class StudentService {
    public List<Student> addStudents() throws StudentWithoutSubjectException {
        List<Student> students = new ArrayList<>();
        try {
            Student student1 = new Student(1, "Ivan", "Ivanov", "M-1", Arrays.asList(
                    new Mark(MATHS, 9),
                    new Mark(PHYSICS, 7),
                    new Mark(INFORMATICS, 5),
                    new Mark(STORY, 7)));
            students.add(student1);
            Student student2 = new Student(2, "Alex", "Komarov", "M-1", Arrays.asList(
                    new Mark(MATHS, 8),
                    new Mark(PHYSICS, 6),
                    new Mark(INFORMATICS, 9),
                    new Mark(STORY, 7)));
            students.add(student2);
            Student student3 = new Student(3, "Pavel", "Agafonov", "M-1", Arrays.asList(
                    new Mark(MATHS, 9),
                    new Mark(PHYSICS, 4),
                    new Mark(INFORMATICS, 6),
                    new Mark(STORY, 9)));
            students.add(student3);
            Student student4 = new Student(4, "Dmitry", "Golovach", "D-1", Arrays.asList(
                    new Mark(DRAWING, 8),
                    new Mark(STORY, 5),
                    new Mark(DESIGN, 4)));
            students.add(student4);
            Student student5 = new Student(5, "Ben", "Sherman", "D-1", Arrays.asList(
                    new Mark(DRAWING, 7),
                    new Mark(STORY, 5),
                    new Mark(DESIGN, 4)));
            students.add(student5);
            Student student6 = new Student(6, "Franc", "Kafka", "D-1", Arrays.asList(
                    new Mark(DRAWING, 4),
                    new Mark(STORY, 5),
                    new Mark(DESIGN, 4)));
            students.add(student6);
        } catch (MarkOutOfBoundsException e) {
            e.printStackTrace();
        }
        return students;
    }
}
