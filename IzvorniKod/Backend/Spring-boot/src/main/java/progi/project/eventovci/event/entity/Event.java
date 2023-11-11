package progi.project.eventovci.event.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import progi.project.eventovci.user.entity.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.lang.Long;


@Entity
@Table(name="dogadjanje")
public class Event {

    @Id
    @Column(name="iddogadjanja")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="nazivdogadjanja")
    @NotBlank
    private String eventName;

    @Column(name="tipdogadjanja")
    @NotBlank
    private String typeOfEvent;

    @Column(name="lokacijadogadjanja")
    @NotBlank
    private String location;


    @Column(name="vrijemedogadjanja")
    @NotBlank
    private LocalDateTime timeOfTheEvent;

    @Column(name="trajanje")
    private Double duration;

    @Column(name="organizatorid")
    @NotNull
    private Long eventCoordinatorid;

    @Column(name="cijenaulaznice")
    @NotNull
    private Double ticketPrice;// 0 - besplatan dogadjaj

    @Column(name = "opis", length=1500)
    private String text;

    @ManyToOne
    @JoinColumn(name = "organizatorid", referencedColumnName = "id", insertable = false, updatable = false)
    private User organizator;


    //konstruktor
    public Event() {

    }

    public Event(String eventName, String typeOfEvent, String location, LocalDateTime timeOfTheEvent, Double duration, Long eventCoordinatorid, Double ticketPrice) {
        this.eventName = eventName;
        this.typeOfEvent = typeOfEvent;
        this.location = location;
        this.timeOfTheEvent = timeOfTheEvent;
        this.duration = duration;
        this.eventCoordinatorid = eventCoordinatorid;
        this.ticketPrice = ticketPrice;
    }

    //equals i hash za id

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(id, event.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    //geteri i seteri


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getTypeOfEvent() {
        return typeOfEvent;
    }

    public void setTypeOfEvent(String typeOfEvent) {
        this.typeOfEvent = typeOfEvent;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getTimeOfTheEvent() {
        return timeOfTheEvent;
    }

    public void setTimeOfTheEvent(LocalDateTime timeOfTheEvent) {
        this.timeOfTheEvent = timeOfTheEvent;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public Long getEventCoordinatorid() {
        return eventCoordinatorid;
    }

    public void setEventCoordinatorid(Long eventCoordinatorid) {
        this.eventCoordinatorid = eventCoordinatorid;
    }

    public Double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}