package com.ex.mvcprac3.controller;

import com.ex.mvcprac3.domain.Hospital;
import com.ex.mvcprac3.repository.HospitalRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Slf4j
@Controller
@RequestMapping("/hospitals")
public class HospitalController {
    private final HospitalRepository hospitalRepository;
    //생성자 di 주입
    public HospitalController(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    //get
    //1. list
    @GetMapping("") //페이징
    public String list(Model model, Pageable pageable){ //리포지토리
        Page<Hospital> hospitals = hospitalRepository.findAll(pageable);
        log.info("size:{}", hospitals.getSize());
        model.addAttribute("hospitals",hospitals);
        model.addAttribute("previous", pageable.previousOrFirst().getPageNumber());
        model.addAttribute("next", pageable.next().getPageNumber());
        return "hospitals/list";
    }

    @GetMapping("") // / 일때 list로
    public String index() {
        return "redirect:/articles/list";
    }


}
