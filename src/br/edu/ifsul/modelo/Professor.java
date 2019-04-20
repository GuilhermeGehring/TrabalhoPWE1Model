/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author guilherme
 */
@Entity
@Table
@DiscriminatorValue(value = "PR")
public class Professor extends Aluno implements Serializable {
    
    @NotNull(message = "A titulação não pode ser nula")
    @NotBlank(message = "A titulação não pode ficar em branco")
    @Length(max = 100, message = "A titulação não pode ter mais que {max} caracteres")
    @Column(name = "titulacao", length = 100, nullable = false)
    private String titulacao;
    
    @NotNull(message = "Os tópicos de interesse não podem ser nulo")
    @NotBlank(message = "Os tópicos de interesse não podem ficar em branco")    
    @Column(name = "topicos_interesse", nullable = false)
    private String topicosInteresse;
    
    @NotNull(message = "A especialidade deve ser informada")
    @ManyToOne
    @JoinColumn(name = "especialidade", referencedColumnName = "id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_especialidade_id"))
    private Especialidade especialidade;

    public Professor() {
        super();
    }
        
    public Professor(Aluno aluno) {
        super.setNome(aluno.getNome());
        super.setEmail(aluno.getNome());
        super.setNascimento(aluno.getNascimento());
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    public String getTopicosInteresse() {
        return topicosInteresse;
    }

    public void setTopicosInteresse(String topicosInteresse) {
        this.topicosInteresse = topicosInteresse;
    }
    
    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.titulacao);
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
        final Professor other = (Professor) obj;
        if (!Objects.equals(this.titulacao, other.titulacao)) {
            return false;
        }
        return true;
    }    
    
}
