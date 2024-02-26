
import java.awt.Dialog.ModalityType;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.PrinterException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;
import javax.swing.JTable;


// Controlador.java
// Componente Controlador del MVC

public class Controlador {
	// Instancias de la Vista y el Modelo
	private Vista miVista;
	private MostrarCatalogoActualizar vistaCatalogoActualizar;
	private MostrarResultadosConsulta vistaCatalogoConsulta;
	private boolean nuevo;
	
	public Controlador( Vista vis )
	{
		miVista = vis;
	}
	
	public void iniciarVista()
	{
		miVista.miVentana.setLocationRelativeTo(null);
		// Crear oyentes de evento
		OyenteElementosMenu oem = new OyenteElementosMenu();
		OyenteVentana ov = new OyenteVentana();
		
		// Asignar oyente a la opci�n Actualizar Cat�logo
		miVista.menuActualizarCatalogo.addActionListener(oem);
		
		// Asignar los oyentes de las dem�s opciones del men�
		miVista.menuConsultarCatalogo.addActionListener(oem);
		miVista.menuImprimir.addActionListener(oem);
		miVista.menuSalir.addActionListener(oem);
		miVista.menuAcercaDe.addActionListener(oem);
		miVista.miVentana.addWindowListener(ov);
		
		miVista.miVentana.setVisible(true);
	}
	
	// Clase Oyente para la casilla de verificaci�n Otros
	class OyenteCasillaOtros implements ItemListener
	{
		public void itemStateChanged( ItemEvent e )
		{
			Vista.txtEspecificar.setEnabled( !Vista.txtEspecificar.isEnabled());
		}
	}
	
	
	
	// Clase Interna para Oyentes de Opciones de Men�
	class OyenteElementosMenu implements ActionListener
	{
		public void actionPerformed( ActionEvent e )
		{
			String cual = e.getActionCommand();
			
			// Preguntar cu�l opci�n del men� gener� el evento
			if ( cual.equals("Actualizar cat�logo..."))
			{
				
				// C�digo para mostrar la pantalla de Actualizar Cat�logo
				vistaCatalogoActualizar = new MostrarCatalogoActualizar();
				

				// Hacer cuadro de di�logo modal y visible
				//vistaCatalogo.setModalityType(ModalityType.APPLICATION_MODAL);
				vistaCatalogoActualizar.setLocationRelativeTo(null);
				vistaCatalogoActualizar.setVisible(true);
			}
			else if ( cual.equals("Consultar cat�logo...") )
			{
				vistaCatalogoConsulta = new MostrarResultadosConsulta();     
			}
			else if (cual.equals("Imprimir")) {
				
				new Imprimir();
				
			}else if (cual.equals("Salir")) {
				int respuesta=JOptionPane.showConfirmDialog(null, "�Esta seguro?", "Alerta!", JOptionPane.YES_NO_OPTION);
				if(respuesta == 0)
					System.exit(0);
			}
			else if ( cual.equals("Acerca de...") )
			{
				JOptionPane.showMessageDialog(miVista.miVentana, "Autor: Carrillo Ibarra Macbeth Adolfo","Acerca De", 1);
			}
			
		}		
		
	}
	
	class OyenteVentana extends WindowAdapter
	{
		public void windowClosing(WindowEvent e) {
			int respuesta=JOptionPane.showConfirmDialog(null, "�Esta seguro?", "Alerta!", JOptionPane.YES_NO_OPTION);
			if(respuesta == 0)
				System.exit(0);
		}
	}
}














