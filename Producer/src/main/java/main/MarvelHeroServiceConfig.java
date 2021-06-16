package main;

import org.springframework.amqp.core.*;
import org.springframework.amqp.remoting.client.AmqpProxyFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import service.MarvelHeroService;

@Configuration
public class MarvelHeroServiceConfig {

    @Bean
    Queue personQueue() {
        return new Queue(MarvelHeroService.class.getSimpleName());
    }

    @Bean
    AmqpProxyFactoryBean marvelHeroServiceAmqp(
            AmqpTemplate amqpTemplate) {
        AmqpProxyFactoryBean factoryBean = new AmqpProxyFactoryBean();
        factoryBean.setAmqpTemplate(amqpTemplate);
        factoryBean.setServiceInterface(MarvelHeroService.class);
        factoryBean.setRoutingKey(MarvelHeroService.class.getSimpleName());
        return factoryBean;
    }

    @Bean
    Binding marvelBinding(Queue marvelQueue, DirectExchange exchange) {
        return BindingBuilder
                .bind(marvelQueue)
                .to(exchange)
                .with(MarvelHeroService.class.getSimpleName());
    }
}