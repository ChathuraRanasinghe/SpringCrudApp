package lk.ijse.absd.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.*;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
//import org.springframework.web.bind.annotation.CrossOrigin;

//import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;


@Configuration
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class WebRootConfig {

    @Autowired
    private Environment env;


    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource ds, JpaVendorAdapter jpaVendorAdapter){
        LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
        emfb.setDataSource(ds);
        emfb.setJpaVendorAdapter(jpaVendorAdapter);
        emfb.setPackagesToScan("lk.ijse.absd.entity");
        return emfb;

    }

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(env.getRequiredProperty("javax.persistence.jdbc.driver"));
        ds.setUrl(env.getRequiredProperty("javax.persistence.jdbc.url"));
        ds.setUsername(env.getRequiredProperty("javax.persistence.jdbc.user"));
        ds.setPassword(env.getRequiredProperty("javax.persistence.jdbc.password"));
        return ds;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter(){
        HibernateJpaVendorAdapter jpa = new HibernateJpaVendorAdapter();
        jpa.setDatabase(Database.MYSQL);
        jpa.setDatabasePlatform(env.getRequiredProperty("hibernate.dialect"));
        jpa.setGenerateDdl(true);
        jpa.setShowSql(true);
        return jpa;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
        return new JpaTransactionManager(emf);
    }

}
