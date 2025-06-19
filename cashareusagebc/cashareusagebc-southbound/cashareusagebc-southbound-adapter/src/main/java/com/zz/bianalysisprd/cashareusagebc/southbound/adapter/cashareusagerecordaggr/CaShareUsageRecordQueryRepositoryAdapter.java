/**
 * CA共享使用记录查询仓储适配器
 *
 * @author HZR 414117117@qq.com
 * ================================<p>
 * Date: 2024/11/6<p>
 * Time: 16:00<p>
 * ================================
 */
package com.zz.bianalysisprd.cashareusagebc.southbound.adapter.cashareusagerecordaggr;

import com.zz.bianalysisprd.cashareusagebc.domain.cashareusagerecordaggr.port.CaShareUsageRecordQueryRepository;
import com.zz.bianalysisprd.cashareusagebc.northbound.local.cashareuseagebiz.CaShareUsageQueryRepository;
import com.zz.bianalysisprd.cashareusagebc.northbound.local.cashareuseagebiz.pl.CountScanUsageRecordRequest;
import com.zz.bianalysisprd.cashareusagebc.northbound.local.cashareuseagebiz.pl.CountScanUsageRecordView;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Slf4j
@Repository
@AllArgsConstructor
public class CaShareUsageRecordQueryRepositoryAdapter implements CaShareUsageRecordQueryRepository, CaShareUsageQueryRepository {
    
    /**
     * CA共享使用记录Mapper
     */
    private final CaShareUsageRecordMapper caShareUsageRecordMapper;

    /**
     * 按使用场景统计CA共享使用记录数量
     *
     * @return 使用场景统计结果 key: 使用场景描述, value: 数量
     */
    @Override
    public Map<String, Long> countByUsageScene() {
        log.info("开始查询CA共享使用记录按使用场景统计");
        
        // 调用Mapper查询统计结果
        Map<String, Long> statisticsResult = caShareUsageRecordMapper.countByUsageScene();
        
        log.info("CA共享使用记录按使用场景统计查询完成，结果数量：{}", statisticsResult.size());
        return statisticsResult;
    }

    /**
     * 统计CA互认扫码使用记录
     *
     * @param countScanUsageRecordRequest 统计请求参数
     * @return 统计结果
     */
    @Override
    public CountScanUsageRecordView countScanUsageRecord(CountScanUsageRecordRequest countScanUsageRecordRequest) {
        log.info("开始统计CA互认扫码使用记录，使用场景：{}，时间范围：{} - {}", 
                countScanUsageRecordRequest.getUsageScene(),
                countScanUsageRecordRequest.getStartUsageTime(),
                countScanUsageRecordRequest.getEndUsageTime());
        
        // 调用Mapper查询统计结果
        Long count = caShareUsageRecordMapper.countByUsageSceneAndTimeRange(
                countScanUsageRecordRequest.getUsageScene(),
                countScanUsageRecordRequest.getStartUsageTime(),
                countScanUsageRecordRequest.getEndUsageTime());
        
        // 构建返回结果
        CountScanUsageRecordView result = new CountScanUsageRecordView();
        result.setSumCount(count != null ? count : 0L);
        
        log.info("CA互认扫码使用记录统计完成，总数量：{}", result.getSumCount());
        return result;
    }
} 