package org.academiadecodigo.charliesangels.dao.jpa;

import org.academiadecodigo.charliesangels.dao.UserDao;
import org.academiadecodigo.charliesangels.models.User;

public class UserJpaDao extends GenericJpaDao<User> implements UserDao {

    public UserJpaDao() {
        super(User.class);
    }
}
