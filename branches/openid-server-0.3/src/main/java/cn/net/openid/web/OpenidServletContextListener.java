/**
 * Created on 2006-11-7 下午11:34:02
 */
package cn.net.openid.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import cn.net.openid.OpenidConfiguration;

/**
 * @author Shutra
 * 
 */
public class OpenidServletContextListener implements ServletContextListener {

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext sc = sce.getServletContext();
		String openidConfigurationBeanName = sc
				.getInitParameter(OpenidConfiguration.CONFIGURATION_BEAN_NAME);
		String openidConfigurationAttributeName = sc
				.getInitParameter(OpenidConfiguration.CONFIGURATION_ATTRIBUTE_NAME);
		OpenidConfiguration openidConfiguration = (OpenidConfiguration) org.springframework.web.context.support.WebApplicationContextUtils
				.getWebApplicationContext(sc).getBean(
						openidConfigurationBeanName);
		sce.getServletContext().setAttribute(openidConfigurationAttributeName,
				openidConfiguration);
	}
}