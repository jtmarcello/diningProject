package com.dining.diningProject.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.dining.diningProject.Entities.DiningReview;

import java.util.List;

public interface DiningReviewRepository extends CrudRepository<DiningReview, Long> {
    public List<DiningReview> findByStatus(DiningReview.Status status);
}
