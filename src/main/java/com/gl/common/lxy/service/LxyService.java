package com.gl.common.lxy.service;

import com.gl.common.lxy.bean.Lxy;

import java.util.List;

public interface LxyService {
    List<Lxy> queryAllLxy(Lxy checkLxy,int currentPage,int pageLimit);
    List<Lxy> queryFinishLxy(Lxy checkLxy,int currentPage,int pageLimit);
    List<Lxy> queryProcessLxy(Lxy checkLxy,int currentPage,int pageLimit);
    Lxy queryLxyByExample(Lxy lxy);
    int insertLxy(Lxy lxy);
    int deleteLxyByExample(Lxy lxy);
    int updateLxyByExample(Lxy lxy);
}
