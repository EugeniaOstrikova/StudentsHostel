package studentHostel;

import java.util.List;

public class TimeInHostel {
    private int year = 2015;
    private int day = 1;
    private final int DAYS_IN_YEAR = 7;
    private Hostel hostel;

    public static void main(String... args) {
        TimeInHostel timeInHostel = new TimeInHostel();

        System.out.println("Create our hostel: \n...");
        Hostel hostel = new Hostel();
        timeInHostel.setHostel(hostel);

        for (int i = 0; i < 21; i++) {
            morningActions(timeInHostel);
            eveningCheck(timeInHostel);
        }
    }

    static void morningActions(TimeInHostel timeInHostel) {
        System.out.println("\nDay " + timeInHostel.getDate() + ".\n");
        System.out.println("Start of morning action.\n");
        Hostel hostel = timeInHostel.getHostel();
        hostel.checkHeadmanLearning();
        hostel.fullHostel();
        hostel.hostelPayment();
        hostel.studentsAllocation();
        hostel.headmanCheckForNotes();
    }

    static void eveningCheck(TimeInHostel timeInHostel) {
        Hostel hostel = timeInHostel.getHostel();
        System.out.println("Start of evening check.\n");

        Headman headman = hostel.getHeadman();
        List<Student> listOfBadStudents = headman.checkStudents(hostel);
        hostel.removeStudentsFromHostel(listOfBadStudents);
        timeInHostel.addDay(hostel);
    }

    public void setHostel(Hostel hostel) {
        this.hostel = hostel;
    }

    public Hostel getHostel() {
        return this.hostel;
    }

    public String getDate() {
        return this.day + " of " + this.year;
    }

    public void addDay(Hostel hostel) {
        if (this.day < this.DAYS_IN_YEAR) {
            hostel.addDayInHostel();
            this.day++;
        } else {
            hostel.endOfYearInHostel();
            this.day = 1;
            this.year++;
        }
    }

}
