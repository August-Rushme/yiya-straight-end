package com.yiya.dentalcity.wx;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.core.env.Environment;

/**
 * @author 战神
 */
@SpringBootApplication
@ServletComponentScan
@MapperScan("com.yiya.dentalcity.wx.dao")

public class DentalCityWxApplication {
    private static final Logger LOG = LoggerFactory.getLogger(DentalCityWxApplication.class);
    public static void main(String[] args) {
        SpringApplication app =  new SpringApplication(DentalCityWxApplication.class);
        Environment env = app.run(args).getEnvironment();
        LOG.info("server is running！！");
        LOG.info("address: \thttp://127.0.0.1:{}", env.getProperty("server.port"));
    }
}
