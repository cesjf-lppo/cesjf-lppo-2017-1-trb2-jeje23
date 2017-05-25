
package br.cesjf.lppo.servlet;

import br.cesjf.lppo.Coleta;
import br.cesjf.lppo.dao.ColetaELeituraDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "NovaColetaServlet", urlPatterns = {"/novo.html"})
public class NovaColetaServlet extends HttpServlet {

  
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       request.getRequestDispatcher("WEB-INF/nova-coleta.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Coleta novaColeta = new Coleta();
        novaColeta.setDescricao(request.getParameter("descricao"));
        
        try{
            ColetaELeituraDAO dao = new ColetaELeituraDAO();
            dao.criaColeta(novaColeta);
        } catch(Exception ex){
            System.err.println(ex);
            request.setAttribute("mensagem", ex);
            request.getRequestDispatcher("WEB-INF/lista-coleta.jsp").forward(request, response);
            return;
        }
        response.sendRedirect("listaColeta.html");
    }
       
    }

   


