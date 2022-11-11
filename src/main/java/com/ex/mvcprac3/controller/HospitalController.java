package com.ex.mvcprac3.controller;

import com.ex.mvcprac3.domain.Hospital;
import com.ex.mvcprac3.repository.HospitalRepository;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("")  // list일 때 list로
    public String list(Pageable pageable, Model model){ //리포지토리
        Page<Hospital> hospitals = hospitalRepository.findAll(pageable);
        model.addAttribute("hospitals",hospitals);
        return "hospitals/list";
    }

    @GetMapping("") // / 일때 list로
    public String index() {
        return "redirect:/articles/list";
    }


}
