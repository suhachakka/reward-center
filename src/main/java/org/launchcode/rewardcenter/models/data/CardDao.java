package org.launchcode.rewardcenter.models.data;

import org.launchcode.rewardcenter.models.Card;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public interface CardDao extends CrudRepository<Card, Integer> {
    List<Card> findByUserId(int userId);

}
