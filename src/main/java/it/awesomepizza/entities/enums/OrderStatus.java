package it.awesomepizza.entities.enums;

public enum OrderStatus {
	NEW("N"),
	IN_PROGRESS("P"),
	COMPLETE("C");

	private String status;

	OrderStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
