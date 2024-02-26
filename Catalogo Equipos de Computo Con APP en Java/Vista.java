
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

// Vista.java
// Componente Vista del MVC
public class Vista {
	MiVentana miVentana;
	// Elementos de la Vista utilizados por el Controlador y el Modelo
	JMenuItem menuActualizarCatalogo;
	JMenuItem menuConsultarCatalogo;
	JMenuItem menuImprimir;
	JMenuItem menuSalir;
	JMenuItem menuAcercaDe;
	
	// Elementos del Cuadro de Diálogo
	static JButton btnInicio;
	static JButton btnAnterior;
	static JTextField txtClave;
	static JTextField txtTotal;
	static JButton btnSiguiente;
	static JButton btnFinal;
	
	static JTextField txtNombre;
	static JTextField txtEdad;
	static JRadioButton rbMasculino;
	static JRadioButton rbFemenino;
	static JComboBox<String> cmbDepartamento;
	static JList<String> lstTurno;
	static JCheckBox chkActivo;
	
	static JCheckBox chkLectura;
	static JCheckBox chkDeportes;
	static JCheckBox chkCine;
	static JCheckBox chkTeatro;
	static JCheckBox chkJuegoSalon;
	static JCheckBox chkConciertos;
	static JCheckBox chkOtros;
	static JTextField txtEspecificar;
	
	static JButton btnNuevo;
	static JButton btnModificar;	
	static JButton btnGuardar;
	static JButton btnCancelar;	
	static JButton btnSalir;
	
	static boolean mostrarModificacion = false;
	
	public Vista()
	{
		miVentana = new MiVentana( "Proyecto MVC Catálogo" );
		miVentana.setDefaultCloseOperation( JFrame.DO_NOTHING_ON_CLOSE );
		
		miVentana.setSize( 600, 400 );
	}
	
	
	// clase interna MiVentana
	class MiVentana extends JFrame
	{
		public MiVentana( String titulo )
		{
			super( titulo );
			
			// Crear una barra de menú
			JMenuBar barraMenu = new JMenuBar();
			// Poner la barra de menú en la ventana
			setJMenuBar( barraMenu );
			
			// Menú Archivo
			JMenu menuArchivo = new JMenu( "Archivo" );
			menuArchivo.setMnemonic( 'o' );
			
			// Crear elementos del menú Archivo
			menuActualizarCatalogo = new JMenuItem( "Actualizar catálogo..." );
			menuActualizarCatalogo.setMnemonic( 't' );
			
			menuConsultarCatalogo = new JMenuItem( "Consultar catálogo..." );
			menuConsultarCatalogo.setMnemonic( 'a' );
			
			menuImprimir = new JMenuItem( "Imprimir" );
			menuImprimir.setMnemonic( 'I' );
			
			menuSalir = new JMenuItem( "Salir" );
			menuSalir.setMnemonic( 'l' );
			
			// Agregar elementos del menú Archivo
			menuArchivo.add( menuActualizarCatalogo );
			menuArchivo.add(menuConsultarCatalogo);
			menuArchivo.addSeparator();
			menuArchivo.add(menuImprimir);
			menuArchivo.addSeparator();
			menuArchivo.add(menuSalir);
			
			// Agregar el menú Archivo a la barra del menú
			barraMenu.add(menuArchivo);
			
			// Menú Ayuda
			JMenu menuAyuda = new JMenu( "Ayuda" );
			menuAyuda.setMnemonic( 'A' );
			
			// Crear elementos del menú Ayuda
			menuAcercaDe = new JMenuItem( "Acerca de..." );
			menuAcercaDe.setMnemonic( 'A' );
						
			// Agregar elementos del menú Ayuda
			menuAyuda.add( menuAcercaDe );
			
			// Agregar el menú Ayuda a la barra del menú
			barraMenu.add(menuAyuda);			
		}
	}
	
	
}