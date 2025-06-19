-- CA共享使用记录表
CREATE TABLE `tb_ca_share_usage_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `ca_share_usage_record_sn` varchar(64) NOT NULL COMMENT 'CA共享使用记录业务序列号',
  `subject_type` varchar(32) NOT NULL COMMENT '主体类型(PERSONAL:个人, ORG:单位)',
  `components_code` varchar(64) NOT NULL COMMENT '组件编码',
  `usage_scene` varchar(32) NOT NULL COMMENT '使用场景(LOGIN:注册登录, MESSAGE_SIGNATURE:消息签名, SIGNATURE:签章, REVOKE_SIGNATURE:撤章, ENCRYPT:加密, DECRYPT:解密)',
  `trading_system_code` varchar(64) NOT NULL COMMENT '交易系统标识码',
  `trading_system_name` varchar(128) NOT NULL COMMENT '交易系统名称',
  `cert_sn` varchar(128) NOT NULL COMMENT '证书序列号',
  `cert_name` varchar(256) NOT NULL COMMENT '证书名称',
  `cert_type` varchar(32) NOT NULL COMMENT '证书类型(ORG_CERT:单位证书, PERSONAL_CERT:个人证书)',
  `public_key_algorithm` varchar(32) NOT NULL COMMENT '公钥算法(RSA:国际RSA, SM2:国密SM2)',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_user` bigint(20) DEFAULT NULL COMMENT '创建用户ID',
  `update_user` bigint(20) DEFAULT NULL COMMENT '更新用户ID',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '状态(1:正常, 0:删除)',
  `tenant_id` varchar(12) DEFAULT '000000' COMMENT '租户ID',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uk_ca_share_usage_record_sn` (`ca_share_usage_record_sn`) USING BTREE COMMENT 'CA共享使用记录业务序列号唯一索引',
  KEY `idx_subject_type` (`subject_type`) USING BTREE COMMENT '主体类型索引',
  KEY `idx_components_code` (`components_code`) USING BTREE COMMENT '组件编码索引',
  KEY `idx_usage_scene` (`usage_scene`) USING BTREE COMMENT '使用场景索引',
  KEY `idx_trading_system_code` (`trading_system_code`) USING BTREE COMMENT '交易系统标识码索引',
  KEY `idx_cert_sn` (`cert_sn`) USING BTREE COMMENT '证书序列号索引',
  KEY `idx_create_time` (`create_time`) USING BTREE COMMENT '创建时间索引',
  KEY `idx_tenant_id` (`tenant_id`) USING BTREE COMMENT '租户ID索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='CA共享使用记录表';

-- This is a test comment. 