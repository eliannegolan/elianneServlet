import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.stream.Collectors;
import com.google.gson.Gson;


@WebServlet(urlPatterns={"/patients"},loadOnStartup = 1)

public class elianne extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        resp.setContentType("text/html");
        resp.getWriter().write("Hello, world!\n");
        resp.getWriter().write("Elianne");


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String reqBody = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        Gson gson = new Gson();
        Patient p = gson.fromJson(reqBody,Patient.class);

        resp.setContentType("application/json");
        resp.getWriter().write("Thank you client!" + reqBody);
        resp.setStatus(201);

    }
}

