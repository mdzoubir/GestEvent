package com.example.GestEvent.Modul;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Events {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    private EventType typeEvent;
    @OneToOne
    private Users createdBy;
    private String description;
    private Date dateDebut;
    private Date deteFin;
    private String related;
    private String element;

    public Events() {
    }

    public Events(int id, EventType typeEvent,Users createdBy, String description, Date dateDebut, Date deteFin, String related, String element) {
        this.id = id;
        this.typeEvent = typeEvent;
        this.createdBy = createdBy;
        this.description = description;
        this.dateDebut = dateDebut;
        this.deteFin = deteFin;
        this.related = related;
        this.element = element;
    }

    public Events(EventType typeEvent,Users createdBy, String description, Date dateDebut, Date deteFin, String related, String element) {
        this.typeEvent = typeEvent;
        this.createdBy = createdBy;
        this.description = description;
        this.dateDebut = dateDebut;
        this.deteFin = deteFin;
        this.related = related;
        this.element = element;
    }


    public Users getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Users createdBy) {
        this.createdBy = createdBy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EventType getTypeEvent() {
        return typeEvent;
    }

    public void setTypeEvent(EventType typeEvent) {
        this.typeEvent = typeEvent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDeteFin() {
        return deteFin;
    }

    public void setDeteFin(Date deteFin) {
        this.deteFin = deteFin;
    }

    public String getRelated() {
        return related;
    }

    public void setRelated(String related) {
        this.related = related;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }


    public void showEvent() {
        System.out.println( "Events{" +
                "id=" + id +
                ", typeEvent=" + typeEvent +
                ", createdBy=" + createdBy +
                ", description='" + description + '\'' +
                ", dateDebut=" + dateDebut +
                ", deteFin=" + deteFin +
                ", related='" + related + '\'' +
                ", element='" + element + '\'' +
                '}');
    }
}
