package modal.entidades;

import modal.exceptiones.DominioExceptiones;

public class Cuenta {
	private Integer nroCuenta;
	private String titular;
	private Double saldo;
	private Double limiteRetiro; 

	//--Definimos el Construtor--//
	public Cuenta(Integer nroCuenta, String titular, Double saldo, Double limiteRetiro) 
	{
		this.nroCuenta = nroCuenta;
		this.titular   = titular;
		this.saldo     = saldo;
		this.limiteRetiro = limiteRetiro;
	}

	//--Definimos Metodos Getters y Setter--//
	public Integer getNroCuenta() {
		return nroCuenta;
	}

	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Double getSaldo() {
		return saldo;
	}

	public Double getLimiteRetiro() {
		return limiteRetiro;
	}

	//--Definimos el metodo deposito--//
	public void deposito(double monto)
	{
	   this.saldo += monto;	
	}

	//--Definimos el metodo retiro--//
    public void retiro(double monto)  
    {
    	//--Monto Mayor a limite de Saldo--//
    	if(monto > limiteRetiro)
    	{
    	   throw new DominioExceptiones("Monto no puede ser > al Limite de Retiro");	
    	}

    	//--Monto Mayor al Saldo--//
    	if(monto > saldo)
    	{
    	   throw new DominioExceptiones("Monto no puede ser > al Saldo");    	
    	}

    	//--Si no Hay Error Resta del Saldo--//
    	saldo -= monto; 
    }
    
	
}
