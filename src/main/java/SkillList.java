package src.main.java;

import java.util.ArrayList;
import java.util.List;

public class SkillList {
    private List<Skill> skills = new ArrayList<Skill>();

    public boolean addSkill(Skill s) {
        skills.add(s.clone());
        return true;
    }

    public boolean addSkill(String label) {
        skills.add(new Skill(label));
        return true;
    }

    public boolean addSkill(String label, double time) {
        if (time < 0)
            return false;

        skills.add(new Skill(label, time));
        return true;
    }

    public Skill getSkill(String s) {
        for (Skill sk : skills) {
            if (sk.getName().equals(s))
                return sk.clone();
        }

        throw new IllegalArgumentException("No skill with label: " + s + " found.");
    }


    public void sortByHoursAscending() {
        quickSortHoursAscending(0, skills.size() - 1);
    }

    private void quickSortHoursAscending(int lowIdx, int highIdx) {
        if (lowIdx < highIdx) {
            int part = partitionHoursAscending(lowIdx, highIdx);

            quickSortHoursAscending(lowIdx, part - 1);
            quickSortHoursAscending(part + 1, highIdx);
        }
    }

    private int partitionHoursAscending(int lowIdx, int highIdx) {
        int pivotIdx = (int) (Math.random() * (highIdx - lowIdx + 1) + lowIdx);

        swap(lowIdx, pivotIdx);

        int lowPt = lowIdx + 1;
        int highPt = highIdx;

        Skill pivotSkill = skills.get(lowIdx);

        while (lowPt <= highPt) {
            if (skills.get(lowPt).compareTo(pivotSkill) >= 0) {
                swap(lowPt, highPt);
                highPt--;
            }

            else 
                lowPt++;
        }

        swap(lowIdx, highPt);

        return highPt;
    }

    public void sortByHoursDescending() {
        quickSortHoursDescending(0, skills.size() - 1);
    }

    private void quickSortHoursDescending(int lowIdx, int highIdx) {
        if (lowIdx < highIdx) {
            int part = partitionHoursDescending(lowIdx, highIdx);

            quickSortHoursDescending(lowIdx, part - 1);
            quickSortHoursDescending(part + 1, highIdx);
        }
    }

    private int partitionHoursDescending(int lowIdx, int highIdx) {
        int pivotIdx = (int) (Math.random() * (highIdx - lowIdx + 1) + lowIdx);

        swap(lowIdx, pivotIdx);

        int lowPt = lowIdx + 1;
        int highPt = highIdx;

        Skill pivotSkill = skills.get(lowIdx);

        while (lowPt <= highPt) {
            if (skills.get(lowPt).compareTo(pivotSkill) <= 0) {
                swap(lowPt, highPt);
                highPt--;
            }

            else 
                lowPt++;
        }

        swap(lowIdx, highPt);

        return highPt;
    }

    public void sortByNameAscending() {
        quickSortNameAscending(0, skills.size() - 1);
    }

    private void quickSortNameAscending(int lowIdx, int highIdx) {
        if (lowIdx < highIdx) {
            int part = partitionNameAscending(lowIdx, highIdx);

            quickSortNameAscending(lowIdx, part - 1);
            quickSortNameAscending(part + 1, highIdx);
        }
    }

    private int partitionNameAscending(int lowIdx, int highIdx) {
        int pivotIdx = (int) (Math.random() * (highIdx - lowIdx + 1) + lowIdx);

        swap(lowIdx, pivotIdx);

        int lowPt = lowIdx + 1;
        int highPt = highIdx;

        Skill pivotSkill = skills.get(lowIdx);

        while (lowPt <= highPt) {
            if (skills.get(lowPt).compareToByName(pivotSkill) >= 0) {
                swap(lowPt, highPt);
                highPt--;
            }

            else 
                lowPt++;
        }

        swap(lowIdx, highPt);

        return highPt;
    }

    private void swap(int idx1, int idx2) {
        Skill temp = skills.get(idx1);
        skills.set(idx1, skills.get(idx2));
        skills.set(idx2, temp);
    }

    @Override
    public String toString() {
        String retVal = "";

        for (Skill s : skills) {
            retVal += s + "\n";
        }

        return retVal;
    }
}
