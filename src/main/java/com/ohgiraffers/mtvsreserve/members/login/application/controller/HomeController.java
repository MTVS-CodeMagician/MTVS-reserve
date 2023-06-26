package com.ohgiraffers.mtvsreserve.members.login.application.controller;

import com.ohgiraffers.mtvsreserve.members.login.application.dto.MemberDTO;
import com.ohgiraffers.mtvsreserve.members.login.common.argumentresolver.Login;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class HomeController {

    @GetMapping("/")
    public String homeLoginArgumentResolver(@Login MemberDTO loginMember, Model model) {

        //세션에 회원 데이터가 없으면 home
        if (loginMember == null) {
            return "home";
        }

        //세션이 유지되면 로그인으로 이동
        model.addAttribute("member", loginMember);
        return "loginHome";
    }
}
