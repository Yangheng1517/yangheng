package com.example.yangheng.mapper;

import com.example.yangheng.model.db.TUser;
import com.example.yangheng.model.db.TUserExample;
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
public interface TUserMapper {
    @SelectProvider(type=TUserSqlProvider.class, method="countByExample")
    long countByExample(TUserExample example);

    @DeleteProvider(type=TUserSqlProvider.class, method="deleteByExample")
    int deleteByExample(TUserExample example);

    @Delete({
        "delete from t_user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_user (id, name, ",
        "password, sex, tel)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{sex,jdbcType=BIT}, #{tel,jdbcType=VARCHAR})"
    })
    int insert(TUser record);

    @InsertProvider(type=TUserSqlProvider.class, method="insertSelective")
    int insertSelective(TUser record);

    @SelectProvider(type=TUserSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="sex", property="sex", jdbcType=JdbcType.BIT),
        @Result(column="tel", property="tel", jdbcType=JdbcType.VARCHAR)
    })
    List<TUser> selectByExample(TUserExample example);

    @Select({
        "select",
        "id, name, password, sex, tel",
        "from t_user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="sex", property="sex", jdbcType=JdbcType.BIT),
        @Result(column="tel", property="tel", jdbcType=JdbcType.VARCHAR)
    })
    TUser selectByPrimaryKey(Integer id);

    @UpdateProvider(type=TUserSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TUser record, @Param("example") TUserExample example);

    @UpdateProvider(type=TUserSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TUser record, @Param("example") TUserExample example);

    @UpdateProvider(type=TUserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TUser record);

    @Update({
        "update t_user",
        "set name = #{name,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "sex = #{sex,jdbcType=BIT},",
          "tel = #{tel,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TUser record);
}