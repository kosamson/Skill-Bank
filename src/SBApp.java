package src;

public class SBApp {
    private SkillList skills;

    public SBApp() {
        skills = new SkillList();
    }

    public void addSkill(String s) {
        skills.addSkill(s);
    }

    public void incrementSkill(String s, double time) {
        skills.getSkill(s).incrementHours(time);
    }
}
