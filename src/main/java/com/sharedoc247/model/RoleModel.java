package com.sharedoc247.model;

public class RoleModel extends BaseModel<RoleModel> {

	private String roleName;
	private String code;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
