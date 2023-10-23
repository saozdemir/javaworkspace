package com.sao.postit.util.exceptions;

import com.sao.postit.util.bundle.BundleReader;

import javax.swing.*;
import java.awt.*;

/**
 * @author saozd
 * @project com.sao.postit.util.exceptions courseexample
 * 7.06.2023 Haz 2023
 */
public final class ExceptionHandler {
    private static JPanel pnlCommon = new JPanel(new BorderLayout());
    private static JPanel pnlError = new JPanel(new BorderLayout());
    private static JPanel pnlErrorMessage = new JPanel(new BorderLayout());
    private static JLabel lblError = new JLabel();
    private static JLabel lblErrorMessage = new JLabel();

    private ExceptionHandler() {
        initPanel();
    }

    public static void showMessage(Exception e) {
        lblError.setText(BundleReader.getString("PST.exception.dialog.error"));
        lblErrorMessage.setText(e.getMessage());

        initPanel();
        JOptionPane.showMessageDialog(null, pnlCommon, BundleReader.getString("PST.exception.dialog.errorMessage"), JOptionPane.ERROR_MESSAGE);
    }

    private static void initPanel() {

        pnlErrorMessage.setBorder(BorderFactory.createLoweredBevelBorder());

        pnlError.add(lblError, BorderLayout.CENTER);
        pnlErrorMessage.add(lblErrorMessage, BorderLayout.CENTER);

        pnlCommon.add(pnlError, BorderLayout.PAGE_START);
        pnlCommon.add(pnlErrorMessage, BorderLayout.CENTER);
    }
}
