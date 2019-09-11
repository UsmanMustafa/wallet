package com.acn.model;

public class LastTrade {
	private Long trade_id;
    private Double price;
    private String size;
    private String time;
    private String bid;
    private String ask;
    private String volume;
    
	public Long getTrade_id() {
		return trade_id;
	}
	public void setTrade_id(Long trade_id) {
		this.trade_id = trade_id;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public String getAsk() {
		return ask;
	}
	public void setAsk(String ask) {
		this.ask = ask;
	}
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
}
