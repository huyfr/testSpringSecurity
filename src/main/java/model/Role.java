package model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "role", schema = "duongshoe")
public class Role {
    private int id;
    private String roleName;
    private int status;
    private Timestamp createDate;
    private Timestamp updateDate;
    private Collection<UserTest> usersById;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "role_name", nullable = false, length = 255)
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Basic
    @Column(name = "status", nullable = false)
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Basic
    @Column(name = "create_date", nullable = true)
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "update_date", nullable = true)
    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return id == role.id &&
                status == role.status &&
                Objects.equals(roleName, role.roleName) &&
                Objects.equals(createDate, role.createDate) &&
                Objects.equals(updateDate, role.updateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roleName, status, createDate, updateDate);
    }

    @OneToMany(mappedBy = "roleByRoleId")
    public Collection<UserTest> getUsersById() {
        return usersById;
    }

    public void setUsersById(Collection<UserTest> usersById) {
        this.usersById = usersById;
    }
}
