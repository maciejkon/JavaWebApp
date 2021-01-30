package io.github.mat3e;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Optional;

@WebServlet(name = "Hello", urlPatterns = {"/api/*"})
public class HelloServlet extends HttpServlet {
    private final static String NAME_PARAM = "name";

    private final Logger logger = LoggerFactory.getLogger(HelloServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enumeration enumeration = req.getParameterNames();

        logger.info("Got request with parameters " + req.getParameterMap());
        //if contain null, then change null to "world"
        var name = Optional.ofNullable(req.getParameter(NAME_PARAM)).orElse("world");
        resp.getWriter().write("Hello "+name+"!");

    }
}