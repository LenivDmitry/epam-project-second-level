package entity;

import exceptions.UniversityWithoutFacultyException;

import java.util.List;

public class University {
    private String name;
    private List<Faculty> faculties;

    public University(String name, List<Faculty> faculties) throws UniversityWithoutFacultyException {
        if (!faculties.isEmpty()) {
            this.name = name;
            this.faculties = faculties;
        } else {
            throw new UniversityWithoutFacultyException();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(List<Faculty> faculties) throws UniversityWithoutFacultyException {
        if (!faculties.isEmpty()) {
            this.faculties = faculties;
        } else {
            throw new UniversityWithoutFacultyException();
        }
    }
}
