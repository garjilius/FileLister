/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emanuelegargiulo.videolister;

import static com.emanuelegargiulo.videolister.VideoLister.f;
import static com.emanuelegargiulo.videolister.VideoLister.secondError;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author emanuelegargiulo
 */
public class GetList {
    
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
    
}
