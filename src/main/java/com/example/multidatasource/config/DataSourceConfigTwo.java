package com.example.multidatasource.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author Ren ZhiQiang
 * @date 2019/5/23 15:54
 * @desc
 */
@Configuration
@MapperScan(basePackages = "com.example.multidatasource.mapper2",
        sqlSessionTemplateRef = "sqlSessionTemplateTwo",sqlSessionFactoryRef = "sqlSessionFactoryTwo")
public class DataSourceConfigTwo {

    @Bean(name = "dataSourceTwo")
    @ConfigurationProperties(prefix = "spring.datasource.db2")
    public DataSource dataSourceTwo(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "sqlSessionFactoryTwo")
    public SqlSessionFactory sqlSessionFactoryTwo(@Qualifier("dataSourceTwo") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        //bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/test1/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "sqlSessionTemplateTwo")
    public SqlSessionTemplate sqlSessionTemplateTwo(@Qualifier("sqlSessionFactoryTwo") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean(name = "dataSourceTransactionManagerTwo")
    public DataSourceTransactionManager dataSourceTransactionManagerTwo(@Qualifier("dataSourceTwo") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}
