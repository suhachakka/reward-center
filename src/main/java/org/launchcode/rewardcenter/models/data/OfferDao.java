package org.launchcode.rewardcenter.models.data;

import org.launchcode.rewardcenter.models.Offer;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface OfferDao extends CrudRepository<Offer,Integer> {
    Page<Offer> findAll(Pageable pageable);
List<Offer> findByUserId(int userId);
}
