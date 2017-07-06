package nc.config;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.MySQL57Dialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by petka on 24.03.2017.
 *
 * @author Evgeniy Tupikov
 */
@Configuration
@EnableTransactionManagement
public class StorageConfig {

    @Autowired
    Environment env;

    @Bean(destroyMethod = "")
    public DataSource getDataSource(){
        JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
        return dataSourceLookup.getDataSource("jdbc/MySQLDataSource");
    }

    @Bean
    public PlatformTransactionManager txManager() {
        DataSourceTransactionManager txManager = new DataSourceTransactionManager();
        txManager.setDataSource(getDataSource());
        //HibernateTransactionManager txManager = new HibernateTransactionManager(getFactoryBean());
        return txManager;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(getDataSource());
    }

    @Bean
    public SessionFactory getFactoryBean() {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(getDataSource());
        MySQL57Dialect dialect = new MySQL57Dialect();
        factoryBean.setHibernateProperties(dialect.getDefaultProperties());
        return factoryBean.getObject();
    }

//    @Bean
//    public HibernateTransactionManager getTransactionManager(){
//        HibernateTransactionManager tm = new HibernateTransactionManager(getFactoryBean());
//        return tm;
//    }

}
