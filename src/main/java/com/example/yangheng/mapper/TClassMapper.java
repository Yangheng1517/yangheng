package com.example.yangheng.mapper;

import com.example.yangheng.model.db.TClass;
import com.example.yangheng.model.db.TClassExample;
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
public interface TClassMapper {
    @SelectProvider(type=TClassSqlProvider.class, method="countByExample")
    long countByExample(TClassExample example);

    @DeleteProvider(type=TClassSqlProvider.class, method="deleteByExample")
    int deleteByExample(TClassExample example);

    @Delete({
        "delete from t_class",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_class (id, name)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR})"
    })
    int insert(TClass record);

    @InsertProvider(type=TClassSqlProvider.class, method="insertSelective")
    int insertSelective(TClass record);

    @SelectProvider(type=TClassSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    List<TClass> selectByExample(TClassExample example);

    @Select({
        "select",
        "id, name",
        "from t_class",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    TClass selectByPrimaryKey(Integer id);

    @UpdateProvider(type=TClassSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TClass record, @Param("example") TClassExample example);

    @UpdateProvider(type=TClassSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TClass record, @Param("example") TClassExample example);

    @UpdateProvider(type=TClassSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TClass record);

    @Update({
        "update t_class",
        "set name = #{name,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TClass record);
}