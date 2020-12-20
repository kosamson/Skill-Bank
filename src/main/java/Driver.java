package src.main.java;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        SBApp sb = new SBApp();

        System.out.println("Main Started");

        Scanner console = new Scanner(System.in);

        while (true) {
            String inputLine = console.nextLine();

            String[] tokens = inputLine.split(" ");

            if (tokens[0].equals("quit")) {
                System.out.println("Quit");
                break;
            }

            else if (tokens[0].equals("add")) {
                String skillName = tokens[1];
                sb.addSkill(skillName);
                System.out.println("Successfully added skill: " + skillName + " to Skill Bank");
            }

            else if (tokens[0].equals("increment")) {
                String skillName = tokens[1];
                int hours = Integer.parseInt(tokens[2]);
                sb.incrementSkill(skillName, hours);
                System.out.println("Successfully incremented skill: " + skillName + " by " + hours + " hours");
            }

            else if (tokens[0].equals("display")) {
                System.out.println("Displaying Skill Bank:");
                System.out.println(sb.sbInfo());
            }

            else {
                System.out.println("ERROR Invalid command: " + inputLine);
            }
        }
    }
}
