package com.sao.swing.table.filechooser;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;
import java.io.File;
import java.util.List;

/**
 * @author xsaozdemir
 * @project javaworkspace com.sao.swing.table.filechooser
 * @date 29.Kas.2023
 * <p>
 * @description:
 */
public class DndExample extends JFrame{
    private JLabel label;

    public DndExample() {
        super("Resim Sürükle-Bırak Uygulaması");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);

        label = new JLabel();
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setOpaque(true);
        label.setBackground(Color.LIGHT_GRAY);

        label.setTransferHandler(new ImageTransferHandler());

        new DropTarget(label, DnDConstants.ACTION_COPY, new ImageDropTargetListener());

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(label, BorderLayout.CENTER);

        add(panel);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class ImageDropTargetListener extends DropTargetAdapter {
        @Override
        public void drop(DropTargetDropEvent event) {
            try {
                Transferable transferable = event.getTransferable();

                if (transferable.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
                    event.acceptDrop(DnDConstants.ACTION_COPY);
                    List<File> files = (List<File>) transferable.getTransferData(DataFlavor.javaFileListFlavor);

                    if (files.size() > 0) {
                        File selectedFile = files.get(0);
                        resimGoster(selectedFile);
                    }

                    event.dropComplete(true);
                } else {
                    event.rejectDrop();
                }
            } catch (Exception e) {
                e.printStackTrace();
                event.rejectDrop();
            }
        }
    }

    private class ImageTransferHandler extends TransferHandler {
        @Override
        public boolean canImport(TransferSupport support) {
            if (!support.isDrop()) {
                return false;
            }

            if (!support.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
                return false;
            }

            Transferable transferable = support.getTransferable();

            try {
                List<File> files = (List<File>) transferable.getTransferData(DataFlavor.javaFileListFlavor);

                if (files.size() == 1) {
                    File file = files.get(0);
                    String fileName = file.getName().toLowerCase();
                    return fileName.endsWith(".jpg") || fileName.endsWith(".jpeg") ||
                            fileName.endsWith(".png") || fileName.endsWith(".gif");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return false;
        }

        @Override
        public boolean importData(TransferSupport support) {
            if (!canImport(support)) {
                return false;
            }

            Transferable transferable = support.getTransferable();

            try {
                List<File> files = (List<File>) transferable.getTransferData(DataFlavor.javaFileListFlavor);

                if (files.size() > 0) {
                    File selectedFile = files.get(0);
                    resimGoster(selectedFile);
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return false;
        }
    }

    private void resimGoster(File file) {
        try {
            ImageIcon imageIcon = new ImageIcon(file.getPath());
            Image image = imageIcon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);

            ImageIcon scaledIcon = new ImageIcon(image);
            label.setIcon(scaledIcon);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Resim yüklenirken bir hata oluştu.", "Hata", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DndExample());
    }
}
