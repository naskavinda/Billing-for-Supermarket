package manager.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created By Supun Kavinda
 * Email naskavinda@gmail.com
 * Date  : 9/2/2018
 */
@Getter
@Setter
@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @SequenceGenerator(name = "payment_id_seq", sequenceName = "payment_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "payment_id_seq")
    private int id;

    @Column(name = "paid_amount")
    private BigDecimal paidAmount;

    @Column(name = "gross_amount")
    private BigDecimal grossAmount;

    @Column(name = "discount")
    private BigDecimal discount;

    @Column(name = "is_discount_rate")
    private boolean isDiscountRate;

    @Column(name = "net_amount")
    private BigDecimal netAmount;

    @Column(name = "balance")
    private BigDecimal balance;

    @Column(name = "status")
    private boolean status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id", nullable = false)
    private Bill bill;
}
