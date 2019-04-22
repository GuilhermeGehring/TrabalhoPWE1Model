/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 *
 * @author guilherme
 */
@Entity
@Table(name = "nota")
public class Nota implements Serializable {
    
    @Id
    @SequenceGenerator(name = "seq_nota", sequenceName = "seq_nota_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_nota", strategy = GenerationType.SEQUENCE)
    private Integer id;        
    
    @Min(message = "A primeira nota não pode ser negativa", value = 0)
    @NotNull(message = "A primeira nota deve ser informada")
    @Column(name = "nota_01", nullable = false, columnDefinition = "numeric(3,1)")  
    private Double nota01;
    
    @Min(message = "A segunda nota não pode ser negativa", value = 0)
    @NotNull(message = "A segunda nota deve ser informada")
    @Column(name = "nota_02", nullable = false, columnDefinition = "numeric(3,1)")  
    private Double nota02;
    
    @Min(message = "A media não pode ser negativa", value = 0)
    @NotNull(message = "A media deve ser informada")
    @Column(name = "media", nullable = false, columnDefinition = "numeric(3,1)")  
    private Double media;
    
    @NotNull(message = "O aluno deve ser informado")
    @ManyToOne
    @JoinColumn(name = "aluno", referencedColumnName = "id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_aluno_id"))
    private Aluno aluno;
    
    @NotNull(message = "A disciplina deve ser informada")
    @ManyToOne
    @JoinColumn(name = "disciplina", referencedColumnName = "id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_disciplina_id"))
    private Disciplina disciplina;

    public Nota() {        
    }
    
    public Double gerarMedia(double nota01, double nota02) {
        return (this.nota01 + this.nota02) / 2;
    }    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getNota01() {
        return nota01;
    }

    public void setNota01(Double nota01) {
        this.nota01 = nota01;
    }

    public Double getNota02() {
        return nota02;
    }

    public void setNota02(Double nota02) {
        this.nota02 = nota02;
    }

    public Double getMedia() {
        return media;
    }

    public void setMedia(Double media) {
        this.media = media;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Nota other = (Nota) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
        
}
