
package org.tts.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.wall.WallConfig;
import com.alibaba.druid.wall.WallFilter;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Configuration
@MapperScan(basePackages = DataSource1Config.PACKAGE, sqlSessionTemplateRef = "sqlSessionTemplateMysql")
public class DataSource1Config {
    /**
     * 主路径
     */
    static final String PACKAGE = "org.tts.domain.mysql";
    /**
     * 扫描的 xml 目录
     */
    static final String MAPPER_LOCATION = "classpath:mybatis/mapper/mysql/*.xml";

    @Value("${spring.datasource.druid.mysql.url}")
    private String url;

    @Value("${spring.datasource.druid.mysql.username}")
    private String user;

    @Value("${spring.datasource.druid.mysql.password}")
    private String password;

    @Value("${spring.datasource.druid.mysql.driver-class-name}")
    private String driverClass;


    @Bean(name = "dataSourceMysql")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.druid.mysql")
    public DataSource dataSourceMysql() {
        DruidDataSource dataSource = new DruidDataSource();
        List filterList=new ArrayList<>(); //可以链式叠加
        filterList.add(wallFilter());
        dataSource.setProxyFilters(filterList);
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "transactionManagerMysql")
    @Primary
    public DataSourceTransactionManager transactionManagerMysql() {
        return new DataSourceTransactionManager(dataSourceMysql());
    }

    @Bean(name = "sqlSessionFactoryMysql")
    @Primary
    public SqlSessionFactory sqlSessionFactoryMysql(@Qualifier("dataSourceMysql") DataSource masterDataSource)throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(masterDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(DataSource1Config.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
    @Bean(name = "sqlSessionTemplateMysql")
    @Primary
    public SqlSessionTemplate sqlSessionTemplateMysql(@Qualifier("sqlSessionFactoryMysql") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
    /**
     * 配置druid执行多条sql（批量执行），避免报sql注入异常
     * 链式配置,从下往上注入
     * @return
     */
    @Bean
    public WallFilter wallFilter() {
        WallFilter wallFilter = new WallFilter();
        wallFilter.setConfig(wallConfig());
        return wallFilter;
    }
    @Bean
    public WallConfig wallConfig() {
        WallConfig wallconfig = new WallConfig();
        wallconfig .setMultiStatementAllow(true);//允许一次执行多条语句
        wallconfig .setNoneBaseStatementAllow(true);//允许非基本语句的其他语句
        return wallconfig ;
    }

}