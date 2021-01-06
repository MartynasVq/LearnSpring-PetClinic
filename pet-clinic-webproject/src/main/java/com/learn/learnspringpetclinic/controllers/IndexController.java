package com.learn.learnspringpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping({"", "/", "index.html", "index", "vets.html"})
    public String index() {
        return "index";
    }

    @RequestMapping({"/find"})
    public String findOwners() {
        return "notimplemented";
    }

}


