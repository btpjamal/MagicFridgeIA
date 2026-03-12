package dev.jamal.magicfridgeia.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "food")
public class FoodModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "quantidade")
    private Integer quantidade;

    @Column(name = "validade")
    private LocalDate validade;

    @JoinColumn(name = "categoria")
    @ManyToOne
    @JsonIgnore
    private CategoriaModel categoria;

    public void setCategoria(Long categoriaID) {
        this.categoria = new CategoriaModel();
        this.categoria.setId(categoriaID);
    }
}
