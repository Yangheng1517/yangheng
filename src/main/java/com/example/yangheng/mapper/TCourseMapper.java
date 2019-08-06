package com.example.yangheng.mapper;

import com.example.yangheng.model.db.TCourse;
import com.example.yangheng.model.db.TCourseExample;
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
public interface TCourseMapper {
    @SelectProvider(type=TCourseSqlProvider.class, method="countByExample")
    long countByExample(TCourseExample example);

    @DeleteProvider(type=TCourseSqlProvider.class, method="deleteByExample")
    int deleteByExample(TCourseExample example);

    @Delete({
        "delete from t_course",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_course (id, name)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR})"
    })
    int insert(TCourse record);

    @InsertProvider(type=TCourseSqlProvider.class, method="insertSelective")
    int insertSelective(TCourse record);

    @SelectProvider(type=TCourseSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    List<TCourse> selectByExample(TCourseExample example);

    @Select({
        "select",
        "id, name",
        "from t_course",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    TCourse selectByPrimaryKey(Integer id);

    @UpdateProvider(type=TCourseSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TCourse record, @Param("example") TCourseExample example);

    @UpdateProvider(type=TCourseSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TCourse record, @Param("example") TCourseExample example);

    @UpdateProvider(type=TCourseSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TCourse record);

    @Update({
        "update t_course",
        "set name = #{name,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TCourse record);
}