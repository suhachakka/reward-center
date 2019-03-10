package org.launchcode.rewardcenter.models.data;

import org.launchcode.rewardcenter.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserDao extends CrudRepository<User,Integer> {

    User findByEmail(String email);

    User findByPhone(String phone);

    User findByKeyword(String keyword);
}