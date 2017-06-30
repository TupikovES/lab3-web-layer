package nc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.xslt.XsltView;
import org.springframework.web.servlet.view.xslt.XsltViewResolver;

import javax.servlet.MultipartConfigElement;
import java.io.IOException;


/**
 * Created by petka on 24.03.2017.
 *
 * @author Evgeniy Tupikov
 */
@Configuration
@ComponentScan(basePackages = {"nc"})
@EnableWebMvc
@Import({StorageConfig.class})
public class WebApp extends WebMvcConfigurerAdapter {

    @Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/views/");
        resolver.setSuffix(".jsp");
        resolver.setRequestContextAttribute("rc");
        return resolver;
    }

    @Bean
    public XsltViewResolver xsltViewResolver() {
        XsltViewResolver xsltViewResolver = new XsltViewResolver();
        xsltViewResolver.setViewClass(XsltView.class);
        xsltViewResolver.setViewNames(new String[] {"viewobject"});
        xsltViewResolver.setPrefix("/WEB-INF/xsl/");
        xsltViewResolver.setSuffix(".xsl");
        return xsltViewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/views/**").addResourceLocations("/views/");
    }

    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver createMultipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("utf-8");
        resolver.setMaxUploadSize(5242880);//5MB
        return resolver;
    }

}
