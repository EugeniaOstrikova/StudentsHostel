package studentHostel;

import java.util.List;

public class Headman extends Student {
    private Student student;

    public Headman() {

    }

    public Headman(Student student) {
        this.student = student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return this.student;
    }

    public List<Student> checkStudents(Hostel hostel) {
        return hostel.checkHostelOfHeadman();
    }

    public void addNotesForStudent(Student student) {
        student.addNotesFromHeadman();
    }
}
