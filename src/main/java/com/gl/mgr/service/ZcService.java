package com.gl.mgr.service;

import com.github.pagehelper.PageInfo;
import com.gl.mgr.bean.Zc;

public interface ZcService {
    PageInfo<Zc> queryAllZc(String keyWord, int currentPage, int pageLimit);
    Zc queryZcByExample(Zc zc);
    int insertZc(Zc zc);
    int deleteZcById(Zc zc);
    int updateZcById(Zc zc);
    Zc queryZcById(int id);
}
