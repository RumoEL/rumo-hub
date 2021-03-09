package com.github.rumoel.rumoel.libs.pas.torrents;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "peers")
public class Peer implements Serializable {
	private static final long serialVersionUID = -3322920320950469695L;
	@Getter
	@Setter
	@Id
	@Column
	private String hash;
	@Getter
	@Setter
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Torrent torrent;
}
