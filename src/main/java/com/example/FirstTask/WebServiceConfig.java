package com.example.FirstTask;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/service/*");
    }
    @Bean(name = "TcDogrula")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema tcSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("TcNoPort");
        wsdl11Definition.setLocationUri("/service");
        wsdl11Definition.setTargetNamespace("http://example.com/FirstTask/service");
        wsdl11Definition.setSchema(tcSchema);
        return wsdl11Definition;
    }
    @Bean
    public XsdSchema tcSchema() {
        return new SimpleXsdSchema(new ClassPathResource("TcSoapService.xsd"));
    }



}
