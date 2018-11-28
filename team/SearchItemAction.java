package com.internousdev.casablanca.action;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.casablanca.dao.MCategoryDAO;
import com.internousdev.casablanca.dao.ProductInfoDAO;
import com.internousdev.casablanca.dto.MCategoryDTO;
import com.internousdev.casablanca.dto.ProductInfoDTO;
import com.internousdev.casablanca.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;


public class SearchItemAction extends ActionSupport implements SessionAware{
	private String categoryId;
	private String keywords;
	private List<String> keywordsErrorMessageList;
	private List<ProductInfoDTO> productInfoDtoList;
	private Map<String,Object> session;

	public String execute(){
	InputChecker inputChecker = new InputChecker();
	if(keywords == null || keywords.equals("") || keywords.equals("　")) {
		keywords=" ";
	}
	keywordsErrorMessageList =inputChecker.doCheck("検索ワード",keywords,0,16,true,true,true,true,false,true,false,true,true);
	if (keywordsErrorMessageList.size() == 0) {
		if(categoryId == null) {
			categoryId = "1";
		}
		ProductInfoDAO productInfoDAO = new ProductInfoDAO();
		switch(categoryId){
			/* 「全て」のカテゴリを選択した場合 */
			case "1":
				if (keywords.equals(" ")) {
					productInfoDtoList = productInfoDAO.getProductList();
				} else {
					productInfoDtoList = productInfoDAO.getProductInfoListAll(keywords.trim().replaceAll("　", " ").split("[\\s]+"));
				}
				break;
			/* それ以外のカテゴリを個別選択した場合 */
			default:
				if (keywords.equals(" ")) {
					productInfoDtoList = productInfoDAO.getProductListByCagegoryId(categoryId);
				} else {
					productInfoDtoList = productInfoDAO.getProductInfoListByKeywords(keywords.trim().replaceAll("　", " ").split("[\\s]+"), categoryId);
				}
				break;
		}
		Iterator<ProductInfoDTO> iterator = productInfoDtoList.iterator();
		if(!(iterator.hasNext())){
			productInfoDtoList = null;
		}
	}
	if(!session.containsKey("mCategoryDtoList")){
		MCategoryDAO mCategoryDAO = new MCategoryDAO();
		List<MCategoryDTO> mCategoryDtoList = mCategoryDAO.getMCategoryList();
		session.put("mCategoryDtoList", mCategoryDtoList);
	}
	return SUCCESS;
}

	public void setCategoryId(String categoryId){
		this.categoryId = categoryId;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public String getKeywords() {
		if (keywords.equals(" ")) {
			this.keywords = "";
		}
		return keywords;
	}
	public void setKeywords(String keywords){
		this.keywords = keywords;
	}
	public List<String> getKeywordsErrorMessageList(){
		return keywordsErrorMessageList;
	}
	public List<ProductInfoDTO> getProductInfoDtoList(){
		return productInfoDtoList;
	}
	public void setSession(Map<String,Object> session){
		this.session = session;
	}
}