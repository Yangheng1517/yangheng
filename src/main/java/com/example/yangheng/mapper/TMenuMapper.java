package com.example.yangheng.mapper;

import com.example.yangheng.model.db.TMenu;
import com.example.yangheng.model.db.TMenuExample;
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
public interface TMenuMapper {
    @SelectProvider(type=TMenuSqlProvider.class, method="countByExample")
    long countByExample(TMenuExample example);

    @DeleteProvider(type=TMenuSqlProvider.class, method="deleteByExample")
    int deleteByExample(TMenuExample example);

    @Delete({
        "delete from t_menu",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_menu (id, permission_id, ",
        "p_id, menu_name, remark)",
        "values (#{id,jdbcType=INTEGER}, #{permissionId,jdbcType=INTEGER}, ",
        "#{pId,jdbcType=INTEGER}, #{menuName,jdbcType=VARCHAR}, #{remark,jdbcType=VARCHAR})"
    })
    int insert(TMenu record);

    @InsertProvider(type=TMenuSqlProvider.class, method="insertSelective")
    int insertSelective(TMenu record);

    @SelectProvider(type=TMenuSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="permission_id", property="permissionId", jdbcType=JdbcType.INTEGER),
        @Result(column="p_id", property="pId", jdbcType=JdbcType.INTEGER),
        @Result(column="menu_name", property="menuName", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR)
    })
    List<TMenu> selectByExample(TMenuExample example);

    @Select({
        "select",
        "id, permission_id, p_id, menu_name, remark",
        "from t_menu",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="permission_id", property="permissionId", jdbcType=JdbcType.INTEGER),
        @Result(column="p_id", property="pId", jdbcType=JdbcType.INTEGER),
        @Result(column="menu_name", property="menuName", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR)
    })
    TMenu selectByPrimaryKey(Integer id);

    @UpdateProvider(type=TMenuSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TMenu record, @Param("example") TMenuExample example);

    @UpdateProvider(type=TMenuSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TMenu record, @Param("example") TMenuExample example);

    @UpdateProvider(type=TMenuSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TMenu record);

    @Update({
        "update t_menu",
        "set permission_id = #{permissionId,jdbcType=INTEGER},",
          "p_id = #{pId,jdbcType=INTEGER},",
          "menu_name = #{menuName,jdbcType=VARCHAR},",
          "remark = #{remark,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TMenu record);
}