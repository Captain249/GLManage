package com.gl.mgr.dao;

import com.gl.mgr.bean.Lxy;
import com.gl.mgr.bean.LxyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LxyMapper {
    int countByExample(LxyExample example);

    int deleteByExample(LxyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Lxy record);

    int insertSelective(Lxy record);

    List<Lxy> selectByExample(LxyExample example);

    Lxy selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Lxy record, @Param("example") LxyExample example);

    int updateByExample(@Param("record") Lxy record, @Param("example") LxyExample example);

    int updateByPrimaryKeySelective(Lxy record);

    int updateByPrimaryKey(Lxy record);
}