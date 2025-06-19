/**
 * CA共享使用记录值对象映射逻辑
 *
 * @author HZR 414117117@qq.com
 * ================================<p>
 * Date: 2024/11/6<p>
 * Time: 14:30<p>
 * ================================
 */
package com.zz.bianalysisprd.cashareusagebc.domain.cashareusagerecordaggr;

import com.zz.bianalysisprd.cashareusagebc.domain.cashareusagerecordaggr.valueobject.*;
import com.zz.core.tool.utils.ZzKits;

public class CaShareUsageRecordMapping {

    /**
     * CA共享使用记录技术Id转数字
     *
     * @param caShareUsageRecordId CA共享使用记录技术Id
     * @return CA共享使用记录技术Id数字
     */
    public Long toLong(CaShareUsageRecordId caShareUsageRecordId) {
        return ZzKits.isEmpty(caShareUsageRecordId) ? null : caShareUsageRecordId.getValue();
    }

    /**
     * 数字转CA共享使用记录技术Id
     *
     * @param caShareUsageRecordId CA共享使用记录技术Id数字
     * @return CA共享使用记录技术Id
     */
    public CaShareUsageRecordId toCaShareUsageRecordId(Long caShareUsageRecordId) {
        return ZzKits.isEmpty(caShareUsageRecordId) ? null : new CaShareUsageRecordId(caShareUsageRecordId);
    }

    /**
     * CA共享使用记录业务序列号转字符串
     *
     * @param caShareUsageRecordSN CA共享使用记录业务序列号
     * @return 字符串
     */
    public String toString(CaShareUsageRecordSN caShareUsageRecordSN) {
        return ZzKits.isEmpty(caShareUsageRecordSN) ? null : caShareUsageRecordSN.getValue();
    }

    /**
     * 字符串转CA共享使用记录业务序列号
     *
     * @param caShareUsageRecordSN 字符串
     * @return CA共享使用记录业务序列号
     */
    public CaShareUsageRecordSN toCaShareUsageRecordSN(String caShareUsageRecordSN) {
        return ZzKits.isEmpty(caShareUsageRecordSN) ? null : new CaShareUsageRecordSN(caShareUsageRecordSN);
    }

    /**
     * 主体类型转字符串
     *
     * @param subjectType 主体类型
     * @return 字符串
     */
    public String toString(SubjectType subjectType) {
        return ZzKits.isEmpty(subjectType) ? null : subjectType.getValue().name();
    }

    /**
     * 字符串转主体类型
     *
     * @param subjectType 字符串
     * @return 主体类型
     */
    public SubjectType toSubjectType(String subjectType) {
        return ZzKits.isEmpty(subjectType) ? null : new SubjectType(SubjectType.Type.valueOf(subjectType));
    }

    /**
     * 组件编码转字符串
     *
     * @param componentsCode 组件编码
     * @return 字符串
     */
    public String toString(ComponentsCode componentsCode) {
        return ZzKits.isEmpty(componentsCode) ? null : componentsCode.getValue();
    }

    /**
     * 字符串转组件编码
     *
     * @param componentsCode 字符串
     * @return 组件编码
     */
    public ComponentsCode toComponentsCode(String componentsCode) {
        return ZzKits.isEmpty(componentsCode) ? null : new ComponentsCode(componentsCode);
    }

    /**
     * 使用场景转字符串
     *
     * @param usageScene 使用场景
     * @return 字符串
     */
    public String toString(UsageScene usageScene) {
        return ZzKits.isEmpty(usageScene) ? null : usageScene.getValue().name();
    }

    /**
     * 字符串转使用场景
     *
     * @param usageScene 字符串
     * @return 使用场景
     */
    public UsageScene toUsageScene(String usageScene) {
        return ZzKits.isEmpty(usageScene) ? null : new UsageScene(UsageScene.Scene.valueOf(usageScene));
    }
} 