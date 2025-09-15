/**
 * CA共享使用记录业务序列号
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
public class CaShareUsageRecordSN implements ValueObject<CaShareUsageRecordSN> {
    /**
     * CA共享使用记录业务序列号
     */
    private final String value;

    /**
     * 构造函数
     *
     * @param value CA共享使用记录业务序列号
     */
    public CaShareUsageRecordSN(String value) {
        if (ZzKits.isEmpty(value)) {
            throw new ServiceException("CA共享使用记录业务序列号不能为空");
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
    public boolean sameValueAs(CaShareUsageRecordSN other) {
        return this.getValue().equals(other.getValue());
    }
} 