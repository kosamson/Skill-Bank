package src;

import java.util.Scanner;

public class AppDriver {
    public static void main(String[] args) {
        SkillList sl = new SkillList();
        String command = "";
        Scanner console = new Scanner(System.in);

        while (!command.equals("exit")) {
            System.out.println("\nSkill Bank");
            System.out.println("----------------------------");
            System.out.println(sl);
            command = console.nextLine();

            if (command.equals("add")) {
                System.out.print("Enter Skill Name: ");
                sl.addSkill(console.nextLine());
            }

            else if (command.equals("exit")) {
                break;
            }

            else 
                System.out.println("\nERROR: Invalid command, please try again.");
        }
    }
}
