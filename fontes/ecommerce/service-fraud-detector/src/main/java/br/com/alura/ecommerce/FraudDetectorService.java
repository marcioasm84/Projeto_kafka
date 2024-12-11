package br.com.alura.ecommerce;

import java.util.HashMap;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public class FraudDetectorService {

	public static void main(String[] args) {
		var fraudService = new FraudDetectorService();
		
		try( 
			var service = new KafkaService<>(FraudDetectorService.class.getSimpleName(),
											"ECOMMERCE_NEW_ORDER", 
											fraudService::parse,
											Order.class,
											new HashMap<>())
		) {
			service.run();		
		}
	}

	private void parse(ConsumerRecord<String, Order> record) {
		System.out.println("-----------------------------------------");
		System.out.println("Processing new order, checking for fraud");
		System.out.println("key: " + record.key());
		System.out.println("value: " + record.value());
		System.out.println("partition: " + record.partition());
		System.out.println("offset: " + record.offset());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Order processed");
	}
	
}
