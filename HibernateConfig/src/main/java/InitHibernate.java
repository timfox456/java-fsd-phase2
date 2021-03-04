

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.example.HibernateUtil;

/**
 * Servlet implementation class InitHibernate
 */
public class InitHibernate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitHibernate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  try {
              PrintWriter out = response.getWriter();
              out.println("<html><body>");

              SessionFactory factory = HibernateUtil.getSessionFactory();
                     
              Session session = factory.openSession();
              out.println("Hibernate Session opened.<br>");
              session.close();
              out.println("Hibernate Session closed.<br>");
                     
              out.println("</body></html>");
                 
                  
       } catch (Exception ex) {
              throw ex;
       }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
        out.println("<html><body>");
        out.println("Hello there, " + fname + " " + lname + "<br>");
        out.println("<a href='index.jsp'>Return to Main Screen</a><br>");
        out.println("</body></html>");

		
		
		
		//doGet(request, response);
	}

}
