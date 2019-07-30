package com.gl.mgr.service;

import com.gl.mgr.bean.Lxy;

import java.util.List;

public interface LxyService {
    List<Lxy> queryAllLxy(Lxy checkLxy, int currentPage, int pageLimit);
    List<Lxy> queryFinishLxy(Lxy checkLxy,int currentPage,int pageLimit);
    List<Lxy> queryProcessLxy(Lxy checkLxy,int currentPage,int pageLimit);
    Lxy queryLxyByExample(Lxy lxy);
    int insertLxy(Lxy lxy);
    int deleteLxyById(Lxy lxy);
    int updateLxyById(Lxy lxy);
    Lxy queryLxyById(int id);
}
