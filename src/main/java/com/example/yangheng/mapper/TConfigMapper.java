package com.example.yangheng.mapper;

import com.example.yangheng.model.TConfig;
import com.example.yangheng.model.TConfigExample;
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
public interface TConfigMapper {
    @SelectProvider(type=TConfigSqlProvider.class, method="countByExample")
    long countByExample(TConfigExample example);

    @DeleteProvider(type=TConfigSqlProvider.class, method="deleteByExample")
    int deleteByExample(TConfigExample example);

    @Delete({
        "delete from t_config",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_config (id, user_id)",
        "values (#{id,jdbcType=INTEGER}, #{userId,jdbcType=INTEGER})"
    })
    int insert(TConfig record);

    @InsertProvider(type=TConfigSqlProvider.class, method="insertSelective")
    int insertSelective(TConfig record);

    @SelectProvider(type=TConfigSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER)
    })
    List<TConfig> selectByExample(TConfigExample example);

    @Select({
        "select",
        "id, user_id",
        "from t_config",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER)
    })
    TConfig selectByPrimaryKey(Integer id);

    @UpdateProvider(type=TConfigSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TConfig record, @Param("example") TConfigExample example);

    @UpdateProvider(type=TConfigSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TConfig record, @Param("example") TConfigExample example);

    @UpdateProvider(type=TConfigSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TConfig record);

    @Update({
        "update t_config",
        "set user_id = #{userId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TConfig record);
}