package com.howei.pojo;

import java.math.BigDecimal;

public class Assessment {

    private int id;
    private int employeeId;
    private String userName;
    private String name;
    private int jiaban;
    private int zhiban;
    private int kaoqin;
    private int score1;
    private int score2;
    //净绩效
    private double netPerformance;
    //综合绩效
    private double comprehensivePerformance;
    //基本工资
    private int basicwages;
    //绩效基数
    private double meritpay;
    //餐补
    private int mealSupplement;
    //通讯补助
    private int phoneAllowance;
    //应付工资
    private double wagePayable;
    private String department;
    private String laowupaiqian;
    private String manager;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getJiaban() {
        return jiaban;
    }

    public void setJiaban(int jiaban) {
        this.jiaban = jiaban;
    }

    public int getZhiban() {
        return zhiban;
    }

    public void setZhiban(int zhiban) {
        this.zhiban = zhiban;
    }

    public int getKaoqin() {
        return kaoqin;
    }

    public void setKaoqin(int kaoqin) {
        this.kaoqin = kaoqin;
    }

    public int getScore1() {
        return score1;
    }

    public void setScore1(int score1) {
        this.score1 = score1;
    }

    public int getScore2() {
        return score2;
    }

    public void setScore2(int score2) {
        this.score2 = score2;
    }

    public double getNetPerformance() {
        netPerformance = (score1 * 0.5 + score2 * 0.5) / 90;
        BigDecimal bd = new BigDecimal(netPerformance);
        return bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public void setNetPerformance(double netPerformance) {

        this.netPerformance = netPerformance;
    }

    public double getComprehensivePerformance() {
        comprehensivePerformance = netPerformance + jiaban * 0.01;
        BigDecimal bd = new BigDecimal(comprehensivePerformance);
        return bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public void setComprehensivePerformance(double comprehensivePerformance) {
        this.comprehensivePerformance = comprehensivePerformance;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getLaowupaiqian() {
        return laowupaiqian;
    }

    public void setLaowupaiqian(String laowupaiqian) {
        this.laowupaiqian = laowupaiqian;
    }

    public int getBasicwages() {
        return basicwages;
    }

    public void setBasicwages(int basicwages) {
        this.basicwages = basicwages;
    }

    public double getMeritpay() {
        BigDecimal bd1 = new BigDecimal(comprehensivePerformance);
        BigDecimal bd = new BigDecimal(meritpay * bd1.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        return bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public void setMeritpay(int meritpay) {
        this.meritpay = meritpay;
    }

    public int getMealSupplement() {
        mealSupplement = 20 * kaoqin + 10 * zhiban;
        return mealSupplement;
    }

    public void setMealSupplement(int mealSupplement) {
        this.mealSupplement = mealSupplement;
    }

    public int getPhoneAllowance() {
        return phoneAllowance;
    }

    public void setPhoneAllowance(int phoneAllowance) {
        this.phoneAllowance = phoneAllowance;
    }

    public double getWagePayable() {
        BigDecimal bd1 = new BigDecimal(comprehensivePerformance);
        double aa = bd1.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        wagePayable = basicwages + phoneAllowance + mealSupplement + meritpay * aa;
        BigDecimal bd = new BigDecimal(wagePayable);
        return bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public void setWagePayable(double wagePayable) {
        this.wagePayable = wagePayable;
    }


}
