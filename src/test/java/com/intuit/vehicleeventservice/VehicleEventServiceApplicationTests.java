package com.intuit.vehicleeventservice;

import com.intuit.vehicleeventservice.common.testcontainers.KafkaTestContainerWrapper;
import com.intuit.vehicleeventservice.common.testcontainers.MongoDbTestContainerWrapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.junit.jupiter.Testcontainers;


@SpringBootTest
@ActiveProfiles("test")
@ExtendWith(value = {KafkaTestContainerWrapper.class, MongoDbTestContainerWrapper.class})
@Testcontainers
@DirtiesContext
@ExtendWith(SpringExtension.class)
class VehicleEventServiceApplicationTests {

    @Test
    void contextLoads() {
    }

}
