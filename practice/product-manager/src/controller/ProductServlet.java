package controller;

import static mapping.PathRegistration.BASE;
import static mapping.PathRegistration.CREATE;
import static mapping.PathRegistration.DELETE;
import static mapping.PathRegistration.EDIT;
import static mapping.PathRegistration.ERR_404;
import static mapping.PathRegistration.FILTER_LIST;
import static mapping.PathRegistration.LIST;
import static mapping.PathRegistration.SEARCH;
import static mapping.PathRegistration.VIEW;
import static util.PathUtil.SLASH;
import static util.PathUtil.getView;

import model.Product;
import service.ProductService;
import service.ProductServiceImpl;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import util.PathUtil;

@WebServlet(name = "ProductServlet", urlPatterns = "/products/*")
public class ProductServlet extends HttpServlet {

    private final ProductService productService = new ProductServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String action = PathUtil.getPath(request);
        switch (action) {
            case CREATE:
                createProduct(request, response);
                break;
            case EDIT:
                updateProduct(request, response);
                break;
            case DELETE:
                deleteProduct(request, response);
                break;
            case LIST:
            default:
                listProducts(request, response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String action = PathUtil.getPath(request);
        switch (action) {
            case CREATE:
                showCreateForm(request, response);
                break;
            case EDIT:
                showEditForm(request, response);
                break;
            case DELETE:
                showDeleteForm(request, response);
                break;
            case VIEW:
                viewProduct(request, response);
                break;
            case SEARCH:
                searchProduct(request, response);
                break;
            case LIST:
            default:
                listProducts(request, response);
                break;
        }
    }

    private void listProducts(HttpServletRequest request, HttpServletResponse response) {
        List<Product> products = this.productService.findAll();
        request.setAttribute("products", products);

        RequestDispatcher dispatcher = request.getRequestDispatcher(getView(LIST));
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher(getView(CREATE));
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = 1;
        while (productService.findById(id) != null) {
            id++;
        }
        String developer = request.getParameter("developer");
        String model = request.getParameter("model");
        float price = Float.parseFloat(request.getParameter("price"));
        String description = request.getParameter("description");

        Product customer = new Product(id, developer, model, price, description);
        this.productService.save(customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher(getView(CREATE));
        request.setAttribute("message", "New product was created, id = " + id);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = PathUtil.getID(request);
        Product product = this.productService.findById(id);
        RequestDispatcher dispatcher;
        if (product == null) {
            dispatcher = request.getRequestDispatcher(getView(ERR_404));
        } else {
            request.setAttribute("product", product);
            dispatcher = request.getRequestDispatcher(getView(EDIT));
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = PathUtil.getID(request);
        String developer = request.getParameter("developer");
        String model = request.getParameter("model");
        float price = Float.parseFloat(request.getParameter("price"));
        String description = request.getParameter("description");
        Product product = this.productService.findById(id);
        RequestDispatcher dispatcher;
        if (product == null) {
            dispatcher = request.getRequestDispatcher(getView(ERR_404));
        } else {
            product.setDeveloper(developer);
            product.setModel(model);
            product.setPrice(price);
            product.setDescription(description);
            this.productService.update(id, product);
            request.setAttribute("product", product);
            request.setAttribute("message", "Product information was updated");
            dispatcher = request.getRequestDispatcher(getView(EDIT));
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = PathUtil.getID(request);
        Product product = this.productService.findById(id);
        RequestDispatcher dispatcher;
        if (product == null) {
            dispatcher = request.getRequestDispatcher(getView(ERR_404));
        } else {
            request.setAttribute("product", product);
            dispatcher = request.getRequestDispatcher(getView(DELETE));
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = PathUtil.getID(request);
        Product product = this.productService.findById(id);
        RequestDispatcher dispatcher;
        if (product == null) {
            dispatcher = request.getRequestDispatcher(getView(ERR_404));
        } else {
            this.productService.remove(id);
            try {
                response.sendRedirect(request.getContextPath() + SLASH + BASE);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void viewProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = PathUtil.getID(request);
        Product product = this.productService.findById(id);
        RequestDispatcher dispatcher;
        if (product == null) {
            dispatcher = request.getRequestDispatcher(getView(ERR_404));
        } else {
            request.setAttribute("product", product);
            dispatcher = request.getRequestDispatcher(getView(VIEW));
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void searchProduct(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        RequestDispatcher dispatcher;
        List<Product> filterByDeveloper = this.productService.findByDeveloper(name);
        List<Product> filterByModel = this.productService.findByModel(name);
        List<Product> filterProducts = new ArrayList<>();
        if (filterByModel.size() > 0) {
            filterProducts.addAll(filterByModel);
        } else {
            filterProducts.addAll(filterByDeveloper);
        }
        request.setAttribute("filterProducts", filterProducts);
        request.setAttribute("name", name);
        request.setAttribute("message",
            filterProducts.size() + (filterProducts.size() >= 2 ? " products" : " product")
                + " found!");
        dispatcher = request.getRequestDispatcher(getView(FILTER_LIST));
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

}
