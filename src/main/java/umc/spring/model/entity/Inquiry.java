package umc.spring.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "inquiries")
public class Inquiry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inquiry_id", nullable = false)
    private Long inquiryId;

    @Column(name = "type")
    private String type;

    @Column(name = "title", nullable = false, length = 10)
    private String title;

    @Column(name = "content", nullable = false, length = 255)
    private String content;

    @Column(name = "is_replied")
    private Boolean isReplied;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
