package io.goorm.youtube.admin.controller;

import io.goorm.youtube.mapper.MemberMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller("adminMemberController")
@RequestMapping("/mgr")
public class MemberController {

    MemberMapper memberMapper;

    @Autowired
    public MemberController(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    //리스트
    @GetMapping("/members")
    public String  list(Model model) {

        model.addAttribute("posts", memberMapper.selectAll());
        model.addAttribute("title", "사용자관라-리스트" );
        return "mgr/member/list";
    }

    //뷰
    @GetMapping("/members/{memberSeq}")
    public String  get(@PathVariable Long memberSeq, Model model) {

        model.addAttribute("posts", memberMapper.selectById(memberSeq));
        model.addAttribute("title", "사용자관라-상세화면" );
        
        return "mgr/member/view";
    }



}




