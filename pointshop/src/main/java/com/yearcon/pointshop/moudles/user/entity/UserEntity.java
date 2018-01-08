package com.yearcon.pointshop.moudles.user.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author itguang
 * @create 2018-01-06 14:41
 **/
@Entity
@Table(name = "users")
@Data
public class UserEntity {

    @Id
    @GeneratedValue
    @ApiModelProperty(hidden = true)
    private long id;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(hidden = true)
    private Boolean enabled;

    @ApiModelProperty(hidden = true)
    private String email;

}
