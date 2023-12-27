package com.s2r.accesscontrol.model.entity;

import com.s2r.accesscontrol.model.EventType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="logs")
public class LogModel {
    @Id
    @Column(name="log_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="tag", nullable = false)
    private String tag;
    @Column(name="check_date_time", nullable = false)
    private LocalDateTime checkDateTime;
    @Column(name="event", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private EventType event;
    @Column(name = "user_id")
    private Long userId;
}