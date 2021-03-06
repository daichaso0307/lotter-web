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
@Table(name="entries")
public class Entry extends Auditable {

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

    @Column(name = "user_name", nullable = false, columnDefinition = "VARCHAR(20)")
    private String userName;

    @Column(name = "user_kana", nullable = false, columnDefinition = "VARCHAR(20)")
    private String userKana;

    @Column(name = "email", nullable = false, columnDefinition = "VARCHAR(100)")
    private String email;

    public Entry(
            Year year,
            Game game,
            Gate gate,
            String passId,
            String userName,
            String userKana,
            int person,
            String email) {
        this.year = year;
        this.game = game;
        this.gate = gate;
        this.passId = passId;
        this.userName = userName;
        this.userKana = userKana;
        this.person = person;
        this.email = email;
    }
}
