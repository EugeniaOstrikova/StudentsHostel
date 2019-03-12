package studentHostel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Hostel {
    private List<Floor> floors = new ArrayList<>();
    private List<Student> students = new ArrayList<>();
    private final int MAX_NUMBER_OF_FLOORS = 4;
    private Headman headman = new Headman();
    private Commandant commandant;

    public Hostel() {
        fullStartHostel();
        createStudentList();
        setHeadman();
        this.commandant = new Commandant();
    }

    public List<Floor> getFloors() {
        return this.floors;
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public List<Student> checkHostelOfHeadman() {
        List<Student> listOfBedStudents = new ArrayList<>();
        for (Student student : getStudents()) {
            if (!student.headmanCheck()) {
                listOfBedStudents.add(student);
            }
        }
        return listOfBedStudents;
    }

    public Headman setHeadman() {
        for (Student student : getStudents()) {
            if (student.isCanBeHeadman()) {
                this.headman.setStudent(student);
                break;
            }
        }
        Student headmanStudent = headman.getStudent();
        System.out.println("The headman is " + headmanStudent.getFullName() + ". " + headmanStudent.getTextCourse() + "\n");
        return headman;
    }

    public void checkHeadmanLearning() {
        if (!getStudents().contains(getHeadman().getStudent())) {
            setHeadman();
        }
    }

    public Headman getHeadman() {
        return this.headman;
    }

    public Commandant getCommandant() {
        return this.commandant;
    }

    public void addDayInHostel() {
        for (Student student : getStudents()) {
            student.addDayInHostel();
        }
    }

    public void endOfYearInHostel() {
        for (Student student : getStudents()) {
            student.transferToNextCourse();
        }
    }

    public void removeStudentsFromHostel(List<Student> students) {
        for (Student student : students) {
            moveOutStudent(student);
        }
        getCommandant().moveOutStudents(students);
    }

    public void fullHostel() {
        for (Floor floor : getFloors()) {
            floor.fullFloor();
        }
    }

    public void hostelPayment() {
        for (Student student : getStudents()) {
            if (!student.getHostelPayment()) {
                student.setHostelPayment(new Random().nextInt(20) > 1);
            }
        }
    }

    public void studentsAllocation() {
        for (Student student : getStudents()) {
            if (student.getEnrolledInUniversity()) {
                student.setEnrolledInUniversity(new Random().nextInt(30) > 1);
            }
        }
    }

    public void headmanCheckForNotes() {
        for (Student student : getStudents()) {
            if (new Random().nextInt(10) < 1) {
                headman.addNotesForStudent(student);
            }
        }
    }

    private void createStudentList() {
        for (Floor floor : getFloors()) {
            for (Room room : floor.getRooms()) {
                for (Student student : room.getStudents()) {
                    addStudent(student);
                }
            }
        }
    }

    private void fullStartHostel() {
        while (getFloors().size() < getMaxNumberOfFloor()) {
            addFloor(new Floor());
        }
    }

    private void addFloor(Floor floor) {
        getFloors().add(floor);
    }

    private void addStudent(Student student) {
        getStudents().add(student);
    }

    private void moveOutStudent(Student student) {
        getStudents().remove(student);
    }

    private int getMaxNumberOfFloor() {
        return this.MAX_NUMBER_OF_FLOORS;
    }
}
