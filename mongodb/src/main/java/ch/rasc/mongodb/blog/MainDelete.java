package ch.rasc.mongodb.blog;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.WriteResult;

public class MainDelete {
	public static void main(final String[] args) throws UnknownHostException, MongoException {
		Mongo mongo = new Mongo("localhost");

		DB db = mongo.getDB("testdb");
		// db.setWriteConcern(WriteConcern.SAFE);

		// db.dropDatabase();

		DBCollection collection = db.getCollection("users");
		// collection.drop();

		BasicDBObject deleteCriteria = new BasicDBObject();
		deleteCriteria.append("enabled", false);
		deleteCriteria.append("noOfLogins", 0);
		System.out.println(deleteCriteria);
		WriteResult wr = collection.remove(deleteCriteria);
		System.out.println(wr);

		DBCursor cursor = collection.find();
		while (cursor.hasNext()) {
			DBObject dbo = cursor.next();
			System.out.println(dbo);
		}

		mongo.close();

	}
}
