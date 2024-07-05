package org.example.footballmanagerdn.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    @DateTimeFormat(pattern = "yyyy/mm/dd")
    private Date dob;
    @NotBlank
    private String homeTown;
    @NotBlank
    private String playingPosition;
    @NotBlank
    private String performance;
    @NotBlank
    @Pattern(regexp = "(^$|[0-9])")
    private Double height;
    @NotBlank
    @Pattern(regexp = "(^$|[0-9])")
    private Double weight;
    @NotBlank
    private String profileRank;
    @NotBlank
    private String avatar;
    @NotBlank
    private String status;

    @OneToMany
    @JoinColumn(name="playerId")
    private Set<Salary> salaries;

    @OneToOne
    @JoinColumn(name = "userId", nullable = false, unique = true)
    private User user;

    public Player() {
    }

    public Player(Long id, String name, Date dob, String homeTown, String playingPosition, String performance, Double height, Double weight, String profileRank, String avatar, String status, Set<Salary> salaries, User user) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.homeTown = homeTown;
        this.playingPosition = playingPosition;
        this.performance = performance;
        this.height = height;
        this.weight = weight;
        this.profileRank = profileRank;
        this.avatar = avatar;
        this.status = status;
        this.salaries = salaries;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public String getPlayingPosition() {
        return playingPosition;
    }

    public void setPlayingPosition(String playingPosition) {
        this.playingPosition = playingPosition;
    }

    public String getPerformance() {
        return performance;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getProfileRank() {
        return profileRank;
    }

    public void setProfileRank(String profileRank) {
        this.profileRank = profileRank;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<Salary> getSalaries() {
        return salaries;
    }

    public void setSalaries(Set<Salary> salaries) {
        this.salaries = salaries;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
