package org.launchcode.techjobs.oo;

import java.util.Objects;

import static java.util.Objects.isNull;

public class CoreCompetency {
//Fields
    private int id;
    //class variable. associated to class itself
    private static int nextId = 1;
    //Var to store description of CC
    private String value;
//Constructors
    //set id of object, using private class variable
    public CoreCompetency() {
        this.id = nextId;
        nextId++;
    }
    //
    public CoreCompetency(String value) {
        this(); //call default constructor, which sets id
        this.value = (isNull(value) || value.trim().isEmpty()) ? "Data not available" : value;
    }

    // Custom toString, equals, and hashCode methods:

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CoreCompetency)) return false;
        CoreCompetency that = (CoreCompetency) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // TODO: Use the "Generate" tool to add a getter and setter for the 'value' field but
    //  ONLY a getter for the 'id' field.


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
