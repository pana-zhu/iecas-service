package com.pana.course;

import com.pana.course.filter.CourseFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class CourseEdgeServiceApplication {

    public static void main(String args[]) {
        SpringApplication.run(CourseEdgeServiceApplication.class, args);
    }

    
    /**
     * 加载filter 
     * @param courseFilter
     * @return
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean(CourseFilter courseFilter ) {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(courseFilter);

        List<String> urlPatterns = new ArrayList<>();
        urlPatterns.add("/*");
        filterRegistrationBean.setUrlPatterns(urlPatterns);
        return filterRegistrationBean;
    }
}
