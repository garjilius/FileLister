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

import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.commons.io.FileUtils;

public class VideoLister {

    public static String directory;
    public static JFileChooser f;
    public static boolean secondError = false;
    public static int result;
    public static String[] filter = {"avi", "mkv", "m4v", "mov", "webm", "flv", "vob", "ogv", "ogg", "gif", "gifv", "mng", "ts", "mts", "m2ts", "qt", "wmv", "yuv", "rm", "rmvb", "asf", "amv", "mp4", "m4p", "m4v", "mpg", "mp2", "mpeg", "mpe", "mpv", "m2v", "svi", "3gp", "3g2", "mxf", "roq", "nsv", "flv", "f4v", "f4p", "f4a", "f4b"};

    public static void main(String[] args) {
        System.out.println(getVersion());
        f = new JFileChooser();
        f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        f.setApproveButtonText("Open");
        f.setDialogType(JFileChooser.OPEN_DIALOG);
        f.setDialogTitle("Pick a directory to list");
        result = f.showOpenDialog(null);
        if (result == JFileChooser.CANCEL_OPTION) {
            System.out.println("Cancel was selected");
            System.exit(1);
        }
        directory = f.getSelectedFile().getAbsolutePath();

        System.out.println(f.getCurrentDirectory().getAbsolutePath());
        System.out.println(f.getSelectedFile().getAbsolutePath());
        System.out.println("Directory: " + directory);

        getList(directory, filter);

    }

    public static void getList(String directory, String[] filter) {
        PrintWriter printWriter;
        try {
            printWriter = new PrintWriter(directory + "/videoList.txt");

            File dir = new File(directory);
            List<File> files = (List<File>) FileUtils.listFiles(dir, filter, true);

            files.sort((File m1, File m2) -> m1.getName().compareToIgnoreCase(m2.getName()));

            System.out.println(files);

            for (File file : files) {
                String name = file.getName();
                Character firstChar = name.charAt(0);
                //Discards some temporary/metadata files
                if (!(firstChar.equals('$')) && !(firstChar.equals('.'))) {
                    //System.out.println(name);
                    printWriter.println(name);
                }
            }

            printWriter.close();
            JOptionPane.showMessageDialog(null, "All done, list saved in " + directory + "/videoList.txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(VideoLister.class.getName()).log(Level.SEVERE, null, ex);
            if (!secondError) {
                //If it's the first time i meet this error, maybe the directory was entered instead of just picked...             
                System.out.println("First File Not Found Error... retrying with currentDirectory");
                secondError = true;
                directory = f.getCurrentDirectory().getAbsolutePath();
                getList(directory, filter);
            } else {
                System.out.println("(Final) File Not Found Error...");
                JOptionPane.showMessageDialog(null, "I/O Error.\n Did you pick a readonly location?");
            }

        } catch (NullPointerException ex) {
            Logger.getLogger(VideoLister.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Null Pointer Exception");

        }
    }

    private static int getVersion() {
        String version = System.getProperty("java.version");
        if (version.startsWith("1.")) {
            version = version.substring(2, 3);
        } else {
            int dot = version.indexOf(".");
            if (dot != -1) {
                version = version.substring(0, dot);
            }
        }
        return Integer.parseInt(version);
    }

}
