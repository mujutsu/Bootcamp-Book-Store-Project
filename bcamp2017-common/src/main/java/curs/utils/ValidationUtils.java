package curs.utils;

import curs.exceptions.ValidationException;

public class ValidationUtils {

	public static void validatePassword(String pPasswd) throws ValidationException {
		if (pPasswd == null || pPasswd.trim().length() == 0) {
			throw new ValidationException("Empty password");
		}

		pPasswd = pPasswd.trim();
		if (pPasswd.length() < 8) {
			throw new ValidationException("Password needs to at least 8 characters long.");
		}
		
		boolean hasLetters=false;
		boolean hasDigits=false;
		for(int i=0;i<pPasswd.length();i++){
			char c=pPasswd.charAt(i);
			if(Character.isLetter(c)){
				hasLetters=true;
			}
			if(Character.isDigit(c)){
				hasDigits=true;
			}
			
		}
		if(!hasLetters||!hasDigits){
			throw new ValidationException("Password must contain both digits and letters");
		}
	}

}
