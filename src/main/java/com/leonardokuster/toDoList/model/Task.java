package com.leonardokuster.toDoList.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tasks")
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "Título")
    @NotBlank(message = "O título é obrigatório e não pode estar em branco")
    private String title;

    @Column(name = "Descrição")
    @NotBlank(message = "A descrição é obrigatória")
    private String description;

    @Column(name = "Status")
    private String status = "Pendente";
}
