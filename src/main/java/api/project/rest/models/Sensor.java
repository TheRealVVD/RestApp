package api.project.rest.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data //создает разные геттеры, сеттеры, хэш-коды
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Sensor")
public class Sensor implements Serializable { // Serializable для того, чтобы в Measurement можно было сделать FK из поля, не являющемся PK в Sensor (из поля name)
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    @NotEmpty(message = "Название не должно быть пустым!")
    @Size(min = 3, max = 30, message = "Название сенсора должно быть от 3 до 30 символов!")
    private String name;
}
