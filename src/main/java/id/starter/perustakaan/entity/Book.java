package id.starter.perustakaan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @Author "Noverry Ambo"
 * @start 11/1/2023
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "book")
public class Book extends BaseEntity<Book>{

    private static final long serialVersionUID = 1L;

    @Column(name = "title", columnDefinition = "VARCHAR(150)")
    private String title;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "author")
    private String author;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "description")
    private String description;
}
