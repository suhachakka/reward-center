package org.launchcode.rewardcenter.models.data;

import org.launchcode.rewardcenter.models.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryDao extends CrudRepository<Category, Integer> {
}
