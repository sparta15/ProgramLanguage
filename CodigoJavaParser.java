// Generated from CodigoJava.g4 by ANTLR 4.7

    import java.util.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CodigoJavaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, CLASS=6, ID=7, LETTER=8, DIGIT=9, 
		WS=10;
	public static final int
		RULE_prog = 0, RULE_idspc = 1, RULE_clase = 2, RULE_ids = 3, RULE_codigo = 4, 
		RULE_params = 5;
	public static final String[] ruleNames = {
		"prog", "idspc", "clase", "ids", "codigo", "params"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'{'", "'}'", "';'", "'('", "')'", "'class'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, "CLASS", "ID", "LETTER", "DIGIT", 
		"WS"
	};
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

	@Override
	public String getGrammarFileName() { return "CodigoJava.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CodigoJavaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public IdspcContext idspc() {
			return getRuleContext(IdspcContext.class,0);
		}
		public TerminalNode CLASS() { return getToken(CodigoJavaParser.CLASS, 0); }
		public TerminalNode ID() { return getToken(CodigoJavaParser.ID, 0); }
		public ClaseContext clase() {
			return getRuleContext(ClaseContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodigoJavaListener ) ((CodigoJavaListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodigoJavaListener ) ((CodigoJavaListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(12);
			idspc();
			setState(13);
			match(CLASS);
			setState(14);
			match(ID);
			setState(15);
			match(T__0);
			setState(16);
			clase();
			setState(17);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdspcContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CodigoJavaParser.ID, 0); }
		public IdspcContext idspc() {
			return getRuleContext(IdspcContext.class,0);
		}
		public IdspcContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_idspc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodigoJavaListener ) ((CodigoJavaListener)listener).enterIdspc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodigoJavaListener ) ((CodigoJavaListener)listener).exitIdspc(this);
		}
	}

	public final IdspcContext idspc() throws RecognitionException {
		IdspcContext _localctx = new IdspcContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_idspc);
		try {
			setState(24);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(19);
				match(ID);
				setState(20);
				idspc();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 2);
				{
				setState(21);
				match(T__2);
				setState(22);
				idspc();
				}
				break;
			case CLASS:
				enterOuterAlt(_localctx, 3);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClaseContext extends ParserRuleContext {
		public IdsContext ids() {
			return getRuleContext(IdsContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(CodigoJavaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CodigoJavaParser.ID, i);
		}
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public CodigoContext codigo() {
			return getRuleContext(CodigoContext.class,0);
		}
		public ClaseContext clase() {
			return getRuleContext(ClaseContext.class,0);
		}
		public ClaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_clase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodigoJavaListener ) ((CodigoJavaListener)listener).enterClase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodigoJavaListener ) ((CodigoJavaListener)listener).exitClase(this);
		}
	}

	public final ClaseContext clase() throws RecognitionException {
		ClaseContext _localctx = new ClaseContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_clase);
		try {
			setState(53);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(26);
				ids();
				setState(27);
				match(ID);
				setState(28);
				match(ID);
				setState(29);
				match(T__3);
				setState(30);
				params();
				setState(31);
				match(T__4);
				setState(32);
				match(T__0);
				setState(33);
				codigo();
				setState(34);
				match(T__1);
				setState(35);
				clase();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(37);
				ids();
				setState(38);
				match(ID);
				setState(39);
				match(ID);
				setState(40);
				match(T__3);
				setState(41);
				params();
				setState(42);
				match(T__4);
				setState(43);
				match(T__2);
				setState(44);
				clase();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(46);
				ids();
				setState(47);
				match(ID);
				setState(48);
				match(ID);
				setState(49);
				match(T__2);
				setState(50);
				clase();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdsContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CodigoJavaParser.ID, 0); }
		public IdsContext ids() {
			return getRuleContext(IdsContext.class,0);
		}
		public IdsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ids; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodigoJavaListener ) ((CodigoJavaListener)listener).enterIds(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodigoJavaListener ) ((CodigoJavaListener)listener).exitIds(this);
		}
	}

	public final IdsContext ids() throws RecognitionException {
		IdsContext _localctx = new IdsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_ids);
		try {
			setState(58);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(55);
				match(ID);
				setState(56);
				ids();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CodigoContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CodigoJavaParser.ID, 0); }
		public List<CodigoContext> codigo() {
			return getRuleContexts(CodigoContext.class);
		}
		public CodigoContext codigo(int i) {
			return getRuleContext(CodigoContext.class,i);
		}
		public CodigoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_codigo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodigoJavaListener ) ((CodigoJavaListener)listener).enterCodigo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodigoJavaListener ) ((CodigoJavaListener)listener).exitCodigo(this);
		}
	}

	public final CodigoContext codigo() throws RecognitionException {
		CodigoContext _localctx = new CodigoContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_codigo);
		try {
			setState(75);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(60);
				match(ID);
				setState(61);
				codigo();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 2);
				{
				setState(62);
				match(T__2);
				setState(63);
				codigo();
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 3);
				{
				setState(64);
				match(T__3);
				setState(65);
				codigo();
				setState(66);
				match(T__4);
				setState(67);
				codigo();
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 4);
				{
				setState(69);
				match(T__0);
				setState(70);
				codigo();
				setState(71);
				match(T__1);
				setState(72);
				codigo();
				}
				break;
			case T__1:
			case T__4:
				enterOuterAlt(_localctx, 5);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamsContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CodigoJavaParser.ID, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodigoJavaListener ) ((CodigoJavaListener)listener).enterParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodigoJavaListener ) ((CodigoJavaListener)listener).exitParams(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_params);
		try {
			setState(80);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(77);
				match(ID);
				setState(78);
				params();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\fU\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3"+
		"\3\3\3\3\3\3\5\3\33\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\48\n"+
		"\4\3\5\3\5\3\5\5\5=\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\5\6N\n\6\3\7\3\7\3\7\5\7S\n\7\3\7\2\2\b\2\4\6\b\n\f\2\2"+
		"\2Y\2\16\3\2\2\2\4\32\3\2\2\2\6\67\3\2\2\2\b<\3\2\2\2\nM\3\2\2\2\fR\3"+
		"\2\2\2\16\17\5\4\3\2\17\20\7\b\2\2\20\21\7\t\2\2\21\22\7\3\2\2\22\23\5"+
		"\6\4\2\23\24\7\4\2\2\24\3\3\2\2\2\25\26\7\t\2\2\26\33\5\4\3\2\27\30\7"+
		"\5\2\2\30\33\5\4\3\2\31\33\3\2\2\2\32\25\3\2\2\2\32\27\3\2\2\2\32\31\3"+
		"\2\2\2\33\5\3\2\2\2\34\35\5\b\5\2\35\36\7\t\2\2\36\37\7\t\2\2\37 \7\6"+
		"\2\2 !\5\f\7\2!\"\7\7\2\2\"#\7\3\2\2#$\5\n\6\2$%\7\4\2\2%&\5\6\4\2&8\3"+
		"\2\2\2\'(\5\b\5\2()\7\t\2\2)*\7\t\2\2*+\7\6\2\2+,\5\f\7\2,-\7\7\2\2-."+
		"\7\5\2\2./\5\6\4\2/8\3\2\2\2\60\61\5\b\5\2\61\62\7\t\2\2\62\63\7\t\2\2"+
		"\63\64\7\5\2\2\64\65\5\6\4\2\658\3\2\2\2\668\3\2\2\2\67\34\3\2\2\2\67"+
		"\'\3\2\2\2\67\60\3\2\2\2\67\66\3\2\2\28\7\3\2\2\29:\7\t\2\2:=\5\b\5\2"+
		";=\3\2\2\2<9\3\2\2\2<;\3\2\2\2=\t\3\2\2\2>?\7\t\2\2?N\5\n\6\2@A\7\5\2"+
		"\2AN\5\n\6\2BC\7\6\2\2CD\5\n\6\2DE\7\7\2\2EF\5\n\6\2FN\3\2\2\2GH\7\3\2"+
		"\2HI\5\n\6\2IJ\7\4\2\2JK\5\n\6\2KN\3\2\2\2LN\3\2\2\2M>\3\2\2\2M@\3\2\2"+
		"\2MB\3\2\2\2MG\3\2\2\2ML\3\2\2\2N\13\3\2\2\2OP\7\t\2\2PS\5\f\7\2QS\3\2"+
		"\2\2RO\3\2\2\2RQ\3\2\2\2S\r\3\2\2\2\7\32\67<MR";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}