package org.academiadecodigo.charliesangels;

import org.academiadecodigo.charliesangels.models.Poll;
import org.academiadecodigo.charliesangels.models.User;

public class Main {


    public static void main(String[] args) {

        Poll poll = new Poll();
        User user = new User();


        user.setEmail("apapap@gmail.com");
        user.setPassword("123password");
        user.setUserName("Miguel Joao");


        System.out.println(user.getEmail());
    }
}
