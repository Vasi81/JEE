package modelo.daos;

import java.util.List;
import java.util.ArrayList;

import modelo.beans.Tipo;

public class TipoListImpl implements IntTipoDao {
	private List<Tipo>lista;
	public TipoListImpl() {
		lista=new ArrayList<Tipo>();
		
		cargarDatos();
		
	}
private void cargarDatos() {

		lista.add(new Tipo(1,"Concierto","Rock"));
		lista.add(new Tipo(2,"Despedida","soltero"));
		lista.add(new Tipo(3,"Cumpleaños","infantil"));
		lista.add(new Tipo(4,"Boda","Juan y Paloma"));
		
	}
	@Override
	public List<Tipo> findAll() {
		
		return lista;
	}
	@Override
	public Tipo findByid(int idTipo) {
		Tipo aux=new Tipo();
		aux.setIdTipo(idTipo);
		int pos=lista.indexOf(aux);
		if(pos==-1)
			return null;
		else
			return lista.get(pos);
		
	}
	@Override
	public int altaTipo(Tipo tipo) {
		if (lista.contains(tipo))
			return 0;
		else
			return lista.add(tipo)?1:0;
	}
	@Override
	public int editarTipo(Tipo tipo) {
		int pos=lista.indexOf(tipo);
		if(pos==-1)
			return 0;
		else return (lista.set(pos, tipo)!=null)?1:0;
	}
	@Override
	public int eliminarTipo(int idTipo) {
		Tipo aux= new Tipo();
		aux.setIdTipo(idTipo);
		int pos=lista.indexOf(aux);
		if(pos==-1)
			return 0;
		else 
			return (lista.remove(pos)!=null)?1:0;
	}
	@Override
	public int eliminarTipo(Tipo tipo) {
		
		return lista.remove(tipo)?1:0;
	}
	
	
}
