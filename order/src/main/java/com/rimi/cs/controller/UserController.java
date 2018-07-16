package com.rimi.cs.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rimi.cs.pojo.User;
import com.rimi.cs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户信息更改
 *
 * @author wenyan
 * @date 2018-06-27 11:29
 */
@Controller
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    public String updateUser(int userId, String userName, String password, String phoneNum,Model model){
        System.out.println(userId);
        User user = userService.selectById(userId);
        /*Map map = new HashMap<String,String>();*/
        if(user != null){
            User user1 = new User(userId,userName,password,phoneNum);
            int i = userService.updateUserById(user1);
            model.addAttribute("mess","更新成功");
        }else{
            model.addAttribute("mess","id不存在");
        }
        return "manger/management";
    }



    @ResponseBody
    @RequestMapping(value = "/delUser", method = RequestMethod.GET)
    public Map delUser(int userid) {
        Map<String, String> map = new HashMap<>();
        String result = userService.delete(userid);
        map.put("result", result);
        return map;
    }

    @RequestMapping(value="/addMess",method = RequestMethod.POST)
    public String addMess(String mess,Model model){
        User user1 = new User("admin","","");
        String messO = userService.selectMessByName(user1);
        messO +="<br>"+ mess;
        User user = new User("admin",messO,"");
        int i = userService.updateMessByUser(user);
        model.addAttribute("mess","添加记录成功");
        return "manger/management";
    }

    @RequestMapping(value="/clearMess",method = RequestMethod.GET)
    public String delMess(Model model){
        User user = new User("admin","","");
        int i = userService.deleteMess(user);
        model.addAttribute("mess","记录清空成功");
        return "manger/management";
    }

    @RequestMapping(value = "/updatePass",method = RequestMethod.POST)
    public String updatePass(String password,Model model){
        User admin = new User("admin","",password);
        int i = userService.updatePass(admin);
        model.addAttribute("mess","密码更新成功");
        return "manger/management";
    }

    @RequestMapping(value = "/selMess",method = RequestMethod.GET)
    public String selPass(Model model){
        User admin = new User("admin","","");
        String messO = userService.selectMessByName(admin);
        model.addAttribute("message",messO );
        return "manger/management";
    }

    @RequestMapping(value="/selAllUser",method=RequestMethod.GET)
    public String selAllFood(String uname,Model model, @RequestParam(required = false, defaultValue = "1") int pageIndex){

        PageHelper.startPage(pageIndex, 5);
        List<User> userList = userService.selectUser(uname);
        model.addAttribute("uname",uname);
        model.addAttribute("page", new PageInfo<User>(userList));
        return "manger/management";
    }


}
