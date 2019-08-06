package com.example.yangheng.mapper;

import com.example.yangheng.model.db.UserRelationRef;
import com.example.yangheng.model.db.UserRelationRefExample.Criteria;
import com.example.yangheng.model.db.UserRelationRefExample.Criterion;
import com.example.yangheng.model.db.UserRelationRefExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class UserRelationRefSqlProvider {

    public String countByExample(UserRelationRefExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("user_relation_ref");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(UserRelationRefExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("user_relation_ref");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(UserRelationRef record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("user_relation_ref");
        
        if (record.getSourceUserId() != null) {
            sql.VALUES("source_user_id", "#{sourceUserId,jdbcType=INTEGER}");
        }
        
        if (record.getTargetUserId() != null) {
            sql.VALUES("target_user_id", "#{targetUserId,jdbcType=INTEGER}");
        }
        
        if (record.getRelationType() != null) {
            sql.VALUES("relation_type", "#{relationType,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(UserRelationRefExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("source_user_id");
        } else {
            sql.SELECT("source_user_id");
        }
        sql.SELECT("target_user_id");
        sql.SELECT("relation_type");
        sql.FROM("user_relation_ref");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        UserRelationRef record = (UserRelationRef) parameter.get("record");
        UserRelationRefExample example = (UserRelationRefExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("user_relation_ref");
        
        if (record.getSourceUserId() != null) {
            sql.SET("source_user_id = #{record.sourceUserId,jdbcType=INTEGER}");
        }
        
        if (record.getTargetUserId() != null) {
            sql.SET("target_user_id = #{record.targetUserId,jdbcType=INTEGER}");
        }
        
        if (record.getRelationType() != null) {
            sql.SET("relation_type = #{record.relationType,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("user_relation_ref");
        
        sql.SET("source_user_id = #{record.sourceUserId,jdbcType=INTEGER}");
        sql.SET("target_user_id = #{record.targetUserId,jdbcType=INTEGER}");
        sql.SET("relation_type = #{record.relationType,jdbcType=VARCHAR}");
        
        UserRelationRefExample example = (UserRelationRefExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(UserRelationRef record) {
        SQL sql = new SQL();
        sql.UPDATE("user_relation_ref");
        
        if (record.getRelationType() != null) {
            sql.SET("relation_type = #{relationType,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("source_user_id = #{sourceUserId,jdbcType=INTEGER}");
        sql.WHERE("target_user_id = #{targetUserId,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, UserRelationRefExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}