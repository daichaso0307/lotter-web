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
@Table(name="gates")
public class Gate extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false, columnDefinition = "VARCHAR(10)")
    private String name;

    @OneToMany(mappedBy = "entry")
    private Collection<Entry> entry;
}
