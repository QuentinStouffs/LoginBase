import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Servlet_login", urlPatterns = {"/login"})
public class Servlet_login extends HttpServlet {

    private ValidationService validationService = new ValidationService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //recup paramètres
        String nom = request.getParameter("nom");
        String pass = request.getParameter("pass");

        //verif a partir d'une classe
        boolean isUserValid = validationService.isUserValid(nom, pass);

        if(isUserValid){
            // création de la session
            HttpSession session = request.getSession();

            //ajout une clé valeur dans la session
            session.setAttribute("nomUser", nom);
            //redirection vers la page bienvenue
            request.getRequestDispatcher("views/bienvenue.jsp").forward(request, response);
        }else{
            request.setAttribute("errorMessage", "Login ou Pass incorrect");
            request.getRequestDispatcher("views/login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("views/login.jsp").forward(request, response);
    }
}
