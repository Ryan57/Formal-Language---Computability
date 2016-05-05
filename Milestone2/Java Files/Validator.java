/* Author - Ryan_Owens  
 * Version 1.0 
 * Formal Language & Computability - Milestone 2
 */



import java.awt.Color;

import javax.swing.JTextPane;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

public class Validator {
	
	String str = null;

	
	public void Validate(JTextPane textPane) {
		
		int currChar = 0;
		str = textPane.getText().toLowerCase();
		
		while(currChar < str.length()) {
			currChar = State00(currChar, currChar, textPane); 		
		}
		
	}
	
	public void styleText(int start, int end, Color c, JTextPane textPane) {
		StyleContext contxt = StyleContext.getDefaultStyleContext();
		
		AttributeSet atr = contxt.addAttribute(contxt.getEmptySet(), StyleConstants.Foreground, c);
		StyledDocument doc = textPane.getStyledDocument();
		
		doc.setCharacterAttributes(start, (end - start) + 1, atr, true);
	}

	public int State00(int startChar, int currChar, JTextPane textPane) {
		if(currChar >= str.length()) {
			return StateErr(startChar, currChar - 1, textPane);		
		}
		
		if(str.charAt(currChar) == 'v') {
			return State01(startChar, currChar + 1, textPane);
		}
		else if(str.charAt(currChar) == 'p') {
			return State06(startChar, currChar + 1, textPane);
		}
		else if(Character.isAlphabetic(str.charAt(currChar))) {
			return State22(startChar, currChar + 1, textPane);
		}
		else if(Character.isWhitespace(str.charAt(currChar))) {		
			return State00(startChar, currChar + 1, textPane);
		}
		else if(str.charAt(currChar) == '*') {
			return State32(startChar, currChar + 1, textPane);
		}
		else
			return StateErr(startChar, currChar, textPane);
		
	}
	
	public int State01(int startChar, int currChar, JTextPane textPane) {
		if(currChar >= str.length()) {
			return StateErr(startChar, currChar - 1, textPane);		
		}
		
		if(str.charAt(currChar) == 'a') {
			return State02(startChar, currChar + 1, textPane);
		}
		else if(str.charAt(currChar) == ' ') {
			return State23(startChar, currChar + 1, textPane);
		}
		else if(Character.isWhitespace(str.charAt(currChar))) {		
			return State01(startChar, currChar + 1, textPane);
		}
		else 
			return StateErr(startChar, currChar, textPane);
		
	}
	
	public int State02(int startChar, int currChar, JTextPane textPane) {
		if(currChar >= str.length()) {
			return StateErr(startChar, currChar - 1, textPane);		
		}
			
		if(str.charAt(currChar) == 'r') {
			return State03(startChar, currChar + 1, textPane);
		}
		else if(str.charAt(currChar) == ' ') {
			return State04(startChar, currChar + 1, textPane);
		}
		else if(Character.isWhitespace(str.charAt(currChar))) {		//Checks for new lines and tab's (needed in all)
			return State02(startChar, currChar + 1, textPane);
		}
		else
			return StateErr(startChar, currChar, textPane);
		
	}
	
	public int State03(int startChar, int currChar, JTextPane textPane) {
		if(currChar >= str.length()) {
			return StateErr(startChar, currChar - 1, textPane);		
		}
		
		if(str.charAt(currChar) == ' ') {
			styleText(startChar, currChar, Color.ORANGE, textPane);
			return State04(currChar + 1, currChar + 1, textPane);
		}
		else if(Character.isWhitespace(str.charAt(currChar))) {		
			return State03(startChar, currChar + 1, textPane);
		}
		else
			return StateErr(startChar, currChar, textPane);
		
	}
	
	public int State04(int startChar, int currChar, JTextPane textPane) {
		if(currChar >= str.length()) {
			return StateErr(startChar, currChar - 1, textPane);		
		}
		//styleText(startChar, currChar - 1, Color.ORANGE, textPane);
		
		if(Character.isAlphabetic(str.charAt(currChar))) {
			styleText(currChar, currChar, Color.BLUE, textPane);
			return State05(currChar + 1, currChar + 1, textPane);
		}
		else if(Character.isWhitespace(str.charAt(currChar))) {
			return State04(startChar, currChar + 1, textPane);
		}
		else
			return StateErr(startChar, currChar, textPane);
		
	}
	
	//Accepting Statemnt VarDecl
	public int State05(int startChar, int currChar, JTextPane textPane) {
		if(currChar >= str.length()) {
			return currChar;		
		}
		
		
		if(Character.isWhitespace(str.charAt(currChar))) {		
			return State05(currChar + 1, currChar + 1, textPane);
		}
		
		return currChar;
	}
	
	//Start PrintStatement
	public int State06(int startChar, int currChar, JTextPane textPane) {
		if(currChar >= str.length()) {
			return StateErr(startChar, currChar - 1, textPane);		
		}
		
		if(str.charAt(currChar) == 'r') {
			return State07(startChar, currChar + 1, textPane);
		}
		else if(str.charAt(currChar) == ' ') {
			return State23(startChar, currChar + 1, textPane);
		}
		else if(Character.isWhitespace(str.charAt(currChar))) {
			return State06(startChar, currChar + 1, textPane);
		}
		else
			return StateErr(startChar, currChar, textPane);
		
	}
	
	public int State07(int startChar, int currChar, JTextPane textPane) {
		if(currChar >= str.length()) {
			return StateErr(startChar, currChar - 1, textPane);		
		}
		
		if(str.charAt(currChar) == 'i') {
			return State08(startChar, currChar + 1, textPane);
		}
		else if(Character.isWhitespace(str.charAt(currChar))) {
			return State07(startChar, currChar + 1, textPane);
		}
		else 
			return StateErr(startChar, currChar, textPane);
		
	}
	
	public int State08(int startChar, int currChar, JTextPane textPane) {
		if(currChar >= str.length()) {
			return StateErr(startChar, currChar - 1, textPane);		
		}
		
		if(str.charAt(currChar) == 'n') {
			return State09(startChar, currChar + 1, textPane);
		}
		else if(Character.isWhitespace(str.charAt(currChar))) {
			return State08(startChar, currChar + 1, textPane);
		}
		else 
			return StateErr(startChar, currChar, textPane);
	}
	
	public int State09(int startChar, int currChar, JTextPane textPane) {
		if(currChar >= str.length()) {
			return StateErr(startChar, currChar - 1, textPane);		
		}
		
		if(str.charAt(currChar) == 't') {
			return State10(startChar, currChar + 1, textPane);
		}
		else if(Character.isWhitespace(str.charAt(currChar))) {
			return State09(startChar, currChar + 1, textPane);
		}
		else 
			return StateErr(startChar, currChar, textPane);
	}
	
	public int State10(int startChar, int currChar, JTextPane textPane) {
		if(currChar >= str.length()) {
			return StateErr(startChar, currChar - 1, textPane);		
		}
		
		if(str.charAt(currChar) == '(') {
			return State11(startChar, currChar + 1, textPane);
		}
		else if(Character.isWhitespace(str.charAt(currChar))) {
			return State10(startChar, currChar + 1, textPane);
		}
		else 
			return StateErr(startChar, currChar, textPane);
	}
	
	public int State11(int startChar, int currChar, JTextPane textPane) {
		if(currChar >= str.length()) {
			return StateErr(startChar, currChar - 1, textPane);		
		}
		
		if(str.charAt(currChar) == ' ') {
			//prntStart = startChar;
			//prntEnd = currChar - 1;
			styleText(startChar, currChar, Color.GREEN, textPane);
			return State12(currChar + 1, currChar + 1, textPane);
		}
		else if(Character.isWhitespace(str.charAt(currChar))) {			//Do I need this here?
			return State12(startChar, currChar + 1, textPane);
		}
		else 
			return StateErr(startChar, currChar, textPane);
		
	}
	
	public int State12(int startChar, int currChar, JTextPane textPane) {
		if(currChar >= str.length()) {
			return StateErr(startChar, currChar - 1, textPane);		
		}
		
		if(Character.isDigit(str.charAt(currChar))) {
			styleText(currChar, currChar, Color.RED, textPane);
			return State13(currChar + 1, currChar + 1, textPane);
		}
		else if(Character.isAlphabetic(str.charAt(currChar))) {
			styleText(currChar, currChar, Color.BLUE, textPane);
			return State14(currChar + 1, currChar + 1, textPane);
		}
		else if(str.charAt(currChar) == '"') {
			return State15(startChar, currChar + 1, textPane);
		}
		else if(Character.isWhitespace(str.charAt(currChar))) {
			return State12(startChar, currChar + 1, textPane);
		}
		else 
			return StateErr(startChar, currChar, textPane);
		
	}
	
	public int State13(int startChar, int currChar, JTextPane textPane) {
		if(currChar >= str.length()) {
			return StateErr(startChar, currChar - 1, textPane);		
		}
		
		
		if(str.charAt(currChar) == ' ') {
			return State20(startChar, currChar + 1, textPane);
		}
		else if(Character.isWhitespace(str.charAt(currChar))) {
			return State13(startChar, currChar + 1, textPane);
		}
		else 
			return StateErr(startChar, currChar, textPane);
		
	}
	
	public int State14(int startChar, int currChar, JTextPane textPane) {
		if(currChar >= str.length()) {
			return StateErr(startChar, currChar - 1, textPane);		
		}
		
		if(str.charAt(currChar) == ' ') {
			return State20(startChar, currChar + 1, textPane);
		}
		else if(Character.isWhitespace(str.charAt(currChar))) {
			return State14(startChar, currChar + 1, textPane);
		}
		else 
			return StateErr(startChar, currChar, textPane);
	}
	
	public int State15(int startChar, int currChar, JTextPane textPane) {
		if(currChar >= str.length()) {
			return StateErr(startChar, currChar - 1, textPane);		
		}
		
		if(str.charAt(currChar) == ' ') {
			return State16(startChar, currChar + 1, textPane);
		}
		else if(Character.isWhitespace(str.charAt(currChar))) {
			return State15(startChar, currChar + 1, textPane);
		}
		else 
			return StateErr(startChar, currChar, textPane);
	}
	
	public int State16(int startChar, int currChar, JTextPane textPane) {
		if(currChar >= str.length()) {
			return StateErr(startChar, currChar - 1, textPane);		
		}
		
		if(str.charAt(currChar) == ' ') {
			return State16(startChar, currChar + 1, textPane);
		}
				
		if(Character.isAlphabetic(str.charAt(currChar))) {
			return State17(startChar, currChar + 1, textPane);
			
		}
		else if(Character.isWhitespace(str.charAt(currChar))) {
			return State16(startChar, currChar + 1, textPane);
		}
		
		else 
			return StateErr(startChar, currChar, textPane);
		
	}
	
	public int State17(int startChar, int currChar, JTextPane textPane) {
		if(currChar >= str.length()) {
			return StateErr(startChar, currChar - 1, textPane);		
		}
		
		if(Character.isAlphabetic(str.charAt(currChar))) {
			return State17(startChar, currChar + 1, textPane);
		}
		else if(str.charAt(currChar) == ' ') {
			return State18(startChar, currChar + 1, textPane);
		}
		else if(Character.isWhitespace(str.charAt(currChar))) {
			return State17(startChar, currChar + 1, textPane);
		}
		else 
			return StateErr(startChar, currChar, textPane);
	}
	
	public int State18(int startChar, int currChar, JTextPane textPane) {
		if(currChar >= str.length()) {
			return StateErr(startChar, currChar - 1, textPane);		
		}
		
		if(Character.isAlphabetic(str.charAt(currChar))) {
			return State17(startChar, currChar + 1, textPane);
		}
		else if(str.charAt(currChar) == ' ') {
			return State18(startChar, currChar + 1, textPane);
		}
		else if(str.charAt(currChar) == '"') {
			return State19(startChar, currChar + 1, textPane);
		}
		else if(Character.isWhitespace(str.charAt(currChar))) {
			return State18(startChar, currChar + 1, textPane);
		}
		else 
			return StateErr(startChar, currChar, textPane);
	}
	
	public int State19(int startChar, int currChar, JTextPane textPane) {
		if(currChar >= str.length()) {
			return StateErr(startChar, currChar - 1, textPane);		
		}
		styleText(startChar, currChar, Color.CYAN, textPane);
		
		if(str.charAt(currChar) == ' ') {
			return State20(startChar, currChar + 1, textPane);
		}
		else if(Character.isWhitespace(str.charAt(currChar))) {
			return State19(startChar, currChar + 1, textPane);
		}
		else 
			return StateErr(startChar, currChar, textPane);
	}
	
	public int State20(int startChar, int currChar, JTextPane textPane) {
		if(currChar >= str.length()) {
			return StateErr(startChar, currChar - 1, textPane);		
		}
		
		if(str.charAt(currChar) == '+') {
			styleText(currChar, currChar, Color.BLACK, textPane);
			return State39(startChar, currChar + 1, textPane);
		}
		else if(str.charAt(currChar) == ')') {
			styleText(currChar, currChar, Color.GREEN, textPane);
			return State21(startChar, currChar + 1, textPane);
		}
		else if(Character.isWhitespace(str.charAt(currChar))) {
			return State20(startChar, currChar + 1, textPane);
		}
		else 
			return StateErr(startChar, currChar, textPane);
	}
	
	public int State21(int startChar, int currChar, JTextPane textPane) {
		
			return currChar;
		
	}
	
	public int State22(int startChar, int currChar, JTextPane textPane) {
		if(currChar >= str.length()) {
			return StateErr(startChar, currChar - 1, textPane);		
		}
		styleText(startChar, currChar, Color.BLUE, textPane);
		
		if(str.charAt(currChar) == ' ') {
			return State23(currChar + 1, currChar + 1, textPane);
		}
		else if(Character.isWhitespace(str.charAt(currChar))) {
			return State22(currChar + 1, currChar + 1, textPane);
		}
		else 
			return StateErr(startChar, currChar, textPane);
	}
	
	public int State23(int startChar, int currChar, JTextPane textPane) {
		if(currChar >= str.length()) {
			return StateErr(startChar, currChar - 1, textPane);		
		}
		
		if(str.charAt(currChar) == '=') {
			styleText(currChar, currChar, Color.BLACK, textPane);
			return State24(currChar + 1, currChar + 1, textPane);
		}
		else if(Character.isWhitespace(str.charAt(currChar))) {
			return State23(startChar, currChar + 1, textPane);
		}
		else 
			return StateErr(startChar, currChar, textPane);
	}
	
	public int State24(int startChar, int currChar, JTextPane textPane) {
		if(currChar >= str.length()) {
			return StateErr(startChar, currChar - 1, textPane);		
		}
		
		if(str.charAt(currChar) == ' ') {
			return State25(startChar, currChar + 1, textPane);
		}
		else if(Character.isWhitespace(str.charAt(currChar))) {
			return State24(startChar, currChar + 1, textPane);
		}
		else 
			return StateErr(startChar, currChar, textPane);
	}
	
	public int State25(int startChar, int currChar, JTextPane textPane) {
		if(currChar >= str.length()) {
			return StateErr(startChar, currChar - 1, textPane);		
		}
		
		if(Character.isDigit(str.charAt(currChar))) {
			styleText(currChar, currChar, Color.RED, textPane);
			return State26(currChar + 1, currChar + 1, textPane);
		}
		else if(Character.isAlphabetic(str.charAt(currChar))) {
			styleText(currChar, currChar, Color.BLUE, textPane);
			return State05(currChar + 1, currChar + 1, textPane);
		}
		else if(str.charAt(currChar) == '"') {
			return State27(currChar, currChar + 1, textPane);
		}
		else if(Character.isWhitespace(str.charAt(currChar))) {
			return State25(startChar, currChar + 1, textPane);
		}
		else 
			return StateErr(startChar, currChar, textPane);
	}
	
	public int State26(int startChar, int currChar, JTextPane textPane) {
		if(currChar >= str.length()) {
			return currChar;		
		}
		
		if(str.charAt(currChar) == '+') {
			styleText(currChar, currChar, Color.BLACK, textPane);
			return State25(currChar + 1, currChar + 1, textPane);
		}
		else if(Character.isWhitespace(str.charAt(currChar))) {
			return State26(startChar, currChar + 1, textPane);
		}
		else
			return currChar;
	}
	
	public int State27(int startChar, int currChar, JTextPane textPane) {
		if(currChar >= str.length()) {
			return StateErr(startChar, currChar - 1, textPane);		
		}
		
		if(str.charAt(currChar) == ' ') {
			return State28(startChar, currChar + 1, textPane);
		}
		else if(Character.isWhitespace(str.charAt(currChar))) {
			return State27(startChar, currChar + 1, textPane);
		}
		else 
			return StateErr(startChar, currChar, textPane);
	}
	
	public int State28(int startChar, int currChar, JTextPane textPane) {
		if(currChar >= str.length()) {
			return StateErr(startChar, currChar - 1, textPane);		
		}
		
		if(str.charAt(currChar) == ' ') {
			return State28(startChar, currChar + 1, textPane);
		}
		else if(Character.isAlphabetic(str.charAt(currChar))) {
			return State29(startChar, currChar + 1, textPane);
		}
		else if(Character.isWhitespace(str.charAt(currChar))) {
			return State28(startChar, currChar + 1, textPane);
		}
		else 
			return StateErr(startChar, currChar, textPane);
	}
	
	public int State29(int startChar, int currChar, JTextPane textPane) {
		if(currChar >= str.length()) {
			return StateErr(startChar, currChar - 1, textPane);		
		}
		
		if(Character.isAlphabetic(str.charAt(currChar))) {
			return State29(startChar, currChar + 1, textPane);
		}
		else if(str.charAt(currChar) == ' ') {
			return State30(startChar, currChar + 1, textPane);
		}
		else if(Character.isWhitespace(str.charAt(currChar))) {
			return State29(startChar, currChar + 1, textPane);
		}
		else 
			return StateErr(startChar, currChar, textPane);
	}
	
	public int State30(int startChar, int currChar, JTextPane textPane) {
		if(currChar >= str.length()) {
			return StateErr(startChar, currChar - 1, textPane);		
		}
		
		if(str.charAt(currChar) == ' ') {
			return State30(startChar, currChar + 1, textPane);
		}
		else if(str.charAt(currChar) == '"') {
			return State31(startChar, currChar + 1, textPane);
		}
		else if(Character.isWhitespace(str.charAt(currChar))) {
			return State30(startChar, currChar + 1, textPane);
		}
		else 
			return StateErr(startChar, currChar, textPane);
	}
	
	public int State31(int startChar, int currChar, JTextPane textPane) {
		if(currChar >= str.length()) {
			return StateErr(startChar, currChar - 1, textPane);		
		}
		styleText(startChar, currChar, Color.CYAN, textPane);
		
		
		return currChar;
	}
	
	public int State32(int startChar, int currChar, JTextPane textPane) {
		if(currChar >= str.length()) {
			return StateErr(startChar, currChar - 1, textPane);		
		}
		
		if(str.charAt(currChar) == '*') {
			return State32(startChar, currChar + 1, textPane);
		}
		else if(str.charAt(currChar) == '-') {
			return State33(startChar, currChar + 1, textPane);
		}
		else if(Character.isWhitespace(str.charAt(currChar))) {
			return State32(startChar, currChar + 1, textPane);
		}
		else 
			return StateErr(startChar, currChar, textPane);
	}
	
	public int State33(int startChar, int currChar, JTextPane textPane) {
		if(currChar >= str.length()) {
			return StateErr(startChar, currChar - 1, textPane);		
		}
		
		if(str.charAt(currChar) == ' ') {
			return State34(startChar, currChar + 1, textPane);
		}
		else if(Character.isWhitespace(str.charAt(currChar))) {
			return State33(startChar, currChar + 1, textPane);
		}
		else 
			return StateErr(startChar, currChar, textPane);
	}
	
	public int State34(int startChar, int currChar, JTextPane textPane) {
		if(currChar >= str.length()) {
			return StateErr(startChar, currChar - 1, textPane);		
		}
		
		if(Character.isAlphabetic(str.charAt(currChar))) {
			return State34(startChar, currChar + 1, textPane);
		}
		else if(str.charAt(currChar) == ' '){
			return State35(startChar, currChar + 1, textPane);
		}
		else if(Character.isWhitespace(str.charAt(currChar))) {
			return State34(startChar, currChar + 1, textPane);
		}
		else 
			return StateErr(startChar, currChar, textPane);
	}
	
	public int State35(int startChar, int currChar, JTextPane textPane) {
		if(currChar >= str.length()) {
			return StateErr(startChar, currChar - 1, textPane);		
		}
		

		if(Character.isAlphabetic(str.charAt(currChar))) {
			return State34(startChar, currChar + 1, textPane);
		}
		else if(str.charAt(currChar) == '-') {
			return State37(startChar, currChar + 1, textPane);
		}
		else if(str.charAt(currChar) == ' ') {
			return State36(startChar, currChar + 1, textPane);
		}
		else if(Character.isWhitespace(str.charAt(currChar))) {
			return State35(startChar, currChar + 1, textPane);
		}
		else 
			return StateErr(startChar, currChar, textPane);
	}
	
	public int State36(int startChar, int currChar, JTextPane textPane) {
		if(currChar >= str.length()) {
			return StateErr(startChar, currChar - 1, textPane);		
		}
		
		if(str.charAt(currChar) == ' ') {
			return State36(startChar, currChar + 1, textPane);
		}
		else if(str.charAt(currChar) == '-') {
			return State37(startChar, currChar + 1, textPane);
		}
		else if(Character.isWhitespace(str.charAt(currChar))) {
			return State36(startChar, currChar + 1, textPane);
		}
		else 
			return StateErr(startChar, currChar, textPane);
	}
	
	public int State37(int startChar, int currChar, JTextPane textPane) {
		if(currChar >= str.length()) {
			return StateErr(startChar, currChar - 1, textPane);		
		}
		
		if(str.charAt(currChar) == '*') {
			styleText(startChar, currChar, Color.PINK, textPane);
			return State38(startChar, currChar + 1, textPane);
		}
		else if(Character.isWhitespace(str.charAt(currChar))) {
			return State37(startChar, currChar + 1, textPane);
		}
		else
			return StateErr(startChar, currChar, textPane);
	}
	
	public int State38(int startChar, int currChar, JTextPane textPane) {
		
		return currChar;
	}
	
	public int State39 (int startChar, int currChar, JTextPane textPane) {
		if(currChar >= str.length()) {
			return StateErr(startChar, currChar - 1, textPane);		
		}

		if(str.charAt(currChar) == ' ') {
			return State12(startChar, currChar + 1, textPane);
		}
		else if(Character.isWhitespace(str.charAt(currChar))) {
			return State39(startChar, currChar + 1, textPane);
		}
		else 
			return StateErr(startChar, currChar, textPane);
		
	}
	
	public int StateErr(int startChar, int currChar, JTextPane textPane) {
		styleText(startChar, currChar, Color.YELLOW, textPane);
		return -1;
	}
}
