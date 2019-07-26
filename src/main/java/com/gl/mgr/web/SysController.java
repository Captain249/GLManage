package com.gl.mgr.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("sys")
public class SysController {

    private static Logger log = LoggerFactory.getLogger(SysController.class);

    @RequestMapping("sysCtr")
    public String sysCtr(){
        return "sys/sysCtr";
    }
}
