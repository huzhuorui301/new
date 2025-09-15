package com.zz.bianalysisprd;

import com.zz.core.launch.ZzApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 项目启动类
 *
 * @author wangsw
 * ===============================
 * Date：2024/05/09
 * Time：14:40
 * ================================
 */
@EnableAsync
@EnableScheduling
@SpringBootApplication
public class Application {

    /**
     * 服务名称
     */
    private static final String APP_NAME = "bianalysisprd";

    public static void main(String[] args) {
        ZzApplication.run(APP_NAME, Application.class, args);
    }
}
