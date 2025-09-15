/**
 * CA共享使用记录Mapper接口
 *
 * @author HZR 414117117@qq.com
 * ================================<p>
 * Date: 2024/11/6<p>
 * Time: 14:30<p>
 * ================================
 */
package com.zz.bianalysisprd.cashareusagebc.southbound.adapter.cashareusagerecordaggr;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface CaShareUsageRecordUtil extends BaseMapper<CaShareUsageRecordDO> {
    
    /**
     * 按使用场景统计CA共享使用记录数量
     *
     * @return 使用场景统计结果
     */
    @Select("SELECT " +
            "CASE usage_scene " +
            "  WHEN 'LOGIN' THEN '注册登录' " +
            "  WHEN 'MESSAGE_SIGNATURE' THEN '消息签名' " +
            "  WHEN 'SIGNATURE' THEN '签章' " +
            "  WHEN 'REVOKE_SIGNATURE' THEN '撤章' " +
            "  WHEN 'ENCRYPT' THEN '加密' " +
            "  WHEN 'DECRYPT' THEN '解密' " +
            "  ELSE usage_scene " +
            "END as sceneName, " +
            "COUNT(*) as count " +
            "FROM tb_ca_share_usage_record " +
            "GROUP BY usage_scene")
    Map<String, Long> countByUsageScene();

    /**
     * 统计指定使用场景和时间范围内的记录数量
     *
     * @param usageScene 使用场景
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return 记录数量
     */
    @Select("SELECT COUNT(1) FROM tb_ca_share_usage_record " +
            "WHERE status = 1 " +
            "AND UPPER(usage_scene) = UPPER(#{usageScene}) " +
            "AND create_time >= #{startTime} " +
            "AND create_time <= #{endTime}")
    Long countByUsageSceneAndTimeRange(@Param("usageScene") String usageScene,
                                       @Param("startTime") String startTime,
                                       @Param("endTime") String endTime);
} 