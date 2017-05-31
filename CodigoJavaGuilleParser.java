// Generated from CodigoJavaGuille.g4 by ANTLR 4.7

    import java.util.*;
    import java.io.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CodigoJavaGuilleParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, CLASS=6, ID=7, LETTER=8, DIGIT=9, 
		WS=10;
	public static final int
		RULE_prog = 0, RULE_idspc = 1, RULE_clase = 2, RULE_resto = 3, RULE_def = 4, 
		RULE_ids = 5, RULE_codigo = 6, RULE_params = 7;
	public static final String[] ruleNames = {
		"prog", "idspc", "clase", "resto", "def", "ids", "codigo", "params"
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
	public String getGrammarFileName() { return "CodigoJavaGuille.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    ArrayList < ArrayList<String> > listaMetodos = new ArrayList <ArrayList<String>>();
	    File fichero;
	    FileWriter escrituraFichero;
	    String metodoActual;
	    String identificador_metodo;
	    String metodo_padre;
	    String metodo_dentro;

	public CodigoJavaGuilleParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public IdspcContext idspc() {
			return getRuleContext(IdspcContext.class,0);
		}
		public TerminalNode CLASS() { return getToken(CodigoJavaGuilleParser.CLASS, 0); }
		public TerminalNode ID() { return getToken(CodigoJavaGuilleParser.ID, 0); }
		public ClaseContext clase() {
			return getRuleContext(ClaseContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodigoJavaGuilleListener ) ((CodigoJavaGuilleListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodigoJavaGuilleListener ) ((CodigoJavaGuilleListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16);
			idspc();
			setState(17);
			match(CLASS);
			setState(18);
			match(ID);
			setState(19);
			match(T__0);
			setState(20);
			clase();
			setState(21);
			match(T__1);

			        try {
			            File fichero = new File("ficheroSalida.txt");
			            FileWriter escrituraFichero = new FileWriter(fichero, false);
			            for(int i=0; i< listaMetodos.size(); i++){
			                for(int j = 0; j< listaMetodos.get(i).size(); j++){
			                    if(j == 0) {
			                        escrituraFichero.write(listaMetodos.get(i).get(j)+"\n");
			                    } else {
			                        escrituraFichero.write("\t"+listaMetodos.get(i).get(j)+"\n");
			                    }
			                }
			            }
			            /*
			            System.out.println("DEBUG: escribiendofichero:");
			            for(int j = 0 ; j < listaMetodos.size(); j++){
			                for(int a = 0; a < listaMetodos.get(j).size(); a++) {
			                    System.out.println(listaMetodos.get(j).get(a));
			                }
			            }
			            */
			            escrituraFichero.close();
			        } catch(IOException exception){};
			    
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
		public TerminalNode ID() { return getToken(CodigoJavaGuilleParser.ID, 0); }
		public IdspcContext idspc() {
			return getRuleContext(IdspcContext.class,0);
		}
		public IdspcContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_idspc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodigoJavaGuilleListener ) ((CodigoJavaGuilleListener)listener).enterIdspc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodigoJavaGuilleListener ) ((CodigoJavaGuilleListener)listener).exitIdspc(this);
		}
	}

	public final IdspcContext idspc() throws RecognitionException {
		IdspcContext _localctx = new IdspcContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_idspc);
		try {
			setState(29);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(24);
				match(ID);
				setState(25);
				idspc();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 2);
				{
				setState(26);
				match(T__2);
				setState(27);
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
		public Token tipo;
		public Token metodo;
		public IdsContext ids() {
			return getRuleContext(IdsContext.class,0);
		}
		public RestoContext resto() {
			return getRuleContext(RestoContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(CodigoJavaGuilleParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CodigoJavaGuilleParser.ID, i);
		}
		public ClaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_clase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodigoJavaGuilleListener ) ((CodigoJavaGuilleListener)listener).enterClase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodigoJavaGuilleListener ) ((CodigoJavaGuilleListener)listener).exitClase(this);
		}
	}

	public final ClaseContext clase() throws RecognitionException {
		ClaseContext _localctx = new ClaseContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_clase);
		try {
			setState(37);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(31);
				((ClaseContext)_localctx).tipo = match(ID);
				setState(32);
				((ClaseContext)_localctx).metodo = match(ID);
				setState(33);
				ids();
				setState(34);
				resto();
				}
				break;
			case T__1:
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

	public static class RestoContext extends ParserRuleContext {
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public DefContext def() {
			return getRuleContext(DefContext.class,0);
		}
		public ClaseContext clase() {
			return getRuleContext(ClaseContext.class,0);
		}
		public RestoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resto; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodigoJavaGuilleListener ) ((CodigoJavaGuilleListener)listener).enterResto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodigoJavaGuilleListener ) ((CodigoJavaGuilleListener)listener).exitResto(this);
		}
	}

	public final RestoContext resto() throws RecognitionException {
		RestoContext _localctx = new RestoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_resto);
		try {
			setState(47);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(39);
				match(T__3);
				setState(40);
				params();
				setState(41);
				match(T__4);
				setState(42);
				def();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(44);
				def();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(45);
				match(T__2);
				setState(46);
				clase();
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

	public static class DefContext extends ParserRuleContext {
		public CodigoContext codigo() {
			return getRuleContext(CodigoContext.class,0);
		}
		public ClaseContext clase() {
			return getRuleContext(ClaseContext.class,0);
		}
		public DefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodigoJavaGuilleListener ) ((CodigoJavaGuilleListener)listener).enterDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodigoJavaGuilleListener ) ((CodigoJavaGuilleListener)listener).exitDef(this);
		}
	}

	public final DefContext def() throws RecognitionException {
		DefContext _localctx = new DefContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_def);
		try {
			setState(56);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(49);
				match(T__0);
				setState(50);
				codigo();
				setState(51);
				match(T__1);
				setState(52);
				clase();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 2);
				{
				setState(54);
				match(T__2);
				setState(55);
				clase();
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

	public static class IdsContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CodigoJavaGuilleParser.ID, 0); }
		public IdsContext ids() {
			return getRuleContext(IdsContext.class,0);
		}
		public IdsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ids; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodigoJavaGuilleListener ) ((CodigoJavaGuilleListener)listener).enterIds(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodigoJavaGuilleListener ) ((CodigoJavaGuilleListener)listener).exitIds(this);
		}
	}

	public final IdsContext ids() throws RecognitionException {
		IdsContext _localctx = new IdsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_ids);
		try {
			setState(61);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(58);
				match(ID);
				setState(59);
				ids();
				}
				break;
			case T__0:
			case T__2:
			case T__3:
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

	public static class CodigoContext extends ParserRuleContext {
		public Token identificador;
		public List<CodigoContext> codigo() {
			return getRuleContexts(CodigoContext.class);
		}
		public CodigoContext codigo(int i) {
			return getRuleContext(CodigoContext.class,i);
		}
		public TerminalNode ID() { return getToken(CodigoJavaGuilleParser.ID, 0); }
		public CodigoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_codigo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodigoJavaGuilleListener ) ((CodigoJavaGuilleListener)listener).enterCodigo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodigoJavaGuilleListener ) ((CodigoJavaGuilleListener)listener).exitCodigo(this);
		}
	}

	public final CodigoContext codigo() throws RecognitionException {
		CodigoContext _localctx = new CodigoContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_codigo);
		try {
			setState(81);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(63);
				((CodigoContext)_localctx).identificador = match(ID);

				              identificador_metodo=(((CodigoContext)_localctx).identificador!=null?((CodigoContext)_localctx).identificador.getText():null);
				          
				setState(65);
				codigo();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 2);
				{
				setState(66);
				match(T__2);
				setState(67);
				codigo();
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 3);
				{
				setState(68);
				match(T__3);

				              System.out.println("Metodo padre: "+metodo_padre);
				              System.out.println("Metodo Dentro: "+ identificador_metodo);
				          
				setState(70);
				codigo();
				setState(71);
				match(T__4);
				setState(72);
				codigo();
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 4);
				{
				setState(74);
				match(T__0);

				                metodo_padre=identificador_metodo;
				                System.out.println("*************DEBUG");
				                System.out.println("Metodo: "+metodo_padre);
				                //Add metodo listaMetodos
				            
				setState(76);
				codigo();
				setState(77);
				match(T__1);
				setState(78);
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
		public TerminalNode ID() { return getToken(CodigoJavaGuilleParser.ID, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodigoJavaGuilleListener ) ((CodigoJavaGuilleListener)listener).enterParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodigoJavaGuilleListener ) ((CodigoJavaGuilleListener)listener).exitParams(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_params);
		try {
			setState(86);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(83);
				match(ID);
				setState(84);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\f[\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\5\3 \n\3\3\4\3\4\3\4\3\4\3\4\3\4\5\4"+
		"(\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\62\n\5\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\5\6;\n\6\3\7\3\7\3\7\5\7@\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bT\n\b\3\t\3\t\3\t\5\tY\n\t\3"+
		"\t\2\2\n\2\4\6\b\n\f\16\20\2\2\2^\2\22\3\2\2\2\4\37\3\2\2\2\6\'\3\2\2"+
		"\2\b\61\3\2\2\2\n:\3\2\2\2\f?\3\2\2\2\16S\3\2\2\2\20X\3\2\2\2\22\23\5"+
		"\4\3\2\23\24\7\b\2\2\24\25\7\t\2\2\25\26\7\3\2\2\26\27\5\6\4\2\27\30\7"+
		"\4\2\2\30\31\b\2\1\2\31\3\3\2\2\2\32\33\7\t\2\2\33 \5\4\3\2\34\35\7\5"+
		"\2\2\35 \5\4\3\2\36 \3\2\2\2\37\32\3\2\2\2\37\34\3\2\2\2\37\36\3\2\2\2"+
		" \5\3\2\2\2!\"\7\t\2\2\"#\7\t\2\2#$\5\f\7\2$%\5\b\5\2%(\3\2\2\2&(\3\2"+
		"\2\2\'!\3\2\2\2\'&\3\2\2\2(\7\3\2\2\2)*\7\6\2\2*+\5\20\t\2+,\7\7\2\2,"+
		"-\5\n\6\2-\62\3\2\2\2.\62\5\n\6\2/\60\7\5\2\2\60\62\5\6\4\2\61)\3\2\2"+
		"\2\61.\3\2\2\2\61/\3\2\2\2\62\t\3\2\2\2\63\64\7\3\2\2\64\65\5\16\b\2\65"+
		"\66\7\4\2\2\66\67\5\6\4\2\67;\3\2\2\289\7\5\2\29;\5\6\4\2:\63\3\2\2\2"+
		":8\3\2\2\2;\13\3\2\2\2<=\7\t\2\2=@\5\f\7\2>@\3\2\2\2?<\3\2\2\2?>\3\2\2"+
		"\2@\r\3\2\2\2AB\7\t\2\2BC\b\b\1\2CT\5\16\b\2DE\7\5\2\2ET\5\16\b\2FG\7"+
		"\6\2\2GH\b\b\1\2HI\5\16\b\2IJ\7\7\2\2JK\5\16\b\2KT\3\2\2\2LM\7\3\2\2M"+
		"N\b\b\1\2NO\5\16\b\2OP\7\4\2\2PQ\5\16\b\2QT\3\2\2\2RT\3\2\2\2SA\3\2\2"+
		"\2SD\3\2\2\2SF\3\2\2\2SL\3\2\2\2SR\3\2\2\2T\17\3\2\2\2UV\7\t\2\2VY\5\20"+
		"\t\2WY\3\2\2\2XU\3\2\2\2XW\3\2\2\2Y\21\3\2\2\2\t\37\'\61:?SX";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}