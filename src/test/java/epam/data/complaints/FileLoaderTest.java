package epam.data.complaints;

import epam.data.configuration.DataIntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;

@DataIntegrationTest
class FileLoaderTest {

    @Autowired
    private FileLoader fileLoader;

    @Test
    void loadData() throws SQLException {
        fileLoader.loadData();
    }
}