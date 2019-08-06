package com.example.yangheng.model.db;

import lombok.Data;

@Data
public class TUser {
    private Integer id;

    private String name;

    private String password;

    private byte[] sex;

    private String tel;
}