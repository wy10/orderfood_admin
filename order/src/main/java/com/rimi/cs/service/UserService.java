package com.rimi.cs.service;

import com.rimi.cs.pojo.User;

import java.util.List;

/**
 * 用户更新接口
 *
 * @author wenyan
 * @date 2018-06-26 16:02
 */
public interface UserService {
    int updateMoneyByUserId(Integer userid,Double money);

    int selectMoneyById(Integer userid);

    User selectById(int userId);

    int updateUserById(User user);

    List<User> select();

    String delete(int userid);

    String selectMessByName(User user);

    int updateMessByUser(User user);

    int deleteMess(User user);

    int updatePass(User admin);

    List<User> selectUser(String username);

    String selectByName(String username);


}
