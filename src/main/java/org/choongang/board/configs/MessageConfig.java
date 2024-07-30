package org.choongang.board.configs;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class MessageConfig {
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource ms = new ResourceBundleMessageSource();
        ms.setDefaultEncoding("UTF-8"); // 언어 설정
        ms.setUseCodeAsDefaultMessage(true);
        ms.setBasenames("messages.commons", "messages.validations"); // commons.properties & validations.properties 연결

        return ms;
    }
}