package simple.provider;

import org.apache.ibatis.jdbc.SQL;

public class PrivilegeProvider {
    public String selectById(final Long id) {
        return new SQL() {
            {
            SELECT("id, privilege_name AS privilegeName, "
                    + "privilege_url AS privilegeUrl");
            FROM("sys_privilege");
            WHERE("id = #{id}");
            }
        }.toString();
    }
}
