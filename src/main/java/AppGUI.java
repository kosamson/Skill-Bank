package src.main.java;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppGUI {
    public static void main(String[] args) {
        // a comment
        SBApp app = new SBApp();

        JFrame jf = new JFrame();
        jf.setSize(1000, 1000);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JTextArea jta = new JTextArea();
        jta.setBounds(550, 600, 100, 100);

        JButton jb2 = new JButton("Add Skill");
        jb2.setBounds(400, 400, 200, 100);

        jb2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String label = jta.getText();
                app.addSkill(label);
            }
        });

        // Add placeholder text to text fields

        JLabel jl1 = new JLabel();
        jl1.setText("Skill Bank Display");
        jl1.setBounds(50, 50, 400, 600);

        JButton jb = new JButton();
        jb.setText("Update Display");
        jb.setBounds(250, 250, 200, 100);

        jb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String convertedInfo = convertToHTML(app.sbInfo());
                jl1.setText(convertedInfo);
            }
        });

        jf.add(jb);
        jf.add(jl1);
        jf.add(jb2);
        jf.add(jta);

        jb.setVisible(true);
        jl1.setVisible(true);
        jb2.setVisible(true);
        jta.setVisible(true);

        jf.setLayout(null);
        jf.setVisible(true);
    }

    private static String convertToHTML(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append("<html><p>");

        // Add a breakline in between each skill
        sb.append(s.replace(", ", "<br>"));

        sb.append("</p></html>");
        System.out.println(sb.toString());
        return sb.toString();
    }
}
