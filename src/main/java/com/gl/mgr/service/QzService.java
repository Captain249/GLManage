package com.gl.mgr.service;

import com.github.pagehelper.PageInfo;
import com.gl.mgr.bean.Qz;

public interface QzService {
    PageInfo<Qz> getAllQz(Qz checkQz, int currentPage, int pageLimit);
    Qz queryQzByExample(Qz qz);
    int insertQz(Qz qz);
    int deleteQzById(Qz qz);
    int updateQzById(Qz qz);
    Qz queryQzById(int id);
    int deleteQzMember(int id);
}
