//package com.mahi.app.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
//import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
//
//import com.fasterxml.jackson.dataformat.xml.XmlMapper;
//
//@Configuration
//public class JacksonConfig {
//
//    @Bean
//    public HttpMessageConverter<?> jacksonXmlConverter() {
//        return new MappingJackson2XmlHttpMessageConverter(new XmlMapper());
//    }
//
//    @Bean
//    public MappingJackson2HttpMessageConverter jacksonJsonConverter() {
//        return new MappingJackson2HttpMessageConverter();
//    }
//}
