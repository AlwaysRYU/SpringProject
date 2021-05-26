package RYU.selfSpring.controller;


import RYU.selfSpring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController{
    //
    private final MemberService memberService;

    // 생성자 -> 바로 연결시켜줌
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}