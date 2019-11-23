package epam.data.complaints;

import epam.data.complaints.repository.ComplaintRepository;
import epam.data.configuration.DataIntegrationTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;

@DataIntegrationTest
class FileLoaderTest {

    @Autowired
    private FileLoader fileLoader;
    @Autowired
    private ComplaintRepository complaintRepository;

    @AfterEach
    void tearDown() {
        complaintRepository.deleteAll();
    }

    @Test
    void loadData() throws SQLException {
        fileLoader.loadData();
        Assertions.assertNotEquals(0, complaintRepository.findAll().size());
    }
}