package progi.project.eventovci.rsvp.entity;

import jakarta.persistence.*;
import progi.project.eventovci.event.entity.Event;
import progi.project.eventovci.user.entity.User;

import java.lang.*;
import java.util.Objects;

@Entity
@Table(name="dolazakkorisnika")
public class UserResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="iddolaskakorisnika")
    private Long id;

    @Column(name="statusdolaska", nullable = false)
    private String status; // OPCIJE: "dolazim", "mozda", "ne dolazim"

    @Column(name="iddogadjanja", nullable = false)
    private Long event_id;

    @Column(name="idkorisnik", nullable = false)
    private Long user_id;

    @ManyToOne
    @JoinColumn(name = "iddogadjanja", referencedColumnName = "iddogadjanja", insertable = false, updatable = false)
    private Event event;

    @ManyToOne
    @JoinColumn(name = "idkorisnik", referencedColumnName = "id", insertable = false, updatable = false)
    private User user;

    //konstruktor

    public UserResponse() {

    }


    public UserResponse(String status, Long event_id, Long user_id) {
        this.status = status;
        this.event_id = event_id;
        this.user_id = user_id;
    }

    //equals i hash za id
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserResponse that = (UserResponse) o;
        return Objects.equals(id, that.id);
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getEvent_id() {
        return event_id;
    }

    public void setEvent_id(Long event_id) {
        this.event_id = event_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
}