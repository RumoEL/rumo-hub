package com.github.rumoel.rumoel.libs.pas.torrents.torrent;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public class MagnetLink implements Serializable {
	private static final long serialVersionUID = 5537288600648358559L;

	@Getter
	@Setter
	@Id
	private String link;
}
