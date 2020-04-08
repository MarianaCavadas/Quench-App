package org.academiadecodigo.charliesangels.services;

import org.academiadecodigo.charliesangels.models.User;

public class LogginServiceImpl implements LogginService{

    private UserService userService;

    /**
     * Get userService
     *
     * @return userService
     */
    public UserService getUserService() {
        return userService;
    }

    /**
     * set the userService
     * @param userService
     */
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     *
     * @param username
     * @param password
     * @return true if authenticates
     */
    @Override
    public boolean authenticate(String username, String password) {
        return false;
    }

    /**
     * Get actual accessingCustomer
     *
     * @return
     */
    @Override
    public User getAccessingUser() {
        return null;
    }
}
