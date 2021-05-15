import entity.Faculty;
import entity.Group;
import entity.Student;
import entity.University;
import exceptions.UniversityWithoutFacultyException;
import exceptions.FacultyWithoutGroupException;
import exceptions.GroupWithoutStudentException;
import exceptions.StudentWithoutSubjectException;
import service.FacultyService;
import service.GroupService;
import service.StudentService;
import service.UniversityService;

import java.util.List;

import static enums.Subject.STORY;

public class Runner {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        GroupService groupService = new GroupService();
        FacultyService facultyService = new FacultyService();
        UniversityService universityService = new UniversityService();
        University awesomeUniversity = null;
        try {
            List<Student> students = studentService.addStudents();

            List<Group> groups = groupService.addGroups(students);

            List<Faculty> faculties = facultyService.addFaculty(groups);

            awesomeUniversity = new University("Awesome university", faculties);
            System.out.println(universityService.averageScoreAllSubjectsOfStudent(students, 3));
            System.out.println(universityService.averageScoreSubjectAllStudents(students, STORY));
            System.out.println(universityService.averageStoreSubjectOfSpecificGroupAndFaculty(awesomeUniversity,
                    "Mechanical faculty", "M-1", STORY));
        } catch (StudentWithoutSubjectException e) {
            e.printStackTrace();
        } catch (GroupWithoutStudentException e) {
            e.printStackTrace();
        } catch (FacultyWithoutGroupException e) {
            e.printStackTrace();
        } catch (UniversityWithoutFacultyException e) {
            e.printStackTrace();
        }
    }
}
