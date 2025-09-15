/**
 * 使用证书
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
public class UsageCert implements ValueObject<UsageCert> {
    
    /**
     * 证书类型枚举
     */
    public enum CertType {
        ORG_CERT("单位证书"),
        PERSONAL_CERT("个人证书");
        
        private final String description;
        
        CertType(String description) {
            this.description = description;
        }
        
        public String getDescription() {
            return description;
        }
    }
    
    /**
     * 公钥算法枚举
     */
    public enum PublicKeyAlgorithm {
        RSA("国际RSA"),
        SM2("国密SM2");
        
        private final String description;
        
        PublicKeyAlgorithm(String description) {
            this.description = description;
        }
        
        public String getDescription() {
            return description;
        }
    }
    
    /**
     * 证书序列号
     */
    private final String certSn;
    
    /**
     * 证书名称
     */
    private final String certName;
    
    /**
     * 证书类型
     */
    private final CertType certType;
    
    /**
     * 公钥算法
     */
    private final PublicKeyAlgorithm publicKeyAlgorithm;

    /**
     * 构造函数
     *
     * @param certSn 证书序列号
     * @param certName 证书名称
     * @param certType 证书类型
     * @param publicKeyAlgorithm 公钥算法
     */
    public UsageCert(String certSn, String certName, CertType certType, PublicKeyAlgorithm publicKeyAlgorithm) {
        if (ZzKits.isEmpty(certSn)) {
            throw new ServiceException("证书序列号不能为空");
        }
        if (ZzKits.isEmpty(certName)) {
            throw new ServiceException("证书名称不能为空");
        }
        if (ZzKits.isEmpty(certType)) {
            throw new ServiceException("证书类型不能为空");
        }
        if (ZzKits.isEmpty(publicKeyAlgorithm)) {
            throw new ServiceException("公钥算法不能为空");
        }
        this.certSn = certSn;
        this.certName = certName;
        this.certType = certType;
        this.publicKeyAlgorithm = publicKeyAlgorithm;
    }

    /**
     * 比较两个值是否相等
     *
     * @param other 另一个对象
     * @return 结果
     */
    @Override
    public boolean sameValueAs(UsageCert other) {
        return this.getCertSn().equals(other.getCertSn()) &&
               this.getCertName().equals(other.getCertName()) &&
               this.getCertType().equals(other.getCertType()) &&
               this.getPublicKeyAlgorithm().equals(other.getPublicKeyAlgorithm());
    }
} 