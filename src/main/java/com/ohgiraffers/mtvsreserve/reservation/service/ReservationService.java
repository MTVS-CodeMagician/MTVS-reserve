package com.ohgiraffers.mtvsreserve.reservation.service;

import com.ohgiraffers.mtvsreserve.reservation.dto.TableInfoDTO;
import com.ohgiraffers.mtvsreserve.reservation.entity.ReservationTableEntity;
import com.ohgiraffers.mtvsreserve.reservation.repository.ReservationTableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationTableRepository reservationTableRepository;

    public void save(TableInfoDTO tableInfoDTO) {
        /*
        1.DTO->entity변환
        2.repository의 save method 호출
         */
        System.out.println("tableInfoDTO = " + tableInfoDTO);
        String date = tableInfoDTO.getDate();
        String[] dates = date.split("-");
        String final_date = dates[0] + dates[1] + dates[2];
        System.out.println("final_date : " + final_date);
        tableInfoDTO.setDate(final_date);
        System.out.println("tableInfoDTO = " + tableInfoDTO);
        ReservationTableEntity reservationTableEntity = ReservationTableEntity.toReservationTableEntity(tableInfoDTO);
        reservationTableRepository.save(reservationTableEntity);
        //repository save메서드 호출(조건 . entity객체를 넘겨줘야 함)
    }

    public List<TableInfoDTO> viewAllReservation(String userId) {
        List<Optional<ReservationTableEntity>> reservationTableEntities = reservationTableRepository.findAllByuserId(userId);
        List<TableInfoDTO> tableInfoDTOS=new ArrayList<>();

        for (Optional<ReservationTableEntity> t: reservationTableEntities){
            tableInfoDTOS.add(TableInfoDTO.toTableInfoDTO(t.get()));
        }

        if(tableInfoDTOS.isEmpty()){
            return null;
        }else{
            return tableInfoDTOS;
        }

    }

}
