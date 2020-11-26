package com.sharedoc247.controller.admin;

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
import com.sharedoc247.model.CategoryModel;
import com.sharedoc247.model.DocumentModel;
import com.sharedoc247.service.CategoryService;
import com.sharedoc247.service.DocumentService;
import com.sharedoc247.utils.FormUtil;

@WebServlet(urlPatterns = { "/tai-lieu" })
public class DocumentController extends HttpServlet {

	private static final long serialVersionUID = -3701726484654792673L;

	@Inject
	private DocumentService documentService;
	
	@Inject
	private CategoryService categoryService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		RequestDispatcher rd = null;
		if (action != null && action.equals("upload"))
			rd = req.getRequestDispatcher("/views/web/doc/upload.jsp");
		else if (action != null && action.equals("update")) {
			String id = req.getParameter("id");
			DocumentModel model = documentService.findOne(Long.parseLong(id));
			req.setAttribute(Constant.MODEL, model);
			rd = req.getRequestDispatcher("/views/web/doc/update.jsp");
		} else {
			DocumentModel model = FormUtil.toModel(DocumentModel.class, req);
			if (model == null)
				model = new DocumentModel();
			model.setListResult(documentService.findAll());
			List<CategoryModel> categoryModels = categoryService.findAll();
			
			req.setAttribute(Constant.MODEL, model);
			req.setAttribute(Constant.CATEGORIES, categoryModels);
			rd = req.getRequestDispatcher("/views/web/doc/manager.jsp");
		}
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
