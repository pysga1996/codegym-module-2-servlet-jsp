package util;

import javax.servlet.http.HttpServletRequest;

public interface PathUtil {

    String SLASH = "/";

    String VIEW_PREFIX = "product";

    String VIEW_SUFFIX = ".jsp";

    static String getPath(HttpServletRequest request) {
        try {
            String path = request.getPathInfo();
            String[] pathArray = path.split("/");
            return pathArray[1];
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return "";
        }
    }

    static Integer getID(HttpServletRequest request) {
        try {
            String path = request.getPathInfo();
            String[] pathArray = path.split("/");
            return Integer.parseInt(pathArray[2]);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return 0;
        }
    }

    static String getView(String path) {
        return SLASH.concat(VIEW_PREFIX).concat(SLASH).concat(path).concat(VIEW_SUFFIX);
    }
}
