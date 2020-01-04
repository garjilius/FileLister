/*
 *  The purpose of this simple application is to list all video files in a given directory.
 *  Created on out of personal necessity, shared in case some one else needs it
 */
package com.emanuelegargiulo.videolister;

/**
 *
 * @author emanuelegargiulo
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.commons.io.FileUtils;

public class VideoLister {

    public static String directory;
    public static JFileChooser f;
    public static boolean secondError = false;
    public static int result;
    public static ArrayList<String> extensions = new ArrayList<String>();
    public static String[] filter = {"avi", "mkv", "m4v", "mov", "webm", "flv", "vob", "ogv", "ogg", "gif", "gifv", "mng", "ts", "mts", "m2ts", "qt", "wmv", "yuv", "rm", "rmvb", "asf", "amv", "mp4", "m4p", "m4v", "mpg", "mp2", "mpeg", "mpe", "mpv", "m2v", "svi", "3gp", "3g2", "mxf", "roq", "nsv", "flv", "f4v", "f4p", "f4a", "f4b"};

    public static void main(String[] args) {
        JFrame picker;
        /* 
        f = new JFileChooser();
        f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        f.setApproveButtonText("Open");
        f.setDialogType(JFileChooser.OPEN_DIALOG);
        f.setDialogTitle("Pick a directory to list");
        f.setVisible(true);
        result = f.showOpenDialog(null);
        if (result == JFileChooser.CANCEL_OPTION) {
            System.out.println("Cancel was selected");
            System.exit(1);
        }

        if (result == JFileChooser.APPROVE_OPTION) {
            System.out.println("ApproveOption");
            picker = new ExtensionPicker(directory);           
        }
        directory = f.getSelectedFile().getAbsolutePath();

        System.out.println(f.getCurrentDirectory().getAbsolutePath());
        System.out.println(f.getSelectedFile().getAbsolutePath());
        System.out.println("Directory: " + directory);
         */
        picker = new ExtensionPicker(directory);

        // GetList.getList(directory, extensions.toArray(new String[extensions.size()]));
    }

}
