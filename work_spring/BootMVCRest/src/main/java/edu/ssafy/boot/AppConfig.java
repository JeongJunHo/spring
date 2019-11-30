package edu.ssafy.boot;



import javax.sql.DataSource;

//import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class AppConfig {
	
//	@Bean
//	public DataSource dataSource() {
//		BasicDataSource ds = new BasicDataSource();
//		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
//		ds.setUrl("jdbc:mysql://localhost/springweb?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8");
//		ds.setUsername("ssafy");
//		ds.setPassword("ssafy");
//		//ds.setMaxActive(20);
//		ds.setMaxIdle(20);
//		return ds;
//	}
//	@Bean
//	public SqlSessionFactoryBean sqlSessionFactory(DataSource ds) {
//		SqlSessionFactoryBean sbean = new SqlSessionFactoryBean();
//		sbean.setDataSource(ds);
//		String configLoc = "classpath:mybatis/mybatisConfig.xml";
//		sbean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource(configLoc));
//
//		return sbean;
//	}
//
//	@Bean
//	@ConditionalOnMissingBean
//	public SqlSession sqlSession(SqlSessionFactoryBean sBean) throws Exception {
//		return new SqlSessionTemplate(sBean.getObject());
//	}
	
	@Bean
	public PlatformTransactionManager transactionManager(DataSource ds) {
		return new DataSourceTransactionManager(ds);
	}
}