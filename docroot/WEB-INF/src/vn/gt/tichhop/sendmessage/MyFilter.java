package vn.gt.tichhop.sendmessage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class MyFilter
 */
@WebFilter("/MyFilter")
public class MyFilter implements Filter {
	
   
	
	public MyFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//	    PrintWriter out=response.getWriter();  
//	    out.print("filter is invoked before");  
	      
		String ipAddress = request.getRemoteAddr();

	      // Log the IP address and current timestamp.
	      System.out.println("IP "+ ipAddress + ", Time "
	                                       + new Date().toString());
	      ThreatSentMessage threatSentMessage = ThreatSentMessage.init();
			ThreatReadDB threatReadDB  = ThreatReadDB.init();
	    chain.doFilter(request, response);//sends request to next resource  
//	          
//	    out.print("filter is invoked after");
		//chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		  
	}

}
