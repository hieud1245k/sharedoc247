package com.sharedoc247.dao.Impl;

import java.sql.Timestamp;
import java.util.List;

import com.sharedoc247.dao.DocumentDao;
import com.sharedoc247.mapper.DocumentMapper;
import com.sharedoc247.model.DocumentModel;

public class DocumentDaoImpl extends AbstractDAOImpl<DocumentModel> implements DocumentDao {

	@Override
	public List<DocumentModel> findAll() {
		StringBuilder sql = new StringBuilder("SELECT * FROM document where deleted_at is null");
		List<DocumentModel> list = query(sql.toString(), new DocumentMapper());
		return list;
	}

	@Override
	public List<DocumentModel> findbyCategoryId(int categoryId) {
		StringBuilder sql = new StringBuilder("SELECT * FROM document where category_id = ? and deleted_at is null");
		return query(sql.toString(), new DocumentMapper(), categoryId);
	}

	@Override
	public DocumentModel findOne(Long id) {
		StringBuilder sql = new StringBuilder("SELECT * FROM document where id =?");
		List<DocumentModel> list = query(sql.toString(), new DocumentMapper(), id);
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public Long save(DocumentModel model) {
		StringBuilder sql = new StringBuilder(
				"INSERT INTO document(document_name,document_path,cost,category_id,user_id,status,created_at,updated_at) ");
		sql.append(" VALUES(?,?,?,?,?,?,?,?)");
		return insert(sql.toString(), model.getDocumentName(), model.getDocumentPath(), model.getCost(),
				model.getCategoryId(), model.getUserId(), 1,model.getCreatedAt(),model.getUpdatedAt());
	}

	@Override
	public DocumentModel findByIdAndDeletedAtNull(Long id) {
		StringBuilder sql = new StringBuilder("SELECT * FROM document where id = ? and deleted_at is null");
		List<DocumentModel> list = query(sql.toString(), new DocumentMapper(), id);
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public void update(DocumentModel model) {
		StringBuilder sql = new StringBuilder(
				"UPDATE document SET document_name = ?, document_path = ?, cost = ?, category_id = ?,");
		sql.append(" status = ?, updated_at = ?, updated_by = ? WHERE id = ?");
		update(sql.toString(), model.getDocumentName(), model.getDocumentPath(), model.getCost(), model.getCategoryId(),
				1, model.getUpdatedAt(), model.getUpdatedBy(), model.getId());
	}

	@Override
	public void deleteById(Long id) {
		Timestamp deleteTime = new Timestamp(System.currentTimeMillis());
		String sql = "UPDATE document SET deleted_at = ?, updated_at = ? WHERE id = ? and deleted_at is null";
		update(sql,deleteTime,deleteTime,id);
	}
}
