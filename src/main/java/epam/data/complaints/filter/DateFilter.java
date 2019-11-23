package epam.data.complaints.filter;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class DateFilter {

    private LocalDate fromDate;
    private LocalDate toDate;
}
