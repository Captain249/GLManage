package com.gl.common.lxy.dao;

import com.gl.common.lxy.bean.Lxy;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LxyMapper {
    List<Lxy> queryAllLxy(@Param("checkLxy") Lxy checkLxy,@Param("currentPage") int currentPage,@Param("pageLimit") int pageLimit);
    List<Lxy> queryFinishLxy(@Param("checkLxy") Lxy checkLxy,@Param("currentPage") int currentPage,@Param("pageLimit") int pageLimit);
    List<Lxy> queryProcessLxy(@Param("checkLxy") Lxy checkLxy,@Param("currentPage") int currentPage,@Param("pageLimit") int pageLimit);
    Lxy queryLxyByExample(Lxy lxy);
    int insertLxy(Lxy lxy);
    int deleteLxyByExample(Lxy lxy);
    int updateLxyByExample(Lxy lxy);
}
