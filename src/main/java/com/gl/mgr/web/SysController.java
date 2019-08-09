package com.gl.mgr.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

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

    @ResponseBody
    @RequestMapping(value = "testFile",method = RequestMethod.POST)
    public Map<String,String> testFile(@RequestParam ("file")MultipartFile file) throws IOException {
        String type = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
        long startName = System.currentTimeMillis();
        File file1 = new File("/home/tomcat/temp/"+startName+type);
        file.transferTo(file1);
        Map<String,String> map = new HashMap<>();
        map.put("msg","success");
        return map;
    }
}
