package com.gl.mgr.service;

import com.github.pagehelper.PageInfo;
import com.gl.mgr.bean.Gwj;

public interface GwjService {
    PageInfo<Gwj> queryAllGwj(Gwj checkGwj, int currentPage, int pageLimit);
    Gwj queryGwjByExample(Gwj gwj);
    int insertGwj(Gwj gwj);
    int deleteGwjById(Gwj gwj);
    int updateGwjById(Gwj gwj);
    Gwj queryGwjById(int id);
}
