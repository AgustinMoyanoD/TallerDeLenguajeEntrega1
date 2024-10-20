package entregable1;

import java.util.Scanner;
import java.util.LinkedList;

public class Programa {
	private static void optGenerarActivos(Usuario user) {
			Scanner in = new Scanner(System.in);
			
			System.out.printf("[Generar Activos]\n"
					+ "Introduzca el nombre de la moneda (* para seleccionar todas): ");
			String sigla = in.next();
			System.out.printf("Introduzca la cantidad de monedas: ");
			Double cantidad = in.nextDouble();
			
			if (sigla.equals("*")) {
				for (Saldo saldo : user.getBilletera().getArregloMontos()) {
					saldo.setCantMonedas(cantidad);
				}
			} else {
				for (Saldo saldo : user.getBilletera().getArregloMontos()) {
					if (saldo.getSigla().equals(sigla)) {
						saldo.setCantMonedas(cantidad);
						break;
					}
				}
			}
	}
	private static void optListarActivos(Usuario user) {
		LinkedList<Saldo> list = new LinkedList<Saldo>();
		for (Saldo saldo : user.getBilletera().getArregloMontos()) {
			list.add(saldo);
		}
		list.sort(null);
		System.out.printf("[Listar Activos]\n"
				+ "%s\n", list.toString());
	}
	private static void optCrearMoneda(Usuario user, Sistema sistema) {
		Coin auxCoin = sistema.crearMoneda();
		user.getBilletera().agregarMoneda(auxCoin);
	}
	
	
	public static Usuario leerUsuario() {
		return null;
	}
	
	public static void main(String[] args) {
		final int _EXIT = 9;

        //Agregar Login y Register...


		final Scanner in = new Scanner(System.in);
		
        Sistema sistema = new Sistema();
        Usuario temp = new Usuario(new String("admin"),
        						new String("0123"),
        						new String("Argentina"));
        
        Integer opt = -1;
        
        
        do {
            System.out.printf("Seleccionar opción: \n"
            		+ "1. Crear moneda \n"
                    + "2. Listar monedas \n"
                    + "3. Generar Stock \n"
                    + "4. Listar Stock \n"
                    + "5. Generar Activos \n"
                    + "6. Listar Mis Activos \n"
                    + "7. Simular una compra \n"
                    + "8. Simular Swap \n"
                    + "9. Cerrar\n"
                    + "10. remove\n"
                    + "opt: ");
            
            opt = in.nextInt();
            System.out.printf("[%d]\n\n", opt);

			switch (opt) {
			case 1:
			    optCrearMoneda(temp, sistema);
			    break;
			case 2:
				sistema.listarMonedas();
			    break;
			case 3:
				sistema.generarStock();
			    break;
			case 4: 
				sistema.listarStock();
			    break;
			case 5:
				optGenerarActivos(temp);
			    break;
			case 6:
				optListarActivos(temp);
			    break;
			case 7:
			    break;
			case 8:
			    break;
			case _EXIT:
			    break;
			case 10: sistema.removerMoneda();
				break;
			default:
			    System.out.printf("Opción incorrecta\n");
			    break;
			}
			System.out.println("Presione [ENTER] para continuar...");
			try{System.in.read();}
			catch(Exception e){}
		
        } while (opt != _EXIT);

        in.close();
    }
}
