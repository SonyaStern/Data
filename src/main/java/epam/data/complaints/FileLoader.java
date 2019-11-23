package epam.data.complaints;

import lombok.RequiredArgsConstructor;
import org.postgresql.PGConnection;
import org.postgresql.copy.CopyManager;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
@RequiredArgsConstructor
public class FileLoader {

    public void loadData() throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:tc:postgresql:10.7-alpine:///data", "data",
                "data");
        CopyManager copyManager = connection.unwrap(PGConnection.class).getCopyAPI();

        String copyCommand = "COPY complaints(received, product_name, sub_product, issue, sub_issue, "
                + "narrative, public_response, company, state_name, zip_code, tags, consent_provided, submitted_via, "
                + "sent, response_to_consumer, timely_response, consumer_disputed, id) "
                + "FROM STDIN "
                + "WITH (DELIMITER ',', FORMAT csv, HEADER)";

    long before = System.nanoTime();
    System.out.println(before);

        try {
            copyManager.copyIn(copyCommand, getClass().getClassLoader().getResource("ConsumerComplaints.csv").openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    long after = System.nanoTime();
    System.out.println(after);
    System.out.println(after - before);
  }
}
