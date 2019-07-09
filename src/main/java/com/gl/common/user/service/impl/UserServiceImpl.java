package com.gl.common.user.service.impl;

import com.gl.common.user.bean.User;
import com.gl.common.user.service.UserService;
import com.gl.common.user.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
@Service(value = "userService")
public class UserServiceImpl implements UserService {

@Autowired
private UserMapper userMapper;

    public User loginCheck(User user) {
        return userMapper.loginCheck(user);
    }

    public void insertBatch(List<User> users) {
        userMapper.insertBatch(users);
    }

    public void createDynamicTable(Integer id) {
        userMapper.createDynamicTable(id);
    }
}
