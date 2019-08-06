package com.example.yangheng.mapper;

import com.example.yangheng.model.RolePermissionRfeExample;
import com.example.yangheng.model.RolePermissionRfeKey;
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
public interface RolePermissionRfeMapper {
    @SelectProvider(type=RolePermissionRfeSqlProvider.class, method="countByExample")
    long countByExample(RolePermissionRfeExample example);

    @DeleteProvider(type=RolePermissionRfeSqlProvider.class, method="deleteByExample")
    int deleteByExample(RolePermissionRfeExample example);

    @Delete({
        "delete from role_permission_ref",
        "where role_id = #{roleId,jdbcType=INTEGER}",
          "and permission_id = #{permissionId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(RolePermissionRfeKey key);

    @Insert({
        "insert into role_permission_ref (role_id, permission_id)",
        "values (#{roleId,jdbcType=INTEGER}, #{permissionId,jdbcType=INTEGER})"
    })
    int insert(RolePermissionRfeKey record);

    @InsertProvider(type=RolePermissionRfeSqlProvider.class, method="insertSelective")
    int insertSelective(RolePermissionRfeKey record);

    @SelectProvider(type=RolePermissionRfeSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="permission_id", property="permissionId", jdbcType=JdbcType.INTEGER, id=true)
    })
    List<RolePermissionRfeKey> selectByExample(RolePermissionRfeExample example);

    @UpdateProvider(type=RolePermissionRfeSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") RolePermissionRfeKey record, @Param("example") RolePermissionRfeExample example);

    @UpdateProvider(type=RolePermissionRfeSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") RolePermissionRfeKey record, @Param("example") RolePermissionRfeExample example);
}