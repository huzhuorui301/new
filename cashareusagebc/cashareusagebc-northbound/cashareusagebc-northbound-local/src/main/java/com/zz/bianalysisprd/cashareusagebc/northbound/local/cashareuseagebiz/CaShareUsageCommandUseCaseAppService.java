package com.zz.bianalysisprd.cashareusagebc.northbound.local.cashareuseagebiz;

import com.zz.bianalysisprd.cashareusagebc.domain.cashareusagerecordaggr.CaShareUsageRecordAggregateRootEntity;
import com.zz.bianalysisprd.cashareusagebc.domain.cashareusagerecordaggr.port.CaShareUsageRecordCommandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.zz.bianalysisprd.cashareusagebc.northbound.local.cashareuseagebiz.pl.ReceiveScanUsageRecordRequest;
import com.zz.bianalysisprd.cashareusagebc.northbound.local.cashareuseagebiz.pl.ReceiveScanUsageRecordResult;
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
     * CA互认扫码使用命令仓储 - 这是域内的仓储
     */
    private final CaShareUsageRecordCommandRepository caShareUsageRecordCommandRepository;


    /**
     * 接收CA互认扫码使用记录
     *
     * @param receiveScanUsageRecordRequest 接收扫码使用记录请求
     * @return 接收结果
     */
    public ReceiveScanUsageRecordResult receiveScanUsageRecord(ReceiveScanUsageRecordRequest receiveScanUsageRecordRequest) {
        log.info("receiveScanUsageRecord request: {}", receiveScanUsageRecordRequest);

        // 使用Assembler将RequestDTO转换为Aggregate
        CaShareUsageRecordAggregateRootEntity aggregate = CaShareUsageAssembler.INSTANCE.toAggregate(receiveScanUsageRecordRequest);

        // 坏味道：应用服务应该调用领域服务，而不是直接调用仓储
        // 这里绕过了领域服务中定义的校验器和其他业务逻辑
        aggregate.toNew(); // 调用聚合根方法设置初始状态
        caShareUsageRecordCommandRepository.store(aggregate);

        // 3、构建返回结果
        ReceiveScanUsageRecordResult result = new ReceiveScanUsageRecordResult();
        result.setStatus("SUCCESS");
        result.setMsg("接收成功");

        
        return result;
    }
} 