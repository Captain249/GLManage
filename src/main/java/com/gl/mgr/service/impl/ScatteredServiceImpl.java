package com.gl.mgr.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gl.mgr.bean.*;
import com.gl.mgr.dao.MemberMapper;
import com.gl.mgr.dao.ScatteredMapper;
import com.gl.mgr.service.ScatteredService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class ScatteredServiceImpl implements ScatteredService {
    @Autowired
    private ScatteredMapper scatteredMapper;
    @Autowired
    private MemberMapper memberMapper;

    @Override
    public PageInfo<Scattered> gnhk(Scattered checkScattered, int currentPage, int pageLimit) {
        ScatteredExample example = new ScatteredExample();
        ScatteredExample.Criteria criteria = example.createCriteria();
        criteria.andTypeEqualTo("国内航空线");
        if(checkScattered.getName()!=null&&!"".equals(checkScattered.getName())){
            criteria.andNameLike("%"+checkScattered.getName()+"%");
        }
        Page<Scattered> pageObject = PageHelper.startPage(currentPage,pageLimit);
        List<Scattered> scatteredList = scatteredMapper.selectByExample(example);
        PageInfo<Scattered> page = new PageInfo<Scattered>(scatteredList);
        return page;
    }

    @Override
    public PageInfo<Scattered> cj(Scattered checkScattered, int currentPage, int pageLimit) {
        ScatteredExample example = new ScatteredExample();
        ScatteredExample.Criteria criteria = example.createCriteria();
        criteria.andTypeEqualTo("出境");
        if(checkScattered.getName()!=null&&!"".equals(checkScattered.getName())){
            criteria.andNameLike("%"+checkScattered.getName()+"%");
        }
        Page<Scattered> pageObject = PageHelper.startPage(currentPage,pageLimit);
        List<Scattered> scatteredList = scatteredMapper.selectByExample(example);
        PageInfo<Scattered> pageInfo = new PageInfo<Scattered>(scatteredList);
        return pageInfo;
    }

    @Override
    public PageInfo<Scattered> dx(Scattered checkScattered, int currentPage, int pageLimit) {
        ScatteredExample example = new ScatteredExample();
        ScatteredExample.Criteria criteria = example.createCriteria();
        criteria.andTypeEqualTo("短线");
        if(checkScattered.getName()!=null&&!"".equals(checkScattered.getName())){
            criteria.andNameLike("%"+checkScattered.getName()+"%");
        }
        Page<Scattered> pageObject = PageHelper.startPage(currentPage,pageLimit);
        List<Scattered> scatteredList = scatteredMapper.selectByExample(example);
        PageInfo<Scattered> pageInfo = new PageInfo<Scattered>(scatteredList);
        return pageInfo;
    }

    @Override
    public Scattered queryScatteredByExample(Scattered scattered) {
        ScatteredExample example = new ScatteredExample();
        ScatteredExample.Criteria criteria = example.createCriteria();
        if(scattered.getName()!=null&&!"".equals(scattered.getName())){
            criteria.andNameLike("%"+scattered.getName()+"%");
        }
        criteria.andIdEqualTo(scattered.getId());
        List<Scattered> scatteredList = scatteredMapper.selectByExample(example);
        if(!scatteredList.isEmpty()){
            return scatteredList.get(0);
        }
        return null;
    }

    @Override
    public int insertScattered(Scattered scattered) {
        return scatteredMapper.insert(scattered);
    }

    @Override
    public int deleteScatteredById(Scattered scattered) {
        return scatteredMapper.deleteByPrimaryKey(scattered.getId());
    }

    @Override
    public int updateScatteredById(Scattered scattered) {
        return scatteredMapper.updateByPrimaryKey(scattered);
    }

    @Override
    public Scattered queryScatteredById(int id) {
        return scatteredMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteScatteredMember(int id) {
        List<Integer> memberIds = memberMapper.queryMembersByScatteredId(id);
        if(!memberIds.isEmpty()){
            MemberExample example = new MemberExample();
            example.createCriteria().andIdIn(memberIds);
            memberMapper.deleteByExample(example);
        }
        return scatteredMapper.deleteScatteredMember(id);
    }
}
