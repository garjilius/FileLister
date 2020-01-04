/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emanuelegargiulo.videolister;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javafx.stage.Screen;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author emanuelegargiulo
 */
public class ExtensionsPicker extends JFrame {

    private JLabel description;
    private JPanel panelDescription = new JPanel();

    public ExtensionsPicker() {
        description = new JLabel("Select file types to enumerate");
        this.setLayout(new BorderLayout());
        this.setTitle("Pick type of files to list");
        this.setSize(500, 500);
        this.setAlwaysOnTop(true);
        this.setResizable(false);
        panelDescription.add(description, BorderLayout.NORTH);
        this.add(panelDescription);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addCheckBoxes(this);
        this.setLocation(100, 200);
        this.setVisible(true);

    }

    private void addCheckBoxes(JFrame frame) {
        JPanel extensionsChecksPanel = new JPanel();
        extensionsChecksPanel.setBorder(new TitledBorder(new EtchedBorder(), "File Types"));
        extensionsChecksPanel.setLayout(new GridLayout(1, 4));
        JCheckBox videoCB = new JCheckBox("Video");
        JCheckBox audioCB = new JCheckBox("Audio");
        JCheckBox picCB = new JCheckBox("Pictures");
        JCheckBox docCB = new JCheckBox("Documents");
        extensionsChecksPanel.add(videoCB);
        extensionsChecksPanel.add(audioCB);
        extensionsChecksPanel.add(picCB);
        extensionsChecksPanel.add(docCB);
        frame.add(extensionsChecksPanel, BorderLayout.CENTER);
    }

}
