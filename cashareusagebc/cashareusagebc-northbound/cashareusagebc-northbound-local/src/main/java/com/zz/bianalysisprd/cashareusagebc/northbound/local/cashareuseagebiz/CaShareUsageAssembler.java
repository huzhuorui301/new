package com.zz.bianalysisprd.cashareusagebc.northbound.local.cashareuseagebiz;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.zz.core.ddd.common.mapstruct.CommonMapping;

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

    // 这里可以添加需要的转换方法
} 