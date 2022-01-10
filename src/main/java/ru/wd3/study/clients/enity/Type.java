package ru.wd3.study.clients.enity;

import javax.persistence.*;

@Table(name = "clientstypes", schema = "public", indexes = {
        @Index(name = "idx_type_id", columnList = "id")
})
@Entity(name = "Type")
public class Type {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    private String title;

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
