package com.sao.postit.view.password;

import com.sao.postit.util.bundle.BundleReader;

import javax.swing.*;
import java.awt.*;

/**
 * @author saozd
 * @project com.sao.postit.view.password courseexample
 * 4.06.2023 Haz 2023
 */
public class PnlPassword extends JPanel {
    private JLabel lblUserName = new JLabel(BundleReader.getString("PST.enter.userName"));
    private JLabel lblPassword = new JLabel(BundleReader.getString("PST.enter.password"));
    private JTextField txtUserName = new JTextField(10);
    private JPasswordField txtPassword = new JPasswordField(10);
    private JButton btnOk = new JButton(BundleReader.getString("PST.enter.ok"));
    private JButton btnCancel = new JButton(BundleReader.getString("PST.enter.cancel"));

    /**
     * Creates a new <code>JPanel</code> with a double buffer
     * and a flow layout.
     */
    public PnlPassword() {
        init();
    }

    private void init() {
        this.setLayout(new GridBagLayout());
        //int gridx, int gridy,int gridwidth, int gridheight,double weightx, double weighty,int anchor, int fill,Insets insets, int ipadx, int ipady
        this.add(lblUserName, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(1, 5, 1, 1), 1, 1));
        this.add(txtUserName, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(1, 5, 1, 1), 1, 1));
        this.add(lblPassword, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(1, 5, 1, 1), 1, 1));
        this.add(txtPassword, new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(1, 5, 1, 1), 1, 1));
        this.add(btnOk, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL, new Insets(1, 5, 1, 1), 1, 1));
        this.add(btnCancel, new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL, new Insets(1, 5, 1, 1), 1, 1));
    }

    public JLabel getLblUserName() {
        return lblUserName;
    }

    public void setLblUserName(JLabel lblUserName) {
        this.lblUserName = lblUserName;
    }

    public JLabel getLblPassword() {
        return lblPassword;
    }

    public void setLblPassword(JLabel lblPassword) {
        this.lblPassword = lblPassword;
    }

    public JTextField getTxtUserName() {
        return txtUserName;
    }

    public void setTxtUserName(JTextField txtUserName) {
        this.txtUserName = txtUserName;
    }

    public JPasswordField getTxtPassword() {
        return txtPassword;
    }

    public void setTxtPassword(JPasswordField txtPassword) {
        this.txtPassword = txtPassword;
    }

    public JButton getBtnOk() {
        return btnOk;
    }

    public void setBtnOk(JButton btnOk) {
        this.btnOk = btnOk;
    }

    public JButton getBtnCancel() {
        return btnCancel;
    }

    public void setBtnCancel(JButton btnCancel) {
        this.btnCancel = btnCancel;
    }
}
