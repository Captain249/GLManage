package com.gl.common.user.service;

import com.gl.common.user.bean.User;

import java.util.List;

public interface UserService {
    public User loginCheck(User user);

    public void insertBatch(List<User> users);

    public void createDynamicTable(Integer id);
}
