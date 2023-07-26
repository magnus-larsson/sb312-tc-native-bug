package se.magnus.microservices.core.product;

import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MongoDBContainer;

public abstract class MongoDbTestBase {

  // TODO: Does not native compile! Fails on:
  // org.springframework.boot.autoconfigure.service.connection.ConnectionDetailsNotFoundException: No ConnectionDetails found for source '@ServiceConnection source for MongoDbTestBase.database'
  @ServiceConnection
  private static MongoDBContainer database = new MongoDBContainer("mongo:6.0.4");

  static {
    database.start();
  }

//  @DynamicPropertySource
//  static void setProperties(DynamicPropertyRegistry registry) {
//    registry.add("spring.data.mongodb.host", database::getContainerIpAddress);
//    registry.add("spring.data.mongodb.port", () -> database.getMappedPort(27017));
//    registry.add("spring.data.mongodb.database", () -> "test");
//  }

}
