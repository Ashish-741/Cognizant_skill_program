package week3.mapping.model;

import jakarta.persistence.*;

/**
 * User entity demonstrating a clean @OneToOne bidirectional relationship with UserProfile.
 * Owns the foreign key 'profile_id' referencing UserProfile.
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false, unique = true, length = 50)
    private String username;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    // Unidirectional/Bidirectional OneToOne owning side
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "profile_id", referencedColumnName = "id", nullable = false)
    private UserProfile profile;

    public User() {}

    public User(String username, String email, UserProfile profile) {
        this.username = username;
        this.email = email;
        this.profile = profile;
        if (profile != null) {
            profile.setUser(this);
        }
    }

    public void setProfile(UserProfile profile) {
        this.profile = profile;
        if (profile != null && profile.getUser() != this) {
            profile.setUser(this);
        }
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public UserProfile getProfile() { return profile; }
}
