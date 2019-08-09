package com.gl.mgr.dao;

import com.gl.mgr.bean.Member;
import com.gl.mgr.bean.MemberExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MemberMapper {
    int countByExample(MemberExample example);

    int deleteByExample(MemberExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Member record);

    int insertSelective(Member record);

    List<Member> selectByExample(MemberExample example);

    Member selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Member record, @Param("example") MemberExample example);

    int updateByExample(@Param("record") Member record, @Param("example") MemberExample example);

    int updateByPrimaryKeySelective(Member record);

    int updateByPrimaryKey(Member record);

    List<Integer> queryMembersByLxyId (@Param("lxyId") int lxyId);

    int deleteLxyMember(@Param("lxyId")int lxyId,@Param("memberId")int memberId);

    int insertLxyMember(@Param("lxyId")int lxyId,@Param("memberId")int memberId);

    List<Integer> queryMembersByScatteredId (@Param("scatteredId") int scatteredId);

    int deleteScatteredMember(@Param("scatteredId")int scatteredId,@Param("memberId")int memberId);

    int insertScatteredMember(@Param("scatteredId")int scatteredId,@Param("memberId")int memberId);
}