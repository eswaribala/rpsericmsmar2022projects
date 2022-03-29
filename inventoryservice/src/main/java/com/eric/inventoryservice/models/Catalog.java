package com.eric.inventoryservice.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//ORM
@Entity
@Table(name="Catalog")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Catalog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Catalog_Id")
	@ApiModelProperty(hidden = true)
	private long catalogId;
	@Column(name="Catalog_Name",nullable = false,length = 100)
	private String catalogName;
}
