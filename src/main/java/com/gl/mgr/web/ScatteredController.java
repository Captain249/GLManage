package com.gl.mgr.web;

import com.github.pagehelper.PageInfo;
import com.gl.mgr.bean.Scattered;
import com.gl.mgr.service.ScatteredService;
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
@RequestMapping("scattered")
public class ScatteredController {

    private static Logger log = LoggerFactory.getLogger(ScatteredController.class);

    @Autowired
    private ScatteredService scatteredService;

    @RequestMapping("gognhk")
    public String gognhk(){
        return "scattered/gnhk";
    }

    @RequestMapping("gocj")
    public String gocj(){
        return "scattered/cj";
    }

    @RequestMapping("godx")
    public String godx(){
        return "scattered/dx";
    }

    @RequestMapping(value = "addScattered" ,method = RequestMethod.GET)
    public String addLxy(@RequestParam (value = "type", required=true) String type,Model model){
        model.addAttribute("t",type);
        return "scattered/addScattered";
    }

    @ResponseBody
    @RequestMapping(value = "gnhk")
    public Map<String,Object> gnhk(@RequestParam(value="keyWord", required=false) String keyWord, int page, int limit){
        Scattered scattered = new Scattered();
        if(keyWord != null && keyWord !=""){
            scattered.setName(keyWord);
        }
        PageInfo<Scattered> pageInfo = scatteredService.gnhk(scattered,page,limit);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("data",pageInfo.getList());
        map.put("code",0);
        map.put("msg","");
        map.put("count",pageInfo.getTotal());
        return map;
    }

    @ResponseBody
    @RequestMapping("cj")
    public Map<String,Object> cj(@RequestParam(value="keyWord", required=false) String keyWord,int page,int limit){
        Scattered scattered = new Scattered();
        if(keyWord != null && keyWord !=""){
            scattered.setName(keyWord);
        }
        PageInfo<Scattered> pageInfo = scatteredService.cj(scattered,page,limit);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("data",pageInfo.getList());
        map.put("code",0);
        map.put("msg","");
        map.put("count",pageInfo.getTotal());
        return map;
    }

    @ResponseBody
    @RequestMapping("dx")
    public Map<String,Object> dx(@RequestParam(value="keyWord", required=false) String keyWord,int page,int limit){
        Scattered scattered = new Scattered();
        if(keyWord != null && keyWord !=""){
            scattered.setName(keyWord);
        }
        PageInfo<Scattered> pageInfo = scatteredService.dx(scattered,page,limit);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("data",pageInfo.getList());
        map.put("code",0);
        map.put("msg","");
        map.put("count",pageInfo.getTotal());
        return map;
    }

    @ResponseBody
    @RequestMapping("queryScatteredById")
    public Map<String,Object> queryScatteredById(Scattered scatteredParam){
        Scattered scattered = scatteredService.queryScatteredById(scatteredParam.getId());
        Map<String,Object> resutMap = new HashMap<String, Object>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String html = "";
        if(scattered.getEnddate()!=null){
            String finishDate = simpleDateFormat.format(scattered.getEnddate());
            html  = "<table width='250px'>" +
                    "<tr><td align='right'>应收款:&nbsp;</td><td><span align='left'>"+scattered.getReceivable()+"元</span></td></tr>" +
                    "<tr><td align='right'>实收款:&nbsp;</td><td><span align='left'>"+scattered.getReceived()+"元</span></td></tr>" +
                    "<tr><td align='right'>b2b报名:&nbsp;</td><td><span align='left'>"+scattered.getB2b()+"元</span></td></tr>" +
                    "<tr><td align='right'>门市:&nbsp;</td><td><span align='left'>"+scattered.getSalesroom()+"</span></td></tr>" +
                    "<tr><td align='right'>合同:&nbsp;</td><td><span align='left'>"+scattered.getContract()+"</span></td></tr>" +
                    "<tr><td align='right'>发票抬头:&nbsp;</td><td><span align='left'>"+scattered.getInvoice()+"</span></td></tr>" +
                    "<tr><td align='right'>操作业务:&nbsp;</td><td><span align='left'>"+scattered.getOperator()+"</span></td></tr>" +
                    "<tr><td align='right'>备注:&nbsp;</td><td><span align='left'>"+scattered.getMore()+"</span></td></tr>" +
                    "<tr><td align='right'>完结日期:&nbsp;</td><td><span align='left'>"+finishDate+"</span></td></tr>"
                    +"</table>";
        }else{
            html = "<table width='250px'>" +
                    "<tr><td align='right'>应收款:&nbsp;</td><td><span align='left'>"+scattered.getReceivable()+"元</span></td></tr>" +
                    "<tr><td align='right'>实收款:&nbsp;</td><td><span align='left'>"+scattered.getReceived()+"元</span></td></tr>" +
                    "<tr><td align='right'>b2b报名:&nbsp;</td><td><span align='left'>"+scattered.getB2b()+"元</span></td></tr>" +
                    "<tr><td align='right'>门市:&nbsp;</td><td><span align='left'>"+scattered.getSalesroom()+"</span></td></tr>" +
                    "<tr><td align='right'>合同:&nbsp;</td><td><span align='left'>"+scattered.getContract()+"</span></td></tr>" +
                    "<tr><td align='right'>发票抬头:&nbsp;</td><td><span align='left'>"+scattered.getInvoice()+"</span></td></tr>" +
                    "<tr><td align='right'>操作业务:&nbsp;</td><td><span align='left'>"+scattered.getOperator()+"</span></td></tr>" +
                    "<tr><td align='right'>备注:&nbsp;</td><td><span align='left'>"+scattered.getMore()+"</span></td></tr>" +
                    "<tr><td align='right'>完结日期:&nbsp;</td><td><span align='left'>"+"未完结"+"</span></td></tr>"
                    +"</table>";
        }
        resutMap.put("html",html);
        return resutMap;
    }

    @ResponseBody
    @RequestMapping(value = "deleteScatteredById" ,method = RequestMethod.POST)
    public boolean deleteScatteredById(Scattered scatteredParam){
        scatteredService.deleteScatteredMember(scatteredParam.getId());
        scatteredService.deleteScatteredById(scatteredParam);
        return true;
    }

    @RequestMapping(value = "editScatteredById" ,method = RequestMethod.GET)
    public String editScatteredById(Scattered scatteredParam,Model model){
        Scattered scattered = scatteredService.queryScatteredByExample(scatteredParam);
        model.addAttribute("editScattered",scattered);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String startDate = simpleDateFormat.format(scattered.getStartdate());
        model.addAttribute("startDateScattered",startDate);
        return "scattered/editScattered";
    }

    @ResponseBody
    @RequestMapping(value = "/editScattered" ,method = RequestMethod.POST)
    public boolean editScattered(Scattered scatteredParam,String startdateStr) throws ParseException {
        //layui时间控件是String类型，需要在这里转换
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date satrtDate = simpleDateFormat.parse(startdateStr);
        scatteredParam.setStartdate(satrtDate);
        Scattered scattered = scatteredService.queryScatteredById(scatteredParam.getId());
        if(scatteredParam.getStatus() == 1){
            if(scattered.getStatus() == 0){
                scatteredParam.setStatus(1);
                scatteredParam.setEnddate(new Date());
            }
        }
        scatteredService.updateScatteredById(scatteredParam);
        return true;
    }

    @ResponseBody
    @RequestMapping(value = "/doaddScattered", method = RequestMethod.POST)
    public boolean doaddScattered(Scattered scatteredParam,String startdateStr) throws ParseException {
        scatteredParam.setStatus(0);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = simpleDateFormat.parse(startdateStr);
        scatteredParam.setStartdate(startDate);
        scatteredService.insertScattered(scatteredParam);
        return true;
    }
}
