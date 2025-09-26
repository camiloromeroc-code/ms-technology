package com.bootcamps.ms_technologies.infrastructure.adapter.out.db;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Table(name = "technology")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TechnologyEntity {
    @Id
    private Long id;
    private String name;
    private String description;
}