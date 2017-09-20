import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class Cart extends HttpServlet {
	
	
	public void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
        Cart_view cv=new Cart_view();
		Catalog cat[]=cv.getcatalog();
		HttpSession session = request.getSession(); //get session		
		
		Catalog c[]=new Catalog[3];
		for(int i=0;i<cat.length;i++){
		c[i]= (Catalog) session.getAttribute(cat[i].gettitle());
				
                }
                double totalprice=0;
                
                for(int i=0;i<cat.length;i++){     
                out.println(c[i].gettitle()+" "+c[i].getprice() +"<br />");
                totalprice=totalprice+c[i].getprice();
                }
                
                out.println("Sinoliko Kostos Paraggelias:"+totalprice);
        out.close();
		

		
	}

}