package com.ng.emts.esd.crazynaijadeal.api;

import com.ng.emts.esd.crazynaijadeal.service.CrazyNaijaDealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CrazyNaijaDealUploadController {
    private final CrazyNaijaDealService crazyNaijaDealService;

    @Autowired
    public CrazyNaijaDealUploadController(CrazyNaijaDealService crazyNaijaDealService) {
        this.crazyNaijaDealService = crazyNaijaDealService;
    }

    @PostMapping("/apply")
    private void callBack() {
        crazyNaijaDealService.doGiftingOfAccessCodes();
        crazyNaijaDealService.doSevenHundredSms();
    }
    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
}
