https://www.baeldung.com/thymeleaf-spring-layouts
https://www.youtube.com/watch?v=D-nZhT6GuW8

Khai bao namespace
<!DOCTYPE html>
<html xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
      xmlns:th="http://www.thymeleaf.org">

// Them cau hinh khi su dung thymeleaf dialect 
@Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());

        // Them cau hinh khi dung layout dialect cua thymeleaf
        templateEngine.addDialect(new LayoutDialect());
        //
        return templateEngine;
    }
// dependecies 
    implementation group: 'org.thymeleaf', name: 'thymeleaf-spring5', version: '3.0.11.RELEASE'
    implementation group: 'nz.net.ultraq.thymeleaf', name: 'thymeleaf-layout-dialect', version: '2.3.0'
//

	
	