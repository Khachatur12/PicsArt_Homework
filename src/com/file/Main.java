package com.file;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        String path = "...";
        File file = new File(path);

        showFilenames(file);
    }

    public static void showFilenames(File file){
        List<File> list = new LinkedList<>();
        list.add(file);

        while (!list.isEmpty()){
            File last = list.get(list.size()-1);

            if (last.isDirectory()){
                for (File f : Objects.requireNonNull(last.listFiles())) {
                    if (f.isDirectory())
                        list.add(f);
                    else
                        System.out.println(f.getName());
                }
            }

            System.out.println(last.getName());
            list.remove(last);
        }
    }
}