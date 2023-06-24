package com.ohgiraffers.mtvsreserve.reservation.controller;

import com.ohgiraffers.mtvsreserve.reservation.dto.TableInfoDTO;
import com.ohgiraffers.mtvsreserve.reservation.dto.TimeListDTO;
import com.ohgiraffers.mtvsreserve.reservation.repository.ReservationTableRepository;
import com.ohgiraffers.mtvsreserve.reservation.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
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
    public String doReserve(@RequestParam int roomNum, @RequestParam String date, Model model){
        model.addAttribute("roomNum",roomNum);
        model.addAttribute("date",date);
        List<TableInfoDTO> roomlist= reservationService.findCompleteReserve(date);
        model.addAttribute("roomlist",roomlist);
        List<TimeListDTO> timelist =reservationService.timeList();
        model.addAttribute("timelist",timelist);
        return "reservation/doreserve1";
    }
    @PostMapping("doreserve1")
    public String doReserve1(@ModelAttribute TableInfoDTO tableInfoDTO
    , HttpServletRequest req, HttpServletResponse response, HttpSession session
    ) throws IOException {
        int count=reservationService.save(tableInfoDTO);
        if(count >= 2){
            String mesg=" "+tableInfoDTO.getUserId()+"님은 더 이상 예약할 수 없습니다.";
            reservationService.alert(mesg,response);
        }
        return "reservation/viewreserve";
    }

    @GetMapping("/reservCheck")
    public String checkReservation(Model model){
        List<TableInfoDTO> tableInfoDTO = reservationService.viewAllReservation("진용민");
        model.addAttribute("infos",tableInfoDTO);
        return "reservation/checkReservation";
    }
}