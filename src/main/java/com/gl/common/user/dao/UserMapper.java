package com.gl.common.user.dao;

import com.gl.common.user.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    User loginCheck(User user);
    void insertBatch(@Param("users") List<User> users);
    void createDynamicTable(@Param("id") Integer id);
    User test(@Param("id") Integer id,@Param("user")User user);
}
