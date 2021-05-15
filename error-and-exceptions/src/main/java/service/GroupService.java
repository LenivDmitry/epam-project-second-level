package service;

import entity.Group;
import entity.Student;
import exceptions.GroupWithoutStudentException;

import java.util.ArrayList;
import java.util.List;

public class GroupService {
    public List<Group> addGroups(List<Student> students) throws GroupWithoutStudentException {
        List<Group> groups = new ArrayList<>();
        Group m1 = new Group("M-1", new ArrayList<>());
        Group d1 = new Group("D-1", new ArrayList<>());
        for (Student student : students) {
            if (m1.getName().equalsIgnoreCase(student.getGroupNumber())) {
                m1.getStudents().add(student);
            } else if (d1.getName().equalsIgnoreCase(student.getGroupNumber())) {
                d1.getStudents().add(student);
            }
        }
        groups.add(m1);
        groups.add(d1);
        return groups;
    }
}
