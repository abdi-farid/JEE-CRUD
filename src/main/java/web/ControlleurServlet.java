package web;

import dao.IProduitDao;
import dao.IProduitImpl;
import metier.entities.Produit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/controlleur", "*.do"})
public class ControlleurServlet extends HttpServlet {
    // Déclarer une instance métier
    IProduitDao metier;


    // instancier le métier au moment de création de la servlet
    @Override
    public void init() {
        metier = new IProduitImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // récupérer servletPath
        String path = request.getServletPath();

        // répondre au client selon le path
        switch (path) {
            case "/chercher.do":
                ProduitModele model = new ProduitModele();
                model.setMc(request.getParameter("mc"));
                model.setProds(metier.produitParMc(request.getParameter("mc")));
                request.setAttribute("model", model);
                request.getRequestDispatcher("produits.jsp").forward(request, response);
                break;

            case "/saisie.do":
                request.getRequestDispatcher("saisieProduit.jsp").forward(request, response);
                break;

            // save et update se font par la méthode POST
            // alors ==> on fait appel a doPost()
            case "/save.do":

            case "/update.do":
                doPost(request, response);
                break;

            case "/delete.do":
                Produit p = metier.getProduit(Integer.parseInt(request.getParameter("id")));
                metier.deleteProduit(Integer.parseInt(request.getParameter("id")));
                request.setAttribute("produit", p);
                request.getRequestDispatcher("chercher.do?mc=").forward(request, response);
                break;

            case "/editer.do":
                request.setAttribute("p", metier.getProduit(Integer.parseInt(request.getParameter("id"))));
                request.getRequestDispatcher("editerProduit.jsp").forward(request, response);
                break;

            default:
                request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // le parametre action spécifie si c'est un save ou update
        String action = request.getParameter("action");

        // Instance de produit
        Produit p = new Produit();

        // dans le cas d'une opération save
        if (action.equals("save")){
            p = metier.save(
                    new Produit(
                            request.getParameter("nomProduit"),
                            Double.parseDouble(request.getParameter("prixProduit"))
                    )
            );
            request.setAttribute("option", "ajout");

            // dans le cas d'une opération update
        }else if(action.equals("update")){
            p = metier.updateProduit(
                    new Produit(
                            Integer.parseInt(request.getParameter("id")),
                            request.getParameter("nomProduit"),
                            Double.parseDouble(request.getParameter("prix"))
                    )
            );
            request.setAttribute("option", "mise à jour");
        }

        // dans les deux cas, on retourne le produit en question
        request.setAttribute("produit", p);
        request.getRequestDispatcher("confirmation.jsp").forward(request, response);
    }
}
