package com.newconstructs.configuration;

import com.newconstructs.domain.api.Layout;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceException;


public class ThymeleafLayoutInterceptor extends HandlerInterceptorAdapter {
    private static final String DEFAULT_TEMPLATE_DIR = "/template";
    private static final String DEFAULT_PAGES_DIR = "/pages";
    private static final String DEFAULT_ATTRIBUTE_NAME_TITLE = "title";
    private static final String DEFAULT_ATTRIBUTE_NAME_DESCRIPTION = "description";
    private static final String DEFAULT_ATTRIBUTE_NAME_CONTENT = "content";
    private static final String DEFAULT_ATTRIBUTE_NAME_SELECTED_NAV = "selectedNav";

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if ((modelAndView == null) || !modelAndView.hasView()) {
            return;
        }

        String contentName = modelAndView.getViewName();

        if (isRedirectOrForward(contentName)) {
            return;
        }

        Layout layout = getLayout(handler);

        setModelValues(layout, modelAndView, contentName);
    }

    private boolean isRedirectOrForward(String viewName) {
        return viewName.startsWith("redirect:") || viewName.startsWith("forward:");
    }

    private Layout getLayout(Object handler) {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Layout layout = handlerMethod.getMethodAnnotation(Layout.class);

        if (layout == null) {
            layout = handlerMethod.getBeanType().getAnnotation(Layout.class);
        }

        if (layout == null) {
            // if layout is still null, throw an error
            throw new WebServiceException("@Layout interface must be present on the method or class.");
        }

        return layout;
    }

    private String getFullTemplatePath(String templateName) {
        if (templateName.isEmpty()) {
            return "";
        }

        return DEFAULT_TEMPLATE_DIR + "/" + replaceDots(templateName);
    }

    private String getFullContentPath(String contentName) {
        return DEFAULT_PAGES_DIR + "/" + replaceDots(contentName);
    }

    private String replaceDots(String path) {
        // want to take pages.default and make it /pages/default
        return path.replaceAll("\\.", "\\/");
    }

    private void setModelValues(Layout layout, ModelAndView modelAndView, String contentName) {
        modelAndView.setViewName(getFullTemplatePath(layout.name()));
        modelAndView.addObject(DEFAULT_ATTRIBUTE_NAME_TITLE, layout.title());
        modelAndView.addObject(DEFAULT_ATTRIBUTE_NAME_DESCRIPTION, layout.description());
        modelAndView.addObject(DEFAULT_ATTRIBUTE_NAME_CONTENT, getFullContentPath(contentName));
        modelAndView.addObject(DEFAULT_ATTRIBUTE_NAME_SELECTED_NAV, layout.selectedNav());
    }
}

