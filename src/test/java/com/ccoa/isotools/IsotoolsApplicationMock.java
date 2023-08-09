package com.ccoa.isotools;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan({"com.ccoa"})
@EnableJpaRepositories(basePackages = "com.ccoa")
public class IsotoolsApplicationMock {

}
