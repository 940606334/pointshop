package com.yearcon.pointshop.moudles.user.entity;

import lombok.Data;

/**
 * @author itguang
 * @create 2018-01-11 15:32
 **/
@Data
public class SMSEntity {


    private String userid;
    private String pwd;
    private String mobile;
    private String content;

    public SMSEntity(String userid, String pwd, String mobile, String content) {
        this.userid = userid;
        this.pwd = pwd;
        this.mobile = mobile;
        this.content = content;
    }
}
