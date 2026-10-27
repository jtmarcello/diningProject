package com.dining.diningProject.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dining.diningProject.Entities.Restaurant;
import com.dining.diningProject.Entities.DiningReview;

import java.util.List;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
    boolean existsByNameAndZipCode(String name, Integer zipCode);
    @Query("""
        select distinct r from Restaurant r
        where r.zipCode = :zipCode
            and exists (
                select d.id from diningReview d
                where d.restaurant = r
                    and d.status = :status
                    and d.peanutScore is not null
            )
        order by r.peanutScore desc
        """)
    List<Restaurant> findPeanutRestaurantsByZip(
        @Param("zipCode") Integer zipCode,
        @Param("status") DiningReview.Status status);
    
    @Query("""
        select distinct r from Restaurant r
        where r.zipCode = :zipCode
            and exists (
                select d.id from diningReview d
                where d.restaurant = r
                    and d.status = :status
                    and d.eggScore is not null
            )
        order by r.eggScore desc    """)
    List<Restaurant> findEggRestaurantsByZip(
        @Param("zipCode") Integer zipCode,
        @Param("status") DiningReview.Status status);
    
    @Query("""
        select distinct r from Restaurant r
        where r.zipCode = :zipCode
            and exists (
                select d.id from diningReview d
                where d.restaurant = r
                    and d.status = :status
                    and d.dairyScore is not null
            )
        order by r.dairyScore desc
    """)
    List<Restaurant> findDairyRestaurantsByZip(
        @Param("zipCode") Integer zipCode,
        @Param("status") DiningReview.Status status
    );
}
