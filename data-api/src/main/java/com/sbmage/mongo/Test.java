package com.sbmage.mongo;

import java.util.Map;
import java.util.Set;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class Test {
	
	private static final Logger logger = LoggerFactory.getLogger(Test.class);
	
	private static MongoClient mongoClient;
	private static DB db;

	public static void main(String[] args) {
		
		logger.info(DateTime.now(DateTimeZone.forID("Asia/Seoul")).toString("yyyy-MM-dd HH:mm:ss"));
		
		
		/*
		try {
			
			 * MongoDb Connection
			 
			mongoClient = new MongoClient("14.63.222.114", 27018);
			db = mongoClient.getDB("game_log");
			boolean auth = db.authenticate("sbmage", "1234".toCharArray());
			
			// 而щ젆?占쏙옙 紐⑸줉
			getCollections(db);
			
			// createCollection(db, "mongoTest");
			
			
			Map<String, Object> insertDoc = new HashMap<String, Object>();
			insertDoc.put("gimme_id", "114294967354");
			insertDoc.put("game_id", "kutarforgimme");
			insertDoc.put("reg_date", 1406021612);
			
			insertDocument(db, "mongoTest", insertDoc);
			
			
			getFind(db, "mongoTest");
			
			
			
			Map<String, String> query = new HashMap<String, String>();
			query.put("kakao_id", "88204110320677856");
			query.put("game_id", "kutar");
			query.put("login_date", "1383704549747");
			
			getFindQuery(db, "test", query);
			
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}
	
	
	/**
	 * 而щ젆?占쏙옙 ?占쏙옙?占쏙옙
	 * 
	 * @param db
	 * @param name
	 */
	public static void createCollection(DB db, String name) {
		DBObject dbObject = new BasicDBObject();
		DBCollection collection = db.createCollection(name, dbObject);
		
		logger.info("-------- createCollection :: name = " + name + " --------");
	}
	
	
	
	
	/**
	 * 而щ젆?占쏙옙 紐⑸줉 異쒕젰
	 * 
	 * @param db
	 */
	public static void getCollections(DB db) {

		Set<String> colls = db.getCollectionNames();

		for (String string : colls) {
			logger.info(string);
		}
		logger.info("-------- getCollections --------");
	}
	
	
	/**
	 * 而щ젆?占쏙옙 ?占쏙옙?占쏙옙
	 * 
	 * @param db
	 * @param name
	 * @param insertDoc
	 */
	public static void insertDocument(DB db, String name, Map<String, Object> insertDoc) {
		DBCollection collection = db.getCollection(name);
		
		
		BasicDBObject doc = new BasicDBObject();
		for (String s : insertDoc.keySet()) {
			doc.append(s, insertDoc.get(s));
		}
		collection.insert(doc);
		
		logger.info("-------- insertDocument --------");
	}

	/**
	 * 而щ젆?占쏙옙 占�??占쏙옙
	 * 
	 * @param db
	 * @param name
	 */
	public static void getFind(DB db, String name) {
		DBCollection collection = db.getCollection(name);
		
		DBCursor cursor = collection.find();

		while (cursor.hasNext()) {
			logger.info(cursor.next().toString());
		}
		logger.info("------- getFind :: collection = " + name + ", count = " + collection.count() + "---------");
		
	}

	/**
	 * 荑쇰━ 占�??占쏙옙
	 * 
	 * @param db
	 * @param name
	 * @param query
	 */
	public static void getFindQuery(DB db, String name, Map<String, String> query) {
		DBCollection collection = db.getCollection(name);
		DBCursor cursor;
		
		BasicDBObject searchQuery = new BasicDBObject();
		for (String q : query.keySet()) {
			searchQuery.put(q, query.get(q));
		}
		cursor = collection.find(searchQuery);
		while (cursor.hasNext()) {
			logger.info(cursor.next().toString());
		}
		logger.info("------- getFindQuery :: query = " + query.toString() +" ---------");
	}
}
