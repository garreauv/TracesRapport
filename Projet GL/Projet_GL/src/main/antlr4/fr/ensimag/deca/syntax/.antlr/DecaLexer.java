// Generated from /home/louis/ensimag/GL/gl19/src/main/antlr4/fr/ensimag/deca/syntax/DecaLexer.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DecaLexer extends AbstractDecaLexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ASM=1, CLASS=2, EXTENDS=3, ELSE=4, FALSE=5, IF=6, INSTANCEOF=7, NEW=8, 
		NULL=9, READINT=10, READFLOAT=11, PRINT=12, PRINTLN=13, PRINTLNX=14, PRINTX=15, 
		PROTECTED=16, RETURN=17, THIS=18, TRUE=19, WHILE=20, LT=21, GT=22, EQUALS=23, 
		TIMES=24, SLASH=25, PERCENT=26, DOT=27, COMMA=28, OPARENT=29, CPARENT=30, 
		OBRACE=31, CBRACE=32, EXCLAM=33, SEMI=34, EQEQ=35, NEQ=36, GEQ=37, LEQ=38, 
		AND=39, OR=40, PLUS=41, MINUS=42, STRING=43, MULTI_LINE_STRING=44, IDENT=45, 
		INT=46, FLOAT=47, SEPARATOR=48, INCLUDE=49, DEFAULT=50;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"ASM", "CLASS", "EXTENDS", "ELSE", "FALSE", "IF", "INSTANCEOF", "NEW", 
			"NULL", "READINT", "READFLOAT", "PRINT", "PRINTLN", "PRINTLNX", "PRINTX", 
			"PROTECTED", "RETURN", "THIS", "TRUE", "WHILE", "LT", "GT", "EQUALS", 
			"TIMES", "SLASH", "PERCENT", "DOT", "COMMA", "OPARENT", "CPARENT", "OBRACE", 
			"CBRACE", "EXCLAM", "SEMI", "EQEQ", "NEQ", "GEQ", "LEQ", "AND", "OR", 
			"PLUS", "MINUS", "EOL", "STRING_CAR", "STRING", "MULTI_LINE_STRING", 
			"LETTER", "DIGIT", "IDENT", "POSITIVE_DIGIT", "INT", "NUM", "SIGN", "EXP", 
			"DEC", "FLOATDEC", "DIGITHEX", "NUMHEX", "FLOATHEX", "FLOAT", "COMMENT", 
			"SINGLE_LINE_COMMENT", "SPACE", "TAB", "RETOUR_CHARIOT", "SEPARATOR", 
			"FILENAME", "INCLUDE", "DEFAULT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'asm'", "'class'", "'extends'", "'else'", "'false'", "'if'", "'instanceof'", 
			"'new'", "'null'", "'readInt'", "'readFloat'", "'print'", "'println'", 
			"'printlnx'", "'printx'", "'protected'", "'return'", "'this'", "'true'", 
			"'while'", "'<'", "'>'", "'='", "'*'", "'/'", "'%'", null, "','", "'('", 
			"')'", "'{'", "'}'", "'!'", "';'", "'=='", "'!='", "'>='", "'<='", "'&&'", 
			"'||'", "'+'", "'-'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ASM", "CLASS", "EXTENDS", "ELSE", "FALSE", "IF", "INSTANCEOF", 
			"NEW", "NULL", "READINT", "READFLOAT", "PRINT", "PRINTLN", "PRINTLNX", 
			"PRINTX", "PROTECTED", "RETURN", "THIS", "TRUE", "WHILE", "LT", "GT", 
			"EQUALS", "TIMES", "SLASH", "PERCENT", "DOT", "COMMA", "OPARENT", "CPARENT", 
			"OBRACE", "CBRACE", "EXCLAM", "SEMI", "EQEQ", "NEQ", "GEQ", "LEQ", "AND", 
			"OR", "PLUS", "MINUS", "STRING", "MULTI_LINE_STRING", "IDENT", "INT", 
			"FLOAT", "SEPARATOR", "INCLUDE", "DEFAULT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}




	public DecaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "DecaLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 44:
			STRING_action((RuleContext)_localctx, actionIndex);
			break;
		case 45:
			MULTI_LINE_STRING_action((RuleContext)_localctx, actionIndex);
			break;
		case 48:
			IDENT_action((RuleContext)_localctx, actionIndex);
			break;
		case 50:
			INT_action((RuleContext)_localctx, actionIndex);
			break;
		case 59:
			FLOAT_action((RuleContext)_localctx, actionIndex);
			break;
		case 65:
			SEPARATOR_action((RuleContext)_localctx, actionIndex);
			break;
		case 67:
			INCLUDE_action((RuleContext)_localctx, actionIndex);
			break;
		case 68:
			DEFAULT_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void STRING_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			 getText();
			break;
		}
	}
	private void MULTI_LINE_STRING_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:
			 getText();
			break;
		}
	}
	private void IDENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2:
			 getText();
			break;
		}
	}
	private void INT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3:
			 getText();
			break;
		}
	}
	private void FLOAT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 4:
			 getText();
			break;
		}
	}
	private void SEPARATOR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 5:
			 skip(); 
			break;
		}
	}
	private void INCLUDE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 6:
			 doInclude(getText());  
			break;
		}
	}
	private void DEFAULT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 7:
			 if(true) {throw new DecaRecognitionException( this, getInputStream());} 
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\64\u0201\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t"+
		"=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\3\2\3\2\3\2\3"+
		"\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5"+
		"\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32"+
		"\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3"+
		"\"\3\"\3#\3#\3$\3$\3$\3%\3%\3%\3&\3&\3&\3\'\3\'\3\'\3(\3(\3(\3)\3)\3)"+
		"\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3.\3.\3.\3.\3.\3.\7.\u0151\n.\f.\16.\u0154"+
		"\13.\3.\3.\3.\3/\3/\3/\3/\3/\3/\3/\7/\u0160\n/\f/\16/\u0163\13/\3/\3/"+
		"\3/\3\60\3\60\3\61\3\61\3\62\3\62\5\62\u016e\n\62\3\62\3\62\3\62\7\62"+
		"\u0173\n\62\f\62\16\62\u0176\13\62\3\62\3\62\3\63\3\63\3\64\3\64\3\64"+
		"\7\64\u017f\n\64\f\64\16\64\u0182\13\64\3\64\3\64\5\64\u0186\n\64\3\65"+
		"\6\65\u0189\n\65\r\65\16\65\u018a\3\66\5\66\u018e\n\66\3\67\3\67\3\67"+
		"\3\67\38\38\38\38\39\39\39\39\59\u019c\n9\39\59\u019f\n9\3:\3:\3;\6;\u01a4"+
		"\n;\r;\16;\u01a5\3<\3<\3<\3<\5<\u01ac\n<\3<\3<\3<\3<\3<\3<\3<\5<\u01b5"+
		"\n<\3=\3=\3=\3=\5=\u01bb\n=\3>\3>\3>\3>\7>\u01c1\n>\f>\16>\u01c4\13>\3"+
		">\3>\3>\3?\3?\3?\3?\7?\u01cd\n?\f?\16?\u01d0\13?\3?\3?\3@\3@\3A\3A\3B"+
		"\3B\3C\3C\3C\3C\3C\3C\5C\u01e0\nC\3C\3C\3D\3D\3D\6D\u01e7\nD\rD\16D\u01e8"+
		"\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\7E\u01f5\nE\fE\16E\u01f8\13E\3E\3E\3E\3"+
		"E\3E\3F\3F\3F\4\u01c2\u01ce\2G\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13"+
		"\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61"+
		"\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W\2Y\2[-]._\2"+
		"a\2c/e\2g\60i\2k\2m\2o\2q\2s\2u\2w\2y\61{\2}\2\177\2\u0081\2\u0083\2\u0085"+
		"\62\u0087\2\u0089\63\u008b\64\3\2\13\5\2\f\f$$^^\4\2C\\c|\4\2&&aa\4\2"+
		"--//\4\2GGgg\4\2HHhh\5\2\62;CHch\4\2RRrr\4\2/\60aa\2\u020e\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2"+
		"\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2"+
		"\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2"+
		"\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2"+
		"\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2"+
		"\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2["+
		"\3\2\2\2\2]\3\2\2\2\2c\3\2\2\2\2g\3\2\2\2\2y\3\2\2\2\2\u0085\3\2\2\2\2"+
		"\u0089\3\2\2\2\2\u008b\3\2\2\2\3\u008d\3\2\2\2\5\u0091\3\2\2\2\7\u0097"+
		"\3\2\2\2\t\u009f\3\2\2\2\13\u00a4\3\2\2\2\r\u00aa\3\2\2\2\17\u00ad\3\2"+
		"\2\2\21\u00b8\3\2\2\2\23\u00bc\3\2\2\2\25\u00c1\3\2\2\2\27\u00c9\3\2\2"+
		"\2\31\u00d3\3\2\2\2\33\u00d9\3\2\2\2\35\u00e1\3\2\2\2\37\u00ea\3\2\2\2"+
		"!\u00f1\3\2\2\2#\u00fb\3\2\2\2%\u0102\3\2\2\2\'\u0107\3\2\2\2)\u010c\3"+
		"\2\2\2+\u0112\3\2\2\2-\u0114\3\2\2\2/\u0116\3\2\2\2\61\u0118\3\2\2\2\63"+
		"\u011a\3\2\2\2\65\u011c\3\2\2\2\67\u011e\3\2\2\29\u0120\3\2\2\2;\u0122"+
		"\3\2\2\2=\u0124\3\2\2\2?\u0126\3\2\2\2A\u0128\3\2\2\2C\u012a\3\2\2\2E"+
		"\u012c\3\2\2\2G\u012e\3\2\2\2I\u0131\3\2\2\2K\u0134\3\2\2\2M\u0137\3\2"+
		"\2\2O\u013a\3\2\2\2Q\u013d\3\2\2\2S\u0140\3\2\2\2U\u0142\3\2\2\2W\u0144"+
		"\3\2\2\2Y\u0146\3\2\2\2[\u0148\3\2\2\2]\u0158\3\2\2\2_\u0167\3\2\2\2a"+
		"\u0169\3\2\2\2c\u016d\3\2\2\2e\u0179\3\2\2\2g\u0185\3\2\2\2i\u0188\3\2"+
		"\2\2k\u018d\3\2\2\2m\u018f\3\2\2\2o\u0193\3\2\2\2q\u019b\3\2\2\2s\u01a0"+
		"\3\2\2\2u\u01a3\3\2\2\2w\u01ab\3\2\2\2y\u01ba\3\2\2\2{\u01bc\3\2\2\2}"+
		"\u01c8\3\2\2\2\177\u01d3\3\2\2\2\u0081\u01d5\3\2\2\2\u0083\u01d7\3\2\2"+
		"\2\u0085\u01df\3\2\2\2\u0087\u01e6\3\2\2\2\u0089\u01ea\3\2\2\2\u008b\u01fe"+
		"\3\2\2\2\u008d\u008e\7c\2\2\u008e\u008f\7u\2\2\u008f\u0090\7o\2\2\u0090"+
		"\4\3\2\2\2\u0091\u0092\7e\2\2\u0092\u0093\7n\2\2\u0093\u0094\7c\2\2\u0094"+
		"\u0095\7u\2\2\u0095\u0096\7u\2\2\u0096\6\3\2\2\2\u0097\u0098\7g\2\2\u0098"+
		"\u0099\7z\2\2\u0099\u009a\7v\2\2\u009a\u009b\7g\2\2\u009b\u009c\7p\2\2"+
		"\u009c\u009d\7f\2\2\u009d\u009e\7u\2\2\u009e\b\3\2\2\2\u009f\u00a0\7g"+
		"\2\2\u00a0\u00a1\7n\2\2\u00a1\u00a2\7u\2\2\u00a2\u00a3\7g\2\2\u00a3\n"+
		"\3\2\2\2\u00a4\u00a5\7h\2\2\u00a5\u00a6\7c\2\2\u00a6\u00a7\7n\2\2\u00a7"+
		"\u00a8\7u\2\2\u00a8\u00a9\7g\2\2\u00a9\f\3\2\2\2\u00aa\u00ab\7k\2\2\u00ab"+
		"\u00ac\7h\2\2\u00ac\16\3\2\2\2\u00ad\u00ae\7k\2\2\u00ae\u00af\7p\2\2\u00af"+
		"\u00b0\7u\2\2\u00b0\u00b1\7v\2\2\u00b1\u00b2\7c\2\2\u00b2\u00b3\7p\2\2"+
		"\u00b3\u00b4\7e\2\2\u00b4\u00b5\7g\2\2\u00b5\u00b6\7q\2\2\u00b6\u00b7"+
		"\7h\2\2\u00b7\20\3\2\2\2\u00b8\u00b9\7p\2\2\u00b9\u00ba\7g\2\2\u00ba\u00bb"+
		"\7y\2\2\u00bb\22\3\2\2\2\u00bc\u00bd\7p\2\2\u00bd\u00be\7w\2\2\u00be\u00bf"+
		"\7n\2\2\u00bf\u00c0\7n\2\2\u00c0\24\3\2\2\2\u00c1\u00c2\7t\2\2\u00c2\u00c3"+
		"\7g\2\2\u00c3\u00c4\7c\2\2\u00c4\u00c5\7f\2\2\u00c5\u00c6\7K\2\2\u00c6"+
		"\u00c7\7p\2\2\u00c7\u00c8\7v\2\2\u00c8\26\3\2\2\2\u00c9\u00ca\7t\2\2\u00ca"+
		"\u00cb\7g\2\2\u00cb\u00cc\7c\2\2\u00cc\u00cd\7f\2\2\u00cd\u00ce\7H\2\2"+
		"\u00ce\u00cf\7n\2\2\u00cf\u00d0\7q\2\2\u00d0\u00d1\7c\2\2\u00d1\u00d2"+
		"\7v\2\2\u00d2\30\3\2\2\2\u00d3\u00d4\7r\2\2\u00d4\u00d5\7t\2\2\u00d5\u00d6"+
		"\7k\2\2\u00d6\u00d7\7p\2\2\u00d7\u00d8\7v\2\2\u00d8\32\3\2\2\2\u00d9\u00da"+
		"\7r\2\2\u00da\u00db\7t\2\2\u00db\u00dc\7k\2\2\u00dc\u00dd\7p\2\2\u00dd"+
		"\u00de\7v\2\2\u00de\u00df\7n\2\2\u00df\u00e0\7p\2\2\u00e0\34\3\2\2\2\u00e1"+
		"\u00e2\7r\2\2\u00e2\u00e3\7t\2\2\u00e3\u00e4\7k\2\2\u00e4\u00e5\7p\2\2"+
		"\u00e5\u00e6\7v\2\2\u00e6\u00e7\7n\2\2\u00e7\u00e8\7p\2\2\u00e8\u00e9"+
		"\7z\2\2\u00e9\36\3\2\2\2\u00ea\u00eb\7r\2\2\u00eb\u00ec\7t\2\2\u00ec\u00ed"+
		"\7k\2\2\u00ed\u00ee\7p\2\2\u00ee\u00ef\7v\2\2\u00ef\u00f0\7z\2\2\u00f0"+
		" \3\2\2\2\u00f1\u00f2\7r\2\2\u00f2\u00f3\7t\2\2\u00f3\u00f4\7q\2\2\u00f4"+
		"\u00f5\7v\2\2\u00f5\u00f6\7g\2\2\u00f6\u00f7\7e\2\2\u00f7\u00f8\7v\2\2"+
		"\u00f8\u00f9\7g\2\2\u00f9\u00fa\7f\2\2\u00fa\"\3\2\2\2\u00fb\u00fc\7t"+
		"\2\2\u00fc\u00fd\7g\2\2\u00fd\u00fe\7v\2\2\u00fe\u00ff\7w\2\2\u00ff\u0100"+
		"\7t\2\2\u0100\u0101\7p\2\2\u0101$\3\2\2\2\u0102\u0103\7v\2\2\u0103\u0104"+
		"\7j\2\2\u0104\u0105\7k\2\2\u0105\u0106\7u\2\2\u0106&\3\2\2\2\u0107\u0108"+
		"\7v\2\2\u0108\u0109\7t\2\2\u0109\u010a\7w\2\2\u010a\u010b\7g\2\2\u010b"+
		"(\3\2\2\2\u010c\u010d\7y\2\2\u010d\u010e\7j\2\2\u010e\u010f\7k\2\2\u010f"+
		"\u0110\7n\2\2\u0110\u0111\7g\2\2\u0111*\3\2\2\2\u0112\u0113\7>\2\2\u0113"+
		",\3\2\2\2\u0114\u0115\7@\2\2\u0115.\3\2\2\2\u0116\u0117\7?\2\2\u0117\60"+
		"\3\2\2\2\u0118\u0119\7,\2\2\u0119\62\3\2\2\2\u011a\u011b\7\61\2\2\u011b"+
		"\64\3\2\2\2\u011c\u011d\7\'\2\2\u011d\66\3\2\2\2\u011e\u011f\7\60\2\2"+
		"\u011f8\3\2\2\2\u0120\u0121\7.\2\2\u0121:\3\2\2\2\u0122\u0123\7*\2\2\u0123"+
		"<\3\2\2\2\u0124\u0125\7+\2\2\u0125>\3\2\2\2\u0126\u0127\7}\2\2\u0127@"+
		"\3\2\2\2\u0128\u0129\7\177\2\2\u0129B\3\2\2\2\u012a\u012b\7#\2\2\u012b"+
		"D\3\2\2\2\u012c\u012d\7=\2\2\u012dF\3\2\2\2\u012e\u012f\7?\2\2\u012f\u0130"+
		"\7?\2\2\u0130H\3\2\2\2\u0131\u0132\7#\2\2\u0132\u0133\7?\2\2\u0133J\3"+
		"\2\2\2\u0134\u0135\7@\2\2\u0135\u0136\7?\2\2\u0136L\3\2\2\2\u0137\u0138"+
		"\7>\2\2\u0138\u0139\7?\2\2\u0139N\3\2\2\2\u013a\u013b\7(\2\2\u013b\u013c"+
		"\7(\2\2\u013cP\3\2\2\2\u013d\u013e\7~\2\2\u013e\u013f\7~\2\2\u013fR\3"+
		"\2\2\2\u0140\u0141\7-\2\2\u0141T\3\2\2\2\u0142\u0143\7/\2\2\u0143V\3\2"+
		"\2\2\u0144\u0145\7\f\2\2\u0145X\3\2\2\2\u0146\u0147\n\2\2\2\u0147Z\3\2"+
		"\2\2\u0148\u0152\7$\2\2\u0149\u0151\5Y-\2\u014a\u014b\7^\2\2\u014b\u0151"+
		"\7p\2\2\u014c\u014d\7^\2\2\u014d\u0151\7$\2\2\u014e\u014f\7^\2\2\u014f"+
		"\u0151\7^\2\2\u0150\u0149\3\2\2\2\u0150\u014a\3\2\2\2\u0150\u014c\3\2"+
		"\2\2\u0150\u014e\3\2\2\2\u0151\u0154\3\2\2\2\u0152\u0150\3\2\2\2\u0152"+
		"\u0153\3\2\2\2\u0153\u0155\3\2\2\2\u0154\u0152\3\2\2\2\u0155\u0156\7$"+
		"\2\2\u0156\u0157\b.\2\2\u0157\\\3\2\2\2\u0158\u0161\7$\2\2\u0159\u0160"+
		"\5Y-\2\u015a\u0160\5W,\2\u015b\u015c\7^\2\2\u015c\u0160\7$\2\2\u015d\u015e"+
		"\7^\2\2\u015e\u0160\7^\2\2\u015f\u0159\3\2\2\2\u015f\u015a\3\2\2\2\u015f"+
		"\u015b\3\2\2\2\u015f\u015d\3\2\2\2\u0160\u0163\3\2\2\2\u0161\u015f\3\2"+
		"\2\2\u0161\u0162\3\2\2\2\u0162\u0164\3\2\2\2\u0163\u0161\3\2\2\2\u0164"+
		"\u0165\7$\2\2\u0165\u0166\b/\3\2\u0166^\3\2\2\2\u0167\u0168\t\3\2\2\u0168"+
		"`\3\2\2\2\u0169\u016a\4\62;\2\u016ab\3\2\2\2\u016b\u016e\5_\60\2\u016c"+
		"\u016e\t\4\2\2\u016d\u016b\3\2\2\2\u016d\u016c\3\2\2\2\u016e\u0174\3\2"+
		"\2\2\u016f\u0173\5_\60\2\u0170\u0173\5a\61\2\u0171\u0173\t\4\2\2\u0172"+
		"\u016f\3\2\2\2\u0172\u0170\3\2\2\2\u0172\u0171\3\2\2\2\u0173\u0176\3\2"+
		"\2\2\u0174\u0172\3\2\2\2\u0174\u0175\3\2\2\2\u0175\u0177\3\2\2\2\u0176"+
		"\u0174\3\2\2\2\u0177\u0178\b\62\4\2\u0178d\3\2\2\2\u0179\u017a\4\63;\2"+
		"\u017af\3\2\2\2\u017b\u0186\7\62\2\2\u017c\u0180\5e\63\2\u017d\u017f\5"+
		"a\61\2\u017e\u017d\3\2\2\2\u017f\u0182\3\2\2\2\u0180\u017e\3\2\2\2\u0180"+
		"\u0181\3\2\2\2\u0181\u0183\3\2\2\2\u0182\u0180\3\2\2\2\u0183\u0184\b\64"+
		"\5\2\u0184\u0186\3\2\2\2\u0185\u017b\3\2\2\2\u0185\u017c\3\2\2\2\u0186"+
		"h\3\2\2\2\u0187\u0189\5a\61\2\u0188\u0187\3\2\2\2\u0189\u018a\3\2\2\2"+
		"\u018a\u0188\3\2\2\2\u018a\u018b\3\2\2\2\u018bj\3\2\2\2\u018c\u018e\t"+
		"\5\2\2\u018d\u018c\3\2\2\2\u018d\u018e\3\2\2\2\u018el\3\2\2\2\u018f\u0190"+
		"\t\6\2\2\u0190\u0191\5k\66\2\u0191\u0192\5i\65\2\u0192n\3\2\2\2\u0193"+
		"\u0194\5i\65\2\u0194\u0195\7\60\2\2\u0195\u0196\5i\65\2\u0196p\3\2\2\2"+
		"\u0197\u019c\5o8\2\u0198\u0199\5o8\2\u0199\u019a\5m\67\2\u019a\u019c\3"+
		"\2\2\2\u019b\u0197\3\2\2\2\u019b\u0198\3\2\2\2\u019c\u019e\3\2\2\2\u019d"+
		"\u019f\t\7\2\2\u019e\u019d\3\2\2\2\u019e\u019f\3\2\2\2\u019fr\3\2\2\2"+
		"\u01a0\u01a1\t\b\2\2\u01a1t\3\2\2\2\u01a2\u01a4\5s:\2\u01a3\u01a2\3\2"+
		"\2\2\u01a4\u01a5\3\2\2\2\u01a5\u01a3\3\2\2\2\u01a5\u01a6\3\2\2\2\u01a6"+
		"v\3\2\2\2\u01a7\u01a8\7\62\2\2\u01a8\u01ac\7z\2\2\u01a9\u01aa\7\62\2\2"+
		"\u01aa\u01ac\7Z\2\2\u01ab\u01a7\3\2\2\2\u01ab\u01a9\3\2\2\2\u01ac\u01ad"+
		"\3\2\2\2\u01ad\u01ae\5u;\2\u01ae\u01af\7\60\2\2\u01af\u01b0\5u;\2\u01b0"+
		"\u01b1\t\t\2\2\u01b1\u01b2\5k\66\2\u01b2\u01b4\5i\65\2\u01b3\u01b5\t\7"+
		"\2\2\u01b4\u01b3\3\2\2\2\u01b4\u01b5\3\2\2\2\u01b5x\3\2\2\2\u01b6\u01bb"+
		"\5q9\2\u01b7\u01b8\5w<\2\u01b8\u01b9\b=\6\2\u01b9\u01bb\3\2\2\2\u01ba"+
		"\u01b6\3\2\2\2\u01ba\u01b7\3\2\2\2\u01bbz\3\2\2\2\u01bc\u01bd\7\61\2\2"+
		"\u01bd\u01be\7,\2\2\u01be\u01c2\3\2\2\2\u01bf\u01c1\13\2\2\2\u01c0\u01bf"+
		"\3\2\2\2\u01c1\u01c4\3\2\2\2\u01c2\u01c3\3\2\2\2\u01c2\u01c0\3\2\2\2\u01c3"+
		"\u01c5\3\2\2\2\u01c4\u01c2\3\2\2\2\u01c5\u01c6\7,\2\2\u01c6\u01c7\7\61"+
		"\2\2\u01c7|\3\2\2\2\u01c8\u01c9\7\61\2\2\u01c9\u01ca\7\61\2\2\u01ca\u01ce"+
		"\3\2\2\2\u01cb\u01cd\13\2\2\2\u01cc\u01cb\3\2\2\2\u01cd\u01d0\3\2\2\2"+
		"\u01ce\u01cf\3\2\2\2\u01ce\u01cc\3\2\2\2\u01cf\u01d1\3\2\2\2\u01d0\u01ce"+
		"\3\2\2\2\u01d1\u01d2\5W,\2\u01d2~\3\2\2\2\u01d3\u01d4\7\"\2\2\u01d4\u0080"+
		"\3\2\2\2\u01d5\u01d6\7\13\2\2\u01d6\u0082\3\2\2\2\u01d7\u01d8\7\17\2\2"+
		"\u01d8\u0084\3\2\2\2\u01d9\u01e0\5{>\2\u01da\u01e0\5}?\2\u01db\u01e0\5"+
		"\177@\2\u01dc\u01e0\5W,\2\u01dd\u01e0\5\u0081A\2\u01de\u01e0\5\u0083B"+
		"\2\u01df\u01d9\3\2\2\2\u01df\u01da\3\2\2\2\u01df\u01db\3\2\2\2\u01df\u01dc"+
		"\3\2\2\2\u01df\u01dd\3\2\2\2\u01df\u01de\3\2\2\2\u01e0\u01e1\3\2\2\2\u01e1"+
		"\u01e2\bC\7\2\u01e2\u0086\3\2\2\2\u01e3\u01e7\5_\60\2\u01e4\u01e7\5a\61"+
		"\2\u01e5\u01e7\t\n\2\2\u01e6\u01e3\3\2\2\2\u01e6\u01e4\3\2\2\2\u01e6\u01e5"+
		"\3\2\2\2\u01e7\u01e8\3\2\2\2\u01e8\u01e6\3\2\2\2\u01e8\u01e9\3\2\2\2\u01e9"+
		"\u0088\3\2\2\2\u01ea\u01eb\7%\2\2\u01eb\u01ec\7k\2\2\u01ec\u01ed\7p\2"+
		"\2\u01ed\u01ee\7e\2\2\u01ee\u01ef\7n\2\2\u01ef\u01f0\7w\2\2\u01f0\u01f1"+
		"\7f\2\2\u01f1\u01f2\7g\2\2\u01f2\u01f6\3\2\2\2\u01f3\u01f5\5\177@\2\u01f4"+
		"\u01f3\3\2\2\2\u01f5\u01f8\3\2\2\2\u01f6\u01f4\3\2\2\2\u01f6\u01f7\3\2"+
		"\2\2\u01f7\u01f9\3\2\2\2\u01f8\u01f6\3\2\2\2\u01f9\u01fa\7$\2\2\u01fa"+
		"\u01fb\5\u0087D\2\u01fb\u01fc\7$\2\2\u01fc\u01fd\bE\b\2\u01fd\u008a\3"+
		"\2\2\2\u01fe\u01ff\7\60\2\2\u01ff\u0200\bF\t\2\u0200\u008c\3\2\2\2\32"+
		"\2\u0150\u0152\u015f\u0161\u016d\u0172\u0174\u0180\u0185\u018a\u018d\u019b"+
		"\u019e\u01a5\u01ab\u01b4\u01ba\u01c2\u01ce\u01df\u01e6\u01e8\u01f6\n\3"+
		".\2\3/\3\3\62\4\3\64\5\3=\6\3C\7\3E\b\3F\t";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}