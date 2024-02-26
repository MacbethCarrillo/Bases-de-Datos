
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.AbstractTableModel;


public class ResultSetTableModel extends AbstractTableModel 
{
   private Connection conexion;
   private Statement instruccion;
   private ResultSet conjuntoResultados;
   private ResultSetMetaData metaDatos;
   private int numeroDeFilas;

   // lleva la cuenta del estado de la conexi�n a la base de datos
   private boolean conectadoABaseDatos = false;
   
   // el constructor inicializa conjuntoResultados y obtiene su objeto de metadatos;
   // determina el n�mero de filas
   public ResultSetTableModel( String controlador,String url, String nombreusuario,
      String contrasenia, String consulta ) 
      throws SQLException, ClassNotFoundException
   {         
      // se conecta a la base de datos
      Class.forName( controlador );
      conexion = DriverManager.getConnection( url, nombreusuario, contrasenia );

      // crea objeto Statement para consultar la base de datos
      instruccion = conexion.createStatement( 
         ResultSet.TYPE_SCROLL_INSENSITIVE,
         ResultSet.CONCUR_READ_ONLY );

      // actualiza el estado de la conexi�n a la base de datos
      conectadoABaseDatos = true;

      // establece consulta y la ejecuta
      establecerConsulta( consulta );
   } // fin del constructor ResultSetTableModel

   // obtiene la clase que representa el tipo de la columna
   public Class getColumnClass( int columna ) throws IllegalStateException
   {
      // verifica que est� disponible la conexi�n a la base de datos
      if ( !conectadoABaseDatos ) 
         throw new IllegalStateException( "No hay conexion a la base de datos" );

      // determina la clase de Java de la columna
      try 
      {
         String nombreClase = metaDatos.getColumnClassName( columna + 1 );
         
         // devuelve objeto Class que representa a nombreClase
         return Class.forName( nombreClase );
      } // fin de try
      catch ( Exception excepcion ) 
      {
         excepcion.printStackTrace();
      } // fin de catch
      
      return Object.class; // si ocurren problemas en el c�digo anterior, asume el tipo Object
   } // fin del m�todo getColumnClass

   // obtiene el n�mero de columnas en el objeto ResultSet
   public int getColumnCount() throws IllegalStateException
   {   
      // verifica que est� disponible la conexi�n a la base de datos
      if ( !conectadoABaseDatos ) 
         throw new IllegalStateException( "No hay conexi�n a la base de datos" );

      // determina el n�mero de columnas
      try 
      {
         return metaDatos.getColumnCount(); 
      } // fin de try
      catch ( SQLException excepcionSql ) 
      {
         excepcionSql.printStackTrace();
      } // fin de catch
      
      return 0; // si ocurren problemas en el c�digo anterior, devuelve 0 para el n�mero de columnas
   } // fin del m�todo getColumnCount

   // obtiene el nombre de una columna espec�fica en el objeto ResultSet
   public String getColumnName( int columna ) throws IllegalStateException
   {    
      // verifica que est� disponible la conexi�n a la base de datos
      if ( !conectadoABaseDatos ) 
         throw new IllegalStateException( "No hay conexion a la base de datos" );

      // determina el nombre de la columna
      try 
      {
         return metaDatos.getColumnName( columna + 1 );  
      } // fin de try
      catch ( SQLException excepcionSql ) 
      {
         excepcionSql.printStackTrace();
      } // end catch
      
      return ""; // si hay problemas, devuelve la cadena vac�a para el nombre de la columna
   } // fin del m�todo getColumnName

   // devuelve el n�mero de filas en el objeto ResultSet
   public int getRowCount() throws IllegalStateException
   {      
      // verifica que est� disponible la conexi�n a la base de datos
      if ( !conectadoABaseDatos ) 
         throw new IllegalStateException( "No hay conexion a la base de datos" );
 
      return numeroDeFilas;
   } // fin del m�todo getRowCount

   // obtiene el valor en la fila y columna espec�ficas
   public Object getValueAt( int fila, int columna ) 
      throws IllegalStateException
   {
      // verifica que est� disponible la conexi�n a la base de datos
      if ( !conectadoABaseDatos ) 
         throw new IllegalStateException( "No hay conexion a la base de datos" );

      // obtiene un valor en una fila y columna especificadas del objeto ResultSet
      try 
      {
         conjuntoResultados.absolute( fila + 1 );
         return conjuntoResultados.getObject( columna + 1 );
      } // fin de try
      catch ( SQLException excepcionSql ) 
      {
         excepcionSql.printStackTrace();
      } // fin de catch
      
      return ""; // si hay problemas, devuelve el objeto cadena vac�a
   } // fin del m�todo getValueAt
   
   // establece nueva cadena de consulta en la base de datos
   public void establecerConsulta( String consulta ) 
      throws SQLException, IllegalStateException 
   {
      // verifica que est� disponible la conexi�n a la base de datos
      if ( !conectadoABaseDatos ) 
         throw new IllegalStateException( "No hay conexion a la base de datos" );

      // especifica la consulta y la ejecuta
      conjuntoResultados = instruccion.executeQuery( consulta );

      // obtiene metadatos para el objeto ResultSet
      metaDatos = conjuntoResultados.getMetaData();

      // determina el n�mero de filas en el objeto ResultSet
      conjuntoResultados.last();                   // avanza a la �ltima fila
      numeroDeFilas = conjuntoResultados.getRow();  // obtiene el n�mero de fila      
      
      // notifica al objeto JTable que el modelo ha cambiado
      fireTableStructureChanged();
   } // fin del m�todo establecerConsulta

   // cierra objetos Statement y Connection               
   public void desconectarDeBaseDatos()            
   {              
      if ( conectadoABaseDatos )                  
      {
         // cierra objetos Statement y Connection            
         try                                          
         {                                            
            conjuntoResultados.close();                        
            instruccion.close();                        
            conexion.close();                       
         } // fin de try                                 
         catch ( SQLException excepcionSql )          
         {                                            
            excepcionSql.printStackTrace();           
         } // fin de catch                               
         finally  // actualiza el estado de la conexi�n a la base de datos
         {                                            
            conectadoABaseDatos = false;              
         } // fin de finally                             
      } // fin de if
   } // fin del m�todo desconectarDeBaseDatos          


}  // fin de la clase ResultSetTableModel

