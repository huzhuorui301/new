/**
 * CA共享使用记录仓储资源库：聚合存储、聚合还原
 *
 * @author HZR 414117117@qq.com
 * ================================<p>
 * Date: 2024/11/6<p>
 * Time: 14:30<p>
 * ================================
 */
package com.zz.bianalysisprd.cashareusagebc.domain.cashareusagerecordaggr.port;

import com.zz.bianalysisprd.cashareusagebc.domain.cashareusagerecordaggr.CaShareUsageRecordAggregateRootEntity;

public interface CaShareUsageRecordCommandRepository {

    /**
     * 存储聚合根
     *
     * @param caShareUsageRecordAggregateRootEntity 聚合根
     */
    void store(CaShareUsageRecordAggregateRootEntity caShareUsageRecordAggregateRootEntity);
} 