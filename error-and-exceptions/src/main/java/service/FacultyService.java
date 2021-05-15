package service;

import entity.Faculty;
import entity.Group;
import exceptions.FacultyWithoutGroupException;

import java.util.ArrayList;
import java.util.List;

public class FacultyService {
    public List<Faculty> addFaculty(List<Group> groups) throws FacultyWithoutGroupException {
        List<Faculty> faculties = new ArrayList<>();
        Faculty mechanicalFaculty = new Faculty("Mechanical faculty", new ArrayList<>());
        Faculty designFaculty = new Faculty("Design faculty", new ArrayList<>());
        for (Group group : groups) {
            if (group.getName().equalsIgnoreCase("M-1")) {
                mechanicalFaculty.getGroups().add(group);
            } else if (group.getName().equalsIgnoreCase("D-1")) {
                designFaculty.getGroups().add(group);
            }
        }
        faculties.add(mechanicalFaculty);
        faculties.add(designFaculty);
        return faculties;
    }
}
