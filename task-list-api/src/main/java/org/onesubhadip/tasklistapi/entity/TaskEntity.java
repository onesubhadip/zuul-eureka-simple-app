package org.onesubhadip.tasklistapi.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "TASKS")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskEntity {

    @Id
    @GeneratedValue
    private Long taskId;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

}
