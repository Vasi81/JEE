package modelo.daos;


import modelo.beans.Tipo;
import modelo.beans.Evento;

public class TestEventoDao {

	public static void main(String[] args) {
		
		IntEventoDao event=new EventoDaoImpl();
		
		for(Evento ele:event.findAll())
			System.out.println(ele);
		
		event.cancelarEvento(11);
		
		System.out.println("");
		
		for(Evento ele:event.findAll())
			System.out.println(ele);
		
		
		IntTipoDao tipo= new TipoListImpl();
		
		for(Tipo ele:tipo.findAll())
			System.out.println(ele);
		
	}
	

}
