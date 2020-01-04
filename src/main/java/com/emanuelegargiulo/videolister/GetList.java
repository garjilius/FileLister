/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emanuelegargiulo.videolister;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.commons.io.FileUtils;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author emanuelegargiulo
 */
public class GetList {

    public static void getList(String directory, String[] filter, ExtensionPicker picker) {
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyHHmm");

        Date date = new Date();

        String filename = "/fileList" + formatter.format(date) + ".txt";
        System.out.println(directory + filename);

        PrintWriter printWriter;
        try {
            printWriter = new PrintWriter(directory + filename);

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
           // JOptionPane.showMessageDialog(null, "All done, list saved in " + directory + filename);
            File tmpDir = new File(directory + filename);
            if (tmpDir.exists()) {
                picker.textLogger(directory + "" + filename);
            } else {
                picker.textLogger("Errore nella scrittura della lista");
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "FileNotFoundException");
            System.exit(0);
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Null Pointer Exception");
        }
    }

}
