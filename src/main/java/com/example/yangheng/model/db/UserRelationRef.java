package com.example.yangheng.model.db;

import lombok.Data;

@Data
public class UserRelationRef extends UserRelationRefKey {
    private String relationType;
}