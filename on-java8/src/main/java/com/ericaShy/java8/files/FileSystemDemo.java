package com.ericaShy.java8.files;

import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

/**
 * 文件系统
 */
public class FileSystemDemo {

    static void show(String id, Object o) {
        System.out.println(id + ": " + o);
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));
        FileSystem fsys = FileSystems.getDefault();
        for (FileStore fs : fsys.getFileStores()) {
            show ("File Store", fs);
        }
        for (Path rd : fsys.getRootDirectories()) {
            show ("Root Directory", rd);
        }

        show("Separator", fsys.getSeparator());
        show("UserPrinicpalLoopupService", fsys.getUserPrincipalLookupService());
        show("isOpen", fsys.isOpen());
        show("isReadyOnly", fsys.isReadOnly());
        show("FileSystemProvider", fsys.provider());
        show("File Attribute Views", fsys.supportedFileAttributeViews());
    }
}
