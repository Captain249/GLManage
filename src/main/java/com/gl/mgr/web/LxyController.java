package com.gl.mgr.web;

import com.github.pagehelper.PageInfo;
import com.gl.mgr.bean.Lxy;
import com.gl.mgr.service.LxyService;
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
@RequestMapping("lxy")
public class LxyController {

    private static Logger log = LoggerFactory.getLogger(LxyController.class);

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

    @RequestMapping(value = "addLxy" ,method = RequestMethod.GET)
    public String addLxy(){
        return "lxy/addLxy";
    }

    @ResponseBody
    @RequestMapping(value = "getalllxy")
    public Map<String,Object> getalllxy(@RequestParam(value="keyWord", required=false) String keyWord, int page, int limit){
        Lxy lxy = new Lxy();
        if(keyWord != null && keyWord !=""){
            lxy.setName(keyWord);
        }
        PageInfo<Lxy> pageInfo = lxyService.queryAllLxy(lxy,page,limit);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("data",pageInfo.getList());
        map.put("code",0);
        map.put("msg","");
        map.put("count",pageInfo.getTotal());
        return map;
    }

    @ResponseBody
    @RequestMapping("getfinishlxy")
    public Map<String,Object> getfinishlxy(@RequestParam(value="keyWord", required=false) String keyWord,int page,int limit){
        Lxy lxy = new Lxy();
        if(keyWord != null && keyWord !=""){
            lxy.setName(keyWord);
        }
        PageInfo<Lxy> pageInfo = lxyService.queryFinishLxy(lxy,page,limit);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("data",pageInfo.getList());
        map.put("code",0);
        map.put("msg","");
        map.put("count",pageInfo.getTotal());
        return map;
    }

    @ResponseBody
    @RequestMapping("getprocesslxy")
    public Map<String,Object> getprocesslxy(@RequestParam(value="keyWord", required=false) String keyWord,int page,int limit){
        Lxy lxy = new Lxy();
        if(keyWord != null && keyWord !=""){
            lxy.setName(keyWord);
        }
        PageInfo<Lxy> pageInfo = lxyService.queryProcessLxy(lxy,page,limit);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("data",pageInfo.getList());
        map.put("code",0);
        map.put("msg","");
        map.put("count",pageInfo.getTotal());
        return map;
    }

    @ResponseBody
    @RequestMapping("queryLxyById")
    public Map<String,Object> queryLxyById(Lxy lxyParam){
        Map<String,Object> resutMap = new HashMap<String, Object>();
        Lxy lxy = lxyService.queryLxyById(lxyParam.getId());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String html = "";
        if(lxy.getFinishdate()!=null){
            String finishDate = simpleDateFormat.format(lxy.getFinishdate());
            html  = "<table width='250px'>" +
                    "<tr><td align='right'>应收款:&nbsp;</td><td><span align='left'>"+lxy.getReceivable()+"元</span></td></tr>" +
                    "<tr><td align='right'>实收款:&nbsp;</td><td><span align='left'>"+lxy.getReceived()+"元</span></td></tr>" +
                    "<tr><td align='right'>b2b报名:&nbsp;</td><td><span align='left'>"+lxy.getB2b()+"元</span></td></tr>" +
                    "<tr><td align='right'>门市:&nbsp;</td><td><span align='left'>"+lxy.getSalesroom()+"</span></td></tr>" +
                    "<tr><td align='right'>合同:&nbsp;</td><td><span align='left'>"+lxy.getContract()+"</span></td></tr>" +
                    "<tr><td align='right'>发票抬头:&nbsp;</td><td><span align='left'>"+lxy.getInvoice()+"</span></td></tr>" +
                    "<tr><td align='right'>备注:&nbsp;</td><td><span align='left'>"+lxy.getMore()+"</span></td></tr>" +
                    "<tr><td align='right'>完结日期:&nbsp;</td><td><span align='left'>"+finishDate+"</span></td></tr>"
                    +"</table>";
        }else{
             html = "<table width='250px'>" +
                     "<tr><td align='right'>应收款:&nbsp;</td><td><span align='left'>"+lxy.getReceivable()+"元</span></td></tr>" +
                     "<tr><td align='right'>实收款:&nbsp;</td><td><span align='left'>"+lxy.getReceived()+"元</span></td></tr>" +
                     "<tr><td align='right'>b2b报名:&nbsp;</td><td><span align='left'>"+lxy.getB2b()+"元</span></td></tr>" +
                     "<tr><td align='right'>门市:&nbsp;</td><td><span align='left'>"+lxy.getSalesroom()+"</span></td></tr>" +
                     "<tr><td align='right'>合同:&nbsp;</td><td><span align='left'>"+lxy.getContract()+"</span></td></tr>" +
                     "<tr><td align='right'>发票抬头:&nbsp;</td><td><span align='left'>"+lxy.getInvoice()+"</span></td></tr>" +
                     "<tr><td align='right'>备注:&nbsp;</td><td><span align='left'>"+lxy.getMore()+"</span></td></tr>" +
                    "<tr><td align='right'>完结日期:&nbsp;</td><td><span align='left'>"+"未完结"+"</span></td></tr>"
                    +"</table>";
        }
        resutMap.put("html",html);
        return resutMap;
    }

    @ResponseBody
    @RequestMapping(value = "deleteLxyById" ,method = RequestMethod.POST)
    public boolean deleteLxyById(Lxy lxyParam){
        lxyService.deleteLxyMember(lxyParam.getId());
        lxyService.deleteLxyById(lxyParam);
        return true;
    }

    @RequestMapping(value = "editLxyById" ,method = RequestMethod.GET)
    public String editLxyById(Lxy lxyParam,Model model){
        Lxy lxy = lxyService.queryLxyByExample(lxyParam);
        model.addAttribute("editLxy",lxy);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String startDate = simpleDateFormat.format(lxy.getStartdate());
        model.addAttribute("startDate",startDate);
        return "lxy/editLxy";
    }

    @ResponseBody
    @RequestMapping(value = "/editLxy" ,method = RequestMethod.POST)
    public boolean editLxy(Lxy lxyParam,String startdateStr) throws ParseException {
        //layui时间控件是String类型，需要在这里转换
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date satrtDate = simpleDateFormat.parse(startdateStr);
        lxyParam.setStartdate(satrtDate);
        Lxy lxy = lxyService.queryLxyById(lxyParam.getId());
        if(lxy.getStatus() == 0){
            lxyParam.setStatus(1);
            lxyParam.setFinishdate(new Date());
        }
        lxyService.updateLxyById(lxyParam);
        return true;
    }

    @ResponseBody
    @RequestMapping(value = "/doaddLxy", method = RequestMethod.POST)
    public boolean doaddLxy(Lxy lxyParam,String startdateStr) throws ParseException {
        lxyParam.setStatus(0);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = simpleDateFormat.parse(startdateStr);
        lxyParam.setStartdate(startDate);
        lxyService.insertLxy(lxyParam);
        return true;
    }
}
