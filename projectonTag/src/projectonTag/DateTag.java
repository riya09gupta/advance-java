package projectonTag;

import java.io.IOException;
import java.util.Date;

//import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class DateTag extends SimpleTagSupport {
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		out.println(new Date().toString());
		//printing date via tags run the program from the jsp page
	}

}
