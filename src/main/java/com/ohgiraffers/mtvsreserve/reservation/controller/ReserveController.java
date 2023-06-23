package com.ohgiraffers.mtvsreserve.reservation.controller;

import com.ohgiraffers.mtvsreserve.reservation.dto.TableInfoDTO;
import com.ohgiraffers.mtvsreserve.reservation.dto.ViewTableDTO;
import com.ohgiraffers.mtvsreserve.reservation.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ReserveController {
    private final ReservationService reservationService;
    @GetMapping("doreserve")
    public String doReservePage(@RequestParam int roomNum ,Model model){
        model.addAttribute("roomNum",roomNum);
        return "/reservation/doreserve";
    }
    @PostMapping("doreserve")
    public String doReserve(@RequestParam int roomNum,@RequestParam String date,@RequestParam String userId, Model model){
        model.addAttribute("roomNum",roomNum);
        model.addAttribute("date",date);
        model.addAttribute("userId",userId);
        List<TableInfoDTO> roomlist= reservationService.findCompleteReserve(date);
        model.addAttribute("roomlist",roomlist);
        System.out.println("roomlist = " + roomlist);
        return "reservation/doreserve1";
    }
    @PostMapping("doreserve1")
    public String doReserve1(@ModelAttribute TableInfoDTO tableInfoDTO){
        System.out.println("tableInfoDTO = " + tableInfoDTO);
        reservationService.save(tableInfoDTO);
        return "reservation/viewreserve";
    }
}
