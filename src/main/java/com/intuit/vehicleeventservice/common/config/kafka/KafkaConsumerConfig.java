package com.intuit.vehicleeventservice.common.config.kafka;

import com.intuit.vehicleeventservice.common.config.deserializer.VehicleOverSpeedNotificationEventDeserializer;
import com.intuit.vehicleeventservice.common.config.deserializer.VehicleRealTimeEventDeserializer;
import com.intuit.vehicleeventservice.service.dto.VehicleOverSpeedEvent;
import com.intuit.vehicleeventservice.service.dto.VehicleRealTimeEvent;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
@Import(value = {KafkaConsumerConfig.VehicleRealTimeEventListenerConfig.class, KafkaConsumerConfig.VehicleOverSpeedNotificationEventListenerConfig.class})
public class KafkaConsumerConfig {

    @Configuration
    public static class VehicleRealTimeEventListenerConfig {

        @Value("${spring.kafka.bootstrap-servers}")
        private String bootstrapServers;

        @Bean
        public Map<String, Object> vehicleRealTimeEventListenerConsumerConfigs() {
            Map<String, Object> props = new HashMap<>();
            props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, this.bootstrapServers);
            props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
            props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, VehicleRealTimeEventDeserializer.class.getName());
            return props;
        }

        @Bean
        public ConsumerFactory<String, VehicleRealTimeEvent> vehicleRealTimeEventListenerConsumerFactory() {
            return new DefaultKafkaConsumerFactory<>(vehicleRealTimeEventListenerConsumerConfigs());
        }

        @Bean
        public ConcurrentKafkaListenerContainerFactory<String, VehicleRealTimeEvent> vehicleRealTimeEventListenerContainerFactory() {
            ConcurrentKafkaListenerContainerFactory<String, VehicleRealTimeEvent> factory = new ConcurrentKafkaListenerContainerFactory<>();
            factory.setConsumerFactory(vehicleRealTimeEventListenerConsumerFactory());
            return factory;
        }
    }

    @Configuration
    static class VehicleOverSpeedNotificationEventListenerConfig {
        @Value("${spring.kafka.bootstrap-servers}")
        private String bootstrapServers;

        @Bean
        public Map<String, Object> vehicleOverSpeedNotificationEventListenerConsumerConfigs() {
            Map<String, Object> props = new HashMap<>();
            props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, this.bootstrapServers);
            props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
            props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, VehicleOverSpeedNotificationEventDeserializer.class.getName());
            return props;
        }

        @Bean
        public ConsumerFactory<String, VehicleOverSpeedEvent> vehicleOverSpeedNotificationEventListenerConsumerFactory() {
            return new DefaultKafkaConsumerFactory<>(vehicleOverSpeedNotificationEventListenerConsumerConfigs());
        }

        @Bean
        public ConcurrentKafkaListenerContainerFactory<String, VehicleOverSpeedEvent> vehicleOverSpeedNotificationEventListenerContainerFactory() {
            ConcurrentKafkaListenerContainerFactory<String, VehicleOverSpeedEvent> factory = new ConcurrentKafkaListenerContainerFactory<>();
            factory.setConsumerFactory(vehicleOverSpeedNotificationEventListenerConsumerFactory());
            return factory;
        }
    }
}
