/**
 * CA共享使用记录错误码
 *
 * @author HZR 414117117@qq.com
 * ================================<p>
 * Date: 2024/11/6<p>
 * Time: 14:30<p>
 * ================================
 */
package com.zz.bianalysisprd.cashareusagebc.domain.cashareusagerecordaggr;

import com.zz.core.tool.api.IResultCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CaShareUsageRecordResultCode implements IResultCode {
    CA_SHARE_USAGE_RECORD_NOT_FOUND(400, "001-05-B-001", "CA共享使用记录未找到"),
    CA_SHARE_USAGE_RECORD_ALREADY_EXISTS(400, "001-05-B-002", "CA共享使用记录已存在"),
    INVALID_SUBJECT_TYPE(400, "001-05-B-003", "无效的主体类型"),
    INVALID_USAGE_SCENE(400, "001-05-B-004", "无效的使用场景"),
    INVALID_CERT_TYPE(400, "001-05-B-005", "无效的证书类型"),
    INVALID_PUBLIC_KEY_ALGORITHM(400, "001-05-B-006", "无效的公钥算法"),
    DATA_FORMAT_ERROR(400, "10091", "数据格式错误");

    /**
     * 响应码
     */
    private final int code;

    /**
     * 错误码
     */
    private final String errorCode;

    /**
     * 错误信息
     */
    private final String message;
} 