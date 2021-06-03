package util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DatabaseUtil {

    private static final HikariDataSource hikariDataSource;

    static {

        HikariConfig configuration = new HikariConfig();
        configuration.setDriverClassName("com.mysql.cj.jdbc.Driver");
        configuration.setUsername("root");
        configuration.setPassword("Alone2222`");
        configuration.setJdbcUrl("jdbc:mysql://localhost:3306/java_todolist?serverTimeZone=Asia/Jakarta");

        // pool
        configuration.setMaximumPoolSize(10);
        configuration.setMinimumIdle(5);
        configuration.setIdleTimeout(60000);
        configuration.setMaxLifetime(60 * 60 * 1000);

        hikariDataSource = new HikariDataSource(configuration);

    }

    public static HikariDataSource getDataSource() {

        return hikariDataSource;

    }

}
