package com.example.yangheng.mapper;

import com.example.yangheng.model.db.TPermission;
import com.example.yangheng.model.db.TPermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface TPermissionMapper {
    @SelectProvider(type=TPermissionSqlProvider.class, method="countByExample")
    long countByExample(TPermissionExample example);

    @DeleteProvider(type=TPermissionSqlProvider.class, method="deleteByExample")
    int deleteByExample(TPermissionExample example);

    @Delete({
        "delete from t_permission",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_permission (id, type, remark, ",
        "name)",
        "values (#{id,jdbcType=INTEGER}, #{type,jdbcType=BIT}, #{remark,jdbcType=VARCHAR}, ",
        "#{name,jdbcType=VARCHAR})"
    })
    int insert(TPermission record);

    @InsertProvider(type=TPermissionSqlProvider.class, method="insertSelective")
    int insertSelective(TPermission record);

    @SelectProvider(type=TPermissionSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="type", property="type", jdbcType=JdbcType.BIT),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    List<TPermission> selectByExample(TPermissionExample example);

    @Select({
        "select",
        "id, type, remark, name",
        "from t_permission",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="type", property="type", jdbcType=JdbcType.BIT),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    TPermission selectByPrimaryKey(Integer id);

    @UpdateProvider(type=TPermissionSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TPermission record, @Param("example") TPermissionExample example);

    @UpdateProvider(type=TPermissionSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TPermission record, @Param("example") TPermissionExample example);

    @UpdateProvider(type=TPermissionSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TPermission record);

    @Update({
        "update t_permission",
        "set type = #{type,jdbcType=BIT},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TPermission record);
}