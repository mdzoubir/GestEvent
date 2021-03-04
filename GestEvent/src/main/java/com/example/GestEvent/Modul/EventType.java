package com.example.GestEvent.Modul;

import javax.persistence.*;

@Entity
@Table(name = "EvenType")
public class EventType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String eventType;

    public EventType() {
    }

    public EventType(int id, String typeEvent) {
        this.id = id;
        this.eventType = typeEvent;
    }

    public EventType(String typeEvent) {
        this.eventType = typeEvent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeEvent() {
        return eventType;
    }

    public void setTypeEvent(String typeEvent) {
        this.eventType = typeEvent;
    }


    public void showTypeCompte() {
        System.out.println("TypeEvent{" +
                "id=" + id +
                ", typeCompte='" + eventType + '\'' +
                '}');
    }
}
