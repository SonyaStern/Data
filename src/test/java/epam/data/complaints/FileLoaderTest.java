package epam.data.complaints;

import epam.data.configuration.DataIntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URISyntaxException;

@DataIntegrationTest
class FileLoaderTest {

    @Autowired
    private FileLoader fileLoader;

    @Test
    void loadData() throws URISyntaxException {
        fileLoader.loadData();
        System.out.println("ok");
    }
}