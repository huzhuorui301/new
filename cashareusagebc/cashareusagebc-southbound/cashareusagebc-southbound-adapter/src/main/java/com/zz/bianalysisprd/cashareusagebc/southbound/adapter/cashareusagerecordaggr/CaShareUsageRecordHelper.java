/**
 * CA共享使用记录数据转换器
 *
 * @author HZR 414117117@qq.com
 * ================================<p>
 * Date: 2024/11/6<p>
 * Time: 14:30<p>
 * ================================
 */
package com.zz.bianalysisprd.cashareusagebc.southbound.adapter.cashareusagerecordaggr;

import com.zz.bianalysisprd.cashareusagebc.domain.cashareusagerecordaggr.CaShareUsageRecordAggregateRootEntity;
import com.zz.bianalysisprd.cashareusagebc.domain.cashareusagerecordaggr.CaShareUsageRecordMapping;
import com.zz.bianalysisprd.cashareusagebc.domain.cashareusagerecordaggr.valueobject.*;
import com.zz.core.ddd.common.mapstruct.CommonMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

/**
 * @author zhenghui
 * @date 2024/05/15 11:32
 */
@Mapper(uses = {CaShareUsageRecordMapping.class, CommonMapping.class})
public interface CaShareUsageRecordHelper {
    CaShareUsageRecordHelper INSTANCE = Mappers.getMapper(CaShareUsageRecordHelper.class);

    /**
     * 聚合根领域对象 转 数据库对象
     *
     * @param caShareUsageRecordAggregateRootEntity 聚合根实体
     * @return 数据库对象
     */
    @Mappings({
            @Mapping(target = "tradingSystemCode", source = "tradingSystem.tradingSystemCode"),
            @Mapping(target = "tradingSystemName", source = "tradingSystem.tradingSystemName"),
            @Mapping(target = "certSn", source = "usageCert")
    })
    CaShareUsageRecordDO toCaShareUsageRecordDO(CaShareUsageRecordAggregateRootEntity caShareUsageRecordAggregateRootEntity);

    /**
     * 数据库对象 转 聚合根领域对象
     *
     * @param caShareUsageRecordDO 数据库对象
     * @return 聚合根实体
     */
    @Mappings({
            @Mapping(target = "tradingSystem", source = "caShareUsageRecordDO", qualifiedByName = "toTradingSystem"),
            @Mapping(target = "usageCert", source = "certSn")
    })
    CaShareUsageRecordAggregateRootEntity toCaShareUsageRecordAggregateRootEntity(CaShareUsageRecordDO caShareUsageRecordDO);

    /**
     * 数据库对象转交易系统值对象
     *
     * @param caShareUsageRecordDO 数据库对象
     * @return 交易系统值对象
     */
    @Named("toTradingSystem")
    default TradingSystem toTradingSystem(CaShareUsageRecordDO caShareUsageRecordDO) {
        return new TradingSystem(caShareUsageRecordDO.getTradingSystemCode(), caShareUsageRecordDO.getTradingSystemName());
    }

} 