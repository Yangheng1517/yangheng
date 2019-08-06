package com.example.yangheng.mapper;

import com.example.yangheng.model.db.CourseClassRefExample;
import com.example.yangheng.model.db.CourseClassRefKey;
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
public interface CourseClassRefMapper {
    @SelectProvider(type=CourseClassRefSqlProvider.class, method="countByExample")
    long countByExample(CourseClassRefExample example);

    @DeleteProvider(type=CourseClassRefSqlProvider.class, method="deleteByExample")
    int deleteByExample(CourseClassRefExample example);

    @Delete({
        "delete from course_class_ref",
        "where course_id = #{courseId,jdbcType=INTEGER}",
          "and class_id = #{classId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(CourseClassRefKey key);

    @Insert({
        "insert into course_class_ref (course_id, class_id)",
        "values (#{courseId,jdbcType=INTEGER}, #{classId,jdbcType=INTEGER})"
    })
    int insert(CourseClassRefKey record);

    @InsertProvider(type=CourseClassRefSqlProvider.class, method="insertSelective")
    int insertSelective(CourseClassRefKey record);

    @SelectProvider(type=CourseClassRefSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="course_id", property="courseId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="class_id", property="classId", jdbcType=JdbcType.INTEGER, id=true)
    })
    List<CourseClassRefKey> selectByExample(CourseClassRefExample example);

    @UpdateProvider(type=CourseClassRefSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CourseClassRefKey record, @Param("example") CourseClassRefExample example);

    @UpdateProvider(type=CourseClassRefSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CourseClassRefKey record, @Param("example") CourseClassRefExample example);
}