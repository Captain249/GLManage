package com.gl.mgr.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gl.mgr.bean.Member;
import com.gl.mgr.bean.MemberExample;
import com.gl.mgr.dao.MemberMapper;
import com.gl.mgr.service.MemberService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberMapper memberMapper;
    @Override
    public PageInfo<Member> queryAllMember(Member checkMember,int lxyId, int currentPage, int pageLimit) {
        List<Integer> memberIds = memberMapper.queryMembersByLxyId(lxyId);
        MemberExample example = new MemberExample();
        MemberExample.Criteria criteria = example.createCriteria();
        if(checkMember.getName()!=null&& !"".equals(checkMember.getName())){
            criteria.andNameLike("%"+checkMember.getName()+"%");
        }
        if(!memberIds.isEmpty()){
            criteria.andIdIn(memberIds);
        }
        Page<Member> pageObject = PageHelper.startPage(currentPage,pageLimit);
        List<Member> memberList = memberMapper.selectByExample(example);
        //将用户信息放入PageInfo对象里
        PageInfo<Member> pageInfo = new PageInfo<Member>(memberList, pageLimit);
        if(memberIds.isEmpty()){
            pageInfo = new PageInfo<Member>(new ArrayList<Member>(),pageLimit);
        }
        return pageInfo;
    }

    @Override
    public Member queryMemberById(int id) {
        Member member = memberMapper.selectByPrimaryKey(id);
        return member;
    }

    @Override
    public int insertMember(Member member,int lxyId){
        memberMapper.insert(member);
        memberMapper.insertLxyMember(lxyId,member.getId());
        return 1;
    }

    @Override
    public int deleteMemberById(int memberId,int lxyId) {
        memberMapper.deleteByPrimaryKey(memberId);
        memberMapper.deleteLxyMember(lxyId,memberId);
        return 1;
    }

    @Override
    public int updateMemberById(Member member) {
        return memberMapper.updateByPrimaryKey(member);
    }

    @Override
    public List<Member> excelUp(MultipartFile file) {
        String orgName = file.getOriginalFilename();//获取上传文件的原名
        List<Member> memberList = new ArrayList<Member>();
        try {
            Workbook wb = getWorkbook(orgName,file.getInputStream());
            Sheet sheet = wb.getSheetAt(0);//获取第一个工作sheet
            for(int x=1;x<sheet.getPhysicalNumberOfRows();x++){ //返回物理定义的行数（不是工作表中的行数）x=0就从第一行开始
                Row row = sheet.getRow(x);
                if(row == null){
                    continue;
                }
                String name = row.getCell(0).getStringCellValue();
                String idcard = row.getCell(1).getStringCellValue();
                String phonenum = row.getCell(2).getStringCellValue();
                String address = row.getCell(3).getStringCellValue();
                String passport = row.getCell(4).getStringCellValue();
                String more = row.getCell(5).getStringCellValue();
                if("".equals(name)&&"".equals(idcard)&&"".equals(phonenum)&&"".equals(address)&&"".equals(passport)&&"".equals(more)){
                    continue;
                }
                Member member = new Member();
                member.setName(name);
                member.setIdcard(idcard);
                member.setPhonenum(phonenum);
                member.setAddress(address);
                member.setPassport(passport);
                member.setMore(more);
                memberList.add(member);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return memberList;
    }

    private Workbook getWorkbook(String name, InputStream in) throws IOException {
        if(name.endsWith(".xls")){
            return new HSSFWorkbook(in);//HSSFWorkbook:是操作Excel2003以前（包括2003）的版本，扩展名是.xls
        }
        return new XSSFWorkbook(in);//XSSFWorkbook:是操作Excel2007的版本，扩展名是.xlsx
    }

    private String getVal(Cell cell){
        String result="";
        switch(cell.getCellType()){
            case Cell.CELL_TYPE_STRING:
                result = ""+cell.getRichStringCellValue().getString();
                break;
            case Cell.CELL_TYPE_NUMERIC:
                result = ""+cell.getNumericCellValue();
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                result = ""+cell.getBooleanCellValue();
                break;
            case Cell.CELL_TYPE_FORMULA:
                result = ""+cell.getCellFormula();
                break;
            default:
                break;
        }
        return result;
    }

    @Override
    public PageInfo<Member> queryAllMemberScattered(Member checkMember, int scatteredId, int currentPage, int pageLimit) {
        List<Integer> memberIds = memberMapper.queryMembersByScatteredId(scatteredId);
        MemberExample example = new MemberExample();
        MemberExample.Criteria criteria = example.createCriteria();
        if(checkMember.getName()!=null&& !"".equals(checkMember.getName())){
            criteria.andNameLike("%"+checkMember.getName()+"%");
        }
        if(!memberIds.isEmpty()){
            criteria.andIdIn(memberIds);
        }
        Page<Member> pageObject = PageHelper.startPage(currentPage,pageLimit);
        List<Member> memberList = memberMapper.selectByExample(example);
        //将用户信息放入PageInfo对象里
        PageInfo<Member> pageInfo = new PageInfo<Member>(memberList, pageLimit);
        if(memberIds.isEmpty()){
            pageInfo = new PageInfo<Member>(new ArrayList<Member>(),pageLimit);
        }
        return pageInfo;
    }

    @Override
    public int insertMemberScattered(Member member, int scatteredId) {
        memberMapper.insert(member);
        memberMapper.insertScatteredMember(scatteredId,member.getId());
        return 1;
    }

    @Override
    public int deleteMemberByIdScattered(int memberId, int scatteredId) {
        memberMapper.deleteByPrimaryKey(memberId);
        memberMapper.deleteScatteredMember(scatteredId,memberId);
        return 1;
    }
}
