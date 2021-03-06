package com.serhey.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;


public class WebAppInitializer implements WebApplicationInitializer {

    private static final String DISPATCHER_SERVLET_NAME = "dispatcher";


    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        // регистрация конфигураций в Spring контексте
        context.register(WebAppConfig.class, SecurityConfig.class);
        servletContext.addListener(new ContextLoaderListener(context));
        context.setServletContext(servletContext);

        ServletRegistration.Dynamic servlet = servletContext.addServlet(DISPATCHER_SERVLET_NAME, new DispatcherServlet(context));
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);
    }
}
