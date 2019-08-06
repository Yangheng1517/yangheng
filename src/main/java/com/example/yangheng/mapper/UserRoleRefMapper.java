package com.example.yangheng.mapper;

import com.example.yangheng.model.UserRoleRefExample;
import com.example.yangheng.model.UserRoleRefKey;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface UserRoleRefMapper {
    @SelectProvider(type=UserRoleRefSqlProvider.class, method="countByExample")
    long countByExample(UserRoleRefExample example);

    @DeleteProvider(type=UserRoleRefSqlProvider.class, method="deleteByExample")
    int deleteByExample(UserRoleRefExample example);

    @Delete({
        "delete from user_role_ref",
        "where user_id = #{userId,jdbcType=INTEGER}",
          "and role_id = #{roleId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(UserRoleRefKey key);

    @Insert({
        "insert into user_role_ref (user_id, role_id)",
        "values (#{userId,jdbcType=INTEGER}, #{roleId,jdbcType=INTEGER})"
    })
    int insert(UserRoleRefKey record);

    @InsertProvider(type=UserRoleRefSqlProvider.class, method="insertSelective")
    int insertSelective(UserRoleRefKey record);

    @SelectProvider(type=UserRoleRefSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.INTEGER, id=true)
    })
    List<UserRoleRefKey> selectByExample(UserRoleRefExample example);

    @UpdateProvider(type=UserRoleRefSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") UserRoleRefKey record, @Param("example") UserRoleRefExample example);

    @UpdateProvider(type=UserRoleRefSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") UserRoleRefKey record, @Param("example") UserRoleRefExample example);
}