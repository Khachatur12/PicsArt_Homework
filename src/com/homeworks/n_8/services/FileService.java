package com.homeworks.n_8.services;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileService {
    public List<String> getLinesList(Path path) {
        try {
            return Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getParameter(Path path, String key) {
        List<String> list = getLinesList(path);
        for (String line : list) {
            String[] split = line.split("=");
            if (split[0].equals(key))
                return split[1];
        }

        return null;
    }

    public void setParameter(Path path, String key, String value) throws IOException {
        List<String> props = getLinesList(path);
        StringBuilder newText = new StringBuilder();
        for (String line : props) {
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
