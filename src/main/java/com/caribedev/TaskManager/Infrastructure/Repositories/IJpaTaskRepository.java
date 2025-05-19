package com.caribedev.TaskManager.Infrastructure.Repositories;

import com.caribedev.TaskManager.Infrastructure.Persistence.Entities.TaskEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */
@Repository
public interface IJpaTaskRepository extends JpaRepository<TaskEntity, Long>{

     List<TaskEntity> findByCompletedTrue();
    
    @Query("SELECT t FROM TaskEntity t WHERE  LOWER(t.description) LIKE LOWER(CONCAT('%',:description,'%'))")
     List<TaskEntity> findByDescription(String description);
    
    @Query(value = "SELECT * FROM Tasks WHERE completed = true AND LOWER(t.description) LIKE LOWER(CONCAT('%',:description,'%'))", nativeQuery = true)
     List<TaskEntity> findByCompletedWithDescription(String description);
    
}
