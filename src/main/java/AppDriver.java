package src.main.java;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.*;

public class AppDriver {
    public static void main(String[] args) {
        // a comment
        SBApp app = new SBApp();

        JFrame jf = new JFrame();
        JButton jb = new JButton("Add Skill");
        jb.setBounds(100, 100, 100, 100);

        jf.add(jb);

        jf.setSize(500, 500);
        jf.setLayout(null);
        jf.setVisible(true);

        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.addSkill("Bruh");
            }
        });

    }
}
