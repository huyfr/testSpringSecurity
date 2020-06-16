package model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "duongshoe")
public class UserTest {
    private int id;
    private String firstName;
    private String lastName;
    private boolean gender;
    private Date dateOfBirth;
    private String phone;
    private String address;
    private String email;
    private String username;
    private String password;
    private int status;
    private Timestamp createdDate;
    private Timestamp updateDate;
    private Collection<Bill> billsById;
    private Role roleByRoleId;

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
    @Column(name = "first_name", nullable = false, length = 255)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name", nullable = false, length = 255)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "gender", nullable = false)
    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "date_of_birth", nullable = false)
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Basic
    @Column(name = "phone", nullable = false, length = 30)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "address", nullable = false, length = 255)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 255)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "username", nullable = false, length = 255)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 50)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
    @Column(name = "created_date", nullable = true)
    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
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
        UserTest userTest = (UserTest) o;
        return id == userTest.id &&
                gender == userTest.gender &&
                status == userTest.status &&
                Objects.equals(firstName, userTest.firstName) &&
                Objects.equals(lastName, userTest.lastName) &&
                Objects.equals(dateOfBirth, userTest.dateOfBirth) &&
                Objects.equals(phone, userTest.phone) &&
                Objects.equals(address, userTest.address) &&
                Objects.equals(email, userTest.email) &&
                Objects.equals(username, userTest.username) &&
                Objects.equals(password, userTest.password) &&
                Objects.equals(createdDate, userTest.createdDate) &&
                Objects.equals(updateDate, userTest.updateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, gender, dateOfBirth, phone, address, email, username, password, status, createdDate, updateDate);
    }

    @OneToMany(mappedBy = "userByUserTestId")
    public Collection<Bill> getBillsById() {
        return billsById;
    }

    public void setBillsById(Collection<Bill> billsById) {
        this.billsById = billsById;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
    public Role getRoleByRoleId() {
        return roleByRoleId;
    }

    public void setRoleByRoleId(Role roleByRoleId) {
        this.roleByRoleId = roleByRoleId;
    }
}
