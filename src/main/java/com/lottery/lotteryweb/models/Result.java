package com.lottery.lotteryweb.models;

import com.lottery.lotteryweb.models.audit.Auditable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="results")
public class Result extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "year_id", referencedColumnName = "id")
    private Year year;

    @Column(name = "person", nullable = false, columnDefinition = "INT(1)")
    private Integer person;

    @ManyToOne
    @JoinColumn(name = "game_id", referencedColumnName = "id")
    private Game game;

    @Column(name = "user_id", nullable = false, columnDefinition = "BIGINT(20)")
    private String passId;

    @ManyToOne
    @JoinColumn(name = "gate_id", referencedColumnName = "id")
    private Gate gate;

    @Column(name = "lottery_no", nullable = false, columnDefinition = "INT(5)")
    private Integer lotteryNo;
}
