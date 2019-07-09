package com.gl.common.sys.web;

import com.gl.common.user.web.UserController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("sys")
public class SysController {
    private static Logger log=LoggerFactory.getLogger(UserController.class);

    @RequestMapping("sysCtr")
    public String sysCtr(){
        return "sys/sysCtr";
    }
}
