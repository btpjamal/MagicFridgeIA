package dev.jamal.magicfridgeia.Repository;

import dev.jamal.magicfridgeia.Model.CategoriaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long> {
}
