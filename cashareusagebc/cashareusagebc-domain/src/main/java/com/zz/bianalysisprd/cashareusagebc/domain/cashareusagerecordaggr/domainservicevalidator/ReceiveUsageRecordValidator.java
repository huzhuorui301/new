/**
 * 接收使用记录校验器
 *
 * @author HZR 414117117@qq.com
 * ================================<p>
 * Date: 2024/11/6<p>
 * Time: 16:00<p>
 * ================================
 */
package com.zz.bianalysisprd.cashareusagebc.domain.cashareusagerecordaggr.domainservicevalidator;

import com.zz.bianalysisprd.cashareusagebc.domain.cashareusagerecordaggr.CaShareUsageRecordManager;
import com.zz.bianalysisprd.cashareusagebc.domain.cashareusagerecordaggr.CaShareUsageRecordResultCode;
import com.zz.core.ddd.validator.AbstractValidator;
import com.zz.core.tool.utils.ZzKits;
import com.zz.starter.log.exception.ServiceException;

public class ReceiveUsageRecordValidator extends AbstractValidator<CaShareUsageRecordManager> {

    /**
     * 校验逻辑
     *
     * @param caShareUsageRecordManager 校验对象
     * @return 校验结果
     */
    @Override
    public boolean validate(CaShareUsageRecordManager caShareUsageRecordManager) {
        // 校验主体类型
        if (ZzKits.isEmpty(caShareUsageRecordManager.getSubjectType())) {
            throw new ServiceException(CaShareUsageRecordResultCode.DATA_FORMAT_ERROR);
        }

        // 校验组件编码
        if (ZzKits.isEmpty(caShareUsageRecordManager.getComponentsCode())) {
            throw new ServiceException(CaShareUsageRecordResultCode.DATA_FORMAT_ERROR);
        }

        // 校验使用场景
        if (ZzKits.isEmpty(caShareUsageRecordManager.getUsageScene())) {
            throw new ServiceException(CaShareUsageRecordResultCode.DATA_FORMAT_ERROR);
        }

        // 校验交易系统
        if (ZzKits.isEmpty(caShareUsageRecordManager.getTradingSystem())) {
            throw new ServiceException(CaShareUsageRecordResultCode.DATA_FORMAT_ERROR);
        }

        // 校验使用证书
        if (ZzKits.isEmpty(caShareUsageRecordManager.getUsageCert())) {
            throw new ServiceException(CaShareUsageRecordResultCode.DATA_FORMAT_ERROR);
        }

        return true;
    }
} 