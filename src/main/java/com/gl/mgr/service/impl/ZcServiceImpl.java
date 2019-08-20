package com.gl.mgr.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gl.mgr.bean.Zc;
import com.gl.mgr.bean.ZcExample;
import com.gl.mgr.dao.ZcMapper;
import com.gl.mgr.service.ZcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class ZcServiceImpl implements ZcService {

    @Autowired
    private ZcMapper zcMapper;

    @Override
    public PageInfo<Zc> queryAllZc(String keyWord, int currentPage, int pageLimit) {
        ZcExample example = new ZcExample();
        if(keyWord!=null&&!"".equals(keyWord)){
            example.or().andCompanyLike("%"+keyWord+"%");
            example.or().andPrincipalLike("%"+keyWord+"%");
        }
        example.setOrderByClause("startdate DESC");
        Page<Zc> pageObject = PageHelper.startPage(currentPage,pageLimit);
        List<Zc> zcList = zcMapper.selectByExample(example);
        PageInfo<Zc> page = new PageInfo<Zc>(zcList);
        return page;
    }

    @Override
    public Zc queryZcByExample(Zc zc) {
        ZcExample example = new ZcExample();
        ZcExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(zc.getId());
        List<Zc> zcList = zcMapper.selectByExample(example);
        if(!zcList.isEmpty()){
            return zcList.get(0);
        }
        return null;
    }

    @Override
    public int insertZc(Zc zc) {
        return zcMapper.insert(zc);
    }

    @Override
    public int deleteZcById(Zc zc) {
        return zcMapper.deleteByPrimaryKey(zc.getId());
    }

    @Override
    public int updateZcById(Zc zc) {
        return zcMapper.updateByPrimaryKey(zc);
    }

    @Override
    public Zc queryZcById(int id) {
        return zcMapper.selectByPrimaryKey(id);
    }
}
