package com.zz.bianalysisprd.cashareusagebc.northbound.local.cashareuseagebiz;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.zz.bianalysisprd.cashareusagebc.northbound.local.cashareuseagebiz.pl.ReceiveScanUsageRecordRequest;
import com.zz.bianalysisprd.cashareusagebc.northbound.local.cashareuseagebiz.pl.ReceiveScanUsageRecordResult;

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
public class CaShareUsageCommandUseCaseAppService {

    /**
     * CA互认扫码使用命令仓储
     */
    private final CaShareUsageCommandRepository caShareUsageCommandRepository;

    /**
     * 接收CA互认扫码使用记录
     *
     * @param receiveScanUsageRecordRequest 接收扫码使用记录请求
     * @return 接收结果
     */
    public ReceiveScanUsageRecordResult receiveScanUsageRecord(ReceiveScanUsageRecordRequest receiveScanUsageRecordRequest) {
        // 1、校验请求参数
        // TODO: 参数校验逻辑

        // 2、调用命令仓储保存扫码使用记录
        caShareUsageCommandRepository.saveScanUsageRecord(receiveScanUsageRecordRequest);

        // 3、构建返回结果
        ReceiveScanUsageRecordResult result = new ReceiveScanUsageRecordResult();
        result.setStatus("SUCCESS");
        result.setMsg("接收成功");
        
        return result;
    }
} 