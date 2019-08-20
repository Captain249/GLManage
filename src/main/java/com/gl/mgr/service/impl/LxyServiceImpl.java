package com.gl.mgr.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gl.mgr.bean.Lxy;
import com.gl.mgr.bean.LxyExample;
import com.gl.mgr.bean.MemberExample;
import com.gl.mgr.dao.LxyMapper;
import com.gl.mgr.dao.MemberMapper;
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
    @Autowired
    private MemberMapper memberMapper;

    @Override
    public PageInfo<Lxy> queryAllLxy(Lxy checkLxy, int currentPage, int pageLimit) {
        LxyExample example = new LxyExample();
        if(checkLxy.getName()!=null&&!"".equals(checkLxy.getName())){
            example.or().andNameLike("%"+checkLxy.getName()+"%").andGrouptypeNotEqualTo("普通团队");
            example.or().andPrincipalLike("%"+checkLxy.getName()+"%").andGrouptypeNotEqualTo("普通团队");
            example.or().andGnameLike("%"+checkLxy.getName()+"%").andGrouptypeNotEqualTo("普通团队");
        }else {
            example.or().andGrouptypeNotEqualTo("普通团队");
        }
        example.setOrderByClause("startDate DESC");
        Page<Lxy> pageObject = PageHelper.startPage(currentPage,pageLimit);
        List<Lxy> lxyList = lxyMapper.selectByExample(example);
        PageInfo<Lxy> page = new PageInfo<Lxy>(lxyList);
        return page;
    }

    @Override
    public PageInfo<Lxy> queryProcessLxy(Lxy checkLxy, int currentPage, int pageLimit) {
        LxyExample example = new LxyExample();
        if(checkLxy.getName()!=null&&!"".equals(checkLxy.getName())){
            example.or().andNameLike("%"+checkLxy.getName()+"%").andStatusEqualTo(0);
            example.or().andPrincipalLike("%"+checkLxy.getName()+"%").andStatusEqualTo(0);
            example.or().andGnameLike("%"+checkLxy.getName()+"%").andStatusEqualTo(0);
        }else{
            example.or().andStatusEqualTo(0);
        }
        example.setOrderByClause("startDate DESC");
        Page<Lxy> pageObject = PageHelper.startPage(currentPage,pageLimit);
        List<Lxy> lxyList = lxyMapper.selectByExample(example);
        PageInfo<Lxy> pageInfo = new PageInfo<Lxy>(lxyList);
        return pageInfo;
    }

    @Override
    public PageInfo<Lxy> queryNomal(Lxy checkLxy, int currentPage, int pageLimit) {
        LxyExample example = new LxyExample();
        if(checkLxy.getName()!=null&&!"".equals(checkLxy.getName())){
            example.or().andNameLike("%"+checkLxy.getName()+"%").andGrouptypeEqualTo("普通团队");
            example.or().andPrincipalLike("%"+checkLxy.getName()+"%").andGrouptypeEqualTo("普通团队");
            example.or().andGnameLike("%"+checkLxy.getName()+"%").andGrouptypeEqualTo("普通团队");
        }else{
            example.or().andGrouptypeEqualTo("普通团队");
        }
        example.setOrderByClause("startDate DESC");
        Page<Lxy> pageObject = PageHelper.startPage(currentPage,pageLimit);
        List<Lxy> lxyList = lxyMapper.selectByExample(example);
        PageInfo<Lxy> pageInfo = new PageInfo<Lxy>(lxyList);
        return pageInfo;
    }

    @Override
    public Lxy queryLxyByExample(Lxy lxy) {
        LxyExample example = new LxyExample();
        LxyExample.Criteria criteria = example.createCriteria();
        if(lxy.getName()!=null&&!"".equals(lxy.getName())){
            criteria.andNameLike("%"+lxy.getName()+"%");
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

    @Override
    public Lxy queryLxyById(int id) {
        return lxyMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteLxyMember(int id) {
        List<Integer> memberIds = memberMapper.queryMembersByLxyId(id);
        if(!memberIds.isEmpty()){
            MemberExample example = new MemberExample();
            example.createCriteria().andIdIn(memberIds);
            memberMapper.deleteByExample(example);
        }
        return lxyMapper.deleteLxyMember(id);
    }
}
