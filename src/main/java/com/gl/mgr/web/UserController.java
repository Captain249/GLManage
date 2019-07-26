package com.gl.mgr.web;

import com.gl.mgr.bean.User;
import com.gl.mgr.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    private static Logger log = LoggerFactory.getLogger(UserController.class);

    @RequestMapping("toLogin")
    public String toLogin(){
        return "user/login";
    }

    @ResponseBody
    @RequestMapping(value = "loginCheck",method = RequestMethod.POST)
    public boolean loginCheck(User userParam, HttpServletRequest request){
        User user = userService.loginCheck(userParam);
        if(user!=null){
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            return true;
        }else{
            return false;
        }
    }

    @RequestMapping(value="toHome")
    public String toHome(){
        return "user/home";
    }
}
