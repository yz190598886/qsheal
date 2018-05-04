package com.yz.vip.dao;

import com.yz.vip.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    public User selectByAccount(@Param("account") String account) throws Exception;
}
