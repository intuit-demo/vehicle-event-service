package com.intuit.vehicleeventservice.common.testcontainers;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.springframework.stereotype.Component;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@Slf4j
@Component
@Testcontainers
public class KafkaTestContainerWrapper implements BeforeAllCallback {

    @Container
    public static KafkaContainer kafka =
            new KafkaContainer(DockerImageName.parse("confluentinc/cp-kafka:7.3.3")
                    .asCompatibleSubstituteFor("confluentinc/cp-kafka"));

    static {
        kafka.start();
    }

    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.kafka.bootstrap-servers", () -> kafka.getBootstrapServers());
    }

    @Override
    public void beforeAll(ExtensionContext extensionContext) throws Exception {
        System.setProperty("spring.kafka.bootstrap-servers", kafka.getBootstrapServers());
    }
}
