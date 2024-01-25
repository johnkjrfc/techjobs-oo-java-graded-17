package org.launchcode.techjobs.oo;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

public class Job {
    //Fields. declaring w/out type represents class object
    private final int id;
    //
    private static int nextId = 1;

    private String name;
    @FieldOrder(1)
    private Employer employer;
    @FieldOrder(2)
    private Location location;
    @FieldOrder(3)
    private PositionType positionType;
    @FieldOrder(4)
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String name,Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name.isEmpty() ? "Data not available" : name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    //  custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.
    @Override
    public boolean equals(Object o) {  // Two objects are equal if they have the same id.
        if (this == o) return true;
        if (!(o instanceof Job)) return false;
        Job job = (Job) o;
        return getId() == job.getId();
    }
    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {

        String lb = System.lineSeparator();
        return lb +//Start line break
        "ID: " + this.id + lb +
        "Name: " + this.name + lb +
        "Employer: " + this.employer + lb +
        "Location: " + this.location + lb +
        "Position Type: " + this.positionType + lb +
        "Core Competency: " + this.coreCompetency + lb
        ;
        //end line break


    }

    //Utility method that adds a space before second capital letter in CamelCase strings
    private String addSpacesToCamelCase(String input) {
        //?<!^ : ignore first character in string. "negative lookbehind"
        //A-Z: look for all capital letters
        //' $1': add a space before the capital letter
        return input.replaceAll("(?<!^)([A-Z])", " $1");
    }

    // getters for each field EXCEPT nextId. setters for each field EXCEPT nextID
    //  and id.
//Getters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public Location getLocation() {
        return location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }
//Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }


    // SUPER HARD MODE CHALLENGE
    //toString that grabs any class name, if new fields are added later
    //StringBuilder sb = new StringBuilder();
    //        Map<String, String> fieldMap = new HashMap<>();
    //
    //        sb.append("\n"); //Start line break
    //
    //        //Set ID and Name in our string (primitive types)
    //        sb.append("ID: ").append(this.id).append("\n");
    //        sb.append("Name: ").append(this.name).append("\n");
    //        //Loop through fields in Job
    //        for (Field field : this.getClass().getDeclaredFields()) {
    //            field.setAccessible(true);
    //
    //            if (field.isAnnotationPresent(FieldOrder.class)) {
    //                //order stores annotations, which will help sort
    //                int order = field.getAnnotation(FieldOrder.class).value();
    //            }
    //
    //            try {
    //                String fieldName = addSpacesToCamelCase(field.getName());
    //                String fieldValue = field.get(this) == null ? "null": field.get(this).toString();
    //                fieldMap.put(fieldName, fieldValue);
    //            } catch (IllegalAccessException e) {
    //                e.printStackTrace();
    //            }
    //        }
    //
    //        for (Map.Entry<String, String> entry : fieldMap.entrySet()) {
    //            sb.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
    //        }
    //        sb.append("\n"); //end line break
    //        return sb.toString();

}
