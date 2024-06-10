package com.monkey.project;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "posts")
public class PostData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private String contents;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @PrePersist
    private void init(){
        this.createdAt = LocalDateTime.now();
    }

}
