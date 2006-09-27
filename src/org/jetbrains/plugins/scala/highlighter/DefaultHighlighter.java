package org.jetbrains.plugins.scala.highlighter;

import org.jetbrains.annotations.NonNls;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.editor.HighlighterColors;

/**
 * Author: Ilya Sergey
 * Date: 24.09.2006
 * Time: 15:08:24
 */
public class DefaultHighlighter {
    // Comments
    @NonNls private static final String LINE_COMMENT_ID = "SCALA_LINE_COMMENT";
    @NonNls private static final String BLOCK_COMMENT_ID = "SCALA_BLOCK_COMMENT";
    @NonNls private static final String KEYWORD_ID = "SCALA_KEYWORD";
    @NonNls private static final String NUMBER_ID = "SCALA_NUMBER";
    @NonNls private static final String STRING_ID = "SCALA_STRING";
    @NonNls private static final String BRACKETS_ID = "SCALA_BRACKETS";

    @NonNls private static final String OPERATION_SIGN_ID = "SCALA_OPERATION_SIGN";

    @NonNls private static final String BAD_CHARACTER_ID = "SCALA_BAD_CHARACTER";


// Registering TextAttributes
    static {
        TextAttributesKey.createTextAttributesKey(LINE_COMMENT_ID, HighlighterColors.JAVA_LINE_COMMENT.getDefaultAttributes());
        TextAttributesKey.createTextAttributesKey(BLOCK_COMMENT_ID, HighlighterColors.JAVA_BLOCK_COMMENT.getDefaultAttributes());
        TextAttributesKey.createTextAttributesKey(KEYWORD_ID, HighlighterColors.JAVA_KEYWORD.getDefaultAttributes());
        TextAttributesKey.createTextAttributesKey(NUMBER_ID, HighlighterColors.JAVA_NUMBER.getDefaultAttributes());
        TextAttributesKey.createTextAttributesKey(STRING_ID, HighlighterColors.JAVA_STRING.getDefaultAttributes());
        TextAttributesKey.createTextAttributesKey(BRACKETS_ID, HighlighterColors.JAVA_BRACKETS.getDefaultAttributes());


        TextAttributesKey.createTextAttributesKey(OPERATION_SIGN_ID, HighlighterColors.JAVA_OPERATION_SIGN.getDefaultAttributes());
        TextAttributesKey.createTextAttributesKey(BAD_CHARACTER_ID, HighlighterColors.BAD_CHARACTER.getDefaultAttributes());
    }

    public static TextAttributesKey LINE_COMMENT = TextAttributesKey.createTextAttributesKey(LINE_COMMENT_ID);
    public static TextAttributesKey BLOCK_COMMENT = TextAttributesKey.createTextAttributesKey(BLOCK_COMMENT_ID);
    public static TextAttributesKey KEYWORD = TextAttributesKey.createTextAttributesKey(KEYWORD_ID);
    public static TextAttributesKey NUMBER = TextAttributesKey.createTextAttributesKey(NUMBER_ID);
    public static TextAttributesKey STRING = TextAttributesKey.createTextAttributesKey(STRING_ID);
    public static TextAttributesKey BRACKETS = TextAttributesKey.createTextAttributesKey(BRACKETS_ID);


    public static TextAttributesKey OPERATION_SIGN = TextAttributesKey.createTextAttributesKey(OPERATION_SIGN_ID);
    public static TextAttributesKey BAD_CHARACTER = TextAttributesKey.createTextAttributesKey(BAD_CHARACTER_ID);

}

