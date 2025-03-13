package controllers;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Marca;
import models.Medicamento;
import services.MarcaService;
import services.MedicamentoService;
import services.impl.MarcaServiceImpl;
import services.impl.MedicamentoServiceImpl;

@WebServlet("/medicamentos")
public class MedicamentosServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private final MedicamentoService medicamentoService;
	private final MarcaService marcaService;
       
    
    public MedicamentosServlet() {
        super();
        medicamentoService = new MedicamentoServiceImpl();
        marcaService = new MarcaServiceImpl();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Medicamento> medicamentos = medicamentoService.listarMedicamentos();
		request.setAttribute("medicamentos", medicamentos);
		
		List<Marca> marcas = marcaService.listarMarcas();
		request.setAttribute("marcas", marcas);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
