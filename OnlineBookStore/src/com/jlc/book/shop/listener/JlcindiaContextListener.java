package com.jlc.book.shop.listener;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class JlcindiaContextListener implements ServletContextListener {

   public void contextInitialized(ServletContextEvent ctxEvent) {
        ServletContext ctx = ctxEvent.getServletContext();
        String path = ctx.getRealPath("/"+"logs\\");
        System.out.println(path);
        //System.out.println(path);
        System.setProperty("jlcindia.root.path", path);
        String str = ctx.getRealPath("/WEB-INF/classes/com/jlc/jlc-log4j.properties");
        PropertyConfigurator.configure(str);
        Logger log = Logger.getLogger(this.getClass());
        log.info("Properties File: "+str);
   }

    public void contextDestroyed(ServletContextEvent ctxEvent) {
    }
	
}
