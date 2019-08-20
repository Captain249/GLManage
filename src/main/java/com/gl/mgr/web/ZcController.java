package com.gl.mgr.web;

import com.github.pagehelper.PageInfo;
import com.gl.mgr.bean.Gwj;
import com.gl.mgr.bean.Zc;
import com.gl.mgr.service.GwjService;
import com.gl.mgr.service.ZcService;
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
@RequestMapping("zc")
public class ZcController {

    private static Logger log = LoggerFactory.getLogger(ZcController.class);

    @Autowired
    private ZcService zcService;

    @RequestMapping("allZc")
    public String allZc(){
        return "zc/allZc";
    }

    @RequestMapping(value = "addZc" ,method = RequestMethod.GET)
    public String addZc(){
        return "zc/addZc";
    }

    @ResponseBody
    @RequestMapping(value = "getallZc")
    public Map<String,Object> getallZc(@RequestParam(value="keyWord", required=false) String keyWord, int page, int limit){
        PageInfo<Zc> pageInfo = zcService.queryAllZc(keyWord,page,limit);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("data",pageInfo.getList());
        map.put("code",0);
        map.put("msg","");
        map.put("count",pageInfo.getTotal());
        return map;
    }

    @ResponseBody
    @RequestMapping("queryZcById")
    public Map<String,Object> queryZcById(Zc zcParam){
        Map<String,Object> resutMap = new HashMap<String, Object>();
        Zc zc = zcService.queryZcById(zcParam.getId());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String html = "";
        if(zc.getEnddate()!=null){
            String finishDate = simpleDateFormat.format(zc.getEnddate());
            html  = "<table width='250px'>" +
                    "<tr><td align='right'>备注:&nbsp;</td><td><span align='left'>"+zc.getMore()+"</span></td></tr>" +
                    "<tr><td align='right'>完结日期:&nbsp;</td><td><span align='left'>"+finishDate+"</span></td></tr>"
                    +"</table>";
        }else{
             html = "<table width='250px'>" +
                     "<tr><td align='right'>备注:&nbsp;</td><td><span align='left'>"+zc.getMore()+"</span></td></tr>" +
                    "<tr><td align='right'>完结日期:&nbsp;</td><td><span align='left'>"+"未完结"+"</span></td></tr>"
                    +"</table>";
        }
        resutMap.put("html",html);
        return resutMap;
    }

    @ResponseBody
    @RequestMapping(value = "deleteZcById" ,method = RequestMethod.POST)
    public boolean deleteZcById(Zc zcParam){
        zcService.deleteZcById(zcParam);
        return true;
    }

    @RequestMapping(value = "editZcById" ,method = RequestMethod.GET)
    public String editZcById(Zc zcParam,Model model){
        Zc zc = zcService.queryZcByExample(zcParam);
        model.addAttribute("editZc",zc);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String startDate = simpleDateFormat.format(zc.getStartdate());
        model.addAttribute("startDateZc",startDate);
        return "zc/editZc";
    }

    @ResponseBody
    @RequestMapping(value = "/editZc" ,method = RequestMethod.POST)
    public boolean editZc(Zc zcParam,String startdateStr) throws ParseException {
        //layui时间控件是String类型，需要在这里转换
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date satrtDate = simpleDateFormat.parse(startdateStr);
        zcParam.setStartdate(satrtDate);
        Zc zc = zcService.queryZcById(zcParam.getId());
        if(zcParam.getStatus() == 1){
            if(zc.getStatus() == 0){
                zcParam.setStatus(1);
                zcParam.setEnddate(new Date());
            }
        }
        zcService.updateZcById(zcParam);
        return true;
    }

    @ResponseBody
    @RequestMapping(value = "/doaddZc", method = RequestMethod.POST)
    public boolean doaddZc(Zc zcParam,String startdateStr) throws ParseException {
        zcParam.setStatus(0);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = simpleDateFormat.parse(startdateStr);
        zcParam.setStartdate(startDate);
        zcService.insertZc(zcParam);
        return true;
    }
}
