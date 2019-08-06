package com.example.yangheng.mapper;

import com.example.yangheng.model.TOrder;
import com.example.yangheng.model.TOrderExample;
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
public interface TOrderMapper {
    @SelectProvider(type=TOrderSqlProvider.class, method="countByExample")
    long countByExample(TOrderExample example);

    @DeleteProvider(type=TOrderSqlProvider.class, method="deleteByExample")
    int deleteByExample(TOrderExample example);

    @Delete({
        "delete from t_order",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_order (id, remark, ",
        "user_id, amount)",
        "values (#{id,jdbcType=INTEGER}, #{remark,jdbcType=VARCHAR}, ",
        "#{userId,jdbcType=INTEGER}, #{amount,jdbcType=INTEGER})"
    })
    int insert(TOrder record);

    @InsertProvider(type=TOrderSqlProvider.class, method="insertSelective")
    int insertSelective(TOrder record);

    @SelectProvider(type=TOrderSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="amount", property="amount", jdbcType=JdbcType.INTEGER)
    })
    List<TOrder> selectByExample(TOrderExample example);

    @Select({
        "select",
        "id, remark, user_id, amount",
        "from t_order",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="amount", property="amount", jdbcType=JdbcType.INTEGER)
    })
    TOrder selectByPrimaryKey(Integer id);

    @UpdateProvider(type=TOrderSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TOrder record, @Param("example") TOrderExample example);

    @UpdateProvider(type=TOrderSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TOrder record, @Param("example") TOrderExample example);

    @UpdateProvider(type=TOrderSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TOrder record);

    @Update({
        "update t_order",
        "set remark = #{remark,jdbcType=VARCHAR},",
          "user_id = #{userId,jdbcType=INTEGER},",
          "amount = #{amount,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TOrder record);
}