package com.gl.mgr.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("sys")
public class SysController {

    private static Logger log = LoggerFactory.getLogger(SysController.class);

    @RequestMapping("sysCtr")
    public String sysCtr(){
        return "sys/sysCtr";
    }

    @ResponseBody
    @RequestMapping(value = "getBaseData",method = RequestMethod.GET)
    public Map<String,Object> getBaseData(){
        List<Integer> list1 = new ArrayList<Integer>();
        for (int i=0;i<12;i++){
            list1.add(1000*(i+1));
        }
        List<Integer> list2 = new ArrayList<Integer>();
        for (int i=0;i<12;i++){
            list2.add(1000*(i+1)-300);
        }
        Map<String,Object> map = new HashMap<>();
        map.put("list1",list1);
        map.put("list2",list2);
        return map;
    }
}
