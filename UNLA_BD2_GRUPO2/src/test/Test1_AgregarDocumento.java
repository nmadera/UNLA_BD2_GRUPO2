package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Test1_AgregarDocumento {

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

		// Documento de prueba
		Document documento = new Document("universidad", "universidad nacional de lanus")
				.append("carrera", "licenciatura en sistemas")
				.append("materias", Arrays.asList("ejemplo1", "ejemplo2", "ejemplo3"))
				.append("alumnos", new Document("ejemplo1", 12345678).append("ejemplo2", 12345678));

		// Obtener collection creada anteriormente
		MongoCollection<Document> collectionLocal = database.getCollection("test_collection_local");

		// Esta linea de abajo inserta el documento de arriba a la coleccion
		collectionLocal.insertOne(documento);

		// Mostrar los documentos de la collection
		List<Document> documents = (List<Document>) collectionLocal.find().into(new ArrayList<Document>());

		for (Document document : documents) {
			System.out.println(document);
		}

	}
}
