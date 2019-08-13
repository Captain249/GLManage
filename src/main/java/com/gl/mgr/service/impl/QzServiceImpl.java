package com.gl.mgr.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gl.mgr.bean.MemberExample;
import com.gl.mgr.bean.Qz;
import com.gl.mgr.bean.QzExample;
import com.gl.mgr.dao.MemberMapper;
import com.gl.mgr.dao.QzMapper;
import com.gl.mgr.service.QzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class QzServiceImpl implements QzService {

    @Autowired
    private QzMapper qzMapper;
    @Autowired
    private MemberMapper memberMapper;

    @Override
    public PageInfo<Qz> getAllQz(Qz checkQz, int currentPage, int pageLimit) {
        QzExample example = new QzExample();
        QzExample.Criteria criteria = example.createCriteria();
        if(checkQz.getName()!=null&&!"".equals(checkQz.getName())){
            criteria.andNameLike("%"+checkQz.getName()+"%");
            example.or().andPrincipalLike("%"+checkQz.getName()+"%");
        }
        example.setOrderByClause("startDate DESC");
        Page<Qz> pageObject = PageHelper.startPage(currentPage,pageLimit);
        List<Qz> qzList = qzMapper.selectByExample(example);
        PageInfo<Qz> page = new PageInfo<Qz>(qzList);
        return page;
    }

    @Override
    public Qz queryQzByExample(Qz qz) {
        QzExample example = new QzExample();
        QzExample.Criteria criteria = example.createCriteria();
        if(qz.getName()!=null&&!"".equals(qz.getName())){
            criteria.andNameLike("%"+qz.getName()+"%");
        }
        criteria.andIdEqualTo(qz.getId());
        List<Qz> qzList = qzMapper.selectByExample(example);
        if(!qzList.isEmpty()){
            return qzList.get(0);
        }
        return null;
    }

    @Override
    public int insertQz(Qz qz) {
        return qzMapper.insert(qz);
    }

    @Override
    public int deleteQzById(Qz qz) {
        return qzMapper.deleteByPrimaryKey(qz.getId());
    }

    @Override
    public int updateQzById(Qz qz) {
        return qzMapper.updateByPrimaryKey(qz);
    }

    @Override
    public Qz queryQzById(int id) {
        return qzMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteQzMember(int id) {
        List<Integer> memberIds = memberMapper.queryMembersByQzId(id);
        if(!memberIds.isEmpty()){
            MemberExample example = new MemberExample();
            example.createCriteria().andIdIn(memberIds);
            memberMapper.deleteByExample(example);
        }
        return qzMapper.deleteQzMember(id);
    }
}
