package com.servlets;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DependencyLoaderListener

        implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("contextintialized()- This method" +
                " in the DependecyLoaderListener has been run.");


    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
