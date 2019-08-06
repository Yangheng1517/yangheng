package com.example.yangheng.model.db;

import lombok.Data;

@Data
public class TOrder {
    private Integer id;

    private String remark;

    private Integer userId;

    private Integer amount;
}