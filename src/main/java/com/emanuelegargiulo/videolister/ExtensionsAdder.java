/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emanuelegargiulo.videolister;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author emanuelegargiulo
 */
public class ExtensionsAdder {

    private static ArrayList<String> extensions = new ArrayList<String>();

    public static void resetFilter() {
        extensions = new ArrayList<>();
    }

    public static void addExtension(String ext) {
        extensions.add(ext);
    }
    
    public static void addExtensions(String[] ext) {
             for (int i = 0; i < ext.length; i++) {
            //I need to do it this way instead of using extensions.add all because extensions would then be case sensitive!
            extensions.add(ext[i].toLowerCase());
            extensions.add(ext[i].toUpperCase());
        }
    }

    public static void removeExtension(String ext) {
        extensions.remove(ext);
    }

    public static String[] getFilter() {
        return extensions.toArray(new String[extensions.size()]);
    }

    public static void addAudio() {

        String[] filter = {"mp3", "flac", "m4a", "wav", "mp4"};
        extensions.addAll(Arrays.asList(filter));

    }

    public static void addVideo() {
        String[] filter = {"avi", "mkv", "m4v", "mov", "webm", "flv", "vob", "ogv", "ogg", "gif", "gifv", "mng", "ts", "mts", "m2ts", "qt", "wmv", "yuv", "rm", "rmvb", "asf", "amv", "mp4", "m4p", "m4v", "mpg", "mp2", "mpeg", "mpe", "mpv", "m2v", "svi", "3gp", "3g2", "mxf", "roq", "nsv", "flv", "f4v", "f4p", "f4a", "f4b"};
        addExtensions(filter);
    }

    public static void addDocs() {
        String[] filter = {"doc", "docx", "odt", "pages", "numbers", "csv", "xlsx", "xlsm", "xlsb", "xls", "xlm", "txt", "pdf"};
        addExtensions(filter);
    }

    public static void addPics() {
        String[] filter = {"JPG", "JPEG", "PNG", "GIF", "TIFF", "RAW", "INDD", "AI", "PDF", "PSD", "EPS"};
        addExtensions(filter);
    }

}
