package service;

import entity.Group;
import entity.Mark;
import entity.Student;
import enums.Subject;
import exceptions.GroupWithoutStudentException;

import java.util.ArrayList;
import java.util.List;

public class GroupService {
    public List<Group> addGroups(List<Student> students) throws GroupWithoutStudentException {
        List<Group> groups = new ArrayList<>();
        Group m1 = new Group("M-1", new ArrayList<>());
        Group d1 = new Group("D-1", new ArrayList<>());
        for (Student student : students) {
            for (Mark mark: student.getMarks()) {
                if (mark.getSubject().equals(Subject.PHYSICS)){
                    m1.getStudents().add(student);
                    break;
                } else if (mark.getSubject().equals(Subject.DESIGN)){
                    d1.getStudents().add(student);
                    break;
                }
            }
        }
        groups.add(m1);
        groups.add(d1);
        return groups;
    }
}
