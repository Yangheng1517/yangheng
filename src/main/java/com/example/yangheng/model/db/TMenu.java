package com.example.yangheng.model.db;

import lombok.Data;

@Data
public class TMenu {
    private Integer id;

    private Integer permissionId;

    private Integer pId;

    private String menuName;

    private String remark;
}