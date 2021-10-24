package modelo.daos;

import java.util.List;

import modelo.beans.Evento;


public interface IntEventoDao {
	Evento findById(int idEvento);
	List<Evento> findAll();
	int altaEvento(Evento evento);
	int editarEvento(Evento evento);
	int eliminarEvento(int idEvento);
	int cancelarEvento(int idEvento);

}
