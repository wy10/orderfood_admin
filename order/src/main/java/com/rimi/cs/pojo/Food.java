package com.rimi.cs.pojo;

public class Food {
    private Integer foodid;

    private String foodname;

    private Double foodprice;

    private String foodtype;

    private String foodimage;

    private Integer maxoutput;

    private Integer count;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }


    public Integer getFoodid() {
        return foodid;
    }

    public void setFoodid(Integer foodid) {
        this.foodid = foodid;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname == null ? null : foodname.trim();
    }

    public Double getFoodprice() {
        return foodprice;
    }

    public void setFoodprice(Double foodprice) {
        this.foodprice = foodprice;
    }

    public String getFoodtype() {
        return foodtype;
    }

    public void setFoodtype(String foodtype) {
        this.foodtype = foodtype == null ? null : foodtype.trim();
    }

    public String getFoodimage() {
        return foodimage;
    }

    public void setFoodimage(String foodimage) {
        this.foodimage = foodimage == null ? null : foodimage.trim();
    }

    public Integer getMaxoutput() {
        return maxoutput;
    }

    public void setMaxoutput(Integer maxoutput) {
        this.maxoutput = maxoutput;
    }

    public Food(){

    }

    public Food(String foodname, Double foodprice, String foodtype, String foodimage, Integer maxoutput) {
        this.foodname = foodname;
        this.foodprice = foodprice;
        this.foodtype = foodtype;
        this.foodimage = foodimage;
        this.maxoutput = maxoutput;
    }

    public Food(Integer foodid, String foodname, Double foodprice, String foodtype, String foodimage, Integer maxoutput) {
        this.foodid = foodid;
        this.foodname = foodname;
        this.foodprice = foodprice;
        this.foodtype = foodtype;
        this.foodimage = foodimage;
        this.maxoutput = maxoutput;
    }
}