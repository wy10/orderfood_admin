package com.rimi.cs.service.impl;

import com.rimi.cs.dao.FoodMapper;
import com.rimi.cs.pojo.Food;
import com.rimi.cs.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 食物相关数据的保存更改
 *
 * @author wenyan
 * @date 2018-06-25 20:44
 */
@Service
public class FoodServiceImpl implements FoodService {
    @Autowired
    FoodMapper foodMapper;

    @Override
    public void insert(Food food) {
        foodMapper.insert(food);
    }

    @Override
    public String delete(int id) {
        Food food = foodMapper.selectByPrimaryKey(id);
        if(food != null){
            int result = foodMapper.deleteByPrimaryKey(id);
            return result > 0 ? "true":"false";
        }else {
            return "notexist";
        }
    }

    @Override
    public List<Food> select() {
        return foodMapper.selectAll();
    }

    @Override
    public Food selectById(int foodId) {
        return foodMapper.selectByPrimaryKey(foodId);
    }

    @Override
    public int updateFoodById(Food food1) {
        return foodMapper.updateByPrimaryKey(food1);
    }

    @Override
    public List<Food> selectCount() {
        return foodMapper.selectCount();
    }

    @Override
    public List<Food> selectFood(String foodname) {
        return foodMapper.selectFood(foodname);
    }



}
