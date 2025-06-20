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

import com.zz.bianalysisprd.cashareusagebc.domain.cashareusagerecordaggr.CaShareUsageRecordManager;
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
     * 将聚合根实体转换为数据对象
     *
     * @param caShareUsageRecordManager 聚合根实体
     * @return {@link CaShareUsageRecordDO}
     */
    CaShareUsageRecordDO toCaShareUsageRecordDO(CaShareUsageRecordManager caShareUsageRecordManager);

    /**
     * 将数据对象转换为聚合根实体
     *
     * @param caShareUsageRecordDO 数据对象
     * @return {@link CaShareUsageRecordManager}
     */
    CaShareUsageRecordManager toCaShareUsageRecordManager(CaShareUsageRecordDO caShareUsageRecordDO);

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