package com.learn.learnspringpetclinic.controllers;

import com.learn.learnspringpetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"/owners", "owners/index", "owners/index.html"})
    public String listOwners(Model model) {
        model.addAttribute("owners" , ownerService.findAll());
        return "owners/index";
    }

    @RequestMapping("owners/{id}")
    public ModelAndView findOwners(@PathVariable String id) {
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        mav.addObject(ownerService.findById(Long.valueOf(id)));

        return mav;
    }
}
