package com.gl.mgr.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gl.mgr.bean.Lxy;
import com.gl.mgr.bean.LxyExample;
import com.gl.mgr.dao.LxyMapper;
import com.gl.mgr.service.LxyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class LxyServiceImpl implements LxyService {
    @Autowired
    private LxyMapper lxyMapper;

    @Override
    public List<Lxy> queryAllLxy(Lxy checkLxy, int currentPage, int pageLimit) {
        LxyExample example = new LxyExample();
        LxyExample.Criteria criteria = example.createCriteria();
        if(checkLxy.getName()!=null&&!"".equals(checkLxy.getName())){
            criteria.andNameLike("%"+checkLxy.getName()+"%");
        }
        Page<Lxy> pageObject = PageHelper.startPage(currentPage,pageLimit);
        List<Lxy> lxyList = lxyMapper.selectByExample(example);
        return lxyList;
    }

    @Override
    public List<Lxy> queryFinishLxy(Lxy checkLxy, int currentPage, int pageLimit) {
        LxyExample example = new LxyExample();
        LxyExample.Criteria criteria = example.createCriteria();
        if(checkLxy.getName()!=null&&!"".equals(checkLxy.getName())){
            criteria.andNameLike("%"+checkLxy.getName()+"%");
        }
        criteria.andStatusEqualTo(1);
        Page<Lxy> pageObject = PageHelper.startPage(currentPage,pageLimit);
        List<Lxy> lxyList = lxyMapper.selectByExample(example);
        return lxyList;
    }

    @Override
    public List<Lxy> queryProcessLxy(Lxy checkLxy, int currentPage, int pageLimit) {
        LxyExample example = new LxyExample();
        LxyExample.Criteria criteria = example.createCriteria();
        if(checkLxy.getName()!=null&&!"".equals(checkLxy.getName())){
            criteria.andNameLike("%"+checkLxy.getName()+"%");
        }
        criteria.andStatusEqualTo(0);
        Page<Lxy> pageObject = PageHelper.startPage(currentPage,pageLimit);
        List<Lxy> lxyList = lxyMapper.selectByExample(example);
        return lxyList;
    }

    @Override
    public Lxy queryLxyByExample(Lxy lxy) {
        LxyExample example = new LxyExample();
        LxyExample.Criteria criteria = example.createCriteria();
        if(lxy.getName()!=null&&!"".equals(lxy.getName())){
            criteria.andNameLike(lxy.getName());
        }
        criteria.andIdEqualTo(lxy.getId());
        List<Lxy> lxyList = lxyMapper.selectByExample(example);
        if(!lxyList.isEmpty()){
            return lxyList.get(0);
        }
        return null;
    }

    @Override
    public int insertLxy(Lxy lxy) {
        return lxyMapper.insert(lxy);
    }

    @Override
    public int deleteLxyById(Lxy lxy) {
        return lxyMapper.deleteByPrimaryKey(lxy.getId());
    }

    @Override
    public int updateLxyById(Lxy lxy) {
        return lxyMapper.updateByPrimaryKey(lxy);
    }
}
