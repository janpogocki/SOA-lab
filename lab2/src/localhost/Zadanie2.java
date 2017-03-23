package localhost;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Jan on 16.03.2017.
 * Utwórz aplikację w modelu MVC korzystając z serwletów będącą grą w papier-nożyczk i kamień.
 */
@WebServlet(name = "Zadanie2")
public class Zadanie2 extends HttpServlet {
    private class Game {
        private String gracz1, gracz2;

        public String getGracz1() {
            return gracz1;
        }

        public String getGracz2() {
            return gracz2;
        }

        public void setGracz1(String gracz1) {
            this.gracz1 = gracz1;
        }

        public void setGracz2(String gracz2) {
            this.gracz2 = gracz2;
        }
    }

    private class GameView {
        private HttpServletResponse response;

        public GameView(HttpServletResponse response){
            this.response = response;
        }

        public void printGameResults(int winner) throws IOException {
            response.setContentType("text/html; charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();

            if (winner == -1)
                out.println("Remis!");
            else
                out.println("Wygrał gracz z numerem " + (winner+1));

            out.close();
        }
    }

    private class GameController {
        private Game model;
        private GameView view;
        private int winner;

        public GameController(Game model, GameView view){
            this.model = model;
            this.view = view;
        }

        public void whoWon(){
            if (model.getGracz1().equals("papier") && model.getGracz2().equals("papier"))
                winner = -1;
            else if (model.getGracz1().equals("papier") && model.getGracz2().equals("kamien"))
                winner = 0;
            else if (model.getGracz1().equals("papier") && model.getGracz2().equals("nozyce"))
                winner = 1;
            else if (model.getGracz1().equals("kamien") && model.getGracz2().equals("papier"))
                winner = 1;
            else if (model.getGracz1().equals("kamien") && model.getGracz2().equals("kamien"))
                winner = -1;
            else if (model.getGracz1().equals("kamien") && model.getGracz2().equals("nozyce"))
                winner = 0;
            else if (model.getGracz1().equals("nozyce") && model.getGracz2().equals("papier"))
                winner = 0;
            else if (model.getGracz1().equals("nozyce") && model.getGracz2().equals("kamien"))
                winner = 1;
            else if (model.getGracz1().equals("nozyce") && model.getGracz2().equals("nozyce"))
                winner = -1;
        }

        public void updateView() throws IOException {
            view.printGameResults(winner);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rzecz1 = request.getParameter("gracz1");
        String rzecz2 = request.getParameter("gracz2");

        Game model = setGameData(rzecz1, rzecz2);
        GameView view = new GameView(response);

        GameController controller = new GameController(model, view);
        controller.whoWon();
        controller.updateView();
    }

    private Game setGameData(String rzecz1, String rzecz2){
        Game game = new Game();
        game.setGracz1(rzecz1);
        game.setGracz2(rzecz2);
        return game;
    }
}
