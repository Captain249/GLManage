package com.gl.mgr.service;

import com.github.pagehelper.PageInfo;
import com.gl.mgr.bean.Member;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

public interface MemberService {
    PageInfo<Member> queryAllMember(Member checkMember,int lxyId, int currentPage, int pageLimit);
    Member queryMemberById(int id);
    int insertMember(Member member,int lxyId);
    int deleteMemberById(int memberId,int lxyId);
    int updateMemberById(Member member);
    List<Member> excelUp(MultipartFile file);
}
