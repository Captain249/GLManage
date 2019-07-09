package com.gl.common.lxy.service.impl;

import com.gl.common.lxy.bean.Lxy;
import com.gl.common.lxy.dao.LxyMapper;
import com.gl.common.lxy.service.LxyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
@Service(value = "lxyService")
public class LxyServiceImpl implements LxyService {

    @Autowired
    private LxyMapper lxyMapper;

    public List<Lxy> queryAllLxy(Lxy checkLxy, int currentPage, int pageLimit) {
        currentPage -= 1;
        currentPage *= pageLimit;
        return lxyMapper.queryAllLxy(checkLxy,currentPage,pageLimit);
    }

    public List<Lxy> queryFinishLxy(Lxy checkLxy, int currentPage, int pageLimit) {
        currentPage -= 1;
        currentPage *= pageLimit;
        return lxyMapper.queryFinishLxy(checkLxy,currentPage,pageLimit);
    }

    public List<Lxy> queryProcessLxy(Lxy checkLxy, int currentPage, int pageLimit) {
        currentPage -= 1;
        currentPage *= pageLimit;
        return lxyMapper.queryProcessLxy(checkLxy,currentPage,pageLimit);
    }

    public Lxy queryLxyByExample(Lxy lxy) {
        return lxyMapper.queryLxyByExample(lxy);
    }

    public int insertLxy(Lxy lxy) {
        return lxyMapper.insertLxy(lxy);
    }

    public int deleteLxyByExample(Lxy lxy) {
        return lxyMapper.deleteLxyByExample(lxy);
    }

    public int updateLxyByExample(Lxy lxy) {
        return lxyMapper.updateLxyByExample(lxy);
    }
}
