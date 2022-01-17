package reflex.entity;

import java.math.BigDecimal;

public class Student {
    private Integer age;
    private String userName;
    private BigDecimal money;
    private Boolean weixin;


    public Student() {
    }

    public Student(Integer age, String userName, BigDecimal money, Boolean weixin) {
        this.age = age;
        this.userName = userName;
        this.money = money;
        this.weixin = weixin;
    }

    public Integer getAge() {

        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Boolean getGood() {
        return weixin;
    }

    public void setGood(Boolean good) {
        weixin = good;
    }
}
