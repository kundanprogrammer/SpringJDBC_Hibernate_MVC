package main.javaa.Dispathers;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages= {"main.javaa"})
public class StudentAppConfig implements WebMvcConfigurer{

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        System.out.println("till jdbc template");
        JdbcTemplate jdbcTemplate;
        jdbcTemplate = new JdbcTemplate(dataSource());
        System.out.println("till jdbc-end template");
        return jdbcTemplate;

    }

    @Bean
    public DataSource dataSource(){
        System.out.println("till data source");
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.setUrl("jdbc:mysql://localhost:3306/studentmanagement?allowPublicKeyRetrieval=true&useSSL=false");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        System.out.println("till data end source");
        return dataSource;
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/URLToResource/**")
                .addResourceLocations("/images/");
    }
}
