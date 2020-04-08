package org.academiadecodigo.charliesangels.services;

import org.academiadecodigo.charliesangels.models.User;

public interface UserService {

    /**
     *
     * @param username
     * @return
     */
    User getUser(String username);

    /**
     *
     * @param user
     */
    void addUser(User user);

    /**
     *
     * @param user
     */
    void deleteUser(User user);

}
