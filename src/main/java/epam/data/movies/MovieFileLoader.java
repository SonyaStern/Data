package epam.data.movies;

import lombok.RequiredArgsConstructor;
import org.postgresql.PGConnection;
import org.postgresql.copy.CopyManager;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static epam.data.utils.DataConstants.URL;
import static epam.data.utils.DataConstants.USER_PASS;

@Component
@RequiredArgsConstructor
public class MovieFileLoader {

    @SuppressWarnings("Duplicates")
    public void loadData() throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER_PASS, USER_PASS);
        CopyManager copyManager = connection.unwrap(PGConnection.class).getCopyAPI();

        String copyCommand = "COPY movies "
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
