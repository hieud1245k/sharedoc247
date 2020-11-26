package com.sharedoc247.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sharedoc247.model.DocumentModel;
import com.sharedoc247.service.DocumentService;
import com.sharedoc247.utils.HttpUtil;

@WebServlet(urlPatterns = {"/api-document"})
public class DocumentApi extends HttpServlet {

	private static final long serialVersionUID = 4463814658444122797L;
	
	@Inject
	private DocumentService documentService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String action = req.getParameter("action");
		if(action != null && action.equals("delete")) {
			documentService.delete(Long.parseLong(id));
			resp.sendRedirect(req.getContextPath() + "/tai-lieu");
		} else if(action != null && action.equals("update")) {
			resp.sendRedirect(req.getContextPath() + "/tai-lieu?action=update&id="+id);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		DocumentModel model = HttpUtil.of(req.getReader()).toModel(DocumentModel.class);
		Long id = documentService.save(model);
		mapper.writeValue(resp.getOutputStream(), id);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		documentService.delete(Long.parseLong(id));
		resp.sendRedirect(req.getContextPath() + "/tai-lieu");
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		DocumentModel model = HttpUtil.of(req.getReader()).toModel(DocumentModel.class);
		documentService.update(model);
		mapper.writeValue(resp.getOutputStream(), model);
	}
}
