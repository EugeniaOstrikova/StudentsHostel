package studentHostel;

import java.util.List;
import java.util.Random;

public class Commandant extends Person {
    public Commandant() {
        int gender = new Random().nextInt(2);
        if (this.gender == 0) {
            createWoman();
        } else {
            createMan();
        }
    }

    public void moveOutStudents(List<Student> students) {
        for (Student student : students) {
            Room room = student.getRoom();
            room.removeStudentFromRoom(student);
            String reasonForMoveOut = "";
            if (!student.getEnrolledInUniversity()) {
                reasonForMoveOut = "This student has been dismissed.";
            } else if (!student.validNotes()) {
                reasonForMoveOut = "This student has many notes from headman";
            } else {
                reasonForMoveOut = "This student didn't pay hostel.";
            }
            System.out.println("The student " + student.getFullName() + " was move out from hostel. " + reasonForMoveOut);
        }
    }
}
