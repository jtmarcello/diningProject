package com.dining.diningProject.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.dining.diningProject.Entities.DiningReview;

public interface DiningReviewRepository extends CrudRepository<DiningReview, Long> {
    
}
