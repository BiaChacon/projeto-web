package filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;

@WebFilter(urlPatterns = "/cliente/*")
public class FiltroAdmin implements Filter {	
	@Override
	public void destroy() {			
	}	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		Usuario u = null;	
		HttpSession session = ((HttpServletRequest) req).getSession(false);
		
		if(session != null){
			u = (Usuario) session.getAttribute("admin-logado");
		}		
		if (u == null || !u.getAdmin()){
			String contextPath = ((HttpServletRequest) req).getContextPath();
			((HttpServletResponse) resp).sendRedirect(contextPath + "/index.xhtml");
		} else {
			chain.doFilter(req, resp);
		}	
	}
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {	
		
	}
}


