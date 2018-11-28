package com.internousdev.ecsite.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateConfirmAction extends ActionSupport implements SessionAware{

	private String loginUserId;
	private String loginPassword;
	private String userName;
	public Map<String,Object>session;

	private List<String> loginUserIdErrorMessageList = new ArrayList<String>();
	private List<String> loginPasswordErrorMessageList = new ArrayList<String>();
	private List<String> userNameErrorMessageList = new ArrayList<String>();

	public String execute(){
		String result=ERROR;
		InputChecker inputChecker = new InputChecker();

			session.put("loginUserId", loginUserId);
			session.put("loginPassword", loginPassword);
			session.put("userName", userName);

			loginUserIdErrorMessageList = inputChecker.doCheck("ログインID",loginUserId,1,8,true,false,false,true,false,false,false);
			loginPasswordErrorMessageList = inputChecker.doCheck("パスワード", loginPassword, 1, 16,true,false,false,true,false,false,false);
			userNameErrorMessageList = inputChecker.doCheck("ユーザー名", userName, 1,8,true,false,false,true,false,false,false);

			if(loginUserIdErrorMessageList.size()==0
					&&loginPasswordErrorMessageList.size()==0
					&&userNameErrorMessageList.size()==0){
				result=SUCCESS;
			}else{
				session.put("loginUserIdErrorMessageList", loginUserIdErrorMessageList);
				session.put("loginPasswordErrorMessageList", loginPasswordErrorMessageList);
				session.put("userNameErrorMessageList", userNameErrorMessageList);
				result=ERROR;
			}
			return result;
	}


	public String getLoginUserId(){
		return loginUserId;
	}
	public void setLoginUserId(String loginUserId){
		this.loginUserId=loginUserId;
	}
	public String getLoginPassword(){
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword){
		this.loginPassword=loginPassword;
	}
	public String getUserName(){
		return userName;
	}
	public void setUserName(String userName){
		this.userName=userName;
	}

	public List<String> getLoginUserIdErrorMessageList(){
		return loginUserIdErrorMessageList;
	}
	public void setLoginUserIdErrorMessageList(List<String> loginUserIdErrorMessageList){
		this.loginUserIdErrorMessageList = loginUserIdErrorMessageList;
	}
	public List<String> getLoginPasswordErrorMessageList(){
		return loginPasswordErrorMessageList;
	}
	public void setLoginPasswordErrorMessageList(List<String> loginPasswordErrorMessageList){
		this.loginPasswordErrorMessageList = loginPasswordErrorMessageList;
	}
	public List<String> getUserNameErrorMessageList(){
		return userNameErrorMessageList;
	}
	public void setUserNameErrorMessageList(List<String> userNameErrorMessageList){
		this.userNameErrorMessageList = userNameErrorMessageList;
	}
	public Map<String,Object> getsession(){
		return session;
	}

	@Override
	public void setSession(Map<String,Object>session){
		this.session=session;
	}
}