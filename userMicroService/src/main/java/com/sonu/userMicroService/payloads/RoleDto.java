package com.sonu.userMicroService.payloads;


import jakarta.persistence.Column;

public class RoleDto {


    private String roleId;
    @Column(nullable = false, unique = true)
    private String roleName;

    public RoleDto() {
    }
    public RoleDto(String roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "RoleDto{" +
                "roleId='" + roleId + '\'' +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
