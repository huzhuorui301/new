package com.zz.bianalysisprd.cashareusagebc.northbound.local.cashareuseagebiz;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import com.zz.bianalysisprd.cashareusagebc.northbound.local.cashareuseagebiz.pl.CountScanUsageRecordRequest;
import com.zz.bianalysisprd.cashareusagebc.northbound.local.cashareuseagebiz.pl.CountScanUsageRecordView;
import lombok.extern.slf4j.Slf4j;

/**
 * CA互认扫码使用记录业务服务（查询职责）
 *
 * @author HZR 414117117@qq.com
 * ================================<p>
 * Date: 2025/1/6<p>
 * Time: 11:10<p>
 * ================================
 */
@Component
@AllArgsConstructor
@Slf4j
public class CaShareUsageQueryUseCaseAppService {

    /**
     * CA互认扫码使用查询仓储
     */
    private final CaShareUsageQueryRepository caShareUsageQueryRepository;

    /**
     * 统计CA互认扫码使用记录
     *
     * @param countScanUsageRecordRequest 统计请求参数
     * @return 统计结果视图
     */
    public CountScanUsageRecordView countScanUsageRecord(CountScanUsageRecordRequest countScanUsageRecordRequest) {
        // 1、参数校验
        // TODO: 校验使用场景、时间范围等参数
        log.info("countScanUsageRecord request: {}", countScanUsageRecordRequest);

        // 2、调用查询仓储统计扫码使用记录
        return caShareUsageQueryRepository.countScanUsageRecord(countScanUsageRecordRequest);
    }
} 