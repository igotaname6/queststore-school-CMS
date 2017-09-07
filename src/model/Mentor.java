package model;

import java.util.ArrayList;

public class Mentor extends AbstractUser {

    private ArrayList<Class> teachedClass;

    public Mentor(String name, String surname, String email, String password) {
        super(name, surname, email, password);
        this.teachedClass = new ArrayList<>();
    }

    public void addClass(Class class) {
        this.teachedClass.add(class);
    }

    public void removeClass(Class class) {
        this.teachedClass.remove(class);
    }
}
