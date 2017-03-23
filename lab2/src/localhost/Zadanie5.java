package localhost;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by Jan on 23.03.2017.
 */
@WebServlet(name = "Zadanie5")
public class Zadanie5 extends HttpServlet {
    private class DaneOsobowe {
        private String login;
        private String password;
        private String imie;
        private String nazwisko;

        public DaneOsobowe(String login, String password, String imie, String nazwisko){
            this.login = login;
            this.password = password;
            this.imie = imie;
            this.nazwisko = nazwisko;
        }

        public String getLogin() {
            return login;
        }

        public String getPassword() {
            return password;
        }
    }

    public static List<String> listOfLoggedUsers = new ArrayList<>();
    Vector<DaneOsobowe> daneOsoboweVector;
    String htmlTemplate1 = "<html><head><title>Logowanie</title></head><body>";
    String htmlTemplate2 = "<form action=\"Zadanie5\" method=\"post\">Login: <input type=\"text\" name=\"login\" /><br><br>Hasło: <input type=\"password\" name=\"haslo\" /><br><br><input type=\"submit\" value=\"Wyślij\" /></form></body></html>";

    private Boolean isLoginDataCorrect(String login, String password){
        for (DaneOsobowe element : daneOsoboweVector){
            if (element.getLogin().equals(login) && element.getPassword().equals(password))
                return true;
        }

        return false;
    }

    private void printResponse(HttpServletResponse response, int status) throws IOException {
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        if (status == 0){
            out.println(htmlTemplate1 + htmlTemplate2);
        }
        else if (status == -1){
            // no user
            out.println(htmlTemplate1);
            out.println("Podaj login!<br><br>");
            out.println(htmlTemplate2);
        }
        else if (status == -2){
            // no password
            out.println(htmlTemplate1);
            out.println("Podaj hasło!<br><br>");
            out.println(htmlTemplate2);
        }
        else if (status == -3){
            // no user & password
            out.println(htmlTemplate1);
            out.println("Podaj login i hasło!<br><br>");
            out.println(htmlTemplate2);
        }
        else if (status == -4){
            // wrong data
            out.println(htmlTemplate1);
            out.println("Podaj poprawne dane logowania!<br><br>");
            out.println(htmlTemplate2);
        }

        out.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("haslo");

        if (login.equals("") && password.equals(""))
            printResponse(response, -3);
        else if (login.equals(""))
            printResponse(response, -1);
        else if (password.equals(""))
            printResponse(response, -2);
        else if (!isLoginDataCorrect(login, password))
            printResponse(response, -4);
        else if (isLoginDataCorrect(login, password)){
            String cookieValue = login + "_" + System.currentTimeMillis();
            Cookie cookie = new Cookie("sessionID", cookieValue);
            cookie.setMaxAge(120);
            response.addCookie(cookie);
            listOfLoggedUsers.add(cookieValue);
            response.sendRedirect("Zadanie5GuestsBook");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        daneOsoboweVector = new Vector<>();
        daneOsoboweVector.add(new DaneOsobowe("user1", "user1pass", "Jan", "Pogocki"));
        daneOsoboweVector.add(new DaneOsobowe("user2", "user2pass", "Henryk", "Nowak"));
        daneOsoboweVector.add(new DaneOsobowe("user3", "user3pass", "Barbara", "Zielińska"));
        daneOsoboweVector.add(new DaneOsobowe("user4", "user4pass", "Katarzyna", "Woźniak"));

        printResponse(response, 0);
    }
}
