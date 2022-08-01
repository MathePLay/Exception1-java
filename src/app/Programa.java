package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entidades.Reserva;
import model.execoes.ExecaoDominio;

public class Programa {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Numero do Quarto: ");
			int numeroQuarto = sc.nextInt();
			System.out.print("Data do Check-in (DD/MM/AAAA): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Data do Check-out (DD/MM/AAAA): ");
			Date checkOut = sdf.parse(sc.next());
	
			Reserva reserva = new Reserva(numeroQuarto, checkIn, checkOut);
			System.out.println("Reservado: " + reserva);
	
			System.out.println();
			System.out.println("Entre com as datas para atualizar a reserva");
			System.out.print("Data do Check-in (DD/MM/AAAA): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data do Check-out (DD/MM/AAAA): ");
			checkOut = sdf.parse(sc.next());
	
			reserva.atualizarData(checkIn, checkOut);
			System.out.println("Reservado: " + reserva);
		}
		catch (ParseException e) {
			System.out.println("Você digitou uma data de forma incorreta!");
		}
		catch (ExecaoDominio e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Error Inesperado!");
		}
		
		sc.close();
	}
}
