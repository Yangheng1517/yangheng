package com.example.yangheng.mapper;

import com.example.yangheng.model.UserRelationRef;
import com.example.yangheng.model.UserRelationRefExample;
import com.example.yangheng.model.UserRelationRefKey;
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
public interface UserRelationRefMapper {
    @SelectProvider(type=UserRelationRefSqlProvider.class, method="countByExample")
    long countByExample(UserRelationRefExample example);

    @DeleteProvider(type=UserRelationRefSqlProvider.class, method="deleteByExample")
    int deleteByExample(UserRelationRefExample example);

    @Delete({
        "delete from user_relation_ref",
        "where source_user_id = #{sourceUserId,jdbcType=INTEGER}",
          "and target_user_id = #{targetUserId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(UserRelationRefKey key);

    @Insert({
        "insert into user_relation_ref (source_user_id, target_user_id, ",
        "relation_type)",
        "values (#{sourceUserId,jdbcType=INTEGER}, #{targetUserId,jdbcType=INTEGER}, ",
        "#{relationType,jdbcType=VARCHAR})"
    })
    int insert(UserRelationRef record);

    @InsertProvider(type=UserRelationRefSqlProvider.class, method="insertSelective")
    int insertSelective(UserRelationRef record);

    @SelectProvider(type=UserRelationRefSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="source_user_id", property="sourceUserId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="target_user_id", property="targetUserId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="relation_type", property="relationType", jdbcType=JdbcType.VARCHAR)
    })
    List<UserRelationRef> selectByExample(UserRelationRefExample example);

    @Select({
        "select",
        "source_user_id, target_user_id, relation_type",
        "from user_relation_ref",
        "where source_user_id = #{sourceUserId,jdbcType=INTEGER}",
          "and target_user_id = #{targetUserId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="source_user_id", property="sourceUserId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="target_user_id", property="targetUserId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="relation_type", property="relationType", jdbcType=JdbcType.VARCHAR)
    })
    UserRelationRef selectByPrimaryKey(UserRelationRefKey key);

    @UpdateProvider(type=UserRelationRefSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") UserRelationRef record, @Param("example") UserRelationRefExample example);

    @UpdateProvider(type=UserRelationRefSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") UserRelationRef record, @Param("example") UserRelationRefExample example);

    @UpdateProvider(type=UserRelationRefSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserRelationRef record);

    @Update({
        "update user_relation_ref",
        "set relation_type = #{relationType,jdbcType=VARCHAR}",
        "where source_user_id = #{sourceUserId,jdbcType=INTEGER}",
          "and target_user_id = #{targetUserId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(UserRelationRef record);
}