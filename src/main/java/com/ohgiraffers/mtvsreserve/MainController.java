package com.ohgiraffers.mtvsreserve;

import com.ohgiraffers.mtvsreserve.reservation.dto.TableInfoDTO;
import com.ohgiraffers.mtvsreserve.reservation.repository.ReservationTableRepository;
import com.ohgiraffers.mtvsreserve.reservation.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final ReservationTableRepository reservationService;

    @RequestMapping(value={"/"})
    public String main(){return "main";}
    @GetMapping("/reservation")
    public String reserve(){
        return "reservation/viewreserve";
    }
}