package epam.data.complaints;

import epam.data.configuration.DataIntegrationTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@DataIntegrationTest
class ComplaintRepositoryTest {

    @Autowired
    private ComplaintRepository complaintRepository;

    @Test
    void shouldSave() {
        ComplaintModel complaintModel = ComplaintModel.builder()
                .complaintID(1L)
                .productName("product Name")
                .build();

        complaintRepository.save(complaintModel);
        ComplaintModel savedModel = complaintRepository.getOne(1L);
        Assertions.assertEquals(complaintModel.getProductName(), savedModel.getProductName());
    }
}