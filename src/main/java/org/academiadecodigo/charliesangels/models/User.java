package org.academiadecodigo.charliesangels.models;

public class User {

    private String userName;
    private String email;
    private String password;
    private Poll poll;

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Poll getPoll() {
        return poll;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPoll(Poll poll) {
        this.poll = poll;
    }
}
