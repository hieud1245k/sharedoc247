package com.sharedoc247.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.sharedoc247.model.DocumentModel;

public class DocumentMapper implements RowMapper<DocumentModel> {

	@Override
	public DocumentModel mapRow(ResultSet resultSet) {
		DocumentModel model = new DocumentModel();
		try {
			model.setId(resultSet.getLong("id"));
			model.setCreatedAt(resultSet.getTimestamp("created_at"));
			model.setUpdatedAt(resultSet.getTimestamp("updated_at"));
			model.setDeletedAt(resultSet.getTimestamp("deleted_at"));
			model.setUpdatedBy(resultSet.getLong("updated_by"));
			
			model.setDescription(resultSet.getString("description"));
			model.setDocumentName(resultSet.getString("document_name"));
			model.setDocumentPath(resultSet.getNString("document_path"));
			model.setCost(resultSet.getInt("cost"));
			model.setStatus(resultSet.getInt("status"));
			model.setCategoryId(resultSet.getInt("category_id"));
			model.setUserId(resultSet.getLong("user_id"));
			return model;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
