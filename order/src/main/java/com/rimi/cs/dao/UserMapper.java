package com.rimi.cs.dao;

import com.rimi.cs.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    User selectByPrimaryKey(Integer userid);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    int updateMoneyByUserId(@Param("userid")Integer userid, @Param("money")Double money);

    int selectMoneyById(Integer userid);

    int updateById(int userId);

    String selectMessByName(User user);

    int updateMessByUser(User user);

    int deleteMess(User user);

    int updatePass(User admin);

    List<User> selectUser(@Param("username") String username);

    User selectByName(String username);

}
