package com.example.ClinicaOdontologica.entity;

import com.example.ClinicaOdontologica.repository.IFilter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter implements IFilter, Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Lógica de inicialización del filtro, si es necesario
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException, IOException {
        HttpServletResponse response = (HttpServletResponse) res;

        // Configura los encabezados CORS permitiendo todas las solicitudes desde cualquier origen
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type");

        chain.doFilter(req, res);
    }

    @Override
    public void destroy() {
        // Lógica de destrucción del filtro, si es necesario
    }
}
