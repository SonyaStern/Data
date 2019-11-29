package epam.data.complaints.repository;

import epam.data.complaints.ComplaintFileLoader;
import epam.data.complaints.model.FilterByCompanyResultModel;
import epam.data.configuration.DataIntegrationTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.List;

@DataIntegrationTest
class FilterByCompanyRepositoryTest {

  @Autowired
  private FilterByCompanyRepository filterByCompanyRepository;
  @Autowired
  private ComplaintFileLoader complaintFileLoader;
  @Autowired
  private ComplaintRepository complaintRepository;

  @BeforeEach
  void setUp() throws SQLException {
    complaintFileLoader.loadData();
  }

  @AfterEach
  void tearDown() {
    complaintRepository.truncateTable();
  }

  @Test
  void getAllByCompany() {
    List<FilterByCompanyResultModel> allByCompany = filterByCompanyRepository.getAllByCompany("Wells Fargo & Company");
    for (FilterByCompanyResultModel result : allByCompany) {
      System.out.println(result.getStateName() + " | "
          + result.getNumberOfComplaints());
    }
    Assertions.assertNotEquals(0, allByCompany.size());
  }
}