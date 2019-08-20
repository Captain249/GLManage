package com.gl.mgr.dao;

import com.gl.mgr.bean.Gwj;
import com.gl.mgr.bean.GwjExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GwjMapper {
    int countByExample(GwjExample example);

    int deleteByExample(GwjExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Gwj record);

    int insertSelective(Gwj record);

    List<Gwj> selectByExample(GwjExample example);

    Gwj selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Gwj record, @Param("example") GwjExample example);

    int updateByExample(@Param("record") Gwj record, @Param("example") GwjExample example);

    int updateByPrimaryKeySelective(Gwj record);

    int updateByPrimaryKey(Gwj record);
}