package org.academiadecodigo.charliesangels.services;

import org.academiadecodigo.charliesangels.exception.UserNotFoundException;
import org.academiadecodigo.charliesangels.models.User;

public interface UserService {

    /**
     *
     * @param id
     * @return
     */
    User getUser(Integer id);

    /**
     *
     * @param user
     */
    User saveUser(User user);

    /**
     *
     * @param id
     */
    void deleteUser(Integer id) throws UserNotFoundException;

    User getUserByUsername(String username);

}
