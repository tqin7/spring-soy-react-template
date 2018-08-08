package com.tqin.dream.config;

import com.tqin.dream.closure.SoyTemplateViewResolver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.servlet.ViewResolver;

import java.util.Arrays;

@Configuration
public class ViewResolverConfig implements ResourceLoaderAware {

    private ResourceLoader resourceLoader;

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Bean
    public ViewResolver viewResolver() {
        SoyTemplateViewResolver viewResolver = new SoyTemplateViewResolver();

        viewResolver.setTofu(Arrays.asList("soy/index.soy"));

        return viewResolver;
    }

}
