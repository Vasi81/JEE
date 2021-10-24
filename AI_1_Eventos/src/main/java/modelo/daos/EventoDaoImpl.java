package modelo.daos;

import java.util.*;

import modelo.beans.Evento;


public class EventoDaoImpl implements IntEventoDao {
    private List<Evento> lista;

    public EventoDaoImpl() {
        lista=new ArrayList<Evento>();

        cargarDatos();

    }

    protected void cargarDatos() {

        IntTipoDao tipoEvento = new TipoListImpl();
        lista.add(new Evento(11, "Concierto", "Rock", new Date(), 6, "Sala caracol", "reservado", 's', 150, 50, 100.50, tipoEvento.findByid(1)));
        lista.add(new Evento(12, "Despedida", "soltero", new Date(), 6, "Calle arganda", "reservado", 's', 100, 30, 100, tipoEvento.findByid(2)));
        lista.add(new Evento(13, "Cumpleaños", "Juan", new Date(), 6, "Calle Petunia 5", "reservado", 's', 30, 10, 25, tipoEvento.findByid(3)));
        lista.add(new Evento(14, "Boda", "formal", new Date(), 6, "Finca Rosales", "reservado", 's', 150, 80, 150, tipoEvento.findByid(3)));

    }

    @Override
    public Evento findById(int idEvento) {
        for (Evento evento: lista){
            if (evento.getIdEvento() == idEvento){
                return evento;
            }
        }
        return null;
    }

    @Override
    public List<Evento> findAll() {

        return lista;
    }

    @Override
    public int altaEvento(Evento evento) {
        if (lista.contains(evento))
            return 0;
        else
            return lista.add(evento) ? 1 : 0;
    }

    @Override
    public int editarEvento(Evento evento) {
        int pos = lista.indexOf(evento);
        if (pos == -1)
            return 0;
        else
            return (lista.set(pos, evento) != null) ? 1 : 0;
    }

    @Override
    public int eliminarEvento(int idEvento) {
        for (Evento evento: lista){
            if (evento.getIdEvento() == idEvento){
                lista.remove(evento);
                return 0;
            }
        }
        return 1;
    }

    @Override
    public int cancelarEvento(int idEvento) {
        Evento aux = new Evento();
        aux = findById(idEvento);
        int pos = lista.indexOf(aux);
        if (pos == -1) {
            return 0;
        } else
            aux.setEstado("cancelado");
        return (lista.set(pos, aux) != null) ? 1 : 0;


    }


}


