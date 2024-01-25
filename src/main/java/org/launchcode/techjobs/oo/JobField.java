package org.launchcode.techjobs.oo;

import java.util.Objects;

import static java.util.Objects.isNull;

public abstract class JobField {
    //Fields
    public int id;
    //class variable. associated to class itself
    public int nextId = 1;
    //Var to store description of CC
    public String value;

    //Constructors
    //set id of object, using private class variable
    public JobField() {
        this.id = nextId;
        nextId++;
    }
    //
    public JobField(String value) {
        this(); //call default constructor, which sets id
        this.value = (isNull(value) || value.trim().isEmpty()) ? "Data not available" : value;
    }
    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JobField)) return false;
        JobField that = (JobField) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    //Get/Set
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getId() {
        return id;
    }


}