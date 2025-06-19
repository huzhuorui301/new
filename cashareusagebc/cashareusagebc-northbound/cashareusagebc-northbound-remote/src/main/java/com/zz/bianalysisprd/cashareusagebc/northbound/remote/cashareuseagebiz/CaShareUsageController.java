package com.zz.bianalysisprd.cashareusagebc.northbound.remote.cashareuseagebiz;

import com.zz.core.tool.api.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.zz.bianalysisprd.cashareusagebc.northbound.local.cashareuseagebiz.CaShareUsageCommandUseCaseAppService;
import com.zz.bianalysisprd.cashareusagebc.northbound.local.cashareuseagebiz.CaShareUsageQueryUseCaseAppService;
import com.zz.bianalysisprd.cashareusagebc.northbound.local.cashareuseagebiz.pl.CountScanUsageRecordRequest;
import com.zz.bianalysisprd.cashareusagebc.northbound.local.cashareuseagebiz.pl.CountScanUsageRecordView;
import com.zz.bianalysisprd.cashareusagebc.northbound.local.cashareuseagebiz.pl.ReceiveScanUsageRecordRequest;
import com.zz.bianalysisprd.cashareusagebc.northbound.local.cashareuseagebiz.pl.ReceiveScanUsageRecordResult;

import javax.validation.Valid;

/**
 * CA互认扫码使用记录管理控制器
 *
 * @author HZR 414117117@qq.com
 * ================================<p>
 * Date: 2025/1/6<p>
 * Time: 11:15<p>
 * ================================
 */
@RestController
@AllArgsConstructor
@RequestMapping("/ca-share-usage")
@Api(tags = "CA互认扫码使用记录管理", value = "CA互认扫码使用记录管理")
public class CaShareUsageController {

    /**
     * CA互认扫码使用记录业务服务（命令模式）
     */
    private final CaShareUsageCommandUseCaseAppService caShareUsageCommandUseCaseAppService;

    /**
     * CA互认扫码使用记录业务服务（查询模式）
     */
    private final CaShareUsageQueryUseCaseAppService caShareUsageQueryUseCaseAppService;

    /**
     * 接收CA互认扫码使用记录API
     *
     * @param receiveScanUsageRecordRequest 接收扫码使用记录请求对象
     * @return 接收结果
     */
    @PostMapping("/receive-scan-usage-record")
    @ApiOperation(value = "接收CA互认扫码使用记录")
    public R<ReceiveScanUsageRecordResult> receiveScanUsageRecord(@RequestBody @Valid ReceiveScanUsageRecordRequest receiveScanUsageRecordRequest) {
        // 接收CA互认扫码使用记录
        ReceiveScanUsageRecordResult result = caShareUsageCommandUseCaseAppService.receiveScanUsageRecord(receiveScanUsageRecordRequest);
        return R.data(result);
    }

    /**
     * 统计CA互认扫码使用记录API
     *
     * @param countScanUsageRecordRequest 统计请求参数
     * @return 统计结果
     */
    @PostMapping("/count-scan-usage-record")
    @ApiOperation(value = "统计CA互认扫码使用记录")
    public R<CountScanUsageRecordView> countScanUsageRecord(@RequestBody @Valid CountScanUsageRecordRequest countScanUsageRecordRequest) {
        // 统计CA互认扫码使用记录
        CountScanUsageRecordView result = caShareUsageQueryUseCaseAppService.countScanUsageRecord(countScanUsageRecordRequest);
        return R.data(result);
    }
} 