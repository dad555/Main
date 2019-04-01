package com.artur.htmleditor;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class HTMLFileFilter extends FileFilter {
    @Override
    public boolean accept(File f) {
        if (f.isDirectory()) return true;
        if (f.getName().toLowerCase().endsWith(".htm")) return true;
        if (f.getName().toLowerCase().endsWith(".html")) return true;
        return false;
    }

    @Override
    public String getDescription() {
        return "HTML и HTM файлы";
    }
}
