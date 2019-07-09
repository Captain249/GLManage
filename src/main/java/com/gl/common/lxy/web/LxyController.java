package com.gl.common.lxy.web;

import com.gl.common.lxy.bean.Lxy;
import com.gl.common.lxy.service.LxyService;
import com.gl.common.user.web.UserController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("lxy")
public class LxyController {
    private static Logger log=LoggerFactory.getLogger(UserController.class);

    @Autowired
    private LxyService lxyService;

    @RequestMapping("alllxy")
    public String alllxy(){
        return "lxy/alllxy";
    }

    @RequestMapping("finishlxy")
    public String finishlxy(){
        return "lxy/finishlxy";
    }

    @RequestMapping("processlxy")
    public String processlxy(){
        return "lxy/processlxy";
    }

    @ResponseBody
    @RequestMapping(value = "getalllxy")
    public  Map<String,Object> getalllxy(@RequestParam(value="keyWord", required=false) String keyWord,int page,int limit){
        List<Lxy> list = new ArrayList<Lxy>();
        Lxy lxy = new Lxy();
        if(keyWord != null && keyWord !=""){
            lxy.setName(keyWord);
        }
        list = lxyService.queryAllLxy(lxy,page,limit);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("data",list);
        map.put("code",0);
        map.put("msg","");
        map.put("count",list.size());
        return map;
    }

    @ResponseBody
    @RequestMapping("getfinishlxy")
    public Map<String,Object> getfinishlxy(@RequestParam(value="keyWord", required=false) String keyWord,int page,int limit){
        List<Lxy> list = new ArrayList<Lxy>();
        Lxy lxy = new Lxy();
        if(keyWord != null && keyWord !=""){
            lxy.setName(keyWord);
        }
        list = lxyService.queryFinishLxy(lxy,page,limit);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("data",list);
        map.put("code",0);
        map.put("msg","");
        map.put("count",list.size());
        return map;
    }

    @ResponseBody
    @RequestMapping("getprocesslxy")
    public Map<String,Object> getprocesslxy(@RequestParam(value="keyWord", required=false) String keyWord,int page,int limit){
        List<Lxy> list = new ArrayList<Lxy>();
        Lxy lxy = new Lxy();
        if(keyWord != null && keyWord !=""){
            lxy.setName(keyWord);
        }
        list = lxyService.queryProcessLxy(lxy,page,limit);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("data",list);
        map.put("code",0);
        map.put("msg","");
        map.put("count",list.size());
        return map;
    }

    @ResponseBody
    @RequestMapping("queryLxyById")
    public Map<String,Object> queryLxyById(Lxy lxyParam){
        Map<String,Object> resutMap = new HashMap<String, Object>();
        Lxy lxy = lxyService.queryLxyByExample(lxyParam);
        String html = "<table width='200px'><tr><td align='right'>类型:&nbsp;</td><td><span align='left'>"+lxy.getGrouptype()+"</span></td></tr>" +
                "<tr><td align='right'>名称:&nbsp;</td><td><span align='left'>"+lxy.getName()+"</span></td></tr>" +
                "<tr><td align='right'>人数:&nbsp;</td><td><span align='left'>"+lxy.getCountmem()+"</span></td></tr>" +
                "<tr><td align='right'>负责人:&nbsp;</td><td><span align='left'>"+lxy.getPrincipal()+"</span></td></tr>" +
                "<tr><td align='right'>手机号:&nbsp;</td><td><span align='left'>"+lxy.getPhonenum()+"</span></td></tr>" +
                "<tr><td align='right'>价格:&nbsp;</td><td><span align='left'>"+lxy.getPrice()+"</span></td></tr>" +
                "<tr><td align='right'>利润:&nbsp;</td><td><span align='left'>"+lxy.getProfit()+"</span></td></tr>" +
                "<tr><td align='right'>时间:&nbsp;</td><td><span align='left'>"+lxy.getDate()+"</span></td></tr>" +
                "<tr><td align='right'>状态:&nbsp;</td><td><span align='left'>"+lxy.getStatus()+"</span></td></tr>"
                +"</table>";
        resutMap.put("html",html);
        return resutMap;
    }

    @RequestMapping(value = "deleteLxyById" ,method = RequestMethod.POST)
    public int deleteLxyById(Lxy lxyParam){
        lxyService.deleteLxyByExample(lxyParam);
        return 0;
    }

    @RequestMapping(value = "editLxyById" ,method = RequestMethod.GET)
    public String editLxyById(Lxy lxyParam,Model model){
        Lxy lxy = lxyService.queryLxyByExample(lxyParam);
        model.addAttribute("editLxy",lxy);
        return "lxy/editLxy";
    }

    @ResponseBody
    @RequestMapping(value = "editLxy" ,method = RequestMethod.POST)
    public boolean editLxy(Lxy lxyParam){
        lxyService.updateLxyByExample(lxyParam);
        return true;
    }

    @RequestMapping(value = "inserLxy" , method = RequestMethod.POST)
    public int inserLxy(Lxy lxyParam){
        return lxyService.insertLxy(lxyParam);
    }
}
