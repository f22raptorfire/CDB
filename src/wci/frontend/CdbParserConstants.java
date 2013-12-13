/* Generated By:JJTree&JavaCC: Do not edit this line. CdbParserConstants.java */
package wci.frontend;


/**
 * Token literal values and constants.
 * Generated by org.javacc.parser.OtherFilesGen#start()
 */
public interface CdbParserConstants {

  /** End of File. */
  int EOF = 0;
  /** RegularExpression Id. */
  int SINGLE_LINE_COMMENT = 6;
  /** RegularExpression Id. */
  int MULTI_LINE_COMMENT = 9;
  /** RegularExpression Id. */
  int IF = 10;
  /** RegularExpression Id. */
  int ELSE = 11;
  /** RegularExpression Id. */
  int TRUE = 12;
  /** RegularExpression Id. */
  int FALSE = 13;
  /** RegularExpression Id. */
  int WHILE = 14;
  /** RegularExpression Id. */
  int FOR = 15;
  /** RegularExpression Id. */
  int DO = 16;
  /** RegularExpression Id. */
  int PRINT = 17;
  /** RegularExpression Id. */
  int PRINTLN = 18;
  /** RegularExpression Id. */
  int DATABASE = 19;
  /** RegularExpression Id. */
  int PROMPT = 20;
  /** RegularExpression Id. */
  int SHOW = 21;
  /** RegularExpression Id. */
  int ADD = 22;
  /** RegularExpression Id. */
  int NEW = 23;
  /** RegularExpression Id. */
  int COLON = 24;
  /** RegularExpression Id. */
  int AT = 25;
  /** RegularExpression Id. */
  int DOLLAR = 26;
  /** RegularExpression Id. */
  int EQUALS = 27;
  /** RegularExpression Id. */
  int EE = 28;
  /** RegularExpression Id. */
  int NE = 29;
  /** RegularExpression Id. */
  int LT = 30;
  /** RegularExpression Id. */
  int LE = 31;
  /** RegularExpression Id. */
  int GT = 32;
  /** RegularExpression Id. */
  int GE = 33;
  /** RegularExpression Id. */
  int COMMA = 34;
  /** RegularExpression Id. */
  int DOT = 35;
  /** RegularExpression Id. */
  int SEMICOLON = 36;
  /** RegularExpression Id. */
  int PLUS = 37;
  /** RegularExpression Id. */
  int MINUS = 38;
  /** RegularExpression Id. */
  int STAR = 39;
  /** RegularExpression Id. */
  int SLASH = 40;
  /** RegularExpression Id. */
  int PERCENT = 41;
  /** RegularExpression Id. */
  int QUOTE = 42;
  /** RegularExpression Id. */
  int DOUBLE_QUOTE = 43;
  /** RegularExpression Id. */
  int LEFT_BRACKET = 44;
  /** RegularExpression Id. */
  int RIGHT_BRACKET = 45;
  /** RegularExpression Id. */
  int LEFT_PAREN = 46;
  /** RegularExpression Id. */
  int RIGHT_PAREN = 47;
  /** RegularExpression Id. */
  int LEFT_BRACE = 48;
  /** RegularExpression Id. */
  int RIGHT_BRACE = 49;
  /** RegularExpression Id. */
  int AND = 50;
  /** RegularExpression Id. */
  int OR = 51;
  /** RegularExpression Id. */
  int UNDERSCORE = 52;
  /** RegularExpression Id. */
  int IDENTIFIER = 53;
  /** RegularExpression Id. */
  int STRING_LIT = 54;
  /** RegularExpression Id. */
  int INTEGER = 55;
  /** RegularExpression Id. */
  int REAL = 56;
  /** RegularExpression Id. */
  int LETTER = 57;
  /** RegularExpression Id. */
  int DIGIT = 58;
  /** RegularExpression Id. */
  int SIGN = 59;
  /** RegularExpression Id. */
  int UNSIGNED_NUMBER = 60;
  /** RegularExpression Id. */
  int WHOLE = 61;
  /** RegularExpression Id. */
  int FRACTION = 62;
  /** RegularExpression Id. */
  int EXPONENT = 63;
  /** RegularExpression Id. */
  int EOL = 64;
  /** RegularExpression Id. */
  int ERROR = 65;

  /** Lexical state. */
  int DEFAULT = 0;
  /** Lexical state. */
  int IN_MULTI_LINE_COMMENT = 1;

  /** Literal token values. */
  String[] tokenImage = {
    "<EOF>",
    "\" \"",
    "\"\\r\"",
    "\"\\t\"",
    "\"\\n\"",
    "\"\\r\\n\"",
    "<SINGLE_LINE_COMMENT>",
    "\"/*\"",
    "<token of kind 8>",
    "\"*/\"",
    "\"IF\"",
    "\"ELSE\"",
    "\"TRUE\"",
    "\"FALSE\"",
    "\"WHILE\"",
    "\"FOR\"",
    "\"DO\"",
    "\"PRINT\"",
    "\"PRINTLN\"",
    "\"DATABASE\"",
    "\"PROMPT\"",
    "\"SHOW\"",
    "\"ADD\"",
    "\"NEW\"",
    "\":\"",
    "\"@\"",
    "\"$\"",
    "\"=\"",
    "\"==\"",
    "\"!=\"",
    "\"<\"",
    "\"<=\"",
    "\">\"",
    "\">=\"",
    "\",\"",
    "\".\"",
    "\";\"",
    "\"+\"",
    "\"-\"",
    "\"*\"",
    "\"/\"",
    "\"%\"",
    "\"\\\'\"",
    "\"\\\"\"",
    "\"[\"",
    "\"]\"",
    "\"(\"",
    "\")\"",
    "\"{\"",
    "\"}\"",
    "\"&&\"",
    "\"||\"",
    "\"_\"",
    "<IDENTIFIER>",
    "<STRING_LIT>",
    "<INTEGER>",
    "<REAL>",
    "<LETTER>",
    "<DIGIT>",
    "<SIGN>",
    "<UNSIGNED_NUMBER>",
    "<WHOLE>",
    "<FRACTION>",
    "<EXPONENT>",
    "<EOL>",
    "<ERROR>",
  };

}
