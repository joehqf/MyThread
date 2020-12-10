package com.joe.designmode.creational.prototype;

/**
 * all. 需要发送出去的邮件账单
 */
public class Mail implements Cloneable {
	// 收件人
	private String receiver;

	// 邮件名称
	private String subject;

	// 称谓
	private String appellation;

	// 邮件内容
	private String contxt;

	// 邮件的尾部，一般都是加上“XXX版权所有”等信息
	private String tail;

	// 构造函数
	public Mail(AdvTemplate advTemplate) {
		this.contxt = advTemplate.getAdvContext();
		this.subject = advTemplate.getAdvSubject();
	}

	@Override
	public Mail clone() {
		Mail mail = null;
		try {
			mail = (Mail) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return mail;
	}

	// 以下为getter/setter方法
	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getAppellation() {
		return appellation;
	}

	public void setAppellation(String appellation) {
		this.appellation = appellation;
	}

	public String getContxt() {
		return contxt;
	}

	public void setContxt(String contxt) {
		this.contxt = contxt;
	}

	public String getTail() {
		return tail;
	}

	public void setTail(String tail) {
		this.tail = tail;
	}

}

class AdvTemplate {
	// 广告信名称
	private String advSubject = "XX银行国庆信用卡抽奖活动";

	// 广告信内容
	private String advContext = "国庆抽奖活动通知：只要刷卡就送你1百万！....";

	// 取得广告信的名称
	public String getAdvSubject() {
		return this.advSubject;
	}

	// 取得广告信的内容
	public String getAdvContext() {
		return this.advContext;
	}
}
