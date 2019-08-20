package com.gl.mgr.dao;

import com.gl.mgr.bean.Scattered;
import com.gl.mgr.bean.ScatteredExample;
import java.util.List;

import com.gl.mgr.bean.Statistic;
import org.apache.ibatis.annotations.Param;

public interface ScatteredMapper {
    int countByExample(ScatteredExample example);

    int deleteByExample(ScatteredExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Scattered record);

    int insertSelective(Scattered record);

    List<Scattered> selectByExample(ScatteredExample example);

    Scattered selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Scattered record, @Param("example") ScatteredExample example);

    int updateByExample(@Param("record") Scattered record, @Param("example") ScatteredExample example);

    int updateByPrimaryKeySelective(Scattered record);

    int updateByPrimaryKey(Scattered record);

    int deleteScatteredMember(int scattered);

    List<Statistic> statistic(String year);
}