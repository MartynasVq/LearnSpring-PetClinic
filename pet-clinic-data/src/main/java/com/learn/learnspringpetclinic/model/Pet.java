package com.learn.learnspringpetclinic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pets")
public class Pet extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "type_id")
    private PetType petType;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;
    @Column(name = "birthday")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    private Set<Visit> visitSet = new HashSet<>();

    public static PetBuilder builder() {
        return new PetBuilder();
    }

    public static class PetBuilder {
        private PetType petType;
        private Owner owner;
        private LocalDate birthday;
        private String name;
        private Set<Visit> visitSet;

        PetBuilder() {
        }

        public PetBuilder petType(PetType petType) {
            this.petType = petType;
            return this;
        }

        public PetBuilder owner(Owner owner) {
            this.owner = owner;
            return this;
        }

        public PetBuilder birthday(LocalDate birthday) {
            this.birthday = birthday;
            return this;
        }

        public PetBuilder name(String name) {
            this.name = name;
            return this;
        }

        public PetBuilder visitSet(Set<Visit> visitSet) {
            this.visitSet = visitSet;
            return this;
        }

        public Pet build() {
            return new Pet(petType, owner, birthday, name, visitSet);
        }

        public String toString() {
            return "Pet.PetBuilder(petType=" + this.petType + ", owner=" + this.owner + ", birthday=" + this.birthday + ", name=" + this.name + ", visitSet=" + this.visitSet + ")";
        }
    }
}
