/**
 * CA共享使用记录聚合根
 *
 * @author HZR 414117117@qq.com
 * ================================<p>
 * Date: 2024/11/6<p>
 * Time: 14:30<p>
 * ================================
 */
package com.zz.bianalysisprd.cashareusagebc.domain.cashareusagerecordaggr;

import com.zz.bianalysisprd.cashareusagebc.domain.cashareusagerecordaggr.valueobject.*;
import com.zz.core.ddd.base.BaseEntity;
import com.zz.starter.serialno.template.SerialNoGeneratorTemplate;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.AccessLevel;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@Setter(AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = true)
public class CaShareUsageRecordAggregateRootEntity extends BaseEntity<CaShareUsageRecordId> {
    /**
     * CA共享使用记录业务序列号
     */
    private CaShareUsageRecordSN caShareUsageRecordSN;
    
    /**
     * 主体类型
     */
    private SubjectType subjectType;
    
    /**
     * 组件编码
     */
    private ComponentsCode componentsCode;
    
    /**
     * 使用场景
     */
    private UsageScene usageScene;
    
    /**
     * 交易系统
     */
    private TradingSystem tradingSystem;
    
    /**
     * 使用证书
     */
    private String usageCert;

    /**
     * 包内可见，仅供Converter/Assembler使用
     */
    void setUsageCert(String usageCert) {
        this.usageCert = usageCert;
    }

    /**
     * 如果是登录场景，则丰富组件编码
     * @return 如果是登录场景，则返回true，否则返回false
     */
    public boolean enrichLoginComponentsCode() {
        if (UsageScene.Scene.LOGIN.equals(this.usageScene.getValue())) {
            this.componentsCode = new ComponentsCode("LOGIN_COMPONENT_" + this.componentsCode.getValue());
            return true;
        }
        return false;
    }

    /**
     * 构建新记录
     */
    @Override
    public void toNew() {
        super.toNew();
        // 生成业务序列号
        this.caShareUsageRecordSN = new CaShareUsageRecordSN(SerialNoGeneratorTemplate.get().generateSerialNo());
    }
} 