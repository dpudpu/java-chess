package chess.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class TableCreator {
    public static final String SRC_MAIN_RESOURCES_SCHEMA_SQL = "src/main/resources/schema.sql";
    private static final Logger LOGGER = LoggerFactory.getLogger(TableCreator.class);
    private static final String SEMICOLON_DELIMITER = ";";
    private static TableCreator INSTANCE = null;

    private DbConnector dbConnector;

    private TableCreator(final DbConnector dbConnector) throws Exception {
        this.dbConnector = dbConnector;
        create();
    }

    public static TableCreator create(final DbConnector dbConnector) throws Exception {
        if(INSTANCE== null){
            INSTANCE = new TableCreator(dbConnector);
        }
        return INSTANCE;
    }

    private void create() throws Exception {
        File file = new File(SRC_MAIN_RESOURCES_SCHEMA_SQL);
        FileInputStream fis = new FileInputStream(file);

        String[] querys = getFileContent(fis).split(SEMICOLON_DELIMITER);
        for (final String query : querys) {
            Connection connection = dbConnector.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.executeUpdate();
            ps.close();
            LOGGER.info(query);
        }
    }

    public String getFileContent(FileInputStream fis) throws IOException {
        StringBuilder sb = new StringBuilder();
        Reader r = new InputStreamReader(fis, StandardCharsets.UTF_8);
        char[] buf = new char[1024];
        int amt = r.read(buf);
        while (amt > 0) {
            sb.append(buf, 0, amt);
            amt = r.read(buf);
        }
        return sb.toString();
    }
}
