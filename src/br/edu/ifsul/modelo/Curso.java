/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author guilherme
 */
@Entity
@Table(name = "curso")
public class Curso implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_curso", sequenceName = "seq_curso_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_curso", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotNull(message = "O nome não pode ser nulo")
    @NotBlank(message = "O nome não pode ficar em branco")
    @Length(max = 100, message = "O nome não pode ter mais que {max} caracteres")
    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @NotNull(message = "A sigla não pode ser nula")
    @NotBlank(message = "A sigla não pode ficar em branco")
    @Length(max = 2, message = "A sigla não pode ter mais que {max} caracteres")
    @Column(name = "sigla", length = 2, nullable = false)
    private String sigla;

    @NotNull(message = "A descrição não pode ser nula")
    @NotBlank(message = "A descrição não pode ficar em branco")
    @Column(name = "descricao", nullable = false)
    private String descricao;

    private Boolean ativo;

    @Temporal(TemporalType.DATE)
    @NotNull(message = "A data de início deve ser informada")
    @Column(name = "inicio_atividades", nullable = false)
    private Calendar inicioAtividades;

    @NotNull(message = "A instituição deve ser informada")
    @ManyToOne
    @JoinColumn(name = "instituicao", referencedColumnName = "id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_instituicao_id"))
    private Instituicao instituicao;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Disciplina> disciplinas;//composição, ou seja, a disciplina nao vive sem o curso. Disciplina por sua vez, referencia Curso. É bidirecional pois, não tem sentido

    public Curso() {
        this.ativo = true;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Calendar getInicioAtividades() {
        return inicioAtividades;
    }

    public void setInicioAtividades(Calendar inicioAtividades) {
        this.inicioAtividades = inicioAtividades;
    }

    public Instituicao getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public void adicionarDisciplina(Disciplina obj) {
        obj.setCurso(this);
        this.getDisciplinas().add(obj);
    }

    public void removerDisciplina(int index) {
        this.getDisciplinas().remove(index);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final Curso other = (Curso) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
