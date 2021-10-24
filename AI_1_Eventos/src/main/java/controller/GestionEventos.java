package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.beans.Evento;
import modelo.daos.EventoDaoImpl;
import modelo.daos.IntEventoDao;
import modelo.daos.IntTipoDao;
import modelo.daos.TipoListImpl;

/**
 * Servlet implementation class GestionEventos
 */
@WebServlet("/GestionEventos")
public class GestionEventos extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    IntEventoDao eventoDao;
    Evento evento;
    public GestionEventos() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
     */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recupero el objeto eventoDao previamente inicializado a través del ServletContextListener
    	if (eventoDao == null) {
    		eventoDao = new EventoDaoImpl();  
    	}
    	else {
    		eventoDao = (IntEventoDao) request.getSession().getAttribute("eventoDao");
    	}
        String opcion = request.getParameter("opcion");
        if (opcion == null) {
            opcion = "activos";
        }
        String metodo = request.getMethod();
        if (metodo.equals("POST")) { // Identifico el alta del formulario
            guardarEvento(request, response, eventoDao);
        } else {

            switch (opcion) {

                case "alta":
                    procAlta(request, response);
                    break;
                case "editar":
                    procEditar(request, response, eventoDao);
                    break;
                case "eliminar":
                    procEliminar(request, response, eventoDao);
                    break;
                case "cancelar":
				procCancelar(request, response,eventoDao);
				break;
                case "listar":
    				procListar(request, response,eventoDao);
    				break;

                case "activos":
                    // Si no hay parametro opcion, muestro los eventos activos
                    // Uso la session para tener persistencia durante la navegacion
                    request.getSession().setAttribute("eventoDao", eventoDao);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    //System.out.println("opcion incorrecta: " +opcion);//meter el codigo para mostrar los activos

            }
        }

    }

    protected void guardarEvento(HttpServletRequest request, HttpServletResponse response, IntEventoDao eventoDao) throws IOException {
        IntTipoDao tipoDao = new TipoListImpl();

        Evento evento = null;
        try {
            evento = new Evento(Integer.valueOf(request.getParameter("idEvento")), request.getParameter("nombre"),
                    request.getParameter("descripcion"), new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fecha_inicio")),
                    Integer.valueOf(request.getParameter("duracion")), request.getParameter("direccion"), request.getParameter("estado"),
                    request.getParameter("destacado").toCharArray()[0],
                    Integer.valueOf(request.getParameter("aforo_maximo")), Integer.valueOf(request.getParameter("min_asistencia")),
                    Double.valueOf(request.getParameter("precio")), tipoDao.findByid(Integer.valueOf(request.getParameter("tipo"))));
            eventoDao.altaEvento(evento);
            response.sendRedirect("/AI_1_Eventos/GestionEventos");
        } catch (Exception e) {
            e.printStackTrace();
            PrintWriter out=response.getWriter();
            out.println("Error en alta de evento");
        }

    }

    protected void procAlta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("formularioAlta.jsp").forward(request, response);
    }

    protected void procEliminar(HttpServletRequest request, HttpServletResponse response, IntEventoDao eventoDao) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        eventoDao.eliminarEvento(id);
        request.getSession().setAttribute("listaEventos", eventoDao.findAll());
        response.sendRedirect("/AI_1_Eventos/GestionEventos");

    }






    protected void procEditar(HttpServletRequest request, HttpServletResponse response, IntEventoDao eventoDao) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        evento=eventoDao.findById(id);
        request.getSession().setAttribute("evento", evento);
        request.getRequestDispatcher("editarEvento.jsp").forward(request, response);
        

    }
    
    protected void procCancelar(HttpServletRequest request, HttpServletResponse response, IntEventoDao eventoDao) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        eventoDao.cancelarEvento(id);
        request.setAttribute("eventoDao", eventoDao);
        request.getRequestDispatcher("index.jsp").forward(request, response);;

    }
    protected void procListar(HttpServletRequest request, HttpServletResponse response, IntEventoDao eventoDao) throws ServletException, IOException {
       
        request.setAttribute("eventoDao", eventoDao);
        request.getRequestDispatcher("listarActivos.jsp").forward(request, response);
    }

	
		
		
}
