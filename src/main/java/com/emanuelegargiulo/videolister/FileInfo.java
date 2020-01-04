/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emanuelegargiulo.videolister;

import java.io.File;

/**
 *
 * @author emanuelegargiulo
 */
public class FileInfo {

    public static String getFileSizeGigaBytes(File file) {
        return (double) file.length() / (1024 * 1024 * 1024) + " gb";
    }

    public static String getFileSizeMegaBytes(File file) {
        double size = file.length() / (1024 * 1024);
        return (int) file.length() / (1024 * 1024) + " mb";

    }

    public static String getFileSizeKiloBytes(File file) {
        return (double) file.length() / 1024 + "  kb";
    }

    public static String getFileSizeBytes(File file) {
        return file.length() + " bytes";
    }

    //Not Working?
    public static String getBestSize(File file) {
        if ((file.length() / (1024 * 1024)) < 1024 * 1024) { //Less than a GB, print in mb
            return getFileSizeMegaBytes(file);
        } else {
            return getFileSizeGigaBytes(file);
        }
    }

}
