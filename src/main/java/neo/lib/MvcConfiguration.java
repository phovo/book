package neo.lib;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class MvcConfiguration extends WebMvcConfigurerAdapter {
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		 registry.addViewController("/").setViewName("home");
		 registry.addViewController("/home").setViewName("home");
	     registry.addViewController("/login").setViewName("login");
	     registry.addViewController("/detail").setViewName("detail");
	     registry.addViewController("/add").setViewName("add");
	     registry.addViewController("/edit").setViewName("edit");
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	 @Bean
	 public InternalResourceViewResolver viewResolver() {
		 InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		 resolver.setSuffix(".faces");
		 return resolver;
	  }
}
