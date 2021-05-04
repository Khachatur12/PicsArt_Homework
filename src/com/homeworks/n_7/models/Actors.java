package com.homeworks.n_7.models;

public class Actors extends Human{
    public boolean hasOscar;

    public Actors() { }

    public Actors(int id, String firstName, String lastName, boolean gender, int age, boolean hasOscar) {
        super(id, firstName, lastName, gender, age);
        this.hasOscar = hasOscar;
    }

    public boolean isHasOscar() {
        return hasOscar;
    }

    public void setHasOscar(boolean hasOscar) {
        this.hasOscar = hasOscar;
    }
}
