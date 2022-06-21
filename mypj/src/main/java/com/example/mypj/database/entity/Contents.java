package com.example.mypj.database.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_contents")
public class Contents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String title;

    @Column(length = 2050)
    private String description;

    @Column(length =  9050)
    private String thumbnailImageUrl;

    @Column
    private LocalDateTime dateTime;

}
