package com.sao.swing.slider;

import javax.swing.*;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author saozdemir
 * @project javaworkspace
 * @date 17 Şub 2025
 * <p>
 * @description:
 */
public class FrmSlider extends JFrame {
    private JPanel pnlCommon = new JPanel();
    private JButton btnVoice = new JButton("Voice");

    private JPopupMenu voiceMenu = new JPopupMenu();
    private JPanel pnlVoice = new JPanel();
    private JToggleButton tbVoice = new JToggleButton("V");
    private JSlider sliderVoice = new JSlider(JSlider.HORIZONTAL, 0, 100, 25);
    private JCheckBox chbIsActive = new JCheckBox("Active");

    private JLabel lblVoice = new JLabel("Voice: ");

    public FrmSlider() throws HeadlessException {
        this.setTitle("Slider");
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(800,800));
        tbVoice.setSize(new Dimension(25,25));
        pnlCommon.add(btnVoice);
        pnlCommon.add(lblVoice);
        pnlCommon.setLayout(new FlowLayout(FlowLayout.CENTER));


        this.add(pnlCommon, BorderLayout.CENTER);
        this.setVisible(true);

        initPopup();

        actions();
    }

    private void initPopup() {
        pnlVoice.add(tbVoice);
        pnlVoice.add(sliderVoice);
        pnlVoice.add(chbIsActive);
        voiceMenu.add(pnlVoice);
        voiceMenu.setSize(new Dimension(200,200));
        sliderVoice.setMinorTickSpacing(1);
        sliderVoice.setMajorTickSpacing(10);

    }

    private void actions() {
        btnVoice.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                voiceMenu.show(e.getComponent(), e.getX()-30, e.getY()-60);
            }
        });

        voiceMenu.addPopupMenuListener(new PopupMenuListener() {
            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {

            }

            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {

            }

            @Override
            public void popupMenuCanceled(PopupMenuEvent e) {
                lblVoice.setText("Voice: " + sliderVoice.getValue() + " | " + tbVoice.isSelected() + " | " + chbIsActive.isSelected());
            }
        });
    }


}
