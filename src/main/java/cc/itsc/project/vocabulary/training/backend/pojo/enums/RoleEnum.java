package cc.itsc.project.vocabulary.training.backend.pojo.enums;

/**
 * 身份权限的枚举
 *
 * @author Leonardo iWzl
 **/
public enum RoleEnum {
    //管理员
    ADMIN("Admin"),
    //普通用户
    USER("User"),
    //登录权限
    ALL("Login");

    private final String role;

    RoleEnum(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public static RoleEnum getRole(String role) {
        if(role == null || "".equals(role)){
            return ALL;
        }
        for(RoleEnum roleEnum:values()){
            if(roleEnum.getRole().equals(role)){
                return roleEnum;
            }
        }
        return ALL;
    }
}
