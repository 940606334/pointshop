package com.yearcon.pointshop.moudles.test.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author itguang
 * @create 2018-01-05 15:10
 **/
@Entity
@Data
@Table(name = "users")
public class UserEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;

}
