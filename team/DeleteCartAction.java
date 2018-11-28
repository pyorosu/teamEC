package com.internousdev.casablanca.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.casablanca.dao.CartInfoDAO;
import com.internousdev.casablanca.dao.MCategoryDAO;
import com.internousdev.casablanca.dto.CartInfoDTO;
import com.internousdev.casablanca.dto.MCategoryDTO;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteCartAction extends ActionSupport implements SessionAware{
	private Collection<String> checkList = new ArrayList<String>();
	private List<String> checkListErrorMessageList = new ArrayList<String>();
	private Map<String,Object> session;

	public String execute(){
		String result=ERROR;
		CartInfoDAO cartInfoDAO = new CartInfoDAO();
		String userId = null;
		if (checkList.toString().equals("[false]") || checkList.toString().equals("[]") ) {
			/* チェックボックスにチェックしなかった場合のみ表示 */
			checkListErrorMessageList.add("チェックされていません。");
		} else {
			if(Objects.equals(session.get("logined"), "1")){
				userId = String.valueOf(session.get("loginId"));
			} else {
				userId = String.valueOf(session.get("tempUserId"));
			}
			/* チェックリストに入れた品物だけ削除 */
			for(String productId:checkList){
				cartInfoDAO.delete(productId, userId);
			}
			/* DBからカート情報を取得する */
			List<CartInfoDTO> cartInfoDtoList = cartInfoDAO.getCartInfoDtoList(userId);
			Iterator<CartInfoDTO> iterator = cartInfoDtoList.iterator();
			if(!(iterator.hasNext())){
				cartInfoDtoList = null;
			}
			session.put("cartInfoDtoList", cartInfoDtoList);
			int totalPrice = Integer.parseInt(String.valueOf(cartInfoDAO.getTotalPrice(userId)));
			session.put("totalPrice", totalPrice);
			result=SUCCESS;
		}
		if(!session.containsKey("mCategoryDtoList")) {
			MCategoryDAO mCategoryDAO = new MCategoryDAO();
			List<MCategoryDTO> mCategoryDtoList = mCategoryDAO.getMCategoryList();
			session.put("mCategoryDtoList", mCategoryDtoList);
		}
		return result;
	}

	public List<String> getCheckListErrorMessageList(){
		return checkListErrorMessageList;
	}
	public void setCheckList(Collection<String> checkList) {
		this.checkList = checkList;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}