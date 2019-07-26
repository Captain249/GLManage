package com.gl.mgr.service.impl;

import com.gl.mgr.bean.User;
import com.gl.mgr.bean.UserExample;
import com.gl.mgr.dao.UserMapper;
import com.gl.mgr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Controller
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User loginCheck(User user) {
        UserExample example = new UserExample();
        if(user != null){
            if(user.getUsername()!=null && !"".equals(user.getUsername()) && user.getPassword()!=null && !"".equals(user.getPassword())){
                example.createCriteria().andUsernameEqualTo(user.getUsername()).andPasswordEqualTo(user.getPassword());
                List<User> userList = userMapper.selectByExample(example);
                if(!userList.isEmpty()){
                    user = userList.get(0);
                    return user;
                }else {
                    return null;
                }
            }else {
                return null;
            }
        }
        return null;
    }
}
