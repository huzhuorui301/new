package com.zz.bianalysisprd.cashareusagebc.northbound.local.cashareuseagebiz;

import com.zz.bianalysisprd.cashareusagebc.northbound.local.cashareuseagebiz.pl.CountScanUsageRecordRequest;
import com.zz.bianalysisprd.cashareusagebc.northbound.local.cashareuseagebiz.pl.CountScanUsageRecordView;

/**
 * CA互认扫码使用查询仓储接口
 *
 * 需要被南向网关对应的领域聚合的查询仓储适配器所实现
 *
 * @author HZR 414117117@qq.com
 * ================================<p>
 * Date: 2025/1/6<p>
 * Time: 10:50<p>
 * ================================
 */
public interface CaShareUsageQueryRepository {

    /**
     * 统计CA互认扫码使用记录
     *
     * @param countScanUsageRecordRequest 统计请求参数
     * @return 统计结果
     */
    CountScanUsageRecordView countScanUsageRecord(CountScanUsageRecordRequest countScanUsageRecordRequest);
} 