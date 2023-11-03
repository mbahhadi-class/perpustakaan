package id.starter.perustakaan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author "Noverry Ambo"
 * @start 11/1/2023
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "loan")
public class Loan extends BaseEntity<Loan>{

    private static final long serialVersionUID = 1L;

    @Column(name = "type_identity")
    private String typeIdentity;

    @Column(name = "number_identity")
    private String numberIdentity;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "loan_date")
    @Temporal(TemporalType.DATE)
    private Date loanDate;

    @Column(name = "return_date")
    @Temporal(TemporalType.DATE)
    private Date returnDate;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusLoan status = StatusLoan.BORROWED;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
