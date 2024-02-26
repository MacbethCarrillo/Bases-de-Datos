
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.SQLException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Imprimir extends JFrame{
	
	static final String CONTROLADOR = "com.microsoft.sqlserver.jdbc.SQLServerDriver";          
    static final String URL_BASEDATOS = "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=Evaluacion;";
	static final String NOMBREUSUARIO = "jhtp7";
	static final String CONTRASENIA = "jhtp7";

	// la consulta predeterminada obtiene todos los datos de la tabla autores
	static final String CONSULTA_PREDETERMINADA = "SELECT * FROM Equipos";

	ResultSetTableModel modeloTabla;
	JTable tablaResultados;
	
	public Imprimir() {

		// crea objeto ResultSetTableModel y muestra la tabla de la base de datos
		try 
		{
			// crea objeto TableModel para los resultados de la consulta SELECT * FROM autores
			modeloTabla = new ResultSetTableModel( CONTROLADOR, URL_BASEDATOS,
					NOMBREUSUARIO, CONTRASENIA, CONSULTA_PREDETERMINADA );

			// crea delegado de JTable para modeloTabla 
			tablaResultados = new JTable( modeloTabla );

			// coloca los componentes de la GUI en el panel de contenido
			add( new JScrollPane( tablaResultados ), BorderLayout.CENTER );

			// crea componente de escucha de eventos para botonEnviar
			try {
				tablaResultados.print();
			} catch (PrinterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog( null, 
					"No se encontro controlador de base de datos", "No se encontro el controlador",
					JOptionPane.ERROR_MESSAGE );

			System.exit( 1 ); // termina la aplicación
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			JOptionPane.showMessageDialog( null, e.getMessage(), 
					"Error en base de datos", JOptionPane.ERROR_MESSAGE );

			// verifica que esté cerrada la conexión a la base de datos
			modeloTabla.desconectarDeBaseDatos();

			System.exit( 1 ); // termina la aplicación
		}
	}
}
