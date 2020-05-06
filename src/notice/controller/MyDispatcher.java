package notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.ControllerEventListener;

import notice.controller.customer.NoticeDetailController;
import notice.controller.customer.NoticeEditController;

public class MyDispatcher extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		System.out.println("service 신호");
		String uri= request.getRequestURI();
		String conPath=request.getContextPath();
		String com= uri.substring(conPath.length());
		System.out.println("uri : "+uri);
		System.out.println("conPath : "+conPath);
		System.out.println("com : "+com);
		
		NoticeDetailController controller1=new NoticeDetailController();
		NoticeEditController controller2=new NoticeEditController();
		
		try {
			if(com.equals("/customer/noticeDetail.do")) {
				controller1.execute(request, response);	
			}else if(com.equals("/customer/noticeEdit.do")) {
				controller2.execute(request, response);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) 
			throws ServletException, IOException {
		service(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) 
			throws ServletException, IOException {
		service(request, response);
		
	}

}
