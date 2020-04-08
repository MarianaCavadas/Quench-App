package org.academiadecodigo.charliesangels.services;

public interface LogginService {

    /**
     *
     * @param username
     * @param password
     * @return
     */
    boolean authenticate(String username, String password);

    /**
     *
     * @return
     */
    User getAccessingUser();
}
