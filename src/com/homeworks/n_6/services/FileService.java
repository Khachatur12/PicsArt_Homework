package com.homeworks.n_6.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileService {
    public String[] getStringArray(Path path) {
        String[] result = new String[0];
        try {
            result = Files.readAllLines(path).toArray(new String[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
