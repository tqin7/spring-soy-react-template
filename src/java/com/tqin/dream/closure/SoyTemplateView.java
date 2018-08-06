package com.tqin.dream.closure;

import com.google.template.soy.tofu.SoyTofu;
import org.springframework.web.servlet.view.AbstractUrlBasedView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class SoyTemplateView extends AbstractUrlBasedView {
    private SoyTofu.Renderer renderer;

    public SoyTemplateView(SoyTofu.Renderer renderer) {
        this.renderer = renderer;
    }

    @Override
    protected boolean isUrlRequired() {
        return false;
    }

    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String result = renderer.setData(model).render();
        response.setContentType("text/html");
        response.getWriter().print(result);
    }
}
