package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Ouyou5in_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>標準クラスの課題の応用５</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form action=\"Ouyou5Servlet\" method=\"post\">\n");
      out.write("            名前：<input type=\"name\" name=\"txtNamae\" value=\"");
      out.print( request.getAttribute( "namae" ) );
      out.write("\">\n");
      out.write("            性別：　男<input type=\"radio\" name=\"rdoSeibetu\" value=\"");
      out.print( request.getAttribute( "seibetu" ) );
      out.write("\">　\n");
      out.write("                    女<input type=\"radio\" name=\"rdoSeibetu\" value=\"");
      out.print( request.getAttribute( "seibetu" ) );
      out.write("\">\n");
      out.write("            趣味：<textarea name=\"mulShumi\">");
      out.print( request.getAttribute( "shumi" ) );
      out.write("</textarea>\n");
      out.write("            <input type=\"submit\" value=\"送信\">\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
