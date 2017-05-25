/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.lppo.servlet;

import br.cesjf.lppo.Coleta;
import br.cesjf.lppo.dao.ColetaELeituraDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ListaColetaServlet", urlPatterns = {"/listaColeta.html"})
public class ListaColetaServlet extends HttpServlet {

   
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             List<Coleta> coletas;
        
        try {
            ColetaELeituraDAO dao = new ColetaELeituraDAO();
            coletas = dao.listAll();
        } catch (Exception ex) {
            Logger.getLogger(ListaColetaServlet.class.getName()).log(Level.SEVERE, null, ex);
            coletas = new ArrayList<>();
            request.setAttribute("mensagem", ex.getLocalizedMessage());
        }
        
        
        request.setAttribute("coletas" , coletas);
        request.getRequestDispatcher("/WEB-INF/lista-coleta.jsp").forward(request, response);
        
       
    }
    

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

 

}
