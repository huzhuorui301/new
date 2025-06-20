package com.zz.bianalysisprd.cashareusagebc.northbound.local.cashareuseagebiz.pl;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 接收CA互认扫码使用记录结果对象
 *
 * @author HZR 414117117@qq.com
 * ================================<p>
 * Date: 2025/1/6<p>
 * Time: 10:45<p>
 * ================================
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "接收CA互认扫码使用记录结果")
public class ReceiveScanUsageRecordResult {
    /**
     * 结果状态
     */
    @ApiModelProperty(value = "结果状态")
    private String status;

    /**
     * 消息
     */
    @ApiModelProperty(value = "消息")
    private String msg;

    /**
     * CA共享使用记录业务序列号
     */
    @ApiModelProperty(value = "CA共享使用记录业务序列号")
    private String caShareUsageRecordSN;
} 