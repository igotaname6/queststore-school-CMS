package com.codecool_mjs.model;

import java.util.ArrayList;

public class Mentor extends AbstractUser {

    private ArrayList<Class> teachedClass;

    public Mentor(String name, String surname, String email, String password) {
        super(name, surname, email, password);
        this.teachedClass = new ArrayList<>();
    }

    public void addClass(Class teachedClass) {
        this.teachedClass.add(teachedClass);
    }

    public void removeClass(Class teachedClass) {
        this.teachedClass.remove(teachedClass);
    }

    public ArrayList<Class> getTeachedClasses() {
        return this.teachedClass;
    }
}
