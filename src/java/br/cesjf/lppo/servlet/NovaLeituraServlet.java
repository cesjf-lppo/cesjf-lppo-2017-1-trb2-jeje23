
package br.cesjf.lppo.servlet;


import br.cesjf.lppo.Leitura;
import br.cesjf.lppo.dao.ColetaELeituraDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "NovaLeitura", urlPatterns = {"/novaLeitura.html"})
public class NovaLeituraServlet extends HttpServlet {

    
    
   
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.getRequestDispatcher("WEB-INF/nova-leitura.jsp").forward(request, response);
        
    }

    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          Leitura novaLeitura = new Leitura();
        novaLeitura.setUnidade(request.getParameter("unidade"));
        novaLeitura.setLocal(request.getParameter("local"));
        
        try{
            ColetaELeituraDAO dao = new ColetaELeituraDAO();
            dao.criaLeitura(novaLeitura);
        } catch(Exception ex){
            System.err.println(ex);
            request.setAttribute("mensagem", ex);
            request.getRequestDispatcher("WEB-INF/lista-leitura.jsp").forward(request, response);
            return;
        }
        response.sendRedirect("listaLeitura.html");
    }
       
}

    


