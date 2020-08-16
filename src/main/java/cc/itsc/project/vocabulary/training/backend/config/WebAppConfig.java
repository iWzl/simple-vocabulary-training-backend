package cc.itsc.project.vocabulary.training.backend.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Leonardo iWzl
 * @version 1.0
 */

@Configuration
public class WebAppConfig implements WebMvcConfigurer {

    @Value("${leonardo.upload.image.filepath}")
    private String imageFilePath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/image/**")
                .addResourceLocations("file:"+imageFilePath);
    }
}
