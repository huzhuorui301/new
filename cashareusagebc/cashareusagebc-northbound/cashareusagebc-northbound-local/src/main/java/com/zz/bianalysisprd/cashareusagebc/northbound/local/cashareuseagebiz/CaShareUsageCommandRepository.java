package com.zz.bianalysisprd.cashareusagebc.northbound.local.cashareuseagebiz;

import com.zz.bianalysisprd.cashareusagebc.northbound.local.cashareuseagebiz.pl.ReceiveScanUsageRecordRequest;

/**
 * CA互认扫码使用命令仓储接口
 *
 * 需要被南向网关对应的领域聚合的命令仓储适配器所实现
 *
 * @author HZR 414117117@qq.com
 * ================================<p>
 * Date: 2025/1/6<p>
 * Time: 12:15<p>
 * ================================
 */
public interface CaShareUsageCommandRepository {

    /**
     * 保存CA互认扫码使用记录
     *
     * @param receiveScanUsageRecordRequest 扫码使用记录请求
     */
    void saveScanUsageRecord(ReceiveScanUsageRecordRequest receiveScanUsageRecordRequest);
} 