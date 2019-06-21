package com.lingku.common.config;

import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.github.pagehelper.PageHelper;

/**
 * @author NYY
 * @2019年6月21日 
 * @description mybatis 分页设置
 */
@Configuration
public class MybatisConfig {

	@Autowired
	private DataSource dataSource;

	@Bean
	public SqlSessionFactory MetropatrolSqlSessionFactory() throws Exception {

		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);

		// mybatis分页

		PageHelper pageHelper = new PageHelper();
		Properties properties = new Properties();
		properties.setProperty("dialect", "mysql");
		properties.setProperty("reasonable", "false");
		pageHelper.setProperties(properties);
		bean.setPlugins(new Interceptor[] { (Interceptor) pageHelper });

		return bean.getObject();
	}

	@Bean(name = "metropatrolTransactionManager")
	public DataSourceTransactionManager devTransactionManager() throws SQLException {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean
	public SqlSessionTemplate OdipfridSqlSessionTemplate() throws Exception {
		SqlSessionTemplate template = new SqlSessionTemplate(MetropatrolSqlSessionFactory());
		// 使用上面配置的Factory
		return template;
	}

}
