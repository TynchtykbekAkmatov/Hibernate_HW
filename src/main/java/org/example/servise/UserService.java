package org.example.servise;

import org.example.model.User;

import java.util.List;

public interface UserService {
    void createUsersTable();

    void dropUsersTable();

    void saveUser(String name, String lastName, byte age);

    void removeUserById(long id);

    List<User> getAllUsers();

    void cleanUsersTable();

    User getById(Long id);

    User updateUser(Long id, String name, String lastName, int age);
}
