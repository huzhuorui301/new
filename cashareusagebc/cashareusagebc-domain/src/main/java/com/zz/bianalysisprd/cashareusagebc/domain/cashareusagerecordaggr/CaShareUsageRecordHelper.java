/**
 * CA共享使用记录领域服务
 *
 * @author HZR 414117117@qq.com
 * ================================<p>
 * Date: 2024/11/6<p>
 * Time: 16:00<p>
 * ================================
 */
package com.zz.bianalysisprd.cashareusagebc.domain.cashareusagerecordaggr;

import com.zz.bianalysisprd.cashareusagebc.domain.cashareusagerecordaggr.domainservicevalidator.ReceiveUsageRecordValidator;
import com.zz.bianalysisprd.cashareusagebc.domain.cashareusagerecordaggr.port.CaShareUsageRecordCommandRepository;
import com.zz.bianalysisprd.cashareusagebc.domain.cashareusagerecordaggr.port.CaShareUsageRecordQueryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
@AllArgsConstructor
public class CaShareUsageRecordHelper {
    /**
     * CA共享使用记录命令仓储
     */
    private final CaShareUsageRecordCommandRepository caShareUsageRecordCommandRepository;

    /**
     * CA共享使用记录查询仓储
     */
    private final CaShareUsageRecordQueryRepository caShareUsageRecordQueryRepository;

    /**
     * 接收CA互认扫码使用记录
     *
     * @param caShareUsageRecordManager CA共享使用记录聚合根实体
     */
    public void receiveUsageRecord(CaShareUsageRecordManager caShareUsageRecordManager) {
        // 校验使用记录数据格式
        new ReceiveUsageRecordValidator().validate(caShareUsageRecordManager);

        // 登录场景处理
        try {
            boolean wasEnriched = caShareUsageRecordManager.enrichLoginComponentsCode();
            if (wasEnriched) {
                log.info("检测到登录场景，已执行特殊逻辑");
            }
        } catch (Exception e) {
            log.error("登录场景处理失败", e);
            throw e;
        }

        // 存储使用记录聚合
        caShareUsageRecordManager.toNew();
        this.caShareUsageRecordCommandRepository.store(caShareUsageRecordManager);

        log.info("成功接收CA互认扫码使用记录，记录SN：{}", caShareUsageRecordManager.getCaShareUsageRecordSN().getValue());
    }

    /**
     * 统计CA互认扫码使用记录
     *
     * @return 使用场景统计结果
     */
    public Map<String, Long> countUsageRecord() {
        log.info("开始统计CA互认扫码使用记录");
        
        // 查询tb_ca_share_usage_record表中所有数据，按照UsageScene分组统计
        Map<String, Long> usageSceneStatistics = this.caShareUsageRecordQueryRepository.countByUsageScene();
        
        log.info("CA互认扫码使用记录统计完成，统计结果：{}", usageSceneStatistics);
        return usageSceneStatistics;
    }
} 