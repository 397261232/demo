package com.example.demov2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 刘子铨
 * @Description:
 * @Date:Create: 2019/4/23 13:53
 * @Modified By:
 */

@RestController
public class HellioController {
    @RequestMapping(value = "/say",method = RequestMethod.GET)
    public String sayHi(){
        return  "Hello My First SpringBoot!";
    }
}
