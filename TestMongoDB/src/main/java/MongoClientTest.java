import com.mongodb.*;

import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

public class MongoClientTest {
    public static final void main(String[] args)
            throws UnknownHostException {
        //MongoClient mongoClient =new MongoClient(new MongoClientURI("mongodb://cluster0-shard-00-01-05ugn.mongodb.net:27017");}
        String user = "parag"; // the user name
        String database = "admin"; // the name of the database in which the user is defined
        char[] password = new char[]{'P', 'a', 'r', 'a', 'g', '@', '1', '2', '3','4'}; // the password as a character array
        // ...

        MongoCredential credential = MongoCredential.createCredential(user, database, password);

        MongoClientOptions options = MongoClientOptions.builder().sslEnabled(true).build();

        MongoClient mongoClient = new MongoClient(new ServerAddress("cluster0-shard-00-01-05ugn.mongodb.net", 27017),
                Arrays.asList(credential),
                options);
        //DB db = (DB) mongoClient.getDatabase("video");
        List<String> dbs = mongoClient.getDatabaseNames();
        System.out.println(dbs);

    }
}
