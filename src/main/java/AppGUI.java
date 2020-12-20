package src.main.java;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppGUI {
    public static void main(String[] args) {
        // a comment
        SBApp app = new SBApp();

        JFrame mainFrame = new JFrame();
        mainFrame.setSize(500, 500);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JLabel infoDisplay = new JLabel();
        infoDisplay.setText("Skill Bank Display");
        infoDisplay.setBounds(50, 0, 300, 200);

        JTextArea addSkillInput = new JTextArea();
        addSkillInput.setBounds(300, 25, 150, 20);

        JButton addSkillButton = new JButton("Add Skill");
        addSkillButton.setBounds(300, 50, 100, 25);

        addSkillButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String label = addSkillInput.getText();
                app.addSkill(label);
                infoDisplay.setText(convertToHTML(app.sbInfo()));
            }
        });

        // Add placeholder text to text fields

        mainFrame.add(infoDisplay);
        mainFrame.add(addSkillButton);
        mainFrame.add(addSkillInput);

        mainFrame.setLayout(null);
        mainFrame.setVisible(true);
    }

    private static String convertToHTML(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append("<html><p>");

        // Add a breakline in between each skill
        sb.append(s.replace(", ", "<br>"));

        sb.append("</p></html>");
        return sb.toString();
    }
}
