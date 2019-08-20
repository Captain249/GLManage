package com.gl.mgr.service;

import com.github.pagehelper.PageInfo;
import com.gl.mgr.bean.Lxy;

public interface LxyService {
    PageInfo<Lxy> queryAllLxy(Lxy checkLxy, int currentPage, int pageLimit);
    PageInfo<Lxy> queryNomal(Lxy checkLxy,int currentPage,int pageLimit);
    PageInfo<Lxy> queryProcessLxy(Lxy checkLxy,int currentPage,int pageLimit);
    Lxy queryLxyByExample(Lxy lxy);
    int insertLxy(Lxy lxy);
    int deleteLxyById(Lxy lxy);
    int updateLxyById(Lxy lxy);
    Lxy queryLxyById(int id);
    int deleteLxyMember(int id);
}
