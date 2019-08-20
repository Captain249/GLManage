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
        List<Statistic> lxyStatistics = lxyMapper.statistic(year);
        List<Statistic> skStatistics = scatteredMapper.statistic(year);
        //疗休养数据
        List<BigDecimal> lxyYs = new ArrayList<BigDecimal>();
        for(int i=0;i<12;i++){
            lxyYs.add(new BigDecimal(0));
        }
        List<BigDecimal> lxySs = new ArrayList<BigDecimal>();
        for(int i=0;i<12;i++){
            lxySs.add(new BigDecimal(0));
        }
        List<BigDecimal> lxyB2bs = new ArrayList<BigDecimal>();
        for(int i=0;i<12;i++){
            lxyB2bs.add(new BigDecimal(0));
        }
        List<Integer> lxyNum = new ArrayList<Integer>();
        for(int i=0;i<12;i++){
            lxyNum.add(0);
        }
        //散客数据
        List<BigDecimal> skYs = new ArrayList<BigDecimal>();
        for(int i=0;i<12;i++){
            skYs.add(new BigDecimal(0));
        }
        List<BigDecimal> skSs = new ArrayList<BigDecimal>();
        for(int i=0;i<12;i++){
            skSs.add(new BigDecimal(0));
        }
        List<BigDecimal> skB2bs = new ArrayList<BigDecimal>();
        for(int i=0;i<12;i++){
            skB2bs.add(new BigDecimal(0));
        }
        List<Integer> skNum = new ArrayList<Integer>();
        for(int i=0;i<12;i++){
            skNum.add(0);
        }
        //数据总和
        List<BigDecimal> sumYs = new ArrayList<BigDecimal>();
        for(int i=0;i<12;i++){
            sumYs.add(new BigDecimal(0));
        }
        List<BigDecimal> sumSs = new ArrayList<BigDecimal>();
        for(int i=0;i<12;i++){
            sumSs.add(new BigDecimal(0));
        }
        List<BigDecimal> sumB2bs = new ArrayList<BigDecimal>();
        for(int i=0;i<12;i++){
            sumB2bs.add(new BigDecimal(0));
        }
        List<Integer> sumNum = new ArrayList<Integer>();
        for(int i=0;i<12;i++){
            sumNum.add(0);
        }

        for(Statistic lxyStatistic : lxyStatistics){
            int j = Integer.parseInt(lxyStatistic.getTime().substring(5));
            int i = j-1;
            if(lxyStatistic.getYs()!=null){
                lxyYs.set(i,lxyStatistic.getYs());
            }
            if(lxyStatistic.getSs()!=null){
                lxySs.set(i,lxyStatistic.getSs());
            }
            if(lxyStatistic.getB2bs()!=null){
                lxyB2bs.set(i,lxyStatistic.getB2bs());
            }
            if(lxyStatistic.getNum()!= 0){
                lxyNum.set(i,lxyStatistic.getNum());
            }
        }

        for(Statistic skStatistic : skStatistics){
            int j = Integer.parseInt(skStatistic.getTime().substring(5));
            int i = j-1;
            if (skStatistic.getYs()!=null) {
                skYs.set(i,skStatistic.getYs());
            }
            if (skStatistic.getSs()!=null) {
                skSs.set(i,skStatistic.getSs());
            }
            if (skStatistic.getB2bs()!=null) {
                skB2bs.set(i,skStatistic.getB2bs());
            }
            if (skStatistic.getNum()!= 0 ) {
                lxyNum.set(i,skStatistic.getNum());
            }
        }

        for(int i = 0;i<12; i++){
            sumYs.set(i,lxyYs.get(i).add(skYs.get(i)));
            sumSs.set(i,lxySs.get(i).add(skSs.get(i)));
            sumB2bs.set(i,lxyB2bs.get(i).add(skB2bs.get(i)));
            sumNum.set(i,lxyNum.get(i)+skNum.get(i));
        }

        resultMap.put("lxyYs",lxyYs);
        resultMap.put("lxySs",lxySs);
        resultMap.put("lxyB2bs",lxyB2bs);
        resultMap.put("lxyNum",lxyNum);

        resultMap.put("skYs",skYs);
        resultMap.put("skSs",skSs);
        resultMap.put("skB2bs",skB2bs);
        resultMap.put("skNum",skNum);

        resultMap.put("sumYs",sumYs);
        resultMap.put("sumSs",sumSs);
        resultMap.put("sumB2bs",sumB2bs);
        resultMap.put("sumNum",sumNum);
        return resultMap;
    }
}
