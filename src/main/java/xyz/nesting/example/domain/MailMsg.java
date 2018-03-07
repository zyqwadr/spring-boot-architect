package xyz.nesting.example.domain;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class MailMsg {

    @Id
    private String id;

    private String to;

    private String subject;

    private String text;

    private Date sendDt;
    
    private BigDecimal price;
    
    @DBRef
    private Apple apple;
    

	public Apple getApple() {
		return apple;
	}

	public void setApple(Apple apple) {
		this.apple = apple;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getSendDt() {
        return sendDt;
    }

    public void setSendDt(Date sendDt) {
        this.sendDt = sendDt;
    }

	@Override
	public String toString() {
		return "MailMsg [id=" + id + ", to=" + to + ", subject=" + subject + ", text=" + text + ", sendDt=" + sendDt
				+ ", price=" + price + ", apple=" + apple + "]";
	}
}
