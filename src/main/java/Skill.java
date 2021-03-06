package src.main.java;

import java.io.Serializable;

public class Skill implements Cloneable, Serializable, Comparable {
    private String name;
    private double hours;

    public Skill() {
        this.name = "Unnamed Skill";
        this.hours = 0;
    }

    public Skill(String label) {
        this.name = label;
        this.hours = 0;
    }

    public Skill(String label, double time) {
        if (time < 0)
            throw new IllegalArgumentException("Time must be greater than or equal to zero");

        this.name = label;
        this.hours = time;
    }

    public Skill(double time) {
        if (time < 0)
            throw new IllegalArgumentException("Time must be greater than or equal to zero");

        this.name = "Unnamed Skill";
        this.hours = time;
    }

    public Skill(Skill otherSkill) {
        this.name = otherSkill.name;
        this.hours = otherSkill.hours;
    }

    public double getHours() {
        return this.hours;
    }

    public String getName() {
        return this.name;
    }

    public boolean setHours(double time) {
        if (time < 0)
            return false;

        this.hours = time;
        return true;
    }

    public boolean incrementHours(double time) {
        this.hours += Math.abs(time);
        return true;
    }

    public boolean decrementHours(double time) {
        if (this.hours - time < 0) {
            this.hours = 0;
            return true;
        }

        this.hours -= Math.abs(time);
        return true;
    }

    public boolean setName(String label) {
        this.name = label;
        return true;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null)
            throw new IllegalArgumentException("Illegal null argument");
        
        if (!(other instanceof Skill))
            throw new IllegalArgumentException("Illegal argument type");

        Skill otherSkill = (Skill) other;

        return this.name == otherSkill.name && this.hours == otherSkill.hours;
    }

    @Override
    public String toString() {
        return this.name + ": " + this.hours + " hours";
    }

    @Override
    public Skill clone() {
        return new Skill(this);
    }

    @Override 
    public int compareTo(Object other) {
        if (other == null)
            throw new IllegalArgumentException("Illegal null argument");
        
        if (!(other instanceof Skill))
            throw new IllegalArgumentException("Illegal argument type");

        Skill otherSkill = (Skill) other;
        if (this.hours > otherSkill.hours)
            return 1;
        
        else if (this.hours < otherSkill.hours)
            return -1;

        return 0;
    }

    public int compareToByName(Object other) {
        if (other == null)
            throw new IllegalArgumentException("Illegal null argument");
        
        if (!(other instanceof Skill))
            throw new IllegalArgumentException("Illegal argument type");

        Skill otherSkill = (Skill) other;

        if (this.name.toLowerCase().compareTo(otherSkill.name.toLowerCase()) > 0)
            return 1;
        
        else if (this.name.toLowerCase().compareTo(otherSkill.name.toLowerCase()) < 0)
            return -1;

        return 0;
    }
}