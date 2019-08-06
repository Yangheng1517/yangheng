package com.example.yangheng.mapper;

import com.example.yangheng.model.UserClassRefExample;
import com.example.yangheng.model.UserClassRefKey;
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
public interface UserClassRefMapper {
    @SelectProvider(type=UserClassRefSqlProvider.class, method="countByExample")
    long countByExample(UserClassRefExample example);

    @DeleteProvider(type=UserClassRefSqlProvider.class, method="deleteByExample")
    int deleteByExample(UserClassRefExample example);

    @Delete({
        "delete from user_class_ref",
        "where user_id = #{userId,jdbcType=INTEGER}",
          "and class_id = #{classId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(UserClassRefKey key);

    @Insert({
        "insert into user_class_ref (user_id, class_id)",
        "values (#{userId,jdbcType=INTEGER}, #{classId,jdbcType=INTEGER})"
    })
    int insert(UserClassRefKey record);

    @InsertProvider(type=UserClassRefSqlProvider.class, method="insertSelective")
    int insertSelective(UserClassRefKey record);

    @SelectProvider(type=UserClassRefSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="class_id", property="classId", jdbcType=JdbcType.INTEGER, id=true)
    })
    List<UserClassRefKey> selectByExample(UserClassRefExample example);

    @UpdateProvider(type=UserClassRefSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") UserClassRefKey record, @Param("example") UserClassRefExample example);

    @UpdateProvider(type=UserClassRefSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") UserClassRefKey record, @Param("example") UserClassRefExample example);
}