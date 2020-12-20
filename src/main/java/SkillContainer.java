package src.main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SkillContainer {
    private Map<String, Skill> skills = new HashMap<String, Skill>();

    public boolean addSkill(Skill s) {
        skills.put(s.getName(), s.clone());
        return true;
    }

    public boolean addSkill(String label) {
        skills.put(label, new Skill(label));
        return true;
    }

    public boolean addSkill(String label, double time) {
        if (time < 0)
            return false;

        skills.put(label, new Skill(label, time));
        return true;
    }

    public Skill getSkill(String s) {
        return this.skills.get(s);
    }

    public boolean incrementSkillHours(String s, double time) {
        this.skills.get(s).incrementHours(time);
        return true;
    }

    @Override
    public String toString() {
        if (this.skills.isEmpty())
            return "Skill Bank is empty";

        String retVal = "";

        for (String label : skills.keySet()) {
            retVal += skills.get(label) + "\n";
        }

        return retVal;
    }
}
