package models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sql2o.Sql2o;

import java.net.URI;
import java.net.URISyntaxException;

public class DB {
    private static URI dbUri;
    public static Sql2o sql2o;
    private static String dblink = "postgres://localhost:5432/wildlife_tracker";

    static Logger logger = LoggerFactory.getLogger(DB.class);
    static {
        try {
            if (System.getenv("DATABASE_URL") == null) {
                dbUri = new URI(dblink);
            } else {
                dbUri = new URI(System.getenv("DATABASE_URL"));
            }
            int port = dbUri.getPort();
            String host = dbUri.getHost();
            String path = dbUri.getPath();
            String username = (dbUri.getUserInfo() == null) ? "danny" : dbUri.getUserInfo().split(":")[0];
            String password = (dbUri.getUserInfo() == null) ? "newpsqlpass" : dbUri.getUserInfo().split(":")[1];
//            sql2o = new Sql2o("jdbc:postgresql://" + host + ":" + port + path, username, password);
            String connectionString = "jdbc:postgresql://ec2-54-156-85-145.compute-1.amazonaws.com:5432/d2gmv0ujh4o07p";
            sql2o = new Sql2o(connectionString, "bhdcmulxsixfoj","43ba57b7cb70bad3f1d0775eedd1d80c26ea19585e726c6c0437e889b9a81f22");
        } catch (URISyntaxException e ) {
            logger.error("Unable to connect to database.");
        }
    }
}
