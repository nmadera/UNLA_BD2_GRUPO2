package test;

import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import com.mongodb.client.*;

public class Test1_ListarCollectionsYDocumentos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Connection string a base de datos en la nube
		//MongoClient mongoClient = MongoClients.create(
	    //    "mongodb+srv://unlabd2user:ooGkBKgDYC6UxVGX@cluster0-yj1yu.gcp.mongodb.net/test?retryWrites=true&w=majority");
	    //MongoDatabase database = mongoClient.getDatabase("test");
		//------------------------------------------------------------------------------------------------------------------
		
		// Acá creamos la conexión con la base de datos (por default local)
		MongoClient mongoClient = MongoClients.create();
	    // Tomamos la base de datos que queremos usar en este caso test que es la que nos da MongoDB por default
	    MongoDatabase database = mongoClient.getDatabase("test"); 

	    // Lista de collections en la base
	    MongoIterable <String> collections = database.listCollectionNames();
	    
	    // Muestra collections y sus documentos en consola
	    for (String collectionName : collections) {
	    	
	        System.out.println(collectionName);
	        MongoCollection<Document> collection = database.getCollection(collectionName);
	        
	        // Mostrar los documentos de la collection
	        List<Document> documents = (List<Document>) collection.find().into(
	    			new ArrayList<Document>());

	        for(Document document : documents){
	             System.out.println(document);
	        }
	        
	    }
		
	    
	}

}
