package main;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.remoting.service.AmqpInvokerServiceExporter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import service.MarvelHeroService;

@Configuration
public class MarvelHeroServiceConfig {
    @Bean
    Queue queue() {
        return new Queue(MarvelHeroService.class.getSimpleName());
    }

    @Bean
    AmqpInvokerServiceExporter exporter(MarvelHeroService personService, AmqpTemplate template) {
        AmqpInvokerServiceExporter exporter = new AmqpInvokerServiceExporter();
        exporter.setServiceInterface(MarvelHeroService.class);
        exporter.setService(personService);
        exporter.setAmqpTemplate(template);
        return exporter;
    }

    @Bean
    SimpleMessageListenerContainer listener(ConnectionFactory factory, AmqpInvokerServiceExporter exporter, Queue queue) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(factory);
        container.setMessageListener(exporter);
        container.setQueueNames(queue.getName());
        return container;
    }
}
