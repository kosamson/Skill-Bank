package src.main.java;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppGUI {
    public static void main(String[] args) {
        // a comment
        SBApp app = new SBApp();

        JFrame mainFrame = new JFrame();
        mainFrame.setSize(500, 300);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JLabel infoDisplay = new JLabel();
        infoDisplay.setText("Skill Bank Display");
        infoDisplay.setBounds(50, 0, 200, 300);

        JTextArea addSkillInput = new JTextArea();
        addSkillInput.setBounds(300, 25, 150, 20);

        JButton addSkillButton = new JButton("Add Skill");
        addSkillButton.setBounds(300, 50, 150, 25);

        addSkillButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String label = addSkillInput.getText();
                app.addSkill(label);
                infoDisplay.setText(convertToHTML(app.sbInfo()));
                addSkillInput.setText("");
            }
        });

        JTextArea incrementSkillLabelInput = new JTextArea();
        incrementSkillLabelInput.setBounds(300, 100, 150, 20);

        JTextArea incrementSkillHoursInput = new JTextArea();
        incrementSkillHoursInput.setBounds(300, 125, 150, 20);

        JButton incrementSkillButton = new JButton("Increment Skill");
        incrementSkillButton.setBounds(300, 150, 150, 25);

        incrementSkillButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String label = incrementSkillLabelInput.getText();
                double hours = Double.parseDouble(incrementSkillHoursInput.getText());
                app.incrementSkill(label, hours);
                infoDisplay.setText(convertToHTML(app.sbInfo()));
                incrementSkillHoursInput.setText("");
                incrementSkillLabelInput.setText("");
            }
        });

        mainFrame.add(infoDisplay);
        mainFrame.add(addSkillButton);
        mainFrame.add(addSkillInput);
        mainFrame.add(incrementSkillButton);
        mainFrame.add(incrementSkillHoursInput);
        mainFrame.add(incrementSkillLabelInput);

        mainFrame.setLayout(null);
        mainFrame.setVisible(true);
    }

    private static String convertToHTML(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append("<html><h3>");

        // Add a breakline in between each skill
        sb.append(s.replace(", ", "<br>"));

        sb.append("</h3></html>");
        return sb.toString();
    }
}
