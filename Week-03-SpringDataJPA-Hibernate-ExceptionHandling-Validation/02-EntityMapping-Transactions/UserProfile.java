package week3.mapping.model;

import jakarta.persistence.*;

/**
 * UserProfile entity representing the inverse side of a bidirectional @OneToOne relationship with User.
 * Uses mappedBy = "profile" so that only one foreign key column exists in the database.
 */
@Entity
@Table(name = "user_profiles")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "phone_number", length = 15)
    private String phoneNumber;

    @Column(name = "address", length = 255)
    private String address;

    @Column(name = "bio", columnDefinition = "TEXT")
    private String bio;

    // Inverse side of OneToOne relationship
    @OneToOne(mappedBy = "profile", fetch = FetchType.LAZY)
    private User user;

    public UserProfile() {}

    public UserProfile(String phoneNumber, String address, String bio) {
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.bio = bio;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getBio() { return bio; }
    public void setBio(String bio) { this.bio = bio; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}
