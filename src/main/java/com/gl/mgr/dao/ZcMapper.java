package com.gl.mgr.dao;

import com.gl.mgr.bean.Zc;
import com.gl.mgr.bean.ZcExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZcMapper {
    int countByExample(ZcExample example);

    int deleteByExample(ZcExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Zc record);

    int insertSelective(Zc record);

    List<Zc> selectByExample(ZcExample example);

    Zc selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Zc record, @Param("example") ZcExample example);

    int updateByExample(@Param("record") Zc record, @Param("example") ZcExample example);

    int updateByPrimaryKeySelective(Zc record);

    int updateByPrimaryKey(Zc record);
}