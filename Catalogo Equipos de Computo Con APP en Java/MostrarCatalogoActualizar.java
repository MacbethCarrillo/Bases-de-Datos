
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.List; 
import javax.swing.JButton;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.BoxLayout;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

public class MostrarCatalogoActualizar extends JFrame
{
	private EquipoComputo entradaActual;
	private ConsultasEquipo consultasEquipo;
	private List< EquipoComputo > resultados;   
	private int numeroDeEntradas = 0;
	private int indiceEntradaActual;

	private JButton botonExplorar;

	private JLabel etiquetaIdClave;
	private JTextField campoTextoIdClave;
	private JLabel etiquetaTipoComputadora;
	private JTextField campoTextoTipoComputadora;
	private JLabel etiquetaMarca;
	private JTextField campoTextoMarca;
	private JLabel etiquetaModelo;
	private JTextField campoTextoModelo;
	private JLabel etiquetaProcesador;
	private JTextField campoTextoProcesador;
	private JLabel etiquetaMemoria;
	private JTextField campoTextoMemoria;
	private JLabel etiquetaAlmacenamiento;
	private JTextField campoTextoAlmacenamiento;

	private JTextField campoTextoIndice;

	private JTextField campoTextoMax;
	private JButton botonSiguiente;
	private JLabel etiquetaDe;

	private JButton botonAnterior;
	private JButton botonConsulta;
	private JLabel etiquetaConsulta;
	private JPanel panelConsulta;
	private JPanel panelNavegar;
	private JPanel panelMostrar;
	private JTextField campoTextoConsulta;
	private JButton botonInsertar;
	private JButton botonModificar;
	private JButton botonLimpiarCampos;

	// constructor sin argumentos
	public MostrarCatalogoActualizar()
	{
		super( "Libreta de direcciones" ); 

		// establece la conexión a la base de datos y las instrucciones PreparedStatement
		consultasEquipo = new ConsultasEquipo(); 

		// crea la GUI
		panelNavegar = new JPanel();
		botonAnterior = new JButton();
		campoTextoIndice = new JTextField( 2 );
		etiquetaDe = new JLabel();
		campoTextoMax = new JTextField( 2 );
		botonSiguiente = new JButton();
		panelMostrar = new JPanel();
		etiquetaIdClave = new JLabel();
		campoTextoIdClave = new JTextField( 15 );
		etiquetaMemoria = new JLabel();
		campoTextoMemoria = new JTextField( 15 );
		etiquetaAlmacenamiento = new JLabel();
		campoTextoAlmacenamiento = new JTextField( 15 );


		etiquetaTipoComputadora = new JLabel();
		campoTextoTipoComputadora = new JTextField( 15 );
		etiquetaMarca = new JLabel();
		campoTextoMarca = new JTextField( 15 );
		etiquetaModelo = new JLabel();
		campoTextoModelo = new JTextField( 15 );
		etiquetaProcesador = new JLabel();
		campoTextoProcesador = new JTextField( 15 );
		panelConsulta = new JPanel();
		etiquetaConsulta = new JLabel();
		campoTextoConsulta = new JTextField( 15 );
		botonConsulta = new JButton();
		botonExplorar = new JButton();
		botonInsertar = new JButton();
		botonModificar = new JButton();
		botonLimpiarCampos = new JButton();

		setLayout( new FlowLayout( FlowLayout.CENTER, 10, 10 ) );
		setSize( 540, 355 );
		setResizable( false );
		setLocationRelativeTo(null);

		panelNavegar.setLayout(
				new BoxLayout( panelNavegar, BoxLayout.X_AXIS ) );

		botonAnterior.setText( "Anterior" );
		botonAnterior.setEnabled( false );
		botonAnterior.addActionListener(
				new ActionListener()
				{
					public void actionPerformed( ActionEvent evt )
					{
						botonAnteriorActionPerformed( evt );
					} // fin del método actionPerformed
				} // fin de la clase interna anónima
				); // fin de la llamada a addActionListener

		panelNavegar.add( botonAnterior );
		panelNavegar.add( Box.createHorizontalStrut( 10 ) );

		campoTextoIndice.setHorizontalAlignment(
				JTextField.CENTER );
		campoTextoIndice.addActionListener(
				new ActionListener()
				{
					public void actionPerformed( ActionEvent evt )
					{
						campoTextoIndiceActionPerformed( evt );
					} // fin del método actionPerformed
				} // fin de la clase interna anónima
				); // fin de la llamada a addActionListener

		panelNavegar.add( campoTextoIndice );
		panelNavegar.add( Box.createHorizontalStrut( 10 ) );

		etiquetaDe.setText( "de" );
		panelNavegar.add( etiquetaDe );
		panelNavegar.add( Box.createHorizontalStrut( 10 ) );

		campoTextoMax.setHorizontalAlignment(
				JTextField.CENTER );
		campoTextoMax.setEditable( false );
		panelNavegar.add( campoTextoMax );
		panelNavegar.add( Box.createHorizontalStrut( 10 ) );

		botonSiguiente.setText( "Siguiente" );
		botonSiguiente.setEnabled( false );
		botonSiguiente.addActionListener(
				new ActionListener()
				{
					public void actionPerformed( ActionEvent evt )
					{
						botonSiguienteActionPerformed( evt );
					} // fin del método actionPerformed
				} // fin de la clase interna anónima
				); // fin de la llamada a addActionListener

		panelNavegar.add( botonSiguiente );
		add( panelNavegar );

		panelMostrar.setLayout( new GridLayout( 7, 2, 4, 4 ) );

		etiquetaIdClave.setText( "Id Clave:" );
		panelMostrar.add( etiquetaIdClave );

		campoTextoIdClave.setEditable( false );
		panelMostrar.add( campoTextoIdClave );

		etiquetaTipoComputadora.setText( "Tipo Computadora:" );
		panelMostrar.add( etiquetaTipoComputadora );
		panelMostrar.add( campoTextoTipoComputadora );

		etiquetaMarca.setText( "Marca:" );
		panelMostrar.add( etiquetaMarca );
		panelMostrar.add( campoTextoMarca );

		etiquetaModelo.setText( "Modelo:" );
		panelMostrar.add( etiquetaModelo );
		panelMostrar.add( campoTextoModelo );

		etiquetaProcesador.setText( "Procesador:" );
		panelMostrar.add( etiquetaProcesador );
		panelMostrar.add( campoTextoProcesador );

		etiquetaMemoria.setText( "Memoria:" );
		panelMostrar.add( etiquetaMemoria );
		panelMostrar.add( campoTextoMemoria );

		etiquetaAlmacenamiento.setText( "Almacenamiento:" );
		panelMostrar.add( etiquetaAlmacenamiento );
		panelMostrar.add( campoTextoAlmacenamiento );
		add( panelMostrar );

		panelConsulta.setLayout( 
				new BoxLayout( panelConsulta, BoxLayout.X_AXIS) );

		panelConsulta.setBorder( BorderFactory.createTitledBorder(
				"Buscar una entrada por marca" ) );
		etiquetaConsulta.setText( "Marca:" );
		panelConsulta.add( Box.createHorizontalStrut( 5 ) );
		panelConsulta.add( etiquetaConsulta );
		panelConsulta.add( Box.createHorizontalStrut( 10 ) );
		panelConsulta.add( campoTextoConsulta );
		panelConsulta.add( Box.createHorizontalStrut( 10 ) );

		botonConsulta.setText( "Buscar" );
		botonConsulta.addActionListener(
				new ActionListener()
				{
					public void actionPerformed( ActionEvent evt )
					{
						botonConsultaActionPerformed( evt );
					} // fin del método actionPerformed
				} // fin de la clase interna anónima
				); // fin de la llamada a addActionListener

		panelConsulta.add( botonConsulta );
		panelConsulta.add( Box.createHorizontalStrut( 5 ) );
		add( panelConsulta );
		
		botonLimpiarCampos.setText( "Limpiar Campos" );
		botonLimpiarCampos.addActionListener(
				new ActionListener()
				{
					public void actionPerformed( ActionEvent evt )
					{
						campoTextoIdClave.setText("0");
						campoTextoTipoComputadora.setText("");
						campoTextoMarca.setText("");
						campoTextoModelo.setText("");
						campoTextoProcesador.setText("");
						campoTextoMemoria.setText("");
						campoTextoAlmacenamiento.setText("");
					} // fin del método actionPerformed
				} // fin de la clase interna anónima
				); // fin de la llamada a addActionListener

		add( botonLimpiarCampos );

		botonExplorar.setText( "Explorar todas las entradas" );
		botonExplorar.addActionListener(
				new ActionListener()
				{
					public void actionPerformed( ActionEvent evt )
					{
						botonExplorarActionPerformed( evt );
					} // fin del método actionPerformed
				} // fin de la clase interna anónima
				); // fin de la llamada a addActionListener

		add( botonExplorar );

		botonInsertar.setText( "Insertar nueva entrada" );
		botonInsertar.addActionListener(
				new ActionListener()
				{
					public void actionPerformed( ActionEvent evt )
					{
						botonInsertarActionPerformed( evt );
					} // fin del método actionPerformed
				} // fin de la clase interna anónima
				); // fin de la llamada a addActionListener

		add( botonInsertar );

		botonModificar.setText( "Modificar entrada" );
		botonModificar.addActionListener(
				new ActionListener()
				{
					public void actionPerformed( ActionEvent evt )
					{
						botonModificarActionPerformed( evt );
					} // fin del método actionPerformed
				} // fin de la clase interna anónima
				); // fin de la llamada a addActionListener

		add( botonModificar );

		addWindowListener( 
				new WindowAdapter() 
				{  
					public void windowClosing( WindowEvent evt )
					{
						consultasEquipo.close(); // cierra la conexión a la base de datos
					} // fin del método windowClosing
				} // fin de la clase interna anónima
				); // fin de la llamada a addWindowListener

		setVisible( true );
	} // fin del constructor sin argumentos

	// maneja la llamada cuando se hace clic en botonAnterior
	private void botonAnteriorActionPerformed( ActionEvent evt )
	{
		indiceEntradaActual--;

		if ( indiceEntradaActual < 0 )
			indiceEntradaActual = numeroDeEntradas - 1;

		campoTextoIndice.setText( "" + ( indiceEntradaActual + 1 ) );
		campoTextoIndiceActionPerformed( evt );  
	} // fin del método botonAnteriorActionPerformed

	// maneja la llamada cuando se hace clic en botonSiguiente
	private void botonSiguienteActionPerformed( ActionEvent evt ) 
	{
		indiceEntradaActual++;

		if ( indiceEntradaActual >= numeroDeEntradas )
			indiceEntradaActual = 0;

		campoTextoIndice.setText( "" + ( indiceEntradaActual + 1 ) );
		campoTextoIndiceActionPerformed( evt );
	} // fin del método botonSiguienteActionPerformed

	// maneja la llamada cuando se hace clic en botonConsulta
	private void botonConsultaActionPerformed( ActionEvent evt )
	{
		resultados = consultasEquipo.obtenerEquipoPorMarca( campoTextoConsulta.getText() );
		numeroDeEntradas = resultados.size();

		if ( numeroDeEntradas != 0 )
		{
			indiceEntradaActual = 0;
			entradaActual = resultados.get( indiceEntradaActual );
			campoTextoIdClave.setText("" + entradaActual.getIdClave() );
			campoTextoTipoComputadora.setText( entradaActual.getTipoComputadora() );
			campoTextoMarca.setText( entradaActual.getMarca() );
			campoTextoModelo.setText( entradaActual.getModelo() );
			campoTextoProcesador.setText( entradaActual.getProcesador() );
			campoTextoMemoria.setText( entradaActual.getMemoria() );
			campoTextoAlmacenamiento.setText( entradaActual.getAlmacenamiento() );
			campoTextoMax.setText( "" + numeroDeEntradas );
			campoTextoIndice.setText( "" + ( indiceEntradaActual + 1 ) );
			botonSiguiente.setEnabled( true );
			botonAnterior.setEnabled( true );
		} // end if
		else
			botonExplorarActionPerformed( evt );
	} // fin del método botonConsultaActionPerformed

	// maneja la llamada cuando se introduce un nuevo valor en campoTextoIndice
	private void campoTextoIndiceActionPerformed( ActionEvent evt )
	{
		indiceEntradaActual = ( Integer.parseInt( campoTextoIndice.getText() ) - 1 );

		if ( numeroDeEntradas != 0 && indiceEntradaActual < numeroDeEntradas )
		{
			entradaActual = resultados.get( indiceEntradaActual );
			campoTextoIdClave.setText("" + entradaActual.getIdClave() );
			campoTextoTipoComputadora.setText( entradaActual.getTipoComputadora() );
			campoTextoMarca.setText( entradaActual.getMarca() );
			campoTextoModelo.setText( entradaActual.getModelo() );
			campoTextoProcesador.setText( entradaActual.getProcesador() );
			campoTextoMemoria.setText( entradaActual.getMemoria() );
			campoTextoAlmacenamiento.setText( entradaActual.getAlmacenamiento() );
			campoTextoMax.setText( "" + numeroDeEntradas );
			campoTextoIndice.setText( "" + ( indiceEntradaActual + 1 ) );
		} // fin de if
	} // fin del método campoTextoIndiceActionPerformed

	// maneja la llamada cuando se hace clic en botonExplorar
	private void botonExplorarActionPerformed( ActionEvent evt )
	{
		try
		{
			resultados = consultasEquipo.obtenerTodasLosEquiposComputo();
			numeroDeEntradas = resultados.size();

			if ( numeroDeEntradas != 0 )
			{
				indiceEntradaActual = 0;
				entradaActual = resultados.get( indiceEntradaActual );
				campoTextoIdClave.setText("" + entradaActual.getIdClave() );
				campoTextoTipoComputadora.setText( entradaActual.getTipoComputadora() );
				campoTextoMarca.setText( entradaActual.getMarca() );
				campoTextoModelo.setText( entradaActual.getModelo() );
				campoTextoProcesador.setText( entradaActual.getProcesador() );
				campoTextoMemoria.setText( entradaActual.getMemoria() );
				campoTextoAlmacenamiento.setText( entradaActual.getAlmacenamiento() );
				campoTextoMax.setText( "" + numeroDeEntradas );
				campoTextoIndice.setText( "" + ( indiceEntradaActual + 1 ) );
				botonSiguiente.setEnabled( true );
				botonAnterior.setEnabled( true );
			} // fin de if
		} // fin de try
		catch ( Exception e )
		{
			e.printStackTrace();
		} // fin de catch
	} // fin del método botonExplorarActionPerformed

	// maneja la llamada cuando se hace clic en botonInsertar
	private void botonInsertarActionPerformed( ActionEvent evt ) 
	{
		if (campoTextoTipoComputadora.getText().equals("") || campoTextoMarca.getText().equals("")
			|| campoTextoModelo.getText().equals("")|| campoTextoProcesador.getText().equals("")
			|| campoTextoMemoria.getText().equals("")|| campoTextoAlmacenamiento.getText().equals("")) {
			JOptionPane.showMessageDialog( this, "Llena todos los espacios!",
					"Se agrego persona", JOptionPane.PLAIN_MESSAGE );
		}else {
			int resultado = consultasEquipo.agregarEquipo( campoTextoTipoComputadora.getText(),
					campoTextoMarca.getText(), campoTextoModelo.getText(),campoTextoProcesador.getText(),
					campoTextoMemoria.getText(), campoTextoAlmacenamiento.getText());

			if ( resultado == 1 )
				JOptionPane.showMessageDialog( this, "Se agregó equipo!",
						"Se agrego persona", JOptionPane.PLAIN_MESSAGE );
			else
				JOptionPane.showMessageDialog( this, "No se agregó equipo!",
						"Error", JOptionPane.PLAIN_MESSAGE );
		}
		

		botonExplorarActionPerformed( evt );
	} // fin del método botonInsertarActionPerformed

	private void botonModificarActionPerformed( ActionEvent evt ) 
	{
		int resultado = consultasEquipo.modificarEquipo( campoTextoTipoComputadora.getText(),
				campoTextoMarca.getText(), campoTextoModelo.getText(),campoTextoProcesador.getText(),
				campoTextoMemoria.getText(), campoTextoAlmacenamiento.getText(), campoTextoIdClave.getText());

		if ( resultado == 1 )
			JOptionPane.showMessageDialog( this, "Se modificó equipo!",
					"Se agrego persona", JOptionPane.PLAIN_MESSAGE );
		else
			JOptionPane.showMessageDialog( this, "No se modificó equipo!",
					"Error", JOptionPane.PLAIN_MESSAGE );

		botonExplorarActionPerformed( evt );
	} // fin del método botonInsertarActionPerformed
} // fin de la clase 