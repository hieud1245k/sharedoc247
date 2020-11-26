package com.sharedoc247.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sharedoc247.model.UserModel;
import com.sharedoc247.service.UserService;
import com.sharedoc247.utils.FormUtil;
import com.sharedoc247.utils.HttpUtil;
import com.sharedoc247.utils.SessionUtil;

@WebServlet(urlPatterns = {"/api-user"})
public class UserApi extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private UserService userService;

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		UserModel userModel = FormUtil.toModel(UserModel.class, req);
		if(!userModel.getPassword().equals(userModel.getConfirmPassword())) {
			resp.sendRedirect(req.getContextPath() + "/dang-ky?action=register");
			return;
		} else {
			userModel = userService.registerUser(userModel);
			SessionUtil.getInstance().putValue(req, "USERMODEL", userModel);
			resp.sendRedirect(req.getContextPath() + "/trang-chu");
		}
	}
}
