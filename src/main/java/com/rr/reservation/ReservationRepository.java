package com.rr.reservation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer>{
    List<Reservation> findByUserId( Integer userId );
    List<Reservation> findByRestaurantId( Integer restaurantId );

    @Query("SELECT r.date, COUNT(*) as totalReservations FROM Reservation r WHERE r.restaurant.id = :restaurantId GROUP BY r.date")
    List<Object[]> findTotalReservationsByRestaurantId(@Param("restaurantId") Integer restaurantId);
}
