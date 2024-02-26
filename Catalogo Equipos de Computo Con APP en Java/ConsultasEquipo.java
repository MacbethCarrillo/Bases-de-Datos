
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
// Fig. 25.31: ConsultasPersona.java
// Instrucciones PreparedStatement utilizadas por la aplicación Libreta de direcciones
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class ConsultasEquipo 
{
	// nombre del controlador de JDBC y URL de la base de datos 
	static final String CONTROLADOR = "com.microsoft.sqlserver.jdbc.SQLServerDriver";             
	static final String URL_BASEDATOS = "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=Evaluacion;";
	//static final String URL_BASEDATOS = "jdbc:sqlserver://localhost:1433;databaseName=Evaluacion;";
	static final String NOMBREUSUARIO = "jhtp7";
	static final String CONTRASENIA = "jhtp7";

	private Connection conexion = null; // maneja la conexión
	private PreparedStatement seleccionarTodasLosEquipos = null; 
	private PreparedStatement seleccionarEquipoPorMarca = null; 
	private PreparedStatement insertarNuevoEquipo = null; 
	private PreparedStatement modificarEquipo = null; 

	// constructor
	public ConsultasEquipo()
	{
		try 
		{
			// carga la clase controlador
			Class.forName( CONTROLADOR );

			conexion = DriverManager.getConnection( URL_BASEDATOS, NOMBREUSUARIO, CONTRASENIA );

			// crea una consulta que selecciona todas las entradas en la LibretaDirecciones
			seleccionarTodasLosEquipos = 
					conexion.prepareStatement( "select * from Equipos" );

			// crea una consulta que selecciona las entradas con un apellido específico
			seleccionarEquipoPorMarca = conexion.prepareStatement( 
					"select * from Equipos where Marca = ?" );

			// crea instrucción insert para agregar una nueva entrada en la base de datos
			insertarNuevoEquipo = conexion.prepareStatement( 
					"INSERT INTO Equipos " + 
							"( TipoComputadora, Marca, Modelo, Procesador, Memoria, Almacenamiento ) " + 
					"VALUES ( ?, ?, ?, ?, ?, ? )" );

			modificarEquipo = conexion.prepareStatement(
					"UPDATE Equipos SET TipoComputadora = ?, Marca = ?, Modelo = ?, Procesador = ?, "
							+ "Memoria = ?, Almacenamiento = ? WHERE IDClave = ?;");
		} // fin de try
		catch ( SQLException excepcionSql )
		{
			excepcionSql.printStackTrace();
			System.exit( 1 );
		} // fin de catch
		catch ( ClassNotFoundException noEncontroClase )                     
		{                                                                  
			noEncontroClase.printStackTrace();            
		} // fin de catch                                                     

	} // fin del constructor de ConsultasPersona

	// selecciona todas las direcciones en la base de datos
	public ArrayList< EquipoComputo > obtenerTodasLosEquiposComputo()
	{
		ArrayList< EquipoComputo > resultados = null;
		ResultSet conjuntoResultados = null;

		try 
		{
			// executeQuery devuelve ResultSet que contiene las entradas que coinciden
			conjuntoResultados = seleccionarTodasLosEquipos.executeQuery(); 
			resultados = new ArrayList< EquipoComputo >();

			while ( conjuntoResultados.next() )
			{
				resultados.add( new EquipoComputo(
						conjuntoResultados.getInt( "idClave" ),
						conjuntoResultados.getString( "tipoComputadora" ),
						conjuntoResultados.getString( "marca" ),
						conjuntoResultados.getString( "modelo" ),
						conjuntoResultados.getString( "procesador" ),
						conjuntoResultados.getString( "memoria" ),
						conjuntoResultados.getString( "almacenamiento" )) );
			} // fin de while
		} // fin de try
		catch ( SQLException excepcionSql )
		{
			excepcionSql.printStackTrace();         
		} // fin de catch
		finally
		{
			try 
			{
				conjuntoResultados.close();
			} // fin de try
			catch ( SQLException excepcionSql )
			{
				excepcionSql.printStackTrace();         
				close();
			} // fin de catch
		} // fin de finally

		return resultados;
	} // fin del método obtenerTodasLasPersonaas

	// selecciona persona por apellido paterno

	public ArrayList< EquipoComputo > obtenerEquipoPorMarca( String marca )
	{
		ArrayList< EquipoComputo > resultados = null;
		ResultSet conjuntoResultados = null;

		try 
		{
			seleccionarEquipoPorMarca.setString( 1, marca ); // especifica el apellido paterno

			// executeQuery devuelve ResultSet que contiene las entradas que coinciden
			conjuntoResultados = seleccionarEquipoPorMarca.executeQuery(); 

			resultados = new ArrayList< EquipoComputo >();

			while ( conjuntoResultados.next() )
			{
				resultados.add( new EquipoComputo(
						conjuntoResultados.getInt( "idClave" ),
						conjuntoResultados.getString( "tipoComputadora" ),
						conjuntoResultados.getString( "marca" ),
						conjuntoResultados.getString( "modelo" ),
						conjuntoResultados.getString( "procesador" ),
						conjuntoResultados.getString( "memoria" ),
						conjuntoResultados.getString( "almacenamiento" )) );
			} // fin de while
		} // fin de try
		catch ( SQLException excepcionSql )
		{
			excepcionSql.printStackTrace();
		} // fin de catch
		finally
		{
			try 
			{
				conjuntoResultados.close();
			} // fin de try
			catch ( SQLException excepcionSql )
			{
				excepcionSql.printStackTrace();         
				close();
			} // fin de catch
		} // fin de finally

		return resultados;
	} // fin del método obtenerPersonasPorApellido

	// agrega una entrada
	public int agregarEquipo(String tipo, String marca, String modelo, String procesador, String memoria, String almacenamiento)
	{
		int resultado = 0;

		// establece los parámetros, después ejecuta insertarNuevaPersona
		try 
		{
			insertarNuevoEquipo.setString( 1, tipo );
			insertarNuevoEquipo.setString( 2, marca );
			insertarNuevoEquipo.setString( 3, modelo );
			insertarNuevoEquipo.setString( 4, procesador );
			insertarNuevoEquipo.setString( 5, memoria );
			insertarNuevoEquipo.setString( 6, almacenamiento );

			// inserta la nueva entrada; devuelve # de filas actualizadas
			resultado = insertarNuevoEquipo.executeUpdate(); 
		} // fin de try
		catch ( SQLException excepcionSql )
		{
			excepcionSql.printStackTrace();
			close();
		} // fin de catch

		return resultado;
	} // fin del método agregarPersona
	
	public int modificarEquipo(String tipo, String marca, String modelo, String procesador, String memoria, String almacenamiento, String idclave )
	   {
		   int resultado = 0;

		   // establece los parámetros, después ejecuta insertarNuevaPersona
		   try 
		   {
			   modificarEquipo.setString( 1, tipo );
			   modificarEquipo.setString( 2, marca );
			   modificarEquipo.setString( 3, modelo );
			   modificarEquipo.setString( 4, procesador );
			   modificarEquipo.setString( 5, memoria );
			   modificarEquipo.setString( 6, almacenamiento );
			   modificarEquipo.setString( 7, idclave );


			   // inserta la nueva entrada; devuelve # de filas actualizadas
			   resultado = modificarEquipo.executeUpdate(); 
		   } // fin de try
		   catch ( SQLException excepcionSql )
		   {
			   excepcionSql.printStackTrace();
			   close();
		   } // fin de catch
		   return resultado;
	   }
	
	
	// cierra la conexión a la base de datos
	public void close()
	{
		try 
		{
			conexion.close();
		} // fin de try
		catch ( SQLException excepcionSql )
		{
			excepcionSql.printStackTrace();
		} // fin de catch
	} // fin del método close
} // fin de la interfaz ConsultasPersona


/**************************************************************************
 * (C) Copyright 1992-2007 por Deitel & Associates, Inc. y                *
 * Pearson Education, Inc. Todos los derechos reservados.                 *
 *                                                                        *
 * RENUNCIA: Los autores y el editor de este libro han realizado su mejor *
 * esfuerzo para preparar este libro. Esto incluye el desarrollo, la      *
 * investigación y prueba de las teorías y programas para determinar su   *
 * efectividad. Los autores y el editor no hacen ninguna garantía de      *
 * ningún tipo, expresa o implícita, en relación con estos programas o    *
 * con la documentación contenida en estos libros. Los autores y el       *
 * editor no serán responsables en ningún caso por los daños consecuentes *
 * en conexión con, o que surjan de, el suministro, desempeño o uso de    *
 * estos programas.                                                       *
 *************************************************************************/

