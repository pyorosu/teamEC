package com.internousdev.ecsite.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class InputChecker {
public List<String> doCheck(String propertyName,String value,int minLength,int maxLength,boolean availableAlphabeticCharacters,boolean availableKanji,boolean availableHiragana,boolean availableHalfWidthDigit,boolean availableHalfWidthSymbols,boolean availableKatakana,boolean availableFullWidthSymbols){

	List<String> stringList=new ArrayList<String>();
	List<String> characterTypeList = new ArrayList<String>();

	if(StringUtils.isEmpty(value)){
		stringList.add(propertyName + "を入力してください。");
	}

	if(value.length()<minLength || value.length()>maxLength){
		stringList.add(propertyName + "は" + minLength + "文字以上" + maxLength + "文字以下で入力してください。");
	}

String regularExpression = "";



	if(availableAlphabeticCharacters || availableKanji || availableHiragana || availableHalfWidthDigit || availableHalfWidthSymbols||availableKatakana||availableFullWidthSymbols){
		regularExpression = "[";
	}

	if(availableAlphabeticCharacters){
		regularExpression +="a-zA-Z";
		characterTypeList.add("半角英字");
	}

	if(availableKanji){
		regularExpression +="一-龠";
		characterTypeList.add("漢字");
	}

	if(availableHiragana){
		regularExpression +="ぁ-んー";
		characterTypeList.add("ひらがな");
	}

	if(availableHalfWidthDigit){
		regularExpression +="0-9";
		characterTypeList.add("半角数字");
	}

	if(availableHalfWidthSymbols){
		regularExpression +="@.,;:!#$%&'*+-/=?^_`{|}~ ";
		characterTypeList.add("半角記号");
	}

	if(availableKatakana){
		regularExpression +="ァ-ヺ";
		characterTypeList.add("カタカナ");
	}

	if(availableFullWidthSymbols){
		regularExpression +="、。＠．，；：！＃＄％＆’＊＋／＝？＾＿｀｛｜｝～　";
		characterTypeList.add("全角記号");
	}

	if(!StringUtils.isEmpty(regularExpression)){
		regularExpression +="]+";
	}
	////////////////////////////ここまで///////////////////////////


	//判別した項目に応じてエラーメッセージを返します
	String characterType = "";
	for(int i = 0;i < characterTypeList.size();i++){
		if(i == 0){
			characterType += characterTypeList.get(i).toString();
		}else{
			characterType += "、" + characterTypeList.get(i).toString();
		}
	}

	if(!value.matches(regularExpression)&&!value.equals("")){
		stringList.add(propertyName + "は" + characterType + "で入力してください。");
	}


	return stringList;
}
}

