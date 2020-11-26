package com.sharedoc247.service.Impl;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.sharedoc247.dao.CategoryDao;
import com.sharedoc247.dao.DocumentDao;
import com.sharedoc247.model.CategoryModel;
import com.sharedoc247.model.DocumentModel;
import com.sharedoc247.service.DocumentService;

public class DocumentServiceImpl implements DocumentService {

	private final DocumentDao documentDao;
	private final CategoryDao categoryDao;

	@Inject
	public DocumentServiceImpl(DocumentDao documentDao, CategoryDao categoryDao) {
		this.documentDao = documentDao;
		this.categoryDao = categoryDao;
	}

	@Override
	public List<DocumentModel> findAll() {
		return documentDao.findAll();
	}

	@Override
	public Long save(DocumentModel model) {
		model.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		model.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
		return documentDao.save(model);
	}

	@Override
	public void delele(Long id) {
		DocumentModel model = documentDao.findByIdAndDeletedAtNull(id);
		if (model == null) {

		}
		documentDao.deleteById(id);
	}

	@Override
	public DocumentModel update(DocumentModel model) {
		DocumentModel oldModel = documentDao.findByIdAndDeletedAtNull(model.getId());
		if (oldModel == null)
			return null;
		model.setCreatedAt(oldModel.getCreatedAt());
		model.setStatus(oldModel.getStatus());
		model.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
		model.setUpdatedBy(oldModel.getUpdatedBy());
		documentDao.update(model);
		return model;
	}

	@Override
	public DocumentModel findOne(Long id) {
		DocumentModel documentModel = documentDao.findByIdAndDeletedAtNull(id);
		CategoryModel categoryModel = categoryDao.findById(documentModel.getCategoryId());
		documentModel.setCategoryName(categoryModel.getCategoryName());
		return documentModel;
	}

	@Override
	public void delete(Long id) {
			documentDao.deleteById(id);
	}

	@Override
	public BufferedInputStream showFile(Long id) {
		try {
			DocumentModel model = documentDao.findByIdAndDeletedAtNull(id);
			File file = new File("D:\\sao luu\\WEB-BOOK-HOTEL\\sharedoc247\\" + model.getDocumentPath());
			FileInputStream f = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(f);
			return bis;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
}
