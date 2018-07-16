package com.rimi.cs.service.impl;

import com.rimi.cs.dao.UserMapper;
import com.rimi.cs.pojo.User;
import com.rimi.cs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * user相关信息接口的实现
 *
 * @author wenyan
 * @date 2018-06-26 16:03
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public int updateMoneyByUserId(Integer userid,Double money) {
        return userMapper.updateMoneyByUserId(userid,money);
    }

    @Override
    public int selectMoneyById(Integer userid) {
        return userMapper.selectMoneyById(userid);
    }

    @Override
    public User selectById(int userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public int updateUserById(User user) {
        return userMapper.updateByPrimaryKey(user);
    }

    @Override
    public List<User> select() {
        return userMapper.selectAll();
    }

    @Override
    public String delete(int userid) {
        User user = userMapper.selectByPrimaryKey(userid);
        if(user != null){
            int result = userMapper.deleteByPrimaryKey(userid);
            return result > 0 ? "true":"false";
        }else {
            return "notexist";
        }
    }

    @Override
    public String selectMessByName(User user) {
        return userMapper.selectMessByName(user);
    }

    @Override
    public int updateMessByUser(User user) {
        return userMapper.updateMessByUser(user);
    }

    @Override
    public int deleteMess(User user) {
        return userMapper.deleteMess(user);
    }

    @Override
    public int updatePass(User admin) {
        return userMapper.updatePass(admin);
    }

    @Override
    public List<User> selectUser(String username) {
        return userMapper.selectUser(username);
    }

    @Override
    public String selectByName(String username) {
        User user = userMapper.selectByName(username);
        if(user != null){
            return "exit";
        }else {
            return "";
        }
    }



}
