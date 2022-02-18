package bdn_mdbj_act6;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * @author DANIELA
 */
public class Conexion {
     DB base_datos;
    DBCollection coleccion;
    BasicDBObject documento = new BasicDBObject();    
    public  Conexion(){
        try{
            Mongo mongo = new Mongo("Localhost", 27017);
            base_datos = mongo.getDB("Mascotas");
            coleccion = base_datos.getCollection("mascota");
            System.out.println("Coneccion establecida");
            
        }catch(UnknownHostException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void mostrar(){
        DBCursor cursor = coleccion.find();
        while(cursor.hasNext()){
            System.out.println(cursor.next());
        }
    } 
      public  boolean insertar(String nombre, String tipo, int edad){
        documento.append("Nombre",nombre).append("Tipo", tipo).append("Edad", edad);
        coleccion.insert(documento);
        return true;
    }  
     public boolean eliminar(String nombre, String tipo, int edad){
        documento.append("Nombre",nombre).append("Tipo", tipo).append("Edad", edad);
        coleccion.remove(documento);
        return true;
    }
     public boolean actualizar(String nombre, String tipo, int edad, String nombre_nuevo, String tipo_nuevo, int edad_nuevo){
       documento.append("Nombre",nombre).append("Tipo", tipo).append("Edad", edad);
        BasicDBObject documento_nuevo = new BasicDBObject();
        documento_nuevo.append("Nombre",nombre_nuevo).append("Tipo", tipo_nuevo).append("Edad", edad_nuevo);
        ///buscamos el ducumento y lo modificaos
        coleccion.findAndModify(documento, documento_nuevo);
        return true;
    }
}
