package com.example.yangheng.model.db;

import lombok.Data;

@Data
public class TPermission {
    private Integer id;

    private Boolean type;

    private String remark;

    private String name;
}