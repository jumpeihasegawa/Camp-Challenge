package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Kadai9_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    HttpSession hs = request.getSession(true);
    Object ProfilesID = hs.getAttribute("ProfilesID");
    Object name = hs.getAttribute("name");
    Object tell = hs.getAttribute("tell");
    Object age = hs.getAttribute("age");
    Object birthday = hs.getAttribute("birthday");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>追加情報</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form action=\"Kadai9Servlet\" method=\"post\">\n");
      out.write("            ID：<input type=\"number\" name=\"ProfilesID\" required>\n");
      out.write("            名前：<input type=\"text\" name=\"name\" required>\n");
      out.write("            電話：<input type=\"tel\" name=\"tell\" maxlength=\"17\" placeholder=\"000-0000-0000\" pattern=\"\\d{3}-\\d{4}-\\d{4}\" required>\n");
      out.write("            年齢：<input type=\"number\" name=\"age\" required>\n");
      out.write("            誕生日：<input type=\"date\" name=\"birthday\" required>            \n");
      out.write("\n");
      out.write("            <input type=\"submit\" value=\"追加\">\n");
      out.write("        </form>\n");
      out.write("        <br>\n");
      out.write("        追加情報\n");
      out.write("        ");

            if (ProfilesID != null) {
                out.print("ID " + ProfilesID + " 名前 " + name + " 電話 " + tell + " 年齢 " + age + " 誕生日 " + birthday + "<br>");
            }
        
      out.write("\n");
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
