package com.intuit.vehicleeventservice.karate.integration;

import com.intuit.karate.Runner;
import com.intuit.vehicleeventservice.VehicleEventServiceApplication;
import com.intuit.vehicleeventservice.common.testcontainers.KafkaTestContainerWrapper;
import com.intuit.vehicleeventservice.common.testcontainers.MongoDbTestContainerWrapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.AssertionErrors;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = VehicleEventServiceApplication.class
)
@Testcontainers
@ActiveProfiles("test")
@DirtiesContext
@ExtendWith(value = {SpringExtension.class, KafkaTestContainerWrapper.class, MongoDbTestContainerWrapper.class})
public class KarateIntegrationTestIT {

    @LocalServerPort
    int port;

    @Test
    void testParallel() {
        String tags = "~@ignore";
        var r = Runner.path("classpath:karate").tags(tags)
                .systemProperty("local.server.port", port + "")
                .parallel(1);
        AssertionErrors.assertEquals(r.getErrorMessages(), 0, r.getFailCount());
    }
}
