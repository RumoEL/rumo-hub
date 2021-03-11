package com.github.rumoel.rumoel.libs.pas.torrents;

import java.io.Serializable;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "torrents")
public class Torrent implements Serializable {
	private static final long serialVersionUID = -1311685397040187997L;
	@Getter
	@Setter
	@Id
	@Column
	private String hash;
	@Getter
	@Setter
	@Column
	private String createdBy;
	@Getter
	@Setter
	@Column
	private long createdDate;

	@Getter
	private CopyOnWriteArrayList<String> announceList = new CopyOnWriteArrayList<>();

	@Getter
	private CopyOnWriteArrayList<FileInTorrent> fileFTorrents = new CopyOnWriteArrayList<>();

}
