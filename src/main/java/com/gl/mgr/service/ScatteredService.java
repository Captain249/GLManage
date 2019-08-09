package com.gl.mgr.service;

import com.github.pagehelper.PageInfo;
import com.gl.mgr.bean.Lxy;
import com.gl.mgr.bean.Scattered;

public interface ScatteredService {
    PageInfo<Scattered> gnhk(Scattered checkScattered, int currentPage, int pageLimit);
    PageInfo<Scattered> cj(Scattered checkScattered, int currentPage, int pageLimit);
    PageInfo<Scattered> dx(Scattered checkScattered, int currentPage, int pageLimit);
    Scattered queryScatteredByExample(Scattered scattered);
    int insertScattered(Scattered scattered);
    int deleteScatteredById(Scattered scattered);
    int updateScatteredById(Scattered scattered);
    Scattered queryScatteredById(int id);
    int deleteScatteredMember(int id);
}
