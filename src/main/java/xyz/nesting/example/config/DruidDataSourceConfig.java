package xyz.nesting.example.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
// 扫描 Mapper 接口并容器管理
@MapperScan(basePackages = DruidDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "sqlSessionFactory")
public class DruidDataSourceConfig {

    static final String PACKAGE = "xyz.nesting.example.dao";
    static final String MAPPER_LOCATION = "classpath:mapper/*.xml";

    @Value("${mysql.druid.datasource.url}")
    private String url;

    @Value("${mysql.druid.datasource.username}")
    private String user;

    @Value("${mysql.druid.datasource.password}")
    private String password;

    @Value("${mysql.druid.datasource.driverClassName}")
    private String driverClass;

    @Bean(name = "dataSource")
    @Primary
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "transactionManager")
    @Primary
    public DataSourceTransactionManager transactionManager() {
         DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(dataSource());
         return dataSourceTransactionManager;
    }

    @Bean(name = "sqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(DruidDataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}