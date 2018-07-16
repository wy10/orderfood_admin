package com.rimi.cs.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rimi.cs.pojo.Food;
import com.rimi.cs.service.FoodService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.*;

/**
 * 添加食物
 *
 * @author wenyan
 * @date 2018-06-25 19:50
 */
@Controller
public class FoodController {

    @Autowired
    private FoodService foodService;

    /* String foodName,Double foodPrice,String foodType,String foodImg,Integer foodMax,*/
    @RequestMapping(value = "/addFood", method = RequestMethod.POST)
    public String addFood(HttpServletRequest request) {

        //上传文件的存储路径（服务器文件系统上的绝对文件路径）
        String uploadFilePath = request.getSession().getServletContext()
                .getRealPath("/statics/upload/");

        boolean uploaded = false;
        String uploadFileName = ""; //上传的文件名
        String fieldName = ""; //表单字段元素的name属性值
        /*String description = "";*/
        String foodName = "";
        Double foodPrice = 0.0;
        String foodType = "";
        String foodImg = "";
        Integer foodMax = 0;


        //通过Arrays类的asList()方法创建固定长度的集合
        List<String> fileType = Arrays.asList("gif", "bmp", "jpg","png");

        //请求信息中的内容是否是multipart类型
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (isMultipart) {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            try {
                //解析form表单中所有文件
                List<FileItem> items = upload.parseRequest(request);
                Iterator<FileItem> iter = items.iterator();
                while (iter.hasNext()) { //依次处理每个文件
                    FileItem item = (FileItem) iter.next();
                    if (item.isFormField()) { //普通表单字段
                        fieldName = item.getFieldName(); //表单字段的description属性值
                        if (fieldName.equals("description")) {
                            /*description = item.getString("UTF-8");*/
                            //输出表单字段的值

                        } else if (fieldName.equals("foodName")) {
                            foodName = item.getString("UTF-8");
                        } else if (fieldName.equals("foodPrice")) {
                            foodPrice = Double.parseDouble(item.getString("UTF-8"));
                        } else if (fieldName.equals("foodType")) {
                            foodType = item.getString("UTF-8");
                        } else if (fieldName.equals("foodMax")) {
                            foodMax = Integer.parseInt(item.getString("UTF-8"));
                        }
                    } else { //文件表单字段

                        String fileName = item.getName();
                        if (fileName != null && !fileName.equals("")) {
                            String ext = fileName.substring(fileName
                                    .lastIndexOf(".") + 1);
                            if (!fileType.contains(ext)) { //判断文件类型是否在允许范围内

                            } else {
                                File fullFile = new File(item.getName());
                                File saveFile = new File(uploadFilePath,
                                        fullFile.getName());
                                item.write(saveFile);
                                uploaded = true;
                                uploadFileName = fullFile.getName();

                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        if (uploaded == true) {
            foodImg = "/upload/" + uploadFileName;
        }

        Food food = new Food(foodName,foodPrice,foodType,foodImg,foodMax);
        foodService.insert(food);
        return "manger/management1";
    }


    /*@RequestMapping(value = "/selFood", method = RequestMethod.GET)
    public String selFood(Model model, @RequestParam(required = false, defaultValue = "1") int pageIndex) {
        PageHelper.startPage(1, 5);
        List<Food> foodList = foodService.select();
        model.addAttribute("foodList", new PageInfo<Food>(foodList));
        return "manger/management1";
    }*/

    @ResponseBody
    @RequestMapping(value = "/delFood", method = RequestMethod.GET)
    public Map delFood(int foodid) {
        Map<String, String> map = new HashMap<>();
        String result = foodService.delete(foodid);
        map.put("result", result);
        System.out.println(result);
        return map;
    }


    @RequestMapping(value = "/updateFood",method = RequestMethod.POST)
    public String updateUser(Model model,HttpServletRequest request){

            //上传文件的存储路径（服务器文件系统上的绝对文件路径）
            String uploadFilePath = request.getSession().getServletContext()
                    .getRealPath("/statics/upload/");

            boolean uploaded = false;
            String uploadFileName = ""; //上传的文件名
            String fieldName = ""; //表单字段元素的name属性值
            /*String description = "";*/
            Integer foodId=0;
            String foodName = "";
            Double foodPrice = 0.0;
            String foodType = "";
            String foodImg = "";
            String foodImg1 = "";
            Integer foodMax = 0;


            //通过Arrays类的asList()方法创建固定长度的集合
            List<String> fileType = Arrays.asList("gif", "bmp", "jpg","png");

            //请求信息中的内容是否是multipart类型
            boolean isMultipart = ServletFileUpload.isMultipartContent(request);
            if (isMultipart) {
                FileItemFactory factory = new DiskFileItemFactory();
                ServletFileUpload upload = new ServletFileUpload(factory);
                try {
                    //解析form表单中所有文件
                    List<FileItem> items = upload.parseRequest(request);
                    Iterator<FileItem> iter = items.iterator();
                    while (iter.hasNext()) { //依次处理每个文件
                        FileItem item = (FileItem) iter.next();
                        if (item.isFormField()) { //普通表单字段
                            fieldName = item.getFieldName(); //表单字段的description属性值
                            if (fieldName.equals("foodId")) {
                                foodId = Integer.parseInt(item.getString("UTF-8"));
                            } else if (fieldName.equals("foodName")) {
                                foodName = item.getString("UTF-8");
                            } else if (fieldName.equals("foodPrice")) {
                                foodPrice = Double.parseDouble(item.getString("UTF-8"));
                            } else if (fieldName.equals("foodType")) {
                                foodType = item.getString("UTF-8");

                            } else if (fieldName.equals("foodMax")) {
                                foodMax = Integer.parseInt(item.getString("UTF-8"));
                            }
                        } else { //文件表单字段

                            String fileName = item.getName();
                            if (fileName != null && !fileName.equals("")) {
                                String ext = fileName.substring(fileName
                                        .lastIndexOf(".") + 1);
                                if (!fileType.contains(ext)) { //判断文件类型是否在允许范围内

                                } else {
                                    File fullFile = new File(item.getName());
                                    File saveFile = new File(uploadFilePath,
                                            fullFile.getName());
                                    item.write(saveFile);
                                    uploaded = true;
                                    uploadFileName = fullFile.getName();
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (uploaded == true) {
                foodImg = "/upload/" + uploadFileName;
            }
            Food food = foodService.selectById(foodId);
            if(food != null){
                Food food1 = new Food(foodId,foodName,foodPrice,foodType,foodImg,foodMax);
                int i = foodService.updateFoodById(food1);
                model.addAttribute("mess","更新成功");
            }else{
                model.addAttribute("mess","id存在");
            }


        return "manger/management1";
    }

    @RequestMapping(value = "/selFoodCount",method = RequestMethod.GET)
    public String selFoodCount(Model model, @RequestParam(required = false, defaultValue = "1") int pageIndex){
        PageHelper.startPage(pageIndex, 5);
        List<Food> foodList = foodService.selectCount();
        model.addAttribute("page", new PageInfo<Food>(foodList));
        return "manger/management2";
    }

    @RequestMapping(value="/selAllFood",method=RequestMethod.GET)
    public String selAllFood(String foodname,Model model, @RequestParam(required = false, defaultValue = "1") int pageIndex){

        PageHelper.startPage(pageIndex, 5);
        List<Food> foodList = foodService.selectFood(foodname);
        model.addAttribute("foodname",foodname);
        model.addAttribute("page", new PageInfo<Food>(foodList));
        return "manger/management1";
    }

}

