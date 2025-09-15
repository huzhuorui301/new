/**
 * CA共享使用记录技术Id
 *
 * @author HZR 414117117@qq.com
 * ================================<p>
 * Date: 2024/11/6<p>
 * Time: 14:30<p>
 * ================================
 */
package com.zz.bianalysisprd.cashareusagebc.domain.cashareusagerecordaggr.valueobject;

import com.zz.core.ddd.base.ValueObject;
import com.zz.core.tool.utils.ZzKits;
import com.zz.starter.log.exception.ServiceException;
import lombok.Getter;

@Getter
public class CaShareUsageRecordId implements ValueObject<CaShareUsageRecordId> {
    /**
     * CA共享使用记录Id
     */
    private final Long value;

    /**
     * 构造函数
     *
     * @param value CA共享使用记录Id
     */
    public CaShareUsageRecordId(Long value) {
        if (ZzKits.isEmpty(value)) {
            throw new ServiceException("CA共享使用记录Id不能为空");
        }
        this.value = value;
    }

    /**
     * 比较两个值是否相等
     *
     * @param other 另一个对象
     * @return 结果
     */
    @Override
    public boolean sameValueAs(CaShareUsageRecordId other) {
        return this.getValue().equals(other.getValue());
    }
} 