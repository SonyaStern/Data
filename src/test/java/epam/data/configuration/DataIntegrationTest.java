package epam.data.configuration;

import epam.data.DataApplication;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@ExtendWith({SpringExtension.class})
@SpringBootTest(
        classes = DataApplication.class,
        properties = {
                "spring.datasource.url=jdbc:tc:postgresql:10.7-alpine:///databasename",
                "spring.datasource.driver-class-name=org.testcontainers.jdbc.ContainerDatabaseDriver",
        }
)
public @interface DataIntegrationTest {
}
