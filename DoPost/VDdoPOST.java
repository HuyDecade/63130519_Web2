package huyVD;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class VDdoPOST
 */
public class VDdoPOST extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VDdoPOST() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter traVe = response.getWriter();
		traVe.append("Bạn vừa gửi Yêu cầu dạng GET, đây là đáp ứng của tôi");
		String noiDungHTML =" <form method = POST action=\" /HelloWorld/VDdoPOST\">"
				+ "				<label >Họ:<label>"
				+ "				<input type=\"text\" name=\"fname\" ><br>\r\n"
				+ "				<label >Tên:</label>"
				+ "				<input type=\"text\" name=\"lname\"><br>"
				+ "				<input type=\"submit\" value=\"Gửi đi\">"
				+ "	</form>";
		traVe.append(noiDungHTML);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		String value1 = request.getParameter("fname");
		String value2 = request.getParameter("lname");
		PrintWriter traVe = response.getWriter();
		traVe.append("Bạn vừa gửi Yêu cầu dạng POST, đây là đáp ứng của tôi ");
		traVe.append("Giá trị tham số fname =");
		traVe.append(value1);
		traVe.append("\nGiá trị tham số lname =");
		traVe.append(value2);
	}

}
