package com.github.rumoel.rumoel.libs.pas.torrents.report;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import com.github.rumoel.rumoel.libs.pas.torrents.peer.PeerInfo;
import com.github.rumoel.rumoel.libs.pas.torrents.trackers.own.RumoBittorrentTrackerInfo;

import lombok.Getter;
import lombok.Setter;

public class ReportForTorrentPeer implements Serializable {
	private static final long serialVersionUID = 5375481922314433060L;
	@Getter
	private String reportId = UUID.randomUUID().toString();
	@Getter
	private long time = System.currentTimeMillis() / 1000;

	@Getter
	@Setter
	private RumoBittorrentTrackerInfo reporter;

	@Getter
	@Setter
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private CopyOnWriteArrayList<PeerInfo> peerInfo = new CopyOnWriteArrayList<>();

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReportForTorrentPeer [");
		if (reportId != null) {
			builder.append("reportId=");
			builder.append(reportId);
			builder.append(", ");
		}
		if (reporter != null) {
			builder.append("reporter=");
			builder.append(reporter);
			builder.append(", ");
		}
		if (peerInfo != null) {
			builder.append("peerInfo=");
			builder.append(peerInfo);
		}
		builder.append("]");
		return builder.toString();
	}

	public static void correctAddtoPeerList(List<PeerInfo> list, PeerInfo peerInfo) {
		if (list.isEmpty()) {
			list.add(peerInfo);
		} else {
			if (!peerInList(list, peerInfo)) {
				list.add(peerInfo);
			}
		}
	}

	private static boolean peerInList(List<PeerInfo> list, PeerInfo peerInfo) {
		for (PeerInfo peerInfoTest : list) {
			if (peerInfoIsPeerIf(peerInfoTest, peerInfo)) {
				return true;
			}
		}
		return false;
	}

	private static boolean peerInfoIsPeerIf(PeerInfo peer1, PeerInfo peer2) {
		String peer1Host = peer1.getHost();
		String peer2Host = peer2.getHost();
		if (peer1Host.equalsIgnoreCase(peer2Host)) {
			int peer1Port = peer1.getPort();
			int peer2Port = peer2.getPort();
			if (peer1Port == peer2Port) {
				return true;
			}
		}
		return false;
	}

}
