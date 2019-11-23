package epam.data.complaints;

import epam.data.complaints.repository.ComplaintRepository;
import epam.data.configuration.DataIntegrationTest;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;

@DataIntegrationTest
class ComplaintRepositoryTest {

    @Autowired
    private ComplaintRepository complaintRepository;
    @Autowired
    private FileLoader fileLoader;

    @BeforeEach
    void setUp() throws SQLException {
        fileLoader.loadData();
    }

//    @Test
//    void shouldFilter() {
//        List<FilterByDateResultModel> results = complaintRepository.filterByDate(LocalDate.of(2013, 7, 29), LocalDate.of(2013, 7, 30));
//        System.out.println(results);
////        for (FirstFilterModel result : results) {
////            System.out.println(result.getProductName() + " | " + result.getNumberOfComplaints());
////        }
//        Assertions.assertNotNull(results);
//    }
}