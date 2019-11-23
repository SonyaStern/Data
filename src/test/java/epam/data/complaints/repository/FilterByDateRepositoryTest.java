package epam.data.complaints.repository;

import epam.data.complaints.FileLoader;
import epam.data.complaints.model.FilterByDateResultModel;
import epam.data.configuration.DataIntegrationTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@DataIntegrationTest
class FilterByDateRepositoryTest {

    @Autowired
    private FilterByDateRepository filterByDateRepository;
    @Autowired
    private FileLoader fileLoader;
    @Autowired
    private ComplaintRepository complaintRepository;

    @BeforeEach
    void setUp() throws SQLException {
        fileLoader.loadData();
    }

    @AfterEach
    void tearDown() {
        complaintRepository.deleteAll();
    }

    @Test
    void test2() {
        List<FilterByDateResultModel> allByDate = filterByDateRepository.getAllByDate(LocalDate.of(2013, 7, 29), LocalDate.of(2013, 8, 31));
        for (FilterByDateResultModel result : allByDate) {
            System.out.println(result.getProductName() + " | "
                    + result.getNumberOfComplaints() + " | "
                    + result.getNumberOfComplaintsWithTimelyResponse() + " | "
                    + result.getNumberOfComplaintsDisputedByCustomer());
            Assertions.assertTrue(result.getNumberOfComplaints() >= result.getNumberOfComplaintsWithTimelyResponse());
            Assertions.assertTrue(result.getNumberOfComplaints() >= result.getNumberOfComplaintsDisputedByCustomer());
        }
    }
}