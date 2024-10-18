package com.example.curriculo.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "experiencias")
public class Experiencias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int tempo;
    private int quantidade;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}