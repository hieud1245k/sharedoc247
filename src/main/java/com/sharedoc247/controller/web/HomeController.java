package com.sharedoc247.controller.web;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sharedoc247.constant.Constant;
import com.sharedoc247.model.DocumentModel;
import com.sharedoc247.model.UserModel;
import com.sharedoc247.service.DocumentService;
import com.sharedoc247.service.UserService;
import com.sharedoc247.utils.FormUtil;
import com.sharedoc247.utils.SessionUtil;

@WebServlet(urlPatterns = { "/trang-chu", "/dang-nhap", "/dang-ky", "/thoat" })
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = -3628466061494830395L;

	@Inject
	private UserService userService;
	
	@Inject
	private DocumentService documentService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = null;
		String action = req.getParameter("action");
		if (action != null && action.equals("login")) {
			rd = req.getRequestDispatcher("/views/login.jsp");
		} else if (action != null && action.equals("register")) {
			rd = req.getRequestDispatcher("/views/register.jsp");
		} else if (action != null && action.equals("logout")) {
				SessionUtil.getInstance().removeValue(req, "USERMODEL");
				resp.sendRedirect(req.getContextPath() + "/trang-chu");
				return;
		} else {
			if (SessionUtil.getInstance().getValue(req, "USERMODEL") != null) {
				
				DocumentModel model = new DocumentModel();
				List<DocumentModel> list = documentService.findAll();
				model.setListResult(list);
				req.setAttribute(Constant.MODEL, model);
				rd = req.getRequestDispatcher("/views/web/home_after_login.jsp");
			} else {
				
				
				rd = req.getRequestDispatcher("/views/web/home.jsp");
			}
		}
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action != null && action.equals("login")) {
			UserModel model = FormUtil.toModel(UserModel.class, req);
			model = userService.findByUsernameAndPassword(model);
			if (model != null) {
				SessionUtil.getInstance().putValue(req, "USERMODEL", model);
				if (model.getRoleId() == 2) {
					resp.sendRedirect(req.getContextPath() + "/trang-chu");
				} else if (model.getRoleId() == 1) {
					resp.sendRedirect(req.getContextPath() + "/admin-home");
				}
			} else {
				resp.sendRedirect(req.getContextPath()
						+ "/dang-nhap?action=login&alert=danger&message=username_password_invalid");
			}
		}
	}
}
