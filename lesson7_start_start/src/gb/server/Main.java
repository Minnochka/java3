package gb.server;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.*;

public class Main {
    private static final Logger logger = Logger.getLogger(gb.server.Main.class.getName());
    private static Handler handler;


    public static void main(String[] args) throws SQLException {

        {
            try {
                handler = new FileHandler("server.log", true);
                handler.setLevel(Level.ALL);
                handler.setFormatter(new SimpleFormatter());
                logger.addHandler(handler);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        new Server(logger, handler);
    }
}
