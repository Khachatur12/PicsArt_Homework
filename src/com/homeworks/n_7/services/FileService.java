package com.homeworks.n_7.services;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileService {
    public String[] getLineArray(Path path) {
        String[] result = new String[0];
        try {
            result = Files.readAllLines(path).toArray(new String[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public String getParameter(Path path, String key) {
        String[] lineArray = getLineArray(path);
        for (String line : lineArray) {
            String[] split = line.split("=");
            if (split[0].equals(key))
                return split[1];
        }

        return null;
    }

    public void setParameter(Path path, String key, String value) throws IOException {
        String[] lineArray = getLineArray(path);
        StringBuilder newText = new StringBuilder();
        for (String line : lineArray) {
            String[] split = line.split("=");
            if (split[0].equals(key))
                split[1] = value;
            newText.append(split[0]);
            newText.append("=");
            newText.append(split[1]);
            newText.append("\n");
        }

        write(path, newText.toString(), StandardOpenOption.CREATE);
    }

    public void write(Path path, String str, StandardOpenOption so) throws IOException {
        Files.write(path, str.getBytes(StandardCharsets.UTF_8), so);
    }
}
