package com.gl.mgr.web;

import com.github.pagehelper.PageInfo;
import com.gl.mgr.bean.Member;
import com.gl.mgr.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("member")
public class MemberController {

    private static Logger log = LoggerFactory.getLogger(MemberController.class);
    @Autowired
    private MemberService memberService;

    @RequestMapping("allmembers")
    public String alllxy(@RequestParam(value="lxyId", required=true) String lxyId,Model model){
        model.addAttribute("lxyId",lxyId);
        return "member/members";
    }

    @ResponseBody
    @RequestMapping(value = "queryAllMember",method = RequestMethod.GET)
    public  Map<String,Object> queryAllMember (@RequestParam(value="lxyId", required=true) String lxyId, @RequestParam(value="keyWord", required=false) String keyWord, int page, int limit, HttpSession session){
        int lid = Integer.parseInt(lxyId);
        Member member = new Member();
        if(keyWord!=null&& !"".equals(keyWord)){
            member.setName(keyWord);
        }
        PageInfo<Member> pageInfo = memberService.queryAllMember(member,lid,page,limit);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("data",pageInfo.getList());
        map.put("code",0);
        map.put("msg","");
        map.put("count",pageInfo.getTotal());
        session.setAttribute("lxyId",lid);
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/queryMemberById",method = RequestMethod.POST)
    public Map<String,Object> queryMemberById(Member memberParam){
        Map<String,Object> resutMap = new HashMap<String, Object>();
        Member member = memberService.queryMemberById(memberParam.getId());
        String passPort = member.getPassport();
        String html;
        if(passPort!=null&&!"".equals(passPort)){
            html = "<table width='400px'>" +
                    "<tr><td align='right'>地址:&nbsp;</td><td><span align='left'>"+member.getAddress()+"</span></td></tr>" +
                    "<tr><td align='right'>护照:&nbsp;</td><td><span align='left'>"+passPort+"</span></td></tr>"
                    +"</table>";
        }else{
            html = "<table width='200px'>" +
                    "<tr><td align='right'>地址:&nbsp;</td><td><span align='left'>"+member.getAddress()+"</span></td></tr>" +
                    "<tr><td align='right'>护照:&nbsp;</td><td><span align='left'>"+"无护照"+"</span></td></tr>"
                    +"</table>";
        }
        resutMap.put("html",html);
        return resutMap;
    }

    @RequestMapping(value = "deleteMemberById" ,method = RequestMethod.POST)
    public void deleteMemberById(Member member,HttpSession session){
        int lxyId =(Integer) session.getAttribute("lxyId");
        memberService.deleteMemberById(member.getId(),lxyId);
    }

    @RequestMapping(value = "editMemberById" ,method = RequestMethod.GET)
    public String editLxyById(Member memberParam,Model model){
        Member member = memberService.queryMemberById(memberParam.getId());
        model.addAttribute("editMember",member);
        return "member/editMember";
    }

    @ResponseBody
    @RequestMapping(value = "/editMember" ,method = RequestMethod.POST)
    public boolean editLxy(Member memberParam){
        memberService.updateMemberById(memberParam);
        return true;
    }

    @RequestMapping(value = "addMember" ,method = RequestMethod.GET)
    public String addMember(){
        return "member/addMember";
    }

    @ResponseBody
    @RequestMapping(value = "/doaddMember", method = RequestMethod.POST)
    public boolean doaddMember(Member memberParam,HttpSession session) {
        int lxyId = (Integer) session.getAttribute("lxyId");
        memberService.insertMember(memberParam,lxyId);
        return true;
    }

    @ResponseBody
    @RequestMapping(value = "/excelUp",method = RequestMethod.POST)
    public boolean excelUp(MultipartFile file,HttpSession session){
        int lxyId =(Integer) session.getAttribute("lxyId");
        List<Member> memberList = memberService.excelUp(file);
        if(memberList.isEmpty()){
            return false;
        }
        for(int i=0;i<memberList.size();i++){
            Member member = memberList.get(i);
            memberService.insertMember(member,lxyId);
        }
        return true;
    }
}
