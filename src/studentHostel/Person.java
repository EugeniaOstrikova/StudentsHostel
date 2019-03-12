package studentHostel;

import java.util.Random;

public abstract class Person {
    protected String lastName;
    protected String firstName;
    protected int gender;

    public void createMan() {
        this.gender = 1;
        this.lastName = Names.lastName[new Random().nextInt(Names.lastName.length)];
        this.firstName = Names.menNames[new Random().nextInt(Names.menNames.length)];
    }

    public void createWoman() {
        this.gender = 0;
        this.lastName = Names.lastName[new Random().nextInt(Names.lastName.length)];
        this.firstName = Names.womenNames[new Random().nextInt(Names.womenNames.length)];
    }
}
