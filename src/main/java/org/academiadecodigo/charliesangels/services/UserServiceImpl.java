package org.academiadecodigo.charliesangels.services;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class UserServiceImpl implements UserService{

    private Map<String, User> users = new ConcurrentHashMap<>();

    public Map<String, User> getUsers() {
        return users;
    }

    public void setUsers(Map<String, User> users) {
        this.users = users;
    }

    @Override
    public User getUser(String username) {
        return users.get(username);
    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public void deleteUser(User user) {

    }
}
