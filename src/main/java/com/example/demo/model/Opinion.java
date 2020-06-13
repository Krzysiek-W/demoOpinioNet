package com.example.demo.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "opinions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

public class Opinion {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_opinion")
    private Long opinionID;

    @Column(nullable = false, name = "place")
    private String place;

    @Column(nullable = false, name = "opinion_about_the_place")
    private String opinionAboutThePlace;

    @Column(nullable = false, name = "time_stamp")
    @DateTimeFormat(pattern = "MM-dd-yyyy HH:mm")
    private String timeStamp;

    @Column(nullable = false, name = "rate")
    @Enumerated(EnumType.STRING)
    private Rate rate;

    @ManyToOne
    @JoinColumn(name = "reviewer_id")
    private User reviewer;
    @Column(name = "reviewer_id", insertable = false, updatable = false)
    private Long reviewerID;


}
