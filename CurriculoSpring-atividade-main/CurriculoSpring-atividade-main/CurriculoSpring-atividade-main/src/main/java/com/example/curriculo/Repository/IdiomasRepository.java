package com.example.curriculo.Repository;

import com.example.curriculo.Model.Idiomas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdiomasRepository  extends JpaRepository<Idiomas, Long> {
}
