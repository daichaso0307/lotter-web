package com.lottery.lotteryweb.models;

import com.lottery.lotteryweb.models.audit.Auditable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="games")
public class Game extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "value", nullable = false, columnDefinition = "INT(5)")
    private int value;

    @Column(name = "team", nullable = false, columnDefinition = "VARCHAR(20)")
    private String team;

    @Column(name = "studium", nullable = false, columnDefinition = "VARCHAR(20)")
    private String studium;

    @Column(name = "time", nullable = false, columnDefinition = "VARCHAR(20)")
    private String time;

    @OneToMany(mappedBy = "entry")
    private Collection<Entry> entry;
}
