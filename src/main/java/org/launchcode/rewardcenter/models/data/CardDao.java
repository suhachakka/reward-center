package org.launchcode.rewardcenter.models.data;

import org.launchcode.rewardcenter.models.Card;
import org.springframework.data.repository.CrudRepository;

public interface CardDao extends CrudRepository<Card, Integer> {

}
