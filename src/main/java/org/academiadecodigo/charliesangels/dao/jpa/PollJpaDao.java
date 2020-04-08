package org.academiadecodigo.charliesangels.dao.jpa;

import org.academiadecodigo.charliesangels.dao.PollDao;
import org.academiadecodigo.charliesangels.models.Poll;

public class PollJpaDao extends GenericJpaDao<Poll> implements PollDao {

    public PollJpaDao() {
        super(Poll.class);
    }
}
