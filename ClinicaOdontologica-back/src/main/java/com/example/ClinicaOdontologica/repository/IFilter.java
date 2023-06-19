package com.example.ClinicaOdontologica.repository;

import javax.servlet.*;
import java.io.IOException;

public interface IFilter {
        void init(FilterConfig var1) throws ServletException;
        void doFilter(ServletRequest var1, ServletResponse var2, FilterChain var3) throws IOException, ServletException;
        void destroy();
}
