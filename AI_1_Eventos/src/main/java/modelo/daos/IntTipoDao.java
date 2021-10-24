package modelo.daos;

import java.util.List;

import modelo.beans.Tipo;



public interface IntTipoDao {
	
	List<Tipo> findAll();
	Tipo findByid(int idTipo);
	int altaTipo(Tipo tipo);
	int editarTipo(Tipo tipo);
	int eliminarTipo(int idTipo);
	int eliminarTipo(Tipo tipo);
	

}


