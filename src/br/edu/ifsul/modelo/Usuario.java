/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 *
 * @author guilherme
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "usuario")
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING, length = 2)
@DiscriminatorValue(value = "US")
public class Usuario {

}
