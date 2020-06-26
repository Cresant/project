package ua.project.model.good;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "good")
@EqualsAndHashCode(exclude = {"id", "category"})
@NoArgsConstructor
public class Good {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 1, max = 64)
    @Column(name = "title")
    private String title;

    @Column(name = "active", columnDefinition = "boolean default true")
    private Boolean active = true;

    @Size(min = 3)
    @Column(name = "description")
    private String description;

    @Column(name = "small_image_link")
    private String smallImageLink;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price")
    @Digits(integer = 9, fraction = 2)
    private Double price;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;
}
