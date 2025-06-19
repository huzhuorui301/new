package com.zz.bianalysisprd.cashareusagebc.northbound.local.cashareuseagebiz.pl;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.NotBlank;

/**
 * 接收CA互认扫码使用记录请求对象
 *
 * @author HZR 414117117@qq.com
 * ================================<p>
 * Date: 2025/1/6<p>
 * Time: 10:40<p>
 * ================================
 */
@Data
@ApiModel(value = "接收CA互认扫码使用记录请求")
public class ReceiveScanUsageRecordRequest {
    /**
     * 组件编码
     */
    @NotBlank(message = "组件编码不能为空")
    @ApiModelProperty(value = "组件编码")
    private String componentsCode;

    /**
     * 交易系统标识码
     */
    @NotBlank(message = "交易系统标识码不能为空")
    @ApiModelProperty(value = "交易系统标识码")
    private String tradingSystemCode;

    /**
     * 交易系统名称
     */
    @NotBlank(message = "交易系统名称不能为空")
    @ApiModelProperty(value = "交易系统名称")
    private String tradingSystemName;

    /**
     * 证书序列号
     */
    @NotBlank(message = "证书序列号不能为空")
    @ApiModelProperty(value = "证书序列号")
    private String certSn;

    /**
     * 证书名称
     */
    @NotBlank(message = "证书名称不能为空")
    @ApiModelProperty(value = "证书名称")
    private String certName;

    /**
     * 证书类型：单位证书：orgCert，个人证书：personalCert
     */
    @NotBlank(message = "证书类型不能为空")
    @ApiModelProperty(value = "证书类型：单位证书：orgCert，个人证书：personalCert")
    private String certType;

    /**
     * 公钥算法 SM2/RSA
     */
    @NotBlank(message = "公钥算法不能为空")
    @ApiModelProperty(value = "公钥算法 SM2/RSA")
    private String publicKeyAlgorithm;

    /**
     * 主体类型：个人personal/单位org
     */
    @NotBlank(message = "主体类型不能为空")
    @ApiModelProperty(value = "主体类型：个人personal/单位org")
    private String subjectType;

    /**
     * 使用场景：注册登录login/消息签名messageSignature/签章signature/撤章revokeSignature/加密encrypt/解密decrypt
     */
    @NotBlank(message = "使用场景不能为空")
    @ApiModelProperty(value = "使用场景：注册登录login/消息签名messageSignature/签章signature/撤章revokeSignature/加密encrypt/解密decrypt")
    private String usageScene;
} 