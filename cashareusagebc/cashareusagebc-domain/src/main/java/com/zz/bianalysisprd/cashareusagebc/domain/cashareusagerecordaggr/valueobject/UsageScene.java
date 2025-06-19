/**
 * 使用场景
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
public class UsageScene implements ValueObject<UsageScene> {
    
    /**
     * 使用场景枚举
     */
    public enum Scene {
        LOGIN("注册登录"),
        MESSAGE_SIGNATURE("消息签名"),
        SIGNATURE("签章"),
        REVOKE_SIGNATURE("撤章"),
        ENCRYPT("加密"),
        DECRYPT("解密");
        
        private final String description;
        
        Scene(String description) {
            this.description = description;
        }
        
        public String getDescription() {
            return description;
        }
    }
    
    /**
     * 使用场景值
     */
    private final Scene value;

    /**
     * 构造函数
     *
     * @param value 使用场景
     */
    public UsageScene(Scene value) {
        if (ZzKits.isEmpty(value)) {
            throw new ServiceException("使用场景不能为空");
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
    public boolean sameValueAs(UsageScene other) {
        return this.getValue().equals(other.getValue());
    }
} 