package org.launchcode.rewardcenter.models.data;


import org.launchcode.rewardcenter.models.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
@Transactional
public interface DepartmentDao extends CrudRepository<Department,Integer> {
}
