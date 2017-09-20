import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class Cart_view extends HttpServlet {
    Catalog c[] = new Catalog[3];
    
    public void additems(){        
        c[0]=new Catalog("LG xe546 320GB ","Hard disk",65.30);
        c[1]=new Catalog("pc TOSHIBA Core i5 ,Radeon Graphics, 4GB DDR3 ","Laptop TOSHIBA",710.50);
        c[2]=new Catalog("Trust mouse XGVD234  ","Mouse",21.40);
    }
   public Catalog[] getcatalog(){return this.c;};
    
    public void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException{
				PrintWriter out = response.getWriter();
				additems();
					
    out.println("<html>");
                out.println("<center>");
				out.println("<head>");
                out.println("<title> My-Shop</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1 align=center>"+"Welcome to my shop!!"+"</h1>");
				 out.println("<table border=2><tr>");
				 //////////////////
				 
         for(int i=0;i<c.length;i++){
				 out.println("<td>");
                out.println("<p><u>"+c[i].gettitle()+"</u></p>");
                out.println("<p>"+c[i].getitem()+"</p>");
                out.println("<p>"+c[i].getprice()+"  Euro</p>");
				out.println("<form method=\"post\"><input type=\"submit\" value=\"Add to Cart\" name="+c[i].gettitle()+"></form>");
				 
                                 
				 out.println("</td>");
          }
	
		 ////////////////////////////form
				 out.println("</tr></table>");	
	 			 
                out.println("</body>");
				out.print("<hr><A HREF=\"Cart.class\"> Cart </hr>");
				
				out.println("</center>");
				 
                out.println("</html>");
                out.close();
				
			}
			public void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException{
				        PrintWriter out = response.getWriter();
						HttpSession session = request.getSession(); //get session
			String action;
			
				for(int i=0;i<c.length;i++){
				action= request.getParameter("action");
				if(action!=null){
				if (action.equals( c[i].gettitle() )){
	              session.setAttribute(c[i].gettitle(), c[i] );
													}
								}
			
				}

}
}