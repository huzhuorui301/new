/**
 * 交易系统
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
public class TradingSystem implements ValueObject<TradingSystem> {
    /**
     * 交易系统标识码
     */
    private final String tradingSystemCode;
    
    /**
     * 交易系统名称
     */
    private final String tradingSystemName;

    /**
     * 构造函数
     *
     * @param tradingSystemCode 交易系统标识码
     * @param tradingSystemName 交易系统名称
     */
    public TradingSystem(String tradingSystemCode, String tradingSystemName) {
        if (ZzKits.isEmpty(tradingSystemCode)) {
            throw new ServiceException("交易系统标识码不能为空");
        }
        if (ZzKits.isEmpty(tradingSystemName)) {
            throw new ServiceException("交易系统名称不能为空");
        }
        this.tradingSystemCode = tradingSystemCode;
        this.tradingSystemName = tradingSystemName;
    }

    /**
     * 比较两个值是否相等
     *
     * @param other 另一个对象
     * @return 结果
     */
    @Override
    public boolean sameValueAs(TradingSystem other) {
        return this.getTradingSystemCode().equals(other.getTradingSystemCode()) &&
               this.getTradingSystemName().equals(other.getTradingSystemName());
    }
} 