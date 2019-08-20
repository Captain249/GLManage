package com.gl.mgr.web;

import com.github.pagehelper.PageInfo;
import com.gl.mgr.bean.Qz;
import com.gl.mgr.bean.Scattered;
import com.gl.mgr.service.QzService;
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
@RequestMapping("qz")
public class QzController {

    private static Logger log = LoggerFactory.getLogger(QzController.class);

    @Autowired
    private QzService qzService;

    @RequestMapping(value = "goallQz",method = RequestMethod.GET)
    public String gognhk(){
        return "qz/allQz";
    }

    @RequestMapping(value = "addQz" ,method = RequestMethod.GET)
    public String addLxy(){
        return "qz/addQz";
    }

    @ResponseBody
    @RequestMapping(value = "getAllQz")
    public Map<String,Object> getAllQz(@RequestParam(value="keyWord", required=false) String keyWord, int page, int limit){
        Qz qz = new Qz();
        if(keyWord != null && keyWord !=""){
            qz.setName(keyWord);
        }
        PageInfo<Qz> pageInfo = qzService.getAllQz(qz,page,limit);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("data",pageInfo.getList());
        map.put("code",0);
        map.put("msg","");
        map.put("count",pageInfo.getTotal());
        return map;
    }

    @ResponseBody
    @RequestMapping("queryQzById")
    public Map<String,Object> queryQzById(Qz qzParam){
        Qz qz = qzService.queryQzById(qzParam.getId());
        Map<String,Object> resutMap = new HashMap<String, Object>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String html = "";
        if(qz.getEnddate()!=null){
            String finishDate = simpleDateFormat.format(qz.getEnddate());
            html  = "<table width='250px'>" +
                    "<tr><td align='right'>应收款:&nbsp;</td><td><span align='left'>"+qz.getReceivable()+"元</span></td></tr>" +
                    "<tr><td align='right'>实收款:&nbsp;</td><td><span align='left'>"+qz.getReceived()+"元</span></td></tr>" +
                    "<tr><td align='right'>b2b报名:&nbsp;</td><td><span align='left'>"+qz.getB2b()+"元</span></td></tr>" +
                    "<tr><td align='right'>门市:&nbsp;</td><td><span align='left'>"+qz.getSalesroom()+"</span></td></tr>" +
                    "<tr><td align='right'>合同:&nbsp;</td><td><span align='left'>"+qz.getContract()+"</span></td></tr>" +
                    "<tr><td align='right'>发票抬头:&nbsp;</td><td><span align='left'>"+qz.getInvoice()+"</span></td></tr>" +
                    "<tr><td align='right'>操作业务:&nbsp;</td><td><span align='left'>"+qz.getOperator()+"</span></td></tr>" +
                    "<tr><td align='right'>备注:&nbsp;</td><td><span align='left'>"+qz.getMore()+"</span></td></tr>" +
                    "<tr><td align='right'>完结日期:&nbsp;</td><td><span align='left'>"+finishDate+"</span></td></tr>"
                    +"</table>";
        }else{
            html = "<table width='250px'>" +
                    "<tr><td align='right'>应收款:&nbsp;</td><td><span align='left'>"+qz.getReceivable()+"元</span></td></tr>" +
                    "<tr><td align='right'>实收款:&nbsp;</td><td><span align='left'>"+qz.getReceived()+"元</span></td></tr>" +
                    "<tr><td align='right'>b2b报名:&nbsp;</td><td><span align='left'>"+qz.getB2b()+"元</span></td></tr>" +
                    "<tr><td align='right'>门市:&nbsp;</td><td><span align='left'>"+qz.getSalesroom()+"</span></td></tr>" +
                    "<tr><td align='right'>合同:&nbsp;</td><td><span align='left'>"+qz.getContract()+"</span></td></tr>" +
                    "<tr><td align='right'>发票抬头:&nbsp;</td><td><span align='left'>"+qz.getInvoice()+"</span></td></tr>" +
                    "<tr><td align='right'>操作业务:&nbsp;</td><td><span align='left'>"+qz.getOperator()+"</span></td></tr>" +
                    "<tr><td align='right'>备注:&nbsp;</td><td><span align='left'>"+qz.getMore()+"</span></td></tr>" +
                    "<tr><td align='right'>完结日期:&nbsp;</td><td><span align='left'>"+"未完结"+"</span></td></tr>"
                    +"</table>";
        }
        resutMap.put("html",html);
        return resutMap;
    }

    @ResponseBody
    @RequestMapping(value = "deleteQzById" ,method = RequestMethod.POST)
    public boolean deleteQzById(Qz qzParam){
        qzService.deleteQzMember(qzParam.getId());
        qzService.deleteQzById(qzParam);
        return true;
    }

    @RequestMapping(value = "editQzById" ,method = RequestMethod.GET)
    public String editQzById(Qz qzParam,Model model){
        Qz qz = qzService.queryQzByExample(qzParam);
        model.addAttribute("editQz",qz);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String startDate = simpleDateFormat.format(qz.getStartdate());
        model.addAttribute("startDateQz",startDate);
        return "qz/editQz";
    }

    @ResponseBody
    @RequestMapping(value = "/editQz" ,method = RequestMethod.POST)
    public boolean editQz(Qz qzParam,String startdateStr) throws ParseException {
        //layui时间控件是String类型，需要在这里转换
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date satrtDate = simpleDateFormat.parse(startdateStr);
        qzParam.setStartdate(satrtDate);
        Qz qz = qzService.queryQzById(qzParam.getId());
        if(qzParam.getStatus() == 1){
            if(qz.getStatus() == 0){
                qzParam.setStatus(1);
                qzParam.setEnddate(new Date());
            }
        }
        qzService.updateQzById(qzParam);
        return true;
    }

    @ResponseBody
    @RequestMapping(value = "/doaddQz", method = RequestMethod.POST)
    public boolean doaddQz(Qz qzParam,String startdateStr) throws ParseException {
        qzParam.setStatus(0);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = simpleDateFormat.parse(startdateStr);
        qzParam.setStartdate(startDate);
        qzService.insertQz(qzParam);
        return true;
    }
}
