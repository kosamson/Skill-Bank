package src.main.java;

public class SBApp {
    private SkillContainer skills;

    public SBApp() {
        skills = new SkillContainer();
    }

    public void addSkill(String s) {
        if (s.equals(""))
            skills.addSkill(new Skill());

        else
            skills.addSkill(s);
    }

    public void incrementSkill(String s, double time) {
        this.skills.incrementSkillHours(s, time);
    }

    public String sbInfo() {
        return this.skills.toString();
    }
}
