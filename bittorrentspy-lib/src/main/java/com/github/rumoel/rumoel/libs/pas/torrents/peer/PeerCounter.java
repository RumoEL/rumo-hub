package com.github.rumoel.rumoel.libs.pas.torrents.peer;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "peercounters")
public class PeerCounter implements Serializable {
	@Id
	@GeneratedValue
	long id;
	private static final long serialVersionUID = 4602007012322023912L;

	private final AtomicLong discoveredTimes = new AtomicLong();
	private final AtomicLong connectedTimes = new AtomicLong();
	private final AtomicLong disconnectedTimes = new AtomicLong();
	private final AtomicInteger piecesCompleted = new AtomicInteger();
	private final AtomicInteger piecesRemaining = new AtomicInteger();

	public void incrementDiscovered() {
		discoveredTimes.addAndGet(1);
	}

	public void incrementConnected() {
		connectedTimes.addAndGet(1);
	}

	public void incrementDisconnected() {
		disconnectedTimes.addAndGet(1);
	}

	public void setPiecesCompleted(int piecesCompleted) {
		this.piecesCompleted.set(piecesCompleted);
	}

	public void setPiecesRemaining(int piecesRemaining) {
		this.piecesRemaining.set(piecesRemaining);
	}

	public long getDiscoveredTimes() {
		return discoveredTimes.get();
	}

	public long getConnectedTimes() {
		return connectedTimes.get();
	}

	public long getDisconnectedTimes() {
		return disconnectedTimes.get();
	}

	public int getPiecesCompleted() {
		return piecesCompleted.get();
	}

	public int getPiecesRemaining() {
		return piecesRemaining.get();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PeerCounter [");
		builder.append("discoveredTimes=");
		builder.append(discoveredTimes);
		builder.append(", ");

		builder.append("connectedTimes=");
		builder.append(connectedTimes);
		builder.append(", ");

		builder.append("disconnectedTimes=");
		builder.append(disconnectedTimes);
		builder.append(", ");

		builder.append("piecesCompleted=");
		builder.append(piecesCompleted);
		builder.append(", ");

		builder.append("piecesRemaining=");
		builder.append(piecesRemaining);
		builder.append("]");
		return builder.toString();
	}

}
