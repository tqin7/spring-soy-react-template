package com.tqin.dream.closure;

import com.google.common.io.Resources;
import com.google.template.soy.SoyFileSet;
import com.google.template.soy.tofu.SoyTofu;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import java.util.Collection;

public class SoyTemplateViewResolver extends UrlBasedViewResolver {

    private SoyTofu tofu;

    public void setTofu(Collection<String> uris) {
        super.setViewClass(SoyTemplateView.class);
        SoyFileSet.Builder soyBuilder = SoyFileSet.builder();

        for (String uri : uris) {
            soyBuilder.add(Resources.getResource(uri));
        }

        tofu = soyBuilder.build().compileToTofu();
    }

    @Override
    protected SoyTemplateView buildView(String name) {
        return new SoyTemplateView(tofu.newRenderer(name));
    }

    @Override
    protected Class<?> requiredViewClass() {
        return SoyTemplateView.class;
    }
}
