package com.sharedoc247.service;

import java.io.BufferedInputStream;
import java.util.List;

import com.sharedoc247.model.DocumentModel;

public interface DocumentService {
	List<DocumentModel> findAll();
	Long save(DocumentModel model);
	void delele(Long id);
	DocumentModel update(DocumentModel model);
	DocumentModel findOne(Long id);
	void delete(Long id);
	BufferedInputStream showFile(Long id);
}
