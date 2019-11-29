package epam.data.complaints;

import epam.data.complaints.repository.ComplaintRepository;
import epam.data.configuration.DataIntegrationTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;

@DataIntegrationTest
class ComplaintFileLoaderTest {

    @Autowired
    private ComplaintFileLoader complaintFileLoader;
    @Autowired
    private ComplaintRepository complaintRepository;

    @AfterEach
    void tearDown() {
        complaintRepository.truncateTable();
    }

    @Test
    void loadData() throws SQLException {
        complaintFileLoader.loadData();
        Assertions.assertNotEquals(0, complaintRepository.findAll().size());
    }
}