
public class Equipos {
	
	public static void main(String[] args) {
		Vista miVista = new Vista();
		Controlador miControlador = new Controlador( miVista );
		miControlador.iniciarVista();
	}
}
