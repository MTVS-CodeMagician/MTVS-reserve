package com.ohgiraffers.mtvsreserve.reservation.dto;

import com.ohgiraffers.mtvsreserve.reservation.entity.ReservationTableEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class TableInfoDTO {
    private Long id;
    private String date;
    private String roomNum;
    private int timeNum;
    private String userId;

    public static TableInfoDTO toMemberDTO(ReservationTableEntity reservationTableEntity){
        TableInfoDTO tableInfoDTO=new TableInfoDTO();
        tableInfoDTO.setId(reservationTableEntity.getId());
        tableInfoDTO.setDate(reservationTableEntity.getDate());
        tableInfoDTO.setRoomNum(reservationTableEntity.getRoomNum());
        tableInfoDTO.setTimeNum(reservationTableEntity.getTimeNum());
        tableInfoDTO.setUserId(reservationTableEntity.getUserId());
        return tableInfoDTO;
    }
}
