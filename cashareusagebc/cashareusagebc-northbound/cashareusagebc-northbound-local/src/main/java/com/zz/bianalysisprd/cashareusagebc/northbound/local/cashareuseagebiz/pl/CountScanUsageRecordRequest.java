package com.zz.bianalysisprd.cashareusagebc.northbound.local.cashareuseagebiz.pl;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.NotBlank;

/**
 * 统计CA互认扫码使用记录请求对象
 *
 * @author HZR 414117117@qq.com
 * ================================<p>
 * Date: 2025/1/6<p>
 * Time: 10:30<p>
 * ================================
 */
@Data
@ApiModel(value = "统计CA互认扫码使用记录请求")
public class CountScanUsageRecordRequest {
    /**
     * 使用场景
     */
    @NotBlank(message = "使用场景不能为空")
    @ApiModelProperty(value = "使用场景")
    private String usageScene;

    /**
     * 开始时间
     */
    @NotBlank(message = "开始时间不能为空")
    @ApiModelProperty(value = "开始时间")
    private String startUsageTime;

    /**
     * 结束时间
     */
    @NotBlank(message = "结束时间不能为空")
    @ApiModelProperty(value = "结束时间")
    private String endUsageTime;
} 