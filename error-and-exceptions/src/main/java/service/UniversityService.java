package service;

import entity.*;
import enums.Subject;

import java.util.List;

public class UniversityService {

    public double averageScoreAllSubjectsOfStudent(List<Student> students, int studentId) {
        double averageScore = 0;
        for (Student student : students) {
            if (student.getId() == studentId) {
                averageScore = countAverageScoreOfMarksList(student.getMarks());
            }
        }
        return averageScore;
    }

    public double averageStoreSubjectOfSpecificGroupAndFaculty(University university, String nameFaculty,
                                                               String nameGroup, Subject nameSubject) {
        double averageScore = 0;
        for (Faculty faculty : university.getFaculties()) {
            if (nameFaculty.equalsIgnoreCase(faculty.getName())) {
                for (Group group : faculty.getGroups()) {
                    if (nameGroup.equalsIgnoreCase(group.getName())) {
                        averageScore = averageScoreSubjectAllStudents(group.getStudents(), nameSubject);
                    }
                }
            }
        }
        return averageScore;
    }

    public double averageScoreSubjectAllStudents(List<Student> students, Subject name) {
        double averageScore = 0;
        int counterStudentWhoHasSubject = 0;
        for (Student student : students) {
            for (Mark mark : student.getMarks()) {
                if (name == mark.getSubject()) {
                    averageScore += mark.getMark();
                    counterStudentWhoHasSubject++;
                    break;
                }
            }
        }
        averageScore = Math.round(averageScore / counterStudentWhoHasSubject * 10) / 10.0;
        return averageScore;
    }

    public double countAverageScoreOfMarksList(List<Mark> marks) {
        double averageScore = 0;
        for (Mark mark : marks) {
            averageScore += mark.getMark();
        }
        return averageScore / marks.size();
    }

}
