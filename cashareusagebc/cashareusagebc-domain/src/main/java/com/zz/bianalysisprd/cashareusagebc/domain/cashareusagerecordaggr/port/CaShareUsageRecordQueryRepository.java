/**
 * CA共享使用记录查询仓储接口
 *
 * @author HZR 414117117@qq.com
 * ================================<p>
 * Date: 2024/11/6<p>
 * Time: 16:00<p>
 * ================================
 */
package com.zz.bianalysisprd.cashareusagebc.domain.cashareusagerecordaggr.port;

import java.util.Map;

public interface CaShareUsageRecordQueryRepository {

    /**
     * 按使用场景统计CA共享使用记录数量
     *
     * @return 使用场景统计结果 key: 使用场景描述, value: 数量
     */
    Map<String, Long> countByUsageScene();
} 