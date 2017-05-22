package nc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

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

//    @Bean
//    public HttpMessageConverter<String> messageConverter() {
//        StringHttpMessageConverter converter = new StringHttpMessageConverter();
//        converter.setSupportedMediaTypes(Arrays.asList(new MediaType("text", "html", Charset.forName("UTF-8"))));
//        return converter;
//    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/views/**").addResourceLocations("/views/");
    }

//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        super.configureMessageConverters(converters);
//        converters.add(messageConverter());
//    }
}
