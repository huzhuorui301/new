package com.zz.bianalysisprd.cashareusagebc.northbound.local.cashareuseagebiz.pl;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 统计CA互认扫码使用记录查询视图对象
 *
 * @author HZR 414117117@qq.com
 * ================================<p>
 * Date: 2025/1/6<p>
 * Time: 10:35<p>
 * ================================
 */
@Data
@ApiModel(value = "统计CA互认扫码使用记录查询视图")
public class CountScanUsageRecordView {
    /**
     * 总数
     */
    @ApiModelProperty(value = "总数")
    private Long sumCount;
} 