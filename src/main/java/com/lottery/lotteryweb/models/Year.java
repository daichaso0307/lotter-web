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
@Table(name="years")
public class Year extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "value", nullable = false, columnDefinition = "INT(5)")
    private int value;

    @OneToMany(mappedBy = "entry")
    private Collection<Entry> entry;
}