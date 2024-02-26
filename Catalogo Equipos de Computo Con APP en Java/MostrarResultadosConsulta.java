

// Fig. 25.29: MostrarResultadosConsulta.java
// Muestra el contenido de la tabla Autores en la base de datos libros.
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.PrinterException;
import java.sql.SQLException;
import java.util.regex.PatternSyntaxException;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import javax.swing.table.TableModel;

public class MostrarResultadosConsulta extends JFrame 
{
	// URL de la base de datos, nombre de usuario y contraseña para JDBC
	static final String CONTROLADOR = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	static final String URL_BASEDATOS = "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=Evaluacion;";
	static final String NOMBREUSUARIO = "jhtp7";
	static final String CONTRASENIA = "jhtp7";

	// la consulta predeterminada obtiene todos los datos de la tabla autores
	static final String CONSULTA_PREDETERMINADA = "SELECT * FROM Equipos";

	ResultSetTableModel modeloTabla;
	JTable tablaResultados;

	// crea objeto ResultSetTableModel y GUI
	public MostrarResultadosConsulta() 
	{   
		super( "Visualizacion de los resultados de la consulta" );

		// crea objeto ResultSetTableModel y muestra la tabla de la base de datos
		try 
		{
			// crea objeto TableModel para los resultados de la consulta SELECT * FROM autores
			modeloTabla = new ResultSetTableModel( CONTROLADOR, URL_BASEDATOS,
					NOMBREUSUARIO, CONTRASENIA, CONSULTA_PREDETERMINADA );

			// establece objeto JButton para enviar las consultas
			JButton botonImprimir = new JButton( "Imprimir" );

			// crea objeto Box para manejar la colocación de areaConsulta y 
			// botonEnviar en la GUI
			Box boxNorte = Box.createHorizontalBox();
			boxNorte.add( botonImprimir );

			// crea delegado de JTable para modeloTabla 
			tablaResultados = new JTable( modeloTabla );

			JLabel etiquetaFiltro = new JLabel( "Filtro:" );
			final JTextField textoFiltro = new JTextField();
			JButton botonFiltro = new JButton( "Aplicar filtro" );
			Box boxSur = boxNorte.createHorizontalBox();

			boxSur.add( etiquetaFiltro );
			boxSur.add( textoFiltro );
			boxSur.add( botonFiltro );

			// coloca los componentes de la GUI en el panel de contenido
			add( boxNorte, BorderLayout.NORTH );
			add( new JScrollPane( tablaResultados ), BorderLayout.CENTER );
			add( boxSur, BorderLayout.SOUTH );

			// crea componente de escucha de eventos para botonEnviar
			botonImprimir.addActionListener( 

					new ActionListener() 
					{
						// pasa la consulta al modelo de la tabla
						public void actionPerformed( ActionEvent evento )
						{
							try {
								tablaResultados.print();
							} catch (PrinterException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} // fin de actionPerformed
					}  // fin de la clase interna ActionListener 
					); // fin de la llamada a addActionListener

			final TableRowSorter< TableModel > sorter = 
					new TableRowSorter< TableModel >( modeloTabla );
			tablaResultados.setRowSorter( sorter );
			setSize( 500, 250 ); // establece el tamaño de la ventana
			setVisible( true ); // muestra la ventana

			// crea componente de escucha para botonFiltro
			botonFiltro.addActionListener(            
					new ActionListener() 
					{
						// pasa el texto del filtro al componente de escucha
						public void actionPerformed( ActionEvent e ) 
						{
							String texto = textoFiltro.getText();

							if ( texto.length() == 0 )
								sorter.setRowFilter( null );
							else
							{
								try
								{
									sorter.setRowFilter( 
											RowFilter.regexFilter( texto ) );
								} // fin de try
								catch ( PatternSyntaxException pse ) 
								{
									JOptionPane.showMessageDialog( null,
											"Patron de exp reg incorrecto", "Patron de exp reg incorrecto",
											JOptionPane.ERROR_MESSAGE );
								} // fin de catch
							} // fin de else
						} // fin del método actionPerfomed
					} // fin de la clase interna anónima
					); // fin de la llamada a addActionLister
		} // fin de try

		catch ( ClassNotFoundException noEncontroClase ) 
		{
			JOptionPane.showMessageDialog( null, 
					"No se encontro controlador de base de datos", "No se encontro el controlador",
					JOptionPane.ERROR_MESSAGE );

			System.exit( 1 ); // termina la aplicación
		} // fin de catch

		catch ( SQLException excepcionSql ) 
		{
			JOptionPane.showMessageDialog( null, excepcionSql.getMessage(), 
					"Error en base de datos", JOptionPane.ERROR_MESSAGE );

			// verifica que esté cerrada la conexión a la base de datos
			modeloTabla.desconectarDeBaseDatos();

			System.exit( 1 ); // termina la aplicación
		} // fin de catch

		// cierra la ventana cuando el usuario sale de la aplicación (se sobrescribe
		// el valor predeterminado de HIDE_ON_CLOSE)
		setLocationRelativeTo(null);
		setDefaultCloseOperation( DISPOSE_ON_CLOSE );

		// verifica que esté cerrada la conexión a la base de datos cuando el usuario sale de la aplicación
		addWindowListener(

				new WindowAdapter() 
				{
					// se desconecta de la base de datos y sale cuando se ha cerrado la ventana
					public void windowClosed( WindowEvent evento )
					{
						modeloTabla.desconectarDeBaseDatos();
						//System.exit( 0 );
					} // fin del método windowClosed
				} // fin de la clase interna WindowAdapter
				); // fin de la llamada a addWindowListener
	} // fin del constructor de MostrarResultadosConsulta

} // fin de la clase MostrarResultadosConsulta

