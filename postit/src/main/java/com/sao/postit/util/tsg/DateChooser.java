package com.sao.postit.util.tsg;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

/**
 * @author saozd
 * @project dummy.example.tsg courseexample
 * 31.07.2023 Tem 2023
 */
public class DateChooser {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Java Swing Calendar Örneği");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JDateChooser dateChooser = new JDateChooser();
        frame.add(dateChooser);

        JButton button = new JButton("Seçili Tarihi Göster");
        button.addActionListener(e -> {
            Date selectedDate = dateChooser.getDate();
            JOptionPane.showMessageDialog(frame, "Seçili Tarih: " + selectedDate);
        });
        frame.add(button);

        frame.pack();
        frame.setVisible(true);
    }
}
