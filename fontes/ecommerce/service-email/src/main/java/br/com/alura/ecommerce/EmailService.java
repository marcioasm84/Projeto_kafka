package br.com.alura.ecommerce;

import java.util.HashMap;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public class EmailService {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		var emailService = new EmailService();
		try( 
			var service = new KafkaService(EmailService.class.getSimpleName(), 
										"ECOMMERCE_SEND_EMAIL", 
										emailService::parse,
										String.class,
										new HashMap<>())
		) {
			service.run();
		}
	}
	
	private void parse(ConsumerRecord<String, String> record) {
		System.out.println("-----------------------------------------");
		System.out.println("Send Email");
		System.out.println("key: " + record.key());
		System.out.println("value: " + record.value());
		System.out.println("partition: " + record.partition());
		System.out.println("offset: " + record.offset());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Email Sent");
	}

}
