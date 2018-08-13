package com.amar.service;

import com.amar.domain.User;
import com.amar.domain.UserExt;
import com.amar.util.tool.ShiroKit;
import org.springframework.stereotype.Service;

/**
 * @author dingmx
 * @date 2018/8/12 22:24
 */
@Service
public class UserService {

    /**
     * 根据用户名获取用户
     * @param username 用户名
     * @return 用户信息
     */
    public User getUserByUserName(String username) {
        User user = new User();
        user.setId(1L);
        user.setUsername("admin");
        user.setPassword(ShiroKit.md5("123456"));
        return user;
    }

    /**
     * 获取用户信息
     * @param user
     * @return
     */
    public UserExt getUserExt(User user) {
        return new UserExt();
    }
}
