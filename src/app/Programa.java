package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entidades.Reserva;



public class Programa {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Numero do Quarto: ");
		int numeroQuarto = sc.nextInt();
		System.out.print("Data do Check-in (DD/MM/AAAA): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Data do Check-out (DD/MM/AAAA): ");
		Date checkOut = sdf.parse(sc.next());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Erro de reserva, A data de check-out deve ser superior à data de Check-in");
		}else {
			Reserva reserva = new Reserva(numeroQuarto, checkIn, checkOut);
			System.out.println("Reservado: " + reserva);
			
			System.out.println();
			System.out.println("Entre com as datas para atualizar a reserva");
			System.out.print("Data do Check-in (DD/MM/AAAA): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data do Check-out (DD/MM/AAAA): ");
			checkOut = sdf.parse(sc.next());
			
			
			String erro = reserva.atualizarData(checkIn, checkOut);
			if (erro != null) {
				System.out.println("Erra na reserva: " + erro);
			}else {
				System.out.println("Reservado: " + reserva);
			}	
		}
		
	
		
		
		
		sc.close();
	}
}
