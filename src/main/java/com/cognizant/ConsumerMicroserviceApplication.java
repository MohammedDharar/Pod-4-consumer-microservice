package com.cognizant;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.cognizant.model.Business;
import com.cognizant.model.Consumer;
import com.cognizant.model.Property;
import com.cognizant.repository.BusinessRepository;
import com.cognizant.repository.ConsumerRepository;
import com.cognizant.repository.PropertyRepository;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableFeignClients
public class ConsumerMicroserviceApplication implements CommandLineRunner{
	private ConsumerRepository consumerRepository;
	private BusinessRepository businessRepository;
	private PropertyRepository propertyRepository;
	public ConsumerMicroserviceApplication(ConsumerRepository consumerRepository,BusinessRepository businessRepository,PropertyRepository propertyRepository) {
		this.consumerRepository=consumerRepository;
		this.businessRepository=businessRepository;
		this.propertyRepository=propertyRepository;
	}
	public static void main(String[] args) {
		SpringApplication.run(ConsumerMicroserviceApplication.class, args);
	}
	/**
	 * ConfigureSwagger2
	 * 
	 * @return Docket
	 */
	@Bean
	public Docket configureSwagger2() {
		return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.ant("/consumer/**"))
				.apis(RequestHandlerSelectors.basePackage("com.cognizant")).build();
	}
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Consumer consumer=new Consumer("momo","momo",new Date(2021-03-26),"momo org","123456","momo123@gmail.com","832928","validity","agent",10);
		consumerRepository.save(consumer);
		
		Business business=new Business((Integer)1,(Integer)10,"Manufacturer",(Long)50000L,(Long)20000L,(Integer)20,(Integer)2,(Integer)2);
		businessRepository.save(business);
		
		Property property=new Property((Integer)10,"Business Property Insurance","Warehouse",(Long)40000L,1,"2000","Rental",(Integer)5,(Long)1000000L,(Long)800000L,(Integer)5);
		propertyRepository.save(property);
	}
}
