package com.internousdev.casablanca.action;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.casablanca.dao.CartInfoDAO;
import com.internousdev.casablanca.dao.MCategoryDAO;
import com.internousdev.casablanca.dto.CartInfoDTO;
import com.internousdev.casablanca.dto.MCategoryDTO;
import com.internousdev.casablanca.util.CommonUtility;
import com.opensymphony.xwork2.ActionSupport;

public class AddCartAction extends ActionSupport implements SessionAware{
	private int productId;
	private int price;
	private String productCount;
	private Map<String,Object> session;

	public String execute(){
		String result = ERROR;
		String userId = null;
		String tempUserId = null;

		/* 未ログイン状態かつカートにモノがない状態のとき */
		if(!(Objects.equals(session.get("logined"), "1")) && ! (session.containsKey("tempUserId"))){
			CommonUtility commonUtility = new CommonUtility();
			session.put("tempUserId", commonUtility.getRamdomValue());
			}

		/* ログイン済みのとき */
		if(Objects.equals(session.get("logined"), "1")){
			userId = String.valueOf(session.get("loginId"));
		}

		/* 未ログイン状態かつカートにモノがあるとき */
		if(!(Objects.equals(session.get("logined"), "1")) && session.containsKey("tempUserId")) {
			userId=String.valueOf(session.get("tempUserId"));
			tempUserId = String.valueOf(session.get("tempUserId"));
		}
		CartInfoDAO cartInfoDao = new CartInfoDAO();
		int count = cartInfoDao.regist(userId, tempUserId, productId, productCount, price);
		if(count > 0){
			result=SUCCESS;
			List<CartInfoDTO> cartInfoDtoList = cartInfoDao.getCartInfoDtoList(userId);
			Iterator<CartInfoDTO> iterator = cartInfoDtoList.iterator();
			if(!(iterator.hasNext())){
				cartInfoDtoList = null;
			}
			session.put("cartInfoDtoList", cartInfoDtoList);
			int totalPrice = Integer.parseInt(String.valueOf(cartInfoDao.getTotalPrice(userId)));
			session.put("totalPrice", totalPrice);
		}
		if (!session.containsKey("mCategoryDtoList")) {
			MCategoryDAO mCategoryDao = new MCategoryDAO();
			List<MCategoryDTO> mCategoryDtoList = mCategoryDao.getMCategoryList();
			session.put("mCategoryDtoList", mCategoryDtoList);
		}
		return result;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setProductCount(String productCount) {
		this.productCount = productCount;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
