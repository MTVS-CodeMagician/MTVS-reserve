package com.ohgiraffers.mtvsreserve.reservation.repository;

import com.ohgiraffers.mtvsreserve.reservation.dto.TableInfoDTO;
import com.ohgiraffers.mtvsreserve.reservation.entity.ReservationTableEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReservationTableRepository extends JpaRepository<ReservationTableEntity, Long> {
    List<Optional<ReservationTableEntity>> findAllByuserId(String userId);
}
