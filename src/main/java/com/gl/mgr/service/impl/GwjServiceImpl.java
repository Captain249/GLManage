package com.gl.mgr.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gl.mgr.bean.Gwj;
import com.gl.mgr.bean.GwjExample;
import com.gl.mgr.dao.GwjMapper;
import com.gl.mgr.service.GwjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class GwjServiceImpl implements GwjService {

    @Autowired
    private GwjMapper gwjMapper;

    @Override
    public PageInfo<Gwj> queryAllGwj(Gwj checkGwj, int currentPage, int pageLimit) {
        GwjExample example = new GwjExample();
        if(checkGwj.getName()!=null&&!"".equals(checkGwj.getName())){
            example.or().andNameLike("%"+checkGwj.getName()+"%");
            example.or().andCompanyLike("%"+checkGwj.getName()+"%");
        }
        example.setOrderByClause("startdate DESC");
        Page<Gwj> pageObject = PageHelper.startPage(currentPage,pageLimit);
        List<Gwj> gwjList = gwjMapper.selectByExample(example);
        PageInfo<Gwj> page = new PageInfo<Gwj>(gwjList);
        return page;
    }

    @Override
    public Gwj queryGwjByExample(Gwj gwj) {
        GwjExample example = new GwjExample();
        GwjExample.Criteria criteria = example.createCriteria();
        if(gwj.getName()!=null&&!"".equals(gwj.getName())){
            criteria.andNameLike("%"+gwj.getName()+"%");
        }
        criteria.andIdEqualTo(gwj.getId());
        List<Gwj> gwjList = gwjMapper.selectByExample(example);
        if(!gwjList.isEmpty()){
            return gwjList.get(0);
        }
        return null;
    }

    @Override
    public int insertGwj(Gwj gwj) {
        return gwjMapper.insert(gwj);
    }

    @Override
    public int deleteGwjById(Gwj gwj) {
        return gwjMapper.deleteByPrimaryKey(gwj.getId());
    }

    @Override
    public int updateGwjById(Gwj gwj) {
        return gwjMapper.updateByPrimaryKey(gwj);
    }

    @Override
    public Gwj queryGwjById(int id) {
        return gwjMapper.selectByPrimaryKey(id);
    }
}
