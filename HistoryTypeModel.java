package com.sharedoc247.model;

public class HistoryTypeModel extends BaseModel<HistoryTypeModel> {

	private String historyTypeName;
	private String code;

	public String getHistoryTypeName() {
		return historyTypeName;
	}

	public void setHistoryTypeName(String historyTypeName) {
		this.historyTypeName = historyTypeName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
