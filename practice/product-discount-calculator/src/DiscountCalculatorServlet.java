import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.servlet.ServletException;

@WebServlet(name = "DiscountCalculatorServlet", urlPatterns = "/result")
public class DiscountCalculatorServlet extends javax.servlet.http.HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
        String productDescription = request.getParameter("product_description");
        float discountPercent = Float.parseFloat(request.getParameter("discount_percent"));
        float listPrice = Float.parseFloat(request.getParameter("list_price"));
        float discountAmount = discountPercent * listPrice / 100;
        float discountPrice = listPrice - discountAmount;
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<title>Product Discount Calculator</title>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<h1>" + productDescription + "</h1>");
        writer.println("<h2>Discount Amount: " + discountAmount + "<h2>");
        writer.println("<h2>Discount Price: " + discountPrice + "<h2>");
        writer.println("</body>");
        writer.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    }
}
