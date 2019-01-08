package com.jlc;

import java.util.Properties;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@Configuration
@ComponentScan({"com.jlc"})
public class JLCConfig {
	
	@Bean
	public InternalResourceViewResolver viewResolver()
	{
		InternalResourceViewResolver itr=new InternalResourceViewResolver();
		itr.setViewClass(JstlView.class);
		itr.setPrefix("/");
		itr.setSuffix(".jsp");
		return itr;
	}
	

	@Bean
	UserValidator valid()
	{
		return new UserValidator();
	}
	
	@Bean
	public javax.sql.DataSource datasource()
	{
		DriverManagerDataSource datasource=new DriverManagerDataSource();
		datasource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		datasource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");	
		datasource.setUsername("system");
		datasource.setPassword("abhay");
		return datasource;
	}
	
	@Bean
	public LocalSessionFactoryBean session(javax.sql.DataSource ds)
	{
		LocalSessionFactoryBean sf=new LocalSessionFactoryBean();
		sf.setDataSource(ds);
		sf.setPackagesToScan("com.jlc");
		Properties p=new Properties();
		p.put("hibernate.dialect", "org.hibernate.dialect.OracleDialect");
		p.put("hibernate.show_sql","true");
		p.put("hibernate.hbm2ddl.auto","update");
		sf.setHibernateProperties(p);
		return sf;
	}


	@Bean
	public MessageSource messageSource()
	{
		ReloadableResourceBundleMessageSource rs=new ReloadableResourceBundleMessageSource();
		rs.setBasename("classpath:message");
		rs.setDefaultEncoding("UTF-8");
		return rs;
	}
	
	@Bean
	public LocaleResolver localeResolver()
	{
		CookieLocaleResolver ck=new CookieLocaleResolver();
		//ck.setDefaultLocale(new Locale("hi"));
		return ck;
	}
	
		public void addInterceptors(InterceptorRegistry reg)
	{
		LocaleChangeInterceptor lc=new LocaleChangeInterceptor();
		lc.setParamName("language");
		reg.addInterceptor(lc);
	}
}
