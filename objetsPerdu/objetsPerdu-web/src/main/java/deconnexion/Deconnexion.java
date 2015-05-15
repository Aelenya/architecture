package deconnexion;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter("/logout")
public class Deconnexion implements Filter {

	public void doFilter(ServletRequest reqIn, ServletResponse res,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)reqIn;
		HttpSession session = req.getSession();
		session.invalidate();
		RequestDispatcher rd = req.getRequestDispatcher("/index.html"); // url
																		// apres
																		// logout
		rd.forward(req, res);
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
