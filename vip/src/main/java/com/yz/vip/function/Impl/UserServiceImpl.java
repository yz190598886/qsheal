package com.yz.vip.function.Impl;

import com.yz.common.ThisSystemException;
import static com.yz.common.ThisSystemUnit.$;

import com.yz.vip.dao.UserDao;
import com.yz.vip.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

    @Service
public class UserServiceImpl implements UserService {
        @Autowired
        UserDao udao;
        @Override
        public User login(String account, String password) throws Exception {
           account= $("账户不能为空",account);
           password= $("密码不能为空",password);
           User u=udao.selectByAccount(account);
           if(u==null){
               throw new ThisSystemException("账户不存在");
           }
           if(!u.getPassword().equals(password)) {
                throw new ThisSystemException("密码错误");
           }
           return u;
        }
}
