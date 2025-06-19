package com.zz.bianalysisprd.cashareusagebc.northbound.local.cashareuseagebiz;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import com.zz.core.ddd.common.mapstruct.CommonMapping;
import com.zz.bianalysisprd.cashareusagebc.northbound.local.cashareuseagebiz.pl.ReceiveScanUsageRecordRequest;
import com.zz.bianalysisprd.cashareusagebc.domain.cashareusagerecordaggr.CaShareUsageRecordAggregateRootEntity;
import com.zz.bianalysisprd.cashareusagebc.domain.cashareusagerecordaggr.valueobject.*;

/**
 * CA互认扫码使用记录业务服务的参数装配器
 *
 * @author HZR 414117117@qq.com
 * ================================<p>
 * Date: 2025/1/6<p>
 * Time: 11:00<p>
 * ================================
 */
@Mapper(uses = {CommonMapping.class})
public interface CaShareUsageAssembler {

    CaShareUsageAssembler INSTANCE = Mappers.getMapper(CaShareUsageAssembler.class);

    /**
     * 请求参数转换为领域对象
     *
     * @param request 请求参数
     * @return 领域对象
     */
    @Mappings({
            @Mapping(target="tradingSystem", expression="java(new com.zz.bianalysisprd.cashareusagebc.domain.cashareusagerecordaggr.valueobject.TradingSystem(request.getTradingSystemCode(), request.getTradingSystemName()))"),
            @Mapping(target="usageCert", source="certSn"),
            @Mapping(target="subjectType", expression="java(new com.zz.bianalysisprd.cashareusagebc.domain.cashareusagerecordaggr.valueobject.SubjectType(request.getSubjectType()))"),
            @Mapping(target="usageScene", expression="java(new com.zz.bianalysisprd.cashareusagebc.domain.cashareusagerecordaggr.valueobject.UsageScene(request.getUsageScene()))"),
            @Mapping(target="componentsCode", expression="java(new com.zz.bianalysisprd.cashareusagebc.domain.cashareusagerecordaggr.valueobject.ComponentsCode(request.getComponentsCode()))")
    })
    CaShareUsageRecordAggregateRootEntity toAggregate(ReceiveScanUsageRecordRequest request);

    // 这里可以添加需要的转换方法
} 