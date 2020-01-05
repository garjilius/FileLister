/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emanuelegargiulo.filelister;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class responsible of the handling of the filter
 *
 * @author emanuelegargiulo
 */
public class ExtensionsAdder {

    private static ArrayList<String> extensions = new ArrayList<String>();

    /**
     * Deletes all extensions from the filter
     */
    public static void resetFilter() {
        extensions = new ArrayList<>();
    }

    /**
     * Adds a single extension to the filter
     *
     * @param ext extension to add
     */
    public static void addExtension(String ext) {
        extensions.add(ext);
    }

    /**
     * Adds all extensions from an array of strings to the filter
     *
     * @param ext the array of strings containing the extensions to add
     */
    public static void addExtensions(String[] ext) {
        for (int i = 0; i < ext.length; i++) {
            //I need to do it this way instead of using extensions.add all because extensions would then be case sensitive!
            extensions.add(ext[i].toLowerCase());
            extensions.add(ext[i].toUpperCase());
        }
    }

    /**
     * Removes a specific extension from the filter
     *
     * @param ext the extension to remove
     */
    public static void removeExtension(String ext) {
        extensions.remove(ext);
    }

    /**
     * Returns the filter in an array format
     *
     * @return
     */
    public static String[] getFilter() {
        return extensions.toArray(new String[extensions.size()]);
    }

    /**
     * Adds extension related to audio files. Possibly incomplete list.
     */
    public static void addAudio() {

        String[] filter = {"mp3", "flac", "m4a", "wav", "mp4"};
        extensions.addAll(Arrays.asList(filter));

    }

    /**
     * Adds extension related to video files. Possibly incomplete list.
     */
    public static void addVideo() {
        String[] filter = {"avi", "mkv", "m4v", "mov", "webm", "flv", "vob", "ogv", "ogg", "gif", "gifv", "mng", "ts", "mts", "m2ts", "qt", "wmv", "yuv", "rm", "rmvb", "asf", "amv", "mp4", "m4p", "m4v", "mpg", "mp2", "mpeg", "mpe", "mpv", "m2v", "svi", "3gp", "3g2", "mxf", "roq", "nsv", "flv", "f4v", "f4p", "f4a", "f4b"};
        addExtensions(filter);
    }

    /**
     * Adds extension related to documents . Possibly incomplete list.
     */
    public static void addDocs() {
        String[] filter = {"doc", "docx", "odt", "pages", "numbers", "csv", "xlsx", "xlsm", "xlsb", "xls", "xlm", "txt", "pdf"};
        addExtensions(filter);
    }

    /**
     * Adds extension related to images. Possibly incomplete list.
     */
    public static void addPics() {
        String[] filter = {"JPG", "JPEG", "PNG", "GIF", "TIFF", "RAW", "INDD", "AI", "PDF", "PSD", "EPS"};
        addExtensions(filter);
    }

}
