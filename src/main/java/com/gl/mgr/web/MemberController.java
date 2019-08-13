package com.gl.mgr.web;

import com.github.pagehelper.PageInfo;
import com.gl.mgr.bean.Member;
import com.gl.mgr.service.MemberService;
import org.apache.commons.io.FileUtils;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLEncoder;
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

    @RequestMapping("allmembersScattered")
    public String allmembersScattered(@RequestParam(value="scatteredId", required=true) String scatteredId,Model model){
        model.addAttribute("scatteredId",scatteredId);
        return "member/membersScattered";
    }

    @RequestMapping("allmembersQz")
    public String allmembersQz(@RequestParam(value="qzid", required=true) String qzid,Model model){
        model.addAttribute("qid",qzid);
        return "member/membersQz";
    }

    @ResponseBody
    @RequestMapping(value = "queryAllMemberQz",method = RequestMethod.GET)
    public  Map<String,Object> queryAllMemberQz (@RequestParam(value="qzid", required=true) String qzid, @RequestParam(value="keyWord", required=false) String keyWord, int page, int limit, HttpSession session){
        int qid = Integer.parseInt(qzid);
        Member member = new Member();
        if(keyWord!=null&& !"".equals(keyWord)){
            member.setName(keyWord);
        }
        PageInfo<Member> pageInfo = memberService.queryAllMemberQz(member,qid,page,limit);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("data",pageInfo.getList());
        map.put("code",0);
        map.put("msg","");
        map.put("count",pageInfo.getTotal());
        session.setAttribute("qid",qid);
        return map;
    }


    @ResponseBody
    @RequestMapping(value = "queryAllMemberScattered",method = RequestMethod.GET)
    public  Map<String,Object> queryAllMemberScattered (@RequestParam(value="scatteredId", required=true) String scatteredId, @RequestParam(value="keyWord", required=false) String keyWord, int page, int limit, HttpSession session){
        int sid = Integer.parseInt(scatteredId);
        Member member = new Member();
        if(keyWord!=null&& !"".equals(keyWord)){
            member.setName(keyWord);
        }
        PageInfo<Member> pageInfo = memberService.queryAllMemberScattered(member,sid,page,limit);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("data",pageInfo.getList());
        map.put("code",0);
        map.put("msg","");
        map.put("count",pageInfo.getTotal());
        session.setAttribute("scatteredId",sid);
        return map;
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

    @ResponseBody
    @RequestMapping(value = "deleteMemberById" ,method = RequestMethod.POST)
    public boolean deleteMemberById(Member member,HttpSession session){
        int lxyId =(Integer) session.getAttribute("lxyId");
        memberService.deleteMemberById(member.getId(),lxyId);
        return true;
    }

    @ResponseBody
    @RequestMapping(value = "deleteMemberByIdScattered" ,method = RequestMethod.POST)
    public boolean deleteMemberByIdScattered(Member member,HttpSession session){
        int scatteredId =(Integer) session.getAttribute("scatteredId");
        memberService.deleteMemberByIdScattered(member.getId(),scatteredId);
        return true;
    }

    @ResponseBody
    @RequestMapping(value = "deleteMemberByIdQz" ,method = RequestMethod.POST)
    public boolean deleteMemberByIdQz(Member member,HttpSession session){
        int qid =(Integer) session.getAttribute("qid");
        memberService.deleteMemberByIdQz(member.getId(),qid);
        return true;
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

    @RequestMapping(value = "addMemberScattered" ,method = RequestMethod.GET)
    public String addMemberScattered(){
        return "member/addMemberScattered";
    }

    @RequestMapping(value = "addMemberQz" ,method = RequestMethod.GET)
    public String addMemberQz(){
        return "member/addMemberQz";
    }

    @ResponseBody
    @RequestMapping(value = "/doaddMember", method = RequestMethod.POST)
    public boolean doaddMember(Member memberParam,HttpSession session) {
        int lxyId = (Integer) session.getAttribute("lxyId");
        memberService.insertMember(memberParam,lxyId);
        return true;
    }

    @ResponseBody
    @RequestMapping(value = "/doaddMemberScattered", method = RequestMethod.POST)
    public boolean doaddMemberScattered(Member memberParam,HttpSession session) {
        int scatteredId = (Integer) session.getAttribute("scatteredId");
        memberService.insertMemberScattered(memberParam,scatteredId);
        return true;
    }

    @ResponseBody
    @RequestMapping(value = "/doaddMemberQz", method = RequestMethod.POST)
    public boolean doaddMemberQz(Member memberParam,HttpSession session) {
        int qid = (Integer) session.getAttribute("qid");
        memberService.insertMemberQz(memberParam,qid);
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

    @ResponseBody
    @RequestMapping(value = "/excelUp2",method = RequestMethod.POST)
    public boolean excelUp2(MultipartFile file,HttpSession session){
        int scatteredId =(Integer) session.getAttribute("scatteredId");
        List<Member> memberList = memberService.excelUp(file);
        if(memberList.isEmpty()){
            return false;
        }
        for(int i=0;i<memberList.size();i++){
            Member member = memberList.get(i);
            memberService.insertMemberScattered(member,scatteredId);
        }
        return true;
    }

    @ResponseBody
    @RequestMapping(value = "/excelUp3",method = RequestMethod.POST)
    public boolean excelUp3(MultipartFile file,HttpSession session){
        int qid =(Integer) session.getAttribute("qid");
        List<Member> memberList = memberService.excelUp(file);
        if(memberList.isEmpty()){
            return false;
        }
        for(int i=0;i<memberList.size();i++){
            Member member = memberList.get(i);
            memberService.insertMemberQz(member,qid);
        }
        return true;
    }

    @RequestMapping(value="/download",method=RequestMethod.GET)
    public void download(HttpServletResponse response) throws IOException {
        response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode("excelMod.xls", "UTF-8"));
        String path = MemberController.class.getClassLoader().getResource("excelMod.xls").getPath();
        FileInputStream in = new FileInputStream(path);
        OutputStream out = response.getOutputStream();
        byte buffer[] = new byte[1024];
        int len = 0;
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer, 0, len);
        }
        in.close();
        out.close();
    }
}
