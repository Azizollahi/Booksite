package infrastructure.config;

import domain_service.top_records.RecordCalculatorImpl;
import domain_service_interfaces.top_records.RecordCalculator;
import org.springframework.context.annotation.Bean;

public class DomainServiceBeans {
	@Bean
	public RecordCalculator getRecordCalculator(){
		return new RecordCalculatorImpl();
	}
}
