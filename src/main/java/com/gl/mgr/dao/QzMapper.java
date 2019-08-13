package com.gl.mgr.dao;

import com.gl.mgr.bean.Qz;
import com.gl.mgr.bean.QzExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QzMapper {
    int countByExample(QzExample example);

    int deleteByExample(QzExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Qz record);

    int insertSelective(Qz record);

    List<Qz> selectByExample(QzExample example);

    Qz selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Qz record, @Param("example") QzExample example);

    int updateByExample(@Param("record") Qz record, @Param("example") QzExample example);

    int updateByPrimaryKeySelective(Qz record);

    int updateByPrimaryKey(Qz record);

    int deleteQzMember(int qid);
}