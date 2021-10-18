package com.usa.ciclo3.ciclo3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

//Entidad
@Entity
//Tabla Skate
@Table(name="Skate")
/**
 * Reto 3: el equipo desarrollará los servicios de backend que antes realizaba en la herramienta APEX de Oracle, ahora,
 * los servicios que serán implementados son los servicios GET que muestran la lista de elementos que hay en las tablas,
 * así como las relaciones que hay en las mismas. También se implementarán todos los servicios POST utilizados para la
 * creación de elementos en las tablas. Se utilizarán los elementos de frontend creados previamente con ciertas
 * modificaciones y se crearán los nuevos para las tablas a las que no se les había creado un Frontend.
 *
 * @author Kelly Johana Solano, Liliana Torres, David Ballen, Nicolas Caicedo y Ruben Ramos.
 * @version 1.0
 * @since 17/10/2021
 */
/**
 * Clase Skateboard
 *
 * @author Kelly Johana Solano Calderon
 * @version 1.0
 * @since 17/10/2021
 */
public class Skateboard implements Serializable {

    /**
     * Atributo Id: key de la patinenta
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * Atributo name: nombre de la patinenta
     */
    @Column(length = 45)
    private String name;
    /**
     * Atributo brand: marca de la patinenta
     */
    @Column(length = 45)
    private String brand;
    /**
     * Atributo year: ano de la patinenta
     */
    @Column(length = 4)
    private Integer year;
    /**
     * Atributo description: descripcion de la patinenta
     */
    @Column(length = 250)
    private String description;

    /**
     * Relacion con category: categoria de la patinenta
     */
    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties("skates")
    private Category category;

    /**
     * Relacion con messages: mnesajes de la patinenta
     */
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "skate")
    @JsonIgnoreProperties({"skate", "client"})
    private List<Message> messages;

    /**
     * Relacion con reservations: reservaciones de la patinenta
     */
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "skate")
    @JsonIgnoreProperties({"skate", "client"})
    private List<Reservation> reservations;

    //Metodo getReservations(). Retorna las reservaciones.
    public List<Reservation> getReservations() {
        return reservations;
    }

    //Metodo setReservations(). Asigna las reservaciones.
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    //Metodo getId(). Retorna el id.
    public Integer getId() {
        return id;
    }

    //Metodo setId(). Asigna el id.
    public void setId(Integer id) {
        this.id = id;
    }

    //Metodo getName(). Retorna el nombre.
    public String getName() {
        return name;
    }

    //Metodo setName(). Asigna el nombre.
    public void setName(String name) {
        this.name = name;
    }

    //Metodo getBrand(). Retorna la marca.
    public String getBrand() {
        return brand;
    }

    //Metodo setBrand(). Asigna la marca.
    public void setBrand(String brand) { this.brand = brand; }

    //Metodo getYear(). Retorna el ano.
    public Integer getYear() {
        return year;
    }

    //Metodo setYear(). Asigna el ano.
    public void setYear(Integer year) {
        this.year = year;
    }

    //Metodo getDescription(). Retorna la descripcion.
    public String getDescription() { return description; }

    //Metodo setDescription(). Asigna la descripcion.
    public void setDescription(String description) {
        this.description = description;
    }

    //Metodo getCategory(). Retorna la categoria.
    public Category getCategory() {
        return category;
    }

    //Metodo setCategory(). Asigna la categoria.
    public void setCategory(Category category) {
        this.category = category;
    }

    //Metodo getMessages(). Retorna los mensajes.
    public List<Message> getMessages() {
        return messages;
    }

    //Metodo setMessages(). Asigna los mensajes.
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}