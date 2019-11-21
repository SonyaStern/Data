package epam.data.complaints;

import epam.data.configuration.DataIntegrationTest;
import java.io.IOException;
import java.sql.SQLException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URISyntaxException;

@DataIntegrationTest
class FileLoaderTest {

    @Autowired
    private FileLoader fileLoader;

    @Test
    void loadData() throws URISyntaxException, IOException, SQLException {
        fileLoader.loadData();
    }
}