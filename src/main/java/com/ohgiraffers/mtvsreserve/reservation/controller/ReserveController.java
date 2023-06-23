package com.ohgiraffers.mtvsreserve.reservation.controller;

import com.ohgiraffers.mtvsreserve.reservation.dto.TableInfoDTO;
import com.ohgiraffers.mtvsreserve.reservation.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String doReserve(@ModelAttribute TableInfoDTO tableInfoDTO){
        System.out.println("tableInfoDTO = " + tableInfoDTO);
        reservationService.save(tableInfoDTO);
        return "reservation/viewreserve";

    }
}
