package com.sao.postit.util.tsg;


import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.text.ParseException;

/**
 * @author saozd
 * @project dummy.example.tsg courseexample
 * 31.07.2023 Tem 2023
 */
public class TsgPanel extends JPanel {
    private MaskFormatter maskFormatter;
    private JFormattedTextField tsgDate;
    private JButton btnDate;

    /**
     * Creates a new <code>JPanel</code> with a double buffer
     * and a flow layout.
     */
    public TsgPanel(String format, int columns) {
        try {
            this.setLayout(new BorderLayout());
            this.maskFormatter = new MaskFormatter(format);
            this.tsgDate = new JFormattedTextField(maskFormatter);
            btnDate = new JButton(new ImageIcon("swing/icons/calendar.png"));
            tsgDate.setColumns(columns);
            this.add(tsgDate, BorderLayout.CENTER);
            this.add(btnDate, BorderLayout.LINE_END);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates a new <code>JPanel</code> with a double buffer
     * and a flow layout.
     */
    public TsgPanel(String format) {
        this(format,10);
    }

}
