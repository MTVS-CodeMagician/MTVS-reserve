package com.ohgiraffers.mtvsreserve.reservation.repository;

import com.ohgiraffers.mtvsreserve.reservation.entity.ReservationTableEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationTableRepository extends JpaRepository<ReservationTableEntity, Long> {

}
