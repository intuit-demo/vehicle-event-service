package com.intuit.vehicleeventservice.common.testcontainers;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.springframework.stereotype.Component;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;

@Slf4j
@Component
public class MongoDbTestContainerWrapper implements BeforeAllCallback {

    @Container
    public static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:4.4.2").withEnv("MONGO_INITDB_DATABASE", "local")
            .withEnv("MONGO_INIT_ROOT_USERNAME", "admin").withEnv("MONGO_INIT_ROOT_PASSWORD", "admin");

    static {
        mongoDBContainer.start();
    }

    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.data.mongodb.host", () -> mongoDBContainer.getHost());
        registry.add("spring.data.mongodb.port", () -> mongoDBContainer.getFirstMappedPort());
        registry.add("spring.data.mongodb.database", () -> "intuit");
    }

    @Override
    public void beforeAll(ExtensionContext extensionContext) throws Exception {
        System.setProperty("spring.data.mongodb.host", mongoDBContainer.getHost());
        System.setProperty("spring.data.mongodb.port", mongoDBContainer.getFirstMappedPort().toString());
        System.setProperty("spring.data.mongodb.database", "intuit");
    }
}
