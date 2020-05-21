package com.jeewms.www.wms.bean.bean;

/**
 * 系统用户父类表
 * @author  admin
 */
public class TSBaseUser implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private String userName;// 用户名
	private String realName;// 真实姓名
	private String browser;// 用户使用浏览器类型
	private String userKey;// 用户验证唯一标示
	private String password;//用户密码
	private Short activitiSync;//是否同步工作流引擎
	/*@Excel(name = "状态")*/
	private Short status;// 状态1：在线,2：离线,0：禁用
	
	private Short deleteFlag;// 状态: 0:不删除  1：删除
	
	private byte[] signature;// 签名文件

	private String departid;

	public void setDepartid(String departid){
		this.departid = departid;
	}
	public String getDepartid(){
		return departid;
	}

	public byte[] getSignature() {
		return signature;
	}
	public void setSignature(byte[] signature) {
		this.signature = signature;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getUserKey() {
		return userKey;
	}

	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}

	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}
	public Short getActivitiSync() {
		return activitiSync;
	}
	public void setActivitiSync(Short activitiSync) {
		this.activitiSync = activitiSync;
	}
	
	
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
//	@JsonIgnore    //getList查询转换为列表时处理json转换异常
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "departid")
//	public TSDepart getTSDepart() {
//		return this.TSDepart;
//	}
//
//	public void setTSDepart(TSDepart TSDepart) {
//		this.TSDepart = TSDepart;
//	}
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRealName() {
		return this.realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public void setDeleteFlag(Short deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	
	public Short getDeleteFlag() {
		return deleteFlag;
	}

}