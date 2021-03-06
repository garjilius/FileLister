/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emanuelegargiulo.filelister;

import com.opencsv.CSVWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.apache.commons.io.FileUtils;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class responsible of generating the file list from a given folder and extensions filter
 * @author emanuelegargiulo
 */
public class GetList {

    /**
     * Returns the list of files of chosen extensions from the given directory
     * @param directory : files in this directory will be lister
     * @param filter : extensions of the file to list
     * @param picker : graphic window, passed as a parameter to retrieve data from the JFileChooser
     */
    public static void getList(String directory, String[] filter, ExtensionPicker picker) {
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyHHmm");

        Date date = new Date();

        String filename = "/fileList" + formatter.format(date) + ".csv";

        // first create file object for file placed at location 
        // specified by filepath 
        File fileOUT = new File(directory + filename);

        try {
            // create FileWriter object with file as parameter 
            FileWriter outputfile = new FileWriter(fileOUT);

            File dir = new File(directory);
            List<File> files = (List<File>) FileUtils.listFiles(dir, filter, true);

            files.sort((File m1, File m2) -> m1.getName().compareToIgnoreCase(m2.getName()));

            System.out.println(files);

            // create CSVWriter object filewriter object as parameter 
            CSVWriter writer = new CSVWriter(outputfile);

            // adding header to csv 
            String[] header = {"File", "Size (MB)"};
            writer.writeNext(header);
            for (File file : files) {
                String name = file.getName();
                Character firstChar = name.charAt(0);
                //Discards some temporary/metadata files
                if (!(firstChar.equals('$')) && !(firstChar.equals('.'))) {
                    //System.out.println(name);
                    String[] toAdd = {name, FileInfo.getSizeMB(file) };               
                    writer.writeNext(toAdd);
                }
            }

            // closing writer connection 
            writer.close();
            //If the file has been created correctly, a message will be added to the built in textarea
            File tmpDir = new File(directory + filename);
            if (tmpDir.exists()) {
                picker.textLogger(directory + filename + " OK");
            } else {
                picker.textLogger("Errore nella scrittura della lista");
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block 
            e.printStackTrace();
        }

        System.out.println(directory + filename);
    }

}
