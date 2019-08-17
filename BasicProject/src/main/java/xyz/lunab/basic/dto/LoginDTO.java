package xyz.lunab.basic.dto;

public class LoginDTO {
	private String uid;
	private String upw;
	private boolean useAutoLogin;
	
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUpw() {
		return upw;
	}
	public void setUpw(String upw) {
		this.upw = upw;
	}
	public boolean isUseAutoLogin() {
		return useAutoLogin;
	}
	public void setUseAutoLogin(boolean useAutoLogin) {
		this.useAutoLogin = useAutoLogin;
	}

	@Override
	public String toString() {
		return "LoginDTO [uid=" + uid + ", upw=" + upw + ", useAutoLogin=" + useAutoLogin + "]";
	}
	
	
}
