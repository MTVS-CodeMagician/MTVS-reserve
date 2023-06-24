package com.ohgiraffers.mtvsreserve.reservation.service;

import com.ohgiraffers.mtvsreserve.reservation.dto.TableInfoDTO;
import com.ohgiraffers.mtvsreserve.reservation.dto.TimeListDTO;
import com.ohgiraffers.mtvsreserve.reservation.entity.ReservationTableEntity;
import com.ohgiraffers.mtvsreserve.reservation.repository.ReservationTableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
        String date = tableInfoDTO.getDate();
        String[] dates = date.split("-");
        String final_date = dates[0] + dates[1] + dates[2];
        tableInfoDTO.setDate(final_date);
        ReservationTableEntity reservationTableEntity = ReservationTableEntity.toReservationTableEntity(tableInfoDTO);
        reservationTableRepository.save(reservationTableEntity);
    }

    public List<TableInfoDTO> findCompleteReserve(String date) {
        String[] dates = date.split("-");
        String final_date = dates[0] + dates[1] + dates[2];

        List<ReservationTableEntity> reservationTableEntityList = reservationTableRepository.findAll();
        List<TableInfoDTO> tableInfoDTOList = new ArrayList<>();
        int j = 0;
        for (ReservationTableEntity reservationTableEntity : reservationTableEntityList) {
            if (reservationTableEntityList.get(j).getDate().equals(final_date)) {
                tableInfoDTOList.add(TableInfoDTO.toTableInfoDTO(reservationTableEntity));
            }
            j++;
        }
        return tableInfoDTOList;
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
    public List<TimeListDTO> timeList(){
        List<TimeListDTO> times=new ArrayList<>();
        String[] list=new String[]{"06~08","08~10","10~12","12~14","14~16","16~18","18~20","20~22","22~24"};
        for (int i=0; i<9; i++){
            times.add(new TimeListDTO(i+1,list[i]));
        }
        return times;
    }

    @Transactional
    public void deleteByuserIdAndId(String userId,Long id){
        reservationTableRepository.deleteByuserIdAndId(userId,id);
    }
    /*
    의문점 2개
    1. Transactional을 사용하는 이유
    2. 위의 method는 정상적으로 작동하지 않음
     */

    @Transactional
    public void deleteById(Long id){
        reservationTableRepository.deleteById(id);
    }

}
