package com.sharedoc247.model;

import java.sql.Timestamp;

public class TransactionModel extends BaseModel<TransactionModel> {

	private Long userId;
	private Long documentId;
	private Long assignBy;
	private Timestamp assignAt;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getDocumentId() {
		return documentId;
	}

	public void setDocumentId(Long documentId) {
		this.documentId = documentId;
	}

	public Long getAssignBy() {
		return assignBy;
	}

	public void setAssignBy(Long assignBy) {
		this.assignBy = assignBy;
	}

	public Timestamp getAssignAt() {
		return assignAt;
	}

	public void setAssignAt(Timestamp assignAt) {
		this.assignAt = assignAt;
	}
}
