package com.sharedoc247.dao;

import java.util.List;

import com.sharedoc247.model.DocumentModel;

public interface DocumentDao extends GenericDao<DocumentModel> {
	List<DocumentModel> findAll();
	List<DocumentModel> findbyCategoryId(int categoryId);
	DocumentModel findOne(Long id);
	Long save(DocumentModel model);
	void update(DocumentModel model);
	DocumentModel findByIdAndDeletedAtNull(Long id);
	void deleteById(Long id);
}
