package xyz.nesting.example.domain;

import org.springframework.data.annotation.Id;

public class Apple {

    @Id
    private String id;

    private String to;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	@Override
	public String toString() {
		return "Apple [id=" + id + ", to=" + to + "]";
	}
	
	
}
