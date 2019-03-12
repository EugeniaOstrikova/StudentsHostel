package studentHostel;

import java.util.List;
import java.util.Random;

public class Student extends Person{
    private int course;
    private int notes;
    private int daysInHostel;
    private boolean hostelPayment;
    private boolean enrolledInUniversity;
    private final int MAX_COURSE = 4;
    private Room room;

    public Student() {
        this.course = new Random().nextInt(getMaxCourse()) + 1;
        this.enrolledInUniversity = true;
        this.hostelPayment = true;
    }

    public void setStartDaysInHostel() {
        this.daysInHostel = this.course > 1 ? this.course * 5 : 0;
    }

    public void addDayInHostel() {
        this.daysInHostel++;
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    public String getTextCourse() {
        String gender = this.gender == 0 ? "She" : "He";
        return gender + " is student of " + getCourse() + " course.";
    }

    public void enterTheRoom(Room room) {
        this.room = room;
    }

    public Room getRoom() {
        return this.room;
    }

    public boolean isCanBeHeadman() {
        return headmanCheck() && this.daysInHostel > 5;
    }

    public int getCourse() {
        return this.course;
    }

    public void transferToNextCourse() {
        if (increaseTheCourse()) {
            resetNotes();
            setHostelPayment(false);
            addDayInHostel();
        } else {
            setEnrolledInUniversity(false);
        }
    }

    public void addNotesFromHeadman() {
        this.notes++;
    }

    public boolean headmanCheck() {
        return getHostelPayment() && getEnrolledInUniversity() && validNotes();
    }

    public boolean validNotes() {
        return this.notes != 2;
    }

    private void resetNotes() {
        this.notes = 0;
    }

    public boolean getHostelPayment() {
        return this.hostelPayment;
    }

    public void setHostelPayment(boolean hostelPayment) {
        this.hostelPayment = hostelPayment;
    }

    public boolean getEnrolledInUniversity() {
        return this.enrolledInUniversity;
    }

    public void setEnrolledInUniversity(boolean enrolledInUniversity) {
        this.enrolledInUniversity = enrolledInUniversity;
    }

    private boolean increaseTheCourse() {
        if (this.course == 4) {
            return false;
        } else {
            this.course++;
            return true;
        }
    }

    private int getMaxCourse() {
        return this.MAX_COURSE;
    }
}
