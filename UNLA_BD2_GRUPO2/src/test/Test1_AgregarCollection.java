package test;

import com.mongodb.client.*;

public class Test1_AgregarCollection {

	public static void main(String[] args) {
		// Connection string a base de datos en la nube
		// MongoClient mongoClient = MongoClients.create(
		// "mongodb+srv://unlabd2user:ooGkBKgDYC6UxVGX@cluster0-yj1yu.gcp.mongodb.net/test?retryWrites=true&w=majority");
		// MongoDatabase database = mongoClient.getDatabase("test");
		// ------------------------------------------------------------------------------------------------------------------

		// Acá creamos la conexión con la base de datos local porque utilizamos el
		// create() sin parametros.
		MongoClient mongoClient = MongoClients.create();
		// Tomamos la base de datos que queremos usar en este caso test que es la que
		// nos da MongoDB por default
		MongoDatabase database = mongoClient.getDatabase("test");
		// Creo una collection de prueba
		database.createCollection("test_collection_local");

		// Lista de collections en la base
		MongoIterable<String> collections = database.listCollectionNames();

		// Muestra la collections en consola
		for (String collectionName : collections) {
			System.out.println(collectionName);
		}
	}

}