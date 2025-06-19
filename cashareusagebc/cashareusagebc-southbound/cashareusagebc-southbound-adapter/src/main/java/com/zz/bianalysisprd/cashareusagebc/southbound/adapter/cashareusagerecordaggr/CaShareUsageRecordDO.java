/**
 * CA共享使用记录数据库对象
 *
 * @author HZR 414117117@qq.com
 * ================================<p>
 * Date: 2024/11/6<p>
 * Time: 14:30<p>
 * ================================
 */
package com.zz.bianalysisprd.cashareusagebc.southbound.adapter.cashareusagerecordaggr;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zz.starter.mp.base.BaseDO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("tb_ca_share_usage_record")
public class CaShareUsageRecordDO extends BaseDO {
    /**
     * CA共享使用记录业务序列号
     */
    @TableField("ca_share_usage_record_sn")
    private String caShareUsageRecordSN;

    /**
     * 主体类型
     */
    @TableField("subject_type")
    private String subjectType;

    /**
     * 组件编码
     */
    @TableField("components_code")
    private String componentsCode;

    /**
     * 使用场景
     */
    @TableField("usage_scene")
    private String usageScene;

    /**
     * 交易系统标识码
     */
    @TableField("trading_system_code")
    private String tradingSystemCode;

    /**
     * 交易系统名称
     */
    @TableField("trading_system_name")
    private String tradingSystemName;

    /**
     * 证书序列号
     */
    @TableField("cert_sn")
    private String certSn;

    /**
     * 证书名称
     */
    @TableField("cert_name")
    private String certName;

    /**
     * 证书类型
     */
    @TableField("cert_type")
    private String certType;

    /**
     * 公钥算法
     */
    @TableField("public_key_algorithm")
    private String publicKeyAlgorithm;

    /**
     * 状态(0-无效，1-有效)
     */
    @TableField("status")
    private Integer status;
} 