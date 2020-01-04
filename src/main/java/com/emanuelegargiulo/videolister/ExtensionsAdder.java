/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emanuelegargiulo.videolister;

import java.util.ArrayList;

/**
 *
 * @author emanuelegargiulo
 */
public class ExtensionsAdder {

    private static ArrayList<String> extensions = new ArrayList<String>();
    
    public static void resetFilter() {
        extensions = new ArrayList<String>();
    }

    public static void addExtension(String ext) {
        extensions.add(ext);
    }

    public static void removeExtension(String ext) {
        extensions.remove(ext);
    }

    public static String[] getFilter() {
        return extensions.toArray(new String[extensions.size()]);
    }

    public static void addAudio() {
        extensions.add("mp3");
        extensions.add("flac");
        extensions.add("m4a");
        extensions.add("wav");
        extensions.add("mp4");
    }

    public static void addVideo() {
        String[] filter = {"avi", "mkv", "m4v", "mov", "webm", "flv", "vob", "ogv", "ogg", "gif", "gifv", "mng", "ts", "mts", "m2ts", "qt", "wmv", "yuv", "rm", "rmvb", "asf", "amv", "mp4", "m4p", "m4v", "mpg", "mp2", "mpeg", "mpe", "mpv", "m2v", "svi", "3gp", "3g2", "mxf", "roq", "nsv", "flv", "f4v", "f4p", "f4a", "f4b"};
        for (int i = 0; i < filter.length; i++) {
            extensions.add(filter[i]);
        }
    }

    public static void addDocs() {
        String[] filter = {"doc","docx","odt","pages","numbers", "csv", "xlsx","xlsm","xlsb","xls","xlm","txt","pdf"};
        for (int i = 0; i < filter.length; i++) {
            extensions.add(filter[i]);
        }
    }
    
        public static void addPics() {
        String[] filter = {"JPG","JPEG","PNG","GIF","TIFF","RAW","INDD","AI","PDF","PSD","EPS"};
        for (int i = 0; i < filter.length; i++) {
            extensions.add(filter[i]);
        }
    }
    
    

}
