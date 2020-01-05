/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emanuelegargiulo.filelister;

import java.io.File;

/**
 * Class responsible of returning size info about the files
 * @author emanuelegargiulo
 */
public class FileInfo {

    /**
     *  
     * @param file
     * @return size in GB
     */
    public static String getFileSizeGigaBytes(File file) {
        return (double) file.length() / (1024 * 1024 * 1024) + " gb";
    }

       /**
     *  
     * @param file
     * @return size in MB
     */
    public static String getFileSizeMegaBytes(File file) {
        double size = file.length() / (1024 * 1024);
        return (double) file.length() / (1024 * 1024) + " mb";
    }
    
     /**
     *  
     * @param file
     * @return size in MB as size only (no "mb" indicator)
     */
        public static String getSizeMB(File file) {
        return (int) file.length() / (1024 * 1024)+"";
    }

     /**
     *  
     * @param file
     * @return size in KB
     */
    public static String getFileSizeKiloBytes(File file) {
        return (double) file.length() / 1024 + "  kb";
    }

    /**
     *  
     * @param file
     * @return size in B
     */
    public static String getFileSizeBytes(File file) {
        return file.length() + " bytes";
    }

}
