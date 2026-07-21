package com.sao.swing.checkedcombobox;

import javax.accessibility.Accessible;
import javax.swing.*;
import javax.swing.event.ListDataListener;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import javax.swing.plaf.basic.ComboPopup;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import java.util.function.Function;

/**
 * @author saozdemir
 * @project javaworkspace
 * @date 21 Tem 2026
 * <p>
 * @description:
 */
public class CheckedComboBox<T> extends JComboBox<CheckedComboBox.CheckableItem<T>> {

    /** Wraps a domain object together with its checked state. */
    public static final class CheckableItem<T> {
        private final T value;
        private boolean selected;

        CheckableItem(T value, boolean selected) {
            this.value = value;
            this.selected = selected;
        }

        public T getValue() {
            return value;
        }

        public boolean isSelected() {
            return selected;
        }

        void setSelected(boolean selected) {
            this.selected = selected;
        }
    }

    /** Listener notified whenever the set of selected items changes. */
    @FunctionalInterface
    public interface SelectionChangeListener<T> {
        void selectionChanged(Set<T> selectedValues);
    }

    private Function<T, String> labelProvider;
    private final List<SelectionChangeListener<T>> listeners = new ArrayList<>();

    /** Guards against the popup closing when an item is toggled. */
    private boolean keepPopupOpen;

    /** No-arg constructor: uses toString() as the label until one is set. */
    public CheckedComboBox() {
        this(Collections.<T>emptyList(), new Function<T, String>() {
            @Override
            public String apply(T t) {
                return String.valueOf(t);
            }
        });
    }

    /**
     * Creates an empty checked combo box.
     *
     * @param labelProvider converts an element to its display text; must not be null
     */
    public CheckedComboBox(Function<T, String> labelProvider) {
        this(Collections.<T>emptyList(), labelProvider);
    }

    /**
     * Creates a checked combo box populated with the given items (all unselected).
     *
     * @param items         initial elements; must not be null
     * @param labelProvider converts an element to its display text; must not be null
     */
    public CheckedComboBox(Collection<? extends T> items, Function<T, String> labelProvider) {
        this.labelProvider = Objects.requireNonNull(labelProvider, "labelProvider");
        Objects.requireNonNull(items, "items");

        DefaultComboBoxModel<CheckableItem<T>> model = new DefaultComboBoxModel<>();
        for (T item : items) {
            model.addElement(new CheckableItem<>(item, false));
        }
        setModel(model);
        setRenderer(new CheckBoxRenderer());

        // Toggle the checked state whenever an item is "selected" (clicked / entered).
        addActionListener(new SelectionToggleHandler());

        // Keep the popup open after a toggle click instead of letting it collapse.
        addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            @Override
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent e) {
            }

            @Override
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent e) {
            }

            @Override
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent e) {
            }
        });
    }

    /** Sets the label provider after construction (e.g. when the no-arg ctor was used). */
    public void setLabelProvider(Function<T, String> labelProvider) {
        this.labelProvider = Objects.requireNonNull(labelProvider, "labelProvider");
        repaint();
    }

    /** Adds an item in the unselected state. */
    public void addValue(T value) {
        addValue(value, false);
    }

    /** Adds an item with an explicit selected state. */
    public void addValue(T value, boolean selected) {
        ((DefaultComboBoxModel<CheckableItem<T>>) getModel())
                .addElement(new CheckableItem<>(value, selected));
    }

    /** Returns an unmodifiable, insertion-ordered set of currently selected values. */
    public Set<T> getSelectedValues() {
        Set<T> result = new LinkedHashSet<>();
        ComboBoxModel<CheckableItem<T>> model = getModel();
        for (int i = 0; i < model.getSize(); i++) {
            CheckableItem<T> item = model.getElementAt(i);
            if (item.isSelected()) {
                result.add(item.getValue());
            }
        }
        return Collections.unmodifiableSet(result);
    }

    /** Programmatically sets the selection to exactly the given values. */
    public void setSelectedValues(Collection<? extends T> values) {
        Set<?> target = new HashSet<>(values);
        ComboBoxModel<CheckableItem<T>> model = getModel();
        for (int i = 0; i < model.getSize(); i++) {
            CheckableItem<T> item = model.getElementAt(i);
            item.setSelected(target.contains(item.getValue()));
        }
        repaint();
        fireSelectionChanged();
    }

    public void addSelectionChangeListener(SelectionChangeListener<T> listener) {
        listeners.add(Objects.requireNonNull(listener));
    }

    public void removeSelectionChangeListener(SelectionChangeListener<T> listener) {
        listeners.remove(listener);
    }

    private void fireSelectionChanged() {
        Set<T> snapshot = getSelectedValues();
        for (SelectionChangeListener<T> l : listeners) {
            l.selectionChanged(snapshot);
        }
    }

    @Override
    public void setPopupVisible(boolean visible) {
        // Swallow the auto-close that Swing triggers right after a toggle click.
        if (keepPopupOpen && !visible) {
            keepPopupOpen = false;
            return;
        }
        super.setPopupVisible(visible);
    }

    /** Toggles the checked state of the clicked item and keeps the popup open. */
    private final class SelectionToggleHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int index = getSelectedIndex();
            if (index < 0) {
                return;
            }
            CheckableItem<T> item = getModel().getElementAt(index);
            item.setSelected(!item.isSelected());

            keepPopupOpen = true; // prevent the imminent close
            repaint();

            // Repaint the open list so the checkbox visually updates.
            Accessible a = getUI().getAccessibleChild(CheckedComboBox.this, 0);
            if (a instanceof ComboPopup) {
                ((ComboPopup) a).getList().repaint();
            }
            fireSelectionChanged();
        }
    }

    /** Renders each row as a checkbox plus its label; the closed field shows a summary. */
    private final class CheckBoxRenderer implements ListCellRenderer<CheckableItem<T>> {
        private final JCheckBox checkBox = new JCheckBox();
        private final DefaultListCellRenderer summary = new DefaultListCellRenderer();

        @Override
        public Component getListCellRendererComponent(
                JList<? extends CheckableItem<T>> list, CheckableItem<T> value,
                int index, boolean isSelected, boolean cellHasFocus) {

            // index < 0 => the collapsed field: show a comma-joined summary.
            if (index < 0 || value == null) {
                summary.getListCellRendererComponent(list, buildSummary(), index, false, false);
                return summary;
            }

            checkBox.setText(labelProvider.apply(value.getValue()));
            checkBox.setSelected(value.isSelected());
            checkBox.setOpaque(true);
            checkBox.setBackground(isSelected ? list.getSelectionBackground() : list.getBackground());
            checkBox.setForeground(isSelected ? list.getSelectionForeground() : list.getForeground());
            checkBox.setFont(list.getFont());
            return checkBox;
        }

        private String buildSummary() {
            StringBuilder sb = new StringBuilder();
            ComboBoxModel<CheckableItem<T>> model = getModel();
            for (int i = 0; i < model.getSize(); i++) {
                CheckableItem<T> item = model.getElementAt(i);
                if (item.isSelected()) {
                    if (sb.length() > 0) sb.append(", ");
                    sb.append(labelProvider.apply(item.getValue()));
                }
            }
            return sb.length() == 0 ? "Seçiniz..." : sb.toString();
        }
    }

    /**
     * Replaces all current items with the given collection (all unselected).
     *
     * @param values new elements; must not be null
     */
    public void setItems(Collection<? extends T> values) {
        Objects.requireNonNull(values, "values");
        DefaultComboBoxModel<CheckableItem<T>> model =
                (DefaultComboBoxModel<CheckableItem<T>>) getModel();
        model.removeAllElements();
        for (T value : values) {
            model.addElement(new CheckableItem<>(value, false));
        }
        fireSelectionChanged();
    }

    /**
     * Appends the given collection to the existing items (all unselected).
     *
     * @param values elements to add; must not be null
     */
    public void addValues(Collection<? extends T> values) {
        Objects.requireNonNull(values, "values");
        DefaultComboBoxModel<CheckableItem<T>> model =
                (DefaultComboBoxModel<CheckableItem<T>>) getModel();
        for (T value : values) {
            model.addElement(new CheckableItem<>(value, false));
        }
    }
}
