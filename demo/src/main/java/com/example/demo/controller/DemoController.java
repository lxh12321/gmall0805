package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DemoController {

    @GetMapping("/demo")
    @ResponseBody
    public String getHello() {

        ArrayList<Object> arrayList = new ArrayList<>();
        List list;



        return "hhhhhh";
    }
}