/**
 * 主体类型
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
public class SubjectType implements ValueObject<SubjectType> {
    
    /**
     * 主体类型枚举
     */
    public enum Type {
        PERSONAL("个人"),
        ORG("单位");
        
        private final String description;
        
        Type(String description) {
            this.description = description;
        }
        
        public String getDescription() {
            return description;
        }
    }
    
    /**
     * 主体类型值
     */
    private final Type value;

    /**
     * 构造函数
     *
     * @param value 主体类型
     */
    public SubjectType(Type value) {
        if (ZzKits.isEmpty(value)) {
            throw new ServiceException("主体类型不能为空");
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
    public boolean sameValueAs(SubjectType other) {
        return this.getValue().equals(other.getValue());
    }
} 