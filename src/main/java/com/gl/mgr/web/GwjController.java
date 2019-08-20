package com.gl.mgr.web;

import com.github.pagehelper.PageInfo;
import com.gl.mgr.bean.Gwj;
import com.gl.mgr.service.GwjService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("gwj")
public class GwjController {

    private static Logger log = LoggerFactory.getLogger(GwjController.class);

    @Autowired
    private GwjService gwjService;

    @RequestMapping("allGwj")
    public String allGwj(){
        return "gwj/allGwj";
    }

    @RequestMapping(value = "addGwj" ,method = RequestMethod.GET)
    public String addGwj(){
        return "gwj/addGwj";
    }

    @ResponseBody
    @RequestMapping(value = "getallGwj")
    public Map<String,Object> getallGwj(@RequestParam(value="keyWord", required=false) String keyWord, int page, int limit){
        Gwj gwj = new Gwj();
        if(keyWord != null && keyWord !=""){
            gwj.setName(keyWord);
        }
        PageInfo<Gwj> pageInfo = gwjService.queryAllGwj(gwj,page,limit);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("data",pageInfo.getList());
        map.put("code",0);
        map.put("msg","");
        map.put("count",pageInfo.getTotal());
        return map;
    }

    @ResponseBody
    @RequestMapping("queryGwjById")
    public Map<String,Object> queryGwjById(Gwj gwjParam){
        Map<String,Object> resutMap = new HashMap<String, Object>();
        Gwj gwj = gwjService.queryGwjById(gwjParam.getId());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String html = "";
        if(gwj.getEnddate()!=null){
            String finishDate = simpleDateFormat.format(gwj.getEnddate());
            html  = "<table width='250px'>" +
                    "<tr><td align='right'>备注:&nbsp;</td><td><span align='left'>"+gwj.getMore()+"</span></td></tr>" +
                    "<tr><td align='right'>完结日期:&nbsp;</td><td><span align='left'>"+finishDate+"</span></td></tr>"
                    +"</table>";
        }else{
             html = "<table width='250px'>" +
                     "<tr><td align='right'>备注:&nbsp;</td><td><span align='left'>"+gwj.getMore()+"</span></td></tr>" +
                    "<tr><td align='right'>完结日期:&nbsp;</td><td><span align='left'>"+"未完结"+"</span></td></tr>"
                    +"</table>";
        }
        resutMap.put("html",html);
        return resutMap;
    }

    @ResponseBody
    @RequestMapping(value = "deleteGwjById" ,method = RequestMethod.POST)
    public boolean deleteGwjById(Gwj gwjParam){
        gwjService.deleteGwjById(gwjParam);
        return true;
    }

    @RequestMapping(value = "editGwjById" ,method = RequestMethod.GET)
    public String editGwjById(Gwj gwjParam,Model model){
        Gwj gwj = gwjService.queryGwjByExample(gwjParam);
        model.addAttribute("editGwj",gwj);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String startDate = simpleDateFormat.format(gwj.getStartdate());
        model.addAttribute("startDateGwj",startDate);
        return "gwj/editGwj";
    }

    @ResponseBody
    @RequestMapping(value = "/editGwj" ,method = RequestMethod.POST)
    public boolean editGwj(Gwj gwjParam,String startdateStr) throws ParseException {
        //layui时间控件是String类型，需要在这里转换
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date satrtDate = simpleDateFormat.parse(startdateStr);
        gwjParam.setStartdate(satrtDate);
        Gwj gwj = gwjService.queryGwjById(gwjParam.getId());
        if(gwjParam.getStatus() == 1){
            if(gwj.getStatus() == 0){
                gwjParam.setStatus(1);
                gwjParam.setEnddate(new Date());
            }
        }
        gwjService.updateGwjById(gwjParam);
        return true;
    }

    @ResponseBody
    @RequestMapping(value = "/doaddGwj", method = RequestMethod.POST)
    public boolean doaddGwj(Gwj gwjParam,String startdateStr) throws ParseException {
        gwjParam.setStatus(0);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = simpleDateFormat.parse(startdateStr);
        gwjParam.setStartdate(startDate);
        gwjService.insertGwj(gwjParam);
        return true;
    }
}
