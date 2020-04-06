package aplicacion;

import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;

import modal.entidades.Cuenta;
import modal.exceptiones.DominioExceptiones;

public class Programa {

	public static void main(String[] args) throws ParseException {
		// --Para definir el punto Decimal--//
		Locale.setDefault(Locale.US);

		// --Entrada de datos por Consola--//
		Scanner sc = new Scanner(System.in);
		try {

			System.out.print("Nro. de Cuenta :");
			int nroCuenta = sc.nextInt();

			System.out.print("Titular :");
			String titular = sc.next();

			System.out.print("Saldo Inicial :");
			double saldo = sc.nextDouble();

			System.out.print("Limite de Retiro :");
			double limiteRetiro = sc.nextDouble();

			// --Instanciamos la cuenta--//
			Cuenta cuenta = new Cuenta(nroCuenta, titular, saldo, limiteRetiro);

			System.out.println();
			System.out.print("Entre el Monto a Retirar :");
			double monto = sc.nextDouble();

			cuenta.retiro(monto);
			System.out.println("Nuevo Saldo :" + String.format("%.2f", cuenta.getSaldo()));
			
		} catch (DominioExceptiones e) {
			System.out.println("Error :" + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Error Imprevisto..." + e.getMessage());
		}

		sc.close();

	}

}
