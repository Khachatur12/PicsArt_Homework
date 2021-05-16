package com.homeworks.n_8.repo;

import com.homeworks.n_8.ProjectInitializer;
import com.homeworks.n_8.models.User;
import com.homeworks.n_8.services.FileService;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.LinkedList;
import java.util.List;

public class UserRepoImpl implements UserRepo {
    private FileService fileService;
    private Path users_data_path;
    private String separation;

    public UserRepoImpl(FileService fileService, Path users_data_path, String separation) {
        this.fileService = fileService;
        this.users_data_path = users_data_path;
        this.separation = separation;
    }


    @Override
    public void saveUser(User u) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append(u.getFullName()).append(separation)
                .append(u.getUsername()).append(separation)
                .append(u.getEmail()).append(separation)
                .append(u.getPassword()).append("\n");

        try {
            fileService.write(users_data_path, stringBuilder.toString(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUserByUsername(String name) {
        User user = null;
        List<User> users = getUsers();
        for (User u : users) {
            if (u.getUsername().equals(name))
                user = u;
        }

        return user;
    }

    @Override
    public List<User> getUsers() {
        List<String> info = fileService.getLinesList(users_data_path);

        List<User> users = new LinkedList<>();
        for (String s : info) {
            String[] split = s.split(ProjectInitializer.USER_DATA_SEPARATION);
            users.add(new User(
                    split[0],
                    split[1],
                    split[2],
                    split[3]));
        }

        return users;
    }



    public FileService getFileService() {
        return fileService;
    }

    public void setFileService(FileService fileService) {
        this.fileService = fileService;
    }

    public Path getUsers_data_path() {
        return users_data_path;
    }

    public void setUsers_data_path(Path users_data_path) {
        this.users_data_path = users_data_path;
    }

    public String getSeparation() {
        return separation;
    }

    public void setSeparation(String separation) {
        this.separation = separation;
    }
}
