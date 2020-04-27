package test;

import java.util.ArrayList;
import java.util.List;

import org.bson.*;
import org.bson.conversions.*;
import com.mongodb.client.*;
import com.mongodb.client.model.*;

public class Test1_EliminarDocumento {
	public static void main(String[] args) {
	    // Connection string a base de datos en la nube
	    //MongoClient mongoClient = MongoClients.create(
		//    "mongodb+srv://unlabd2user:ooGkBKgDYC6UxVGX@cluster0-yj1yu.gcp.mongodb.net/test?retryWrites=true&w=majority");
		//MongoDatabase database = mongoClient.getDatabase("test");
		//------------------------------------------------------------------------------------------------------------------	
			
		// Acá creamos la conexión con la base de datos local porque utilizamos el create() sin parametros.
		MongoClient mongoClient = MongoClients.create();
	    // Tomamos la base de datos que queremos usar en este caso test que es la que nos da MongoDB por default
	    MongoDatabase database = mongoClient.getDatabase("test"); 
	    // Obtener collection
	    MongoCollection<Document> collectionLocal = database.getCollection("test_collection_local2");
	    // Filtro del documento que quiero eliminar
	    Bson filtro = Filters.eq("universidad", "universidad nacional de lanus");
	    collectionLocal.deleteOne(filtro);
	    
	    List<Document> documents = (List<Document>) collectionLocal.find().into(
				new ArrayList<Document>());

	    for(Document document : documents){
	         System.out.println(document);
	    }
	}
}
