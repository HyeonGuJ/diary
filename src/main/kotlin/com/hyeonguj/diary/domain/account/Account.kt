package com.hyeonguj.diary.domain.account

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import java.time.LocalDateTime
import java.util.stream.Collectors
import javax.persistence.*

@Entity
class Account(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(updatable = false, insertable = false)
        var id: Long? = null,

        @Column(nullable = false)
        var email: String,
        @Column(nullable = false)
        var password: String,

        var nickname: String,


        @Enumerated(EnumType.STRING)
        @ElementCollection(fetch = FetchType.EAGER)
        var roles: MutableSet<AccountRole>,

        @CreationTimestamp
        var createdTime: LocalDateTime = LocalDateTime.now(),

        @UpdateTimestamp
        var updatedTime: LocalDateTime = LocalDateTime.now()
){
        fun getAuthorities(): User {
                return User(
                        this.email, this.password,
                        this.roles.stream().map { role -> SimpleGrantedAuthority("ROLE_$role") }.collect(Collectors.toSet())
                )
        }
}