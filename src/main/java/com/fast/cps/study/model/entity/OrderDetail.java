package com.fast.cps.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString(exclude = {"item", "user"})
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime orderAt;

    //N : 1
    @ManyToOne
    private User user; //user_id 찾아감

    @ManyToOne
    private Item item; //item_id 찾아감
}
