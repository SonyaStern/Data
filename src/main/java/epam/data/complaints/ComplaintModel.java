package epam.data.complaints;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "complaint")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ComplaintModel {

    private LocalDate received;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "sub_product")
    private String subProduct;
    private String issue;
    @Column(name = "sub_issue")
    private String subIssue;
    private String narrative;
    @Column(name = "public_response")
    private String publicResponse;
    private String company;
    @Column(name = "state_name")
    private String stateName;
    @Column(name = "zip_code")
    private String zipCode;
    private String tags;
    @Column(name = "consent_provided")
    private String consentProvided;
    @Column(name = "submitted_via")
    private String submittedVia;
    private LocalDate sent;
    @Column(name = "response_to_consumer")
    private String responseToConsumer;
    @Column(name = "timely_response")
    private String timelyResponse;
    @Column(name = "consumer_disputed")
    private String consumerDisputed;
    @Id
    @Column(name = "id")
    private Long complaintID;

}
