package model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "bill", schema = "duongshoe")
public class Bill {
    private int id;
    private String message;
    private Double discount;
    private Double shippingFee;
    private String payment;
    private Timestamp dateOfPayment;
    private int status;
    private Timestamp createDate;
    private Timestamp updateDate;
    private UserTest userByUserTestId;

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
    @Column(name = "message", nullable = true, length = -1)
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Basic
    @Column(name = "discount", nullable = true, precision = 0)
    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    @Basic
    @Column(name = "shipping_fee", nullable = true, precision = 0)
    public Double getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(Double shippingFee) {
        this.shippingFee = shippingFee;
    }

    @Basic
    @Column(name = "payment", nullable = false, length = 255)
    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    @Basic
    @Column(name = "date_of_payment", nullable = false)
    public Timestamp getDateOfPayment() {
        return dateOfPayment;
    }

    public void setDateOfPayment(Timestamp dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
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
        Bill bill = (Bill) o;
        return id == bill.id &&
                status == bill.status &&
                Objects.equals(message, bill.message) &&
                Objects.equals(discount, bill.discount) &&
                Objects.equals(shippingFee, bill.shippingFee) &&
                Objects.equals(payment, bill.payment) &&
                Objects.equals(dateOfPayment, bill.dateOfPayment) &&
                Objects.equals(createDate, bill.createDate) &&
                Objects.equals(updateDate, bill.updateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, message, discount, shippingFee, payment, dateOfPayment, status, createDate, updateDate);
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public UserTest getUserByUserTestId() {
        return userByUserTestId;
    }

    public void setUserByUserTestId(UserTest userByUserTestId) {
        this.userByUserTestId = userByUserTestId;
    }
}
