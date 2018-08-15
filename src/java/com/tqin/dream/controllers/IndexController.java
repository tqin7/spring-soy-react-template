package com.tqin.dream.controllers;

import com.google.common.collect.ImmutableMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tqin.dream.soy.tmpl.IndexSoyInfo;

@Controller
public class IndexController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String doGet(HttpServletRequest request, HttpServletResponse response) {
        return "This is homepage";
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ModelAndView doGetHello(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView(IndexSoyInfo.TemplateName.INDEX,
                new ImmutableMap.Builder<String, Object>()
                        .put("name", "World")
                        .build());
    }

}
