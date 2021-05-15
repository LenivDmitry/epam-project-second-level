package entity;

import exceptions.FacultyWithoutGroupException;

import java.util.List;

public class Faculty {
    private String name;
    private List<Group> groups;

    public Faculty() {
    }

    public Faculty(String name, List<Group> groups) {
        this.name = name;
        this.groups = groups;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) throws FacultyWithoutGroupException {
        if (!groups.isEmpty()) {
            this.groups = groups;
        } else {
            throw new FacultyWithoutGroupException();
        }
    }
}
