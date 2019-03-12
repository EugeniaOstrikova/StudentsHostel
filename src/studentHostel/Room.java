package studentHostel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Room {
    private static int counter = 0;
    private List<Student> students = new ArrayList<>();
    private int roomNumber;
    private final int MAX_NUMBER_OF_STUDENTS = 3;
    private boolean boysRoom;

    public Room() {
        counter++;
        this.roomNumber = counter;
        this.boysRoom = new Random().nextBoolean();
        fullStartRoom();
    }

    public void fullRoom() {
        while (getStudents().size() < getMaxNumberOfStudents()) {
            Student student = new Student();
            addGenderForStudent(student);
        }
    }

    public void fullStartRoom() {
        while (getStudents().size() < getMaxNumberOfStudents()) {
            Student student = new Student();
            student.setStartDaysInHostel();
            addGenderForStudent(student);
        }
    }

    private void addGenderForStudent(Student student) {
        if (this.boysRoom) {
            student.createMan();
        } else {
            student.createWoman();
        }
        addStudentInRoom(student);
    }

    private void addStudentInRoom(Student student) {
        student.enterTheRoom(this);
        getStudents().add(student);
        System.out.println(student.getFullName() + " settled in the room " + getRoomNumber() + ". " + student.getTextCourse());
    }

    public boolean removeStudentFromRoom(Student student) {
        if (getStudents().contains(student)) {
            getStudents().remove(student);
            return true;
        }
        return false;
    }

    public int getRoomNumber() {
        return this.roomNumber;
    }

    public List<Student> getStudents() {
        return this.students;
    }

    private int getMaxNumberOfStudents() {
        return MAX_NUMBER_OF_STUDENTS;
    }
}
