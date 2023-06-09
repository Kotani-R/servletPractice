package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Human;

@WebServlet("/RequestScopeServlet")
public class RequestScopeServlet extends HttpServlet {
	private static final long selialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエススコープに保存するインスタンスの生成
		Human human = new Human("湊", 23);
		
		// リクエススコープにインスタンスを保存
		request.setAttribute("hunan", human);
		
		//リクエストスコープからインスタンスを取得
		Human h = (Human)request.getAttribute("hunan");
		
		RequestDispatcher dispatcher= request.getRequestDispatcher("WEB-INF/jsp/RequestScopeServlet.jsp");
		dispatcher.forward(request, response);
		
		
		

	}
}
