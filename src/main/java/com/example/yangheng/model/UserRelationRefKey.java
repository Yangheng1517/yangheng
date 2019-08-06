package com.example.yangheng.model;

import lombok.Data;

@Data
public class UserRelationRefKey {
    private Integer sourceUserId;

    private Integer targetUserId;
}