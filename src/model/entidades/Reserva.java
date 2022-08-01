package model.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.execoes.ExecaoDominio;

public class Reserva {
	
	private Integer numeroQuarto;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	
	public Reserva(Integer numeroQuarto, Date checkIn, Date checkOut) throws ExecaoDominio {
		if(!checkOut.after(checkIn)) {
			throw new ExecaoDominio("A data de check-out deve ser superior à data de Check-in");
		}
		this.numeroQuarto = numeroQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}
	
	// metodos
	
	public long duracao() {
		long dif = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);
	}
	
	
	
	public void atualizarData(Date checkIn, Date checkOut) throws ExecaoDominio {
		
		Date now = new Date();
		if(checkIn.before(now) || checkOut.before(now)) {
			throw new ExecaoDominio("As datas de check-in e check-out devem ser datas futuras");
		}
		if(!checkOut.after(checkIn)) {
			throw new ExecaoDominio("A data de check-out deve ser superior à data de Check-in");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	
	}
	
	@Override
	public String toString() {
		return "Quarto " 
				+ numeroQuarto 
				+ ", chech-in: "
				+ sdf.format(checkIn)
				+ ", check-out: "
				+ sdf.format(checkIn)
				+ ", "
				+ duracao()
				+ " noites";
	}
	
	
	

}
