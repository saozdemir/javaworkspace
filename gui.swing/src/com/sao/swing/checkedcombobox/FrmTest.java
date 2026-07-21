package com.sao.swing.checkedcombobox;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author saozdemir
 * @project javaworkspace
 * @date 21 Tem 2026
 * <p>
 * @description:
 */
public class FrmTest extends JFrame {
    private JPanel pnlCommon = new JPanel(new BorderLayout());
    private CheckedComboBox<Country> cmbCountry = new CheckedComboBox<Country>();

    public FrmTest() throws HeadlessException {
        init();
    }

    private void init() {
        this.setSize(400, 300);
        this.setVisible(true);
        List<Country> countries = Arrays.asList(
                new Country("Turkey", "TR"),
                new Country("United States", "US"),
                new Country("Germany", "DE"),
                new Country("France", "FR"),
                new Country("Italy", "IT"),
                new Country("Spain", "ES"),
                new Country("United Kingdom", "UK")
        );
        cmbCountry.setItems(countries);
        pnlCommon.add(cmbCountry, BorderLayout.NORTH);
        this.setLayout(new BorderLayout());
        this.add(BorderLayout.CENTER, pnlCommon);
    }

    public CheckedComboBox<Country> getCmbCountry() {
        return cmbCountry;
    }
}
