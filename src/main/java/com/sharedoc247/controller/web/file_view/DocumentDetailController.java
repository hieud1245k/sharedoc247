package com.sharedoc247.controller.web.file_view;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sharedoc247.service.DocumentService;

@WebServlet(urlPatterns = { "/show" })
public class DocumentDetailController extends HttpServlet {

	@Inject
	private DocumentService documentService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		resp.setHeader("Content-Type", "application/pdf");
		BufferedInputStream bis = documentService.showFile(Long.parseLong(id));
		BufferedOutputStream bos = new BufferedOutputStream(resp.getOutputStream());

		int t;
		while ((t = bis.read()) != -1) {
			bos.write(t);
		}
		bis.close();
		bos.close();
	}
}
