package com.rimi.cs.service;

import com.rimi.cs.pojo.Food;

import java.util.List;

/**
 * 食物添加接口
 *
 * @author wenyan
 * @date 2018-06-25 20:42
 */
public interface FoodService {
     void insert(Food food);
     String delete(int id);
     List<Food> select();

    Food selectById(int foodId);

    int updateFoodById(Food food1);

    List<Food> selectCount();

    List<Food> selectFood(String foodname);
}
