package epam.data.complaints.repository;

import epam.data.complaints.FileLoader;
import epam.data.complaints.FilterByDateSpecification;
import epam.data.complaints.filter.DateFilter;
import epam.data.complaints.model.FilterByDateResultModel;
import epam.data.configuration.DataIntegrationTest;
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

    @BeforeEach
    void setUp() throws SQLException {
        fileLoader.loadData();
    }

    @Test
    void test() {
        DateFilter dateFilter = DateFilter
                .builder()
                .fromDate(LocalDate.of(2013, 7, 29))
                .toDate(LocalDate.of(2013, 7, 31))
                .build();
        List<FilterByDateResultModel> results = filterByDateRepository.findAll(new FilterByDateSpecification(dateFilter));
        System.out.println(results);
        for (FilterByDateResultModel result : results) {
            System.out.println(result.getProductName() + " | " + result.getNumberOfComplaints());
        }
    }

    @Test
    void test2() {
        List<FilterByDateResultModel> allByDate = filterByDateRepository.getAllByDate(LocalDate.of(2013, 7, 29), LocalDate.of(2013, 8, 31));
        for (FilterByDateResultModel result : allByDate) {
            System.out.println(result.getProductName() + " | " + result.getNumberOfComplaints() + " | " + result.getNumberOfComplaintsWithTimelyResponse() + " | " + result.getNumberOfComplaintsDisputedByCustomer());
        }
    }
}