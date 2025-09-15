/**
 * CA共享使用记录仓储实现：聚合存储、聚合还原
 *
 * @author HZR 414117117@qq.com
 * ================================<p>
 * Date: 2024/11/6<p>
 * Time: 14:30<p>
 * ================================
 */
package com.zz.bianalysisprd.cashareusagebc.southbound.adapter.cashareusagerecordaggr;

import com.zz.bianalysisprd.cashareusagebc.domain.cashareusagerecordaggr.CaShareUsageRecordId;
import com.zz.bianalysisprd.cashareusagebc.domain.cashareusagerecordaggr.CaShareUsageRecordManager;
import com.zz.bianalysisprd.cashareusagebc.domain.cashareusagerecordaggr.port.CaShareUsageRecordCommandRepository;
import com.zz.bianalysisprd.cashareusagebc.northbound.local.cashareuseagebiz.CaShareUsageCommandRepository;
import com.zz.bianalysisprd.cashareusagebc.northbound.local.cashareuseagebiz.pl.ReceiveScanUsageRecordRequest;
import com.zz.starter.serialno.template.SerialNoGeneratorTemplate;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import com.zz.bianalysisprd.cashareusagebc.southbound.adapter.cashareusagerecordaggr.db.CaShareUsageRecordMapper;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@Slf4j
@Component
@AllArgsConstructor
public class CaShareUsageRecordCommandRepositoryAdapter implements CaShareUsageRecordCommandRepository, CaShareUsageCommandRepository {
    @Resource
    private CaShareUsageRecordUtil caShareUsageRecordUtil;

    /**
     * 存储CA共享使用记录聚合
     *
     * @param caShareUsageRecordManager CA共享使用记录聚合
     */
    @Override
    public void store(CaShareUsageRecordManager caShareUsageRecordManager) {
        CaShareUsageRecordDO caShareUsageRecordDO = CaShareUsageRecordHelper.INSTANCE.toCaShareUsageRecordDO(caShareUsageRecordManager);
        switch (caShareUsageRecordManager.getChangingStatus()) {
            case NEW:
                caShareUsageRecordUtil.insert(caShareUsageRecordDO);
                caShareUsageRecordManager.toUnChang();
                break;
            case UPDATED:
                caShareUsageRecordUtil.updateById(caShareUsageRecordDO);
                caShareUsageRecordManager.toUnChang();
                break;
            case DELETED:
                caShareUsageRecordUtil.deleteById(caShareUsageRecordDO.getId());
                caShareUsageRecordManager.toUnChang();
                break;
            default:
                break;
        }
    }

    /**
     * 保存CA互认扫码使用记录
     *
     * @param receiveScanUsageRecordRequest 扫码使用记录请求
     */
    @Override
    public void saveScanUsageRecord(ReceiveScanUsageRecordRequest receiveScanUsageRecordRequest) {
        log.info("开始保存CA互认扫码使用记录，组件编码：{}，使用场景：{}", 
                receiveScanUsageRecordRequest.getComponentsCode(),
                receiveScanUsageRecordRequest.getUsageScene());
        
        // 构建数据库对象
        CaShareUsageRecordDO caShareUsageRecordDO = CaShareUsageRecordDO.builder()
                .caShareUsageRecordSN(SerialNoGeneratorTemplate.get().generateSerialNo())
                .componentsCode(receiveScanUsageRecordRequest.getComponentsCode())
                .usageScene(receiveScanUsageRecordRequest.getUsageScene())
                .subjectType(receiveScanUsageRecordRequest.getSubjectType())
                .tradingSystemCode(receiveScanUsageRecordRequest.getTradingSystemCode())
                .tradingSystemName(receiveScanUsageRecordRequest.getTradingSystemName())
                .certSn(receiveScanUsageRecordRequest.getCertSn())
                .certName(receiveScanUsageRecordRequest.getCertName())
                .certType(receiveScanUsageRecordRequest.getCertType())
                .publicKeyAlgorithm(receiveScanUsageRecordRequest.getPublicKeyAlgorithm())
                .build();
        
        // 设置创建时间
        caShareUsageRecordDO.setCreateTime(LocalDateTime.now());
        caShareUsageRecordDO.setUpdateTime(LocalDateTime.now());
        
        // 保存到数据库
        caShareUsageRecordUtil.insert(caShareUsageRecordDO);
        
        log.info("CA互认扫码使用记录保存成功，记录序列号：{}", caShareUsageRecordDO.getCaShareUsageRecordSN());
    }
} 