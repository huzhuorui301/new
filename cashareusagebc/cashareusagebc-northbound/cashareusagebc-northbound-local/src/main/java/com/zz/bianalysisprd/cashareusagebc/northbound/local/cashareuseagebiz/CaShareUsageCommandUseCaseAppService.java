package com.zz.bianalysisprd.cashareusagebc.northbound.local.cashareuseagebiz;

import com.zz.bianalysisprd.cashareusagebc.domain.cashareusagerecordaggr.CaShareUsageRecordHelper;
import com.zz.bianalysisprd.cashareusagebc.domain.cashareusagerecordaggr.CaShareUsageRecordManager;
import com.zz.bianalysisprd.cashareusagebc.northbound.local.cashareuseagebiz.pl.ReceiveScanUsageRecordRequest;
import com.zz.bianalysisprd.cashareusagebc.northbound.local.cashareuseagebiz.pl.ReceiveScanUsageRecordResult;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

/**
 * CA互认扫码使用记录业务服务（操作、命令职责）
 *
 * @author HZR 414117117@qq.com
 * ================================<p>
 * Date: 2025/1/6<p>
 * Time: 11:05<p>
 * ================================
 */
@Service
@AllArgsConstructor
@Slf4j
public class CaShareUsageCommandUseCaseAppService {

    /**
     * CA共享使用记录领域服务
     */
    private final CaShareUsageRecordHelper caShareUsageRecordHelper;

    /**
     * 接收CA互认扫码使用记录
     *
     * @param receiveScanUsageRecordRequest 接收CA互认扫码使用记录请求
     * @return 接收CA互认扫码使用记录结果
     */
    public ReceiveScanUsageRecordResult receiveScanUsageRecord(ReceiveScanUsageRecordRequest receiveScanUsageRecordRequest) {
        log.info("receiveScanUsageRecord request: {}", receiveScanUsageRecordRequest);

        // 请求转换为聚合
        CaShareUsageRecordManager aggregate = CaShareUsageAssembler.INSTANCE.toAggregate(receiveScanUsageRecordRequest);

        // 调用领域服务
        this.caShareUsageRecordHelper.receiveUsageRecord(aggregate);

        // 拼接返回结果
        return ReceiveScanUsageRecordResult.builder()
                .caShareUsageRecordSN(aggregate.getCaShareUsageRecordSN().getValue())
                .build();
    }
} 