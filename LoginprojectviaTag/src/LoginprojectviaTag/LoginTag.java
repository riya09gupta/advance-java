package LoginprojectviaTag;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class LoginTag extends TagSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int doStartTag() throws JspException {
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		HttpSession session = request.getSession(false);
		if (session.getAttribute("loginStatus") == null) {
			try {
		 
			((HttpServletResponse) pageContext.getResponse())
					.sendRedirect("http://localhost:8080/LoginprojectviaTag/login.jsp");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	return SKIP_BODY;
}
}

