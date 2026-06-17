package com.example.TDD.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TodoResponseDTO {
    private Long id;
    private String title;
    private boolean completed;

    public TodoResponseDTO(Long id, String title, boolean completed) {
        this.id = id;
        this.title = title;
        this.completed = completed;
    }


}
