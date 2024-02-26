
public class EquipoComputo {
	private int idClave;
	private String tipoComputadora;
	private String marca;
	private String modelo;
	private String procesador;
	private String memoria;
	private String almacenamiento;
	
	public EquipoComputo() {
		
	}
	
	public EquipoComputo(int idClave, String tipoComputadora,String marca,
			String modelo,String procesador,String memoria,String almacenamiento) {
		
		setIdClave(idClave);
		setTipoComputadora(tipoComputadora);
		setMarca(marca);
		setModelo(modelo);
		setProcesador(procesador);
		setMemoria(memoria);
		setAlmacenamiento(almacenamiento);
	}
	
	
	public int getIdClave() {
		return idClave;
	}
	public void setIdClave(int idClave) {
		this.idClave = idClave;
	}
	
	public String getTipoComputadora() {
		return tipoComputadora;
	}
	public void setTipoComputadora(String tipoComputadora) {
		this.tipoComputadora = tipoComputadora;
	}
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public String getProcesador() {
		return procesador;
	}
	public void setProcesador(String procesador) {
		this.procesador = procesador;
	}
	
	public String getMemoria() {
		return memoria;
	}
	public void setMemoria(String memoria) {
		this.memoria = memoria;
	}
	
	public String getAlmacenamiento() {
		return almacenamiento;
	}
	public void setAlmacenamiento(String almacenamiento) {
		this.almacenamiento = almacenamiento;
	}
}
