package com.gl.mgr.web;

import com.gl.mgr.bean.Statistic;
import com.gl.mgr.dao.LxyMapper;
import com.gl.mgr.dao.ScatteredMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("sys")
public class SysController {

    @Autowired
    private LxyMapper lxyMapper;
    @Autowired
    private ScatteredMapper scatteredMapper;

    private static Logger log = LoggerFactory.getLogger(SysController.class);

    @RequestMapping("sysCtr")
    public String sysCtr(){
        return "sys/sysCtr";
    }

    @ResponseBody
    @RequestMapping(value = "getBaseData",method = RequestMethod.POST)
    public Map<String,Object> getBaseData(@RequestBody Map<String,Object> params){
        Map<String,Object> map = getStatistic((String) params.get("year"));
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

    public Map<String,Object> getStatistic(String year){
        Map<String,Object> resultMap = new HashMap<String,Object>();
        List<Statistic> lxys = lxyMapper.statisticLxy(year);
        List<Statistic> nomals = lxyMapper.statisticNomal(year);
        //List<Statistic> td = lxyMapper.statistic(year);
        List<Statistic> skStatistics = scatteredMapper.statistic(year);

        //疗休养数据
        List<BigDecimal> lxySs = new ArrayList<BigDecimal>();
        for(int i=0;i<12;i++){
            lxySs.add(new BigDecimal(0));
        }
        List<Integer> lxyNum = new ArrayList<Integer>();
        for(int i=0;i<12;i++){
            lxyNum.add(0);
        }

        //普通团队数据
        List<BigDecimal> nomalSs = new ArrayList<BigDecimal>();
        for(int i=0;i<12;i++){
            nomalSs.add(new BigDecimal(0));
        }
        List<Integer> nomalNum = new ArrayList<Integer>();
        for(int i=0;i<12;i++){
            nomalNum.add(0);
        }

        //散客数据
        List<BigDecimal> skSs = new ArrayList<BigDecimal>();
        for(int i=0;i<12;i++){
            skSs.add(new BigDecimal(0));
        }
        List<Integer> skNum = new ArrayList<Integer>();
        for(int i=0;i<12;i++){
            skNum.add(0);
        }

        //数据总和
        List<BigDecimal> sumSs = new ArrayList<BigDecimal>();
        for(int i=0;i<12;i++){
            sumSs.add(new BigDecimal(0));
        }
        List<Integer> sumNum = new ArrayList<Integer>();
        for(int i=0;i<12;i++){
            sumNum.add(0);
        }

        for(Statistic lxyStatistic : lxys){
            int j = Integer.parseInt(lxyStatistic.getTime().substring(5));
            int i = j-1;
            if(lxyStatistic.getSs()!=null){
                lxySs.set(i,lxyStatistic.getSs());
            }
            if(lxyStatistic.getNum()!= 0){
                lxyNum.set(i,lxyStatistic.getNum());
            }
        }

        for(Statistic nomalStatistic : nomals){
            int j = Integer.parseInt(nomalStatistic.getTime().substring(5));
            int i = j-1;
            if(nomalStatistic.getSs()!=null){
                nomalSs.set(i,nomalStatistic.getSs());
            }
            if(nomalStatistic.getNum()!= 0){
                nomalNum.set(i,nomalStatistic.getNum());
            }
        }

        for(Statistic skStatistic : skStatistics){
            int j = Integer.parseInt(skStatistic.getTime().substring(5));
            int i = j-1;
            if (skStatistic.getSs()!=null) {
                skSs.set(i,skStatistic.getSs());
            }
            if (skStatistic.getNum()!= 0 ) {
                lxyNum.set(i,skStatistic.getNum());
            }
        }

        for(int i = 0;i<12; i++){
            sumSs.set(i,lxySs.get(i).add(skSs.get(i)).add(nomalSs.get(i)));
            sumNum.set(i,lxyNum.get(i)+skNum.get(i)+nomalNum.get(i));
        }

        resultMap.put("lxySs",lxySs);
        resultMap.put("lxyNum",lxyNum);

        resultMap.put("nomalSs",nomalSs);
        resultMap.put("nomalNum",nomalNum);

        resultMap.put("skSs",skSs);
        resultMap.put("skNum",skNum);

        resultMap.put("sumSs",sumSs);
        resultMap.put("sumNum",sumNum);
        return resultMap;
    }
}
