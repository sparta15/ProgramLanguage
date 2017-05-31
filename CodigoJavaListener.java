// Generated from CodigoJava.g4 by ANTLR 4.7

    import java.util.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CodigoJavaParser}.
 */
public interface CodigoJavaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CodigoJavaParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(CodigoJavaParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodigoJavaParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(CodigoJavaParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodigoJavaParser#idspc}.
	 * @param ctx the parse tree
	 */
	void enterIdspc(CodigoJavaParser.IdspcContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodigoJavaParser#idspc}.
	 * @param ctx the parse tree
	 */
	void exitIdspc(CodigoJavaParser.IdspcContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodigoJavaParser#clase}.
	 * @param ctx the parse tree
	 */
	void enterClase(CodigoJavaParser.ClaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodigoJavaParser#clase}.
	 * @param ctx the parse tree
	 */
	void exitClase(CodigoJavaParser.ClaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodigoJavaParser#ids}.
	 * @param ctx the parse tree
	 */
	void enterIds(CodigoJavaParser.IdsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodigoJavaParser#ids}.
	 * @param ctx the parse tree
	 */
	void exitIds(CodigoJavaParser.IdsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodigoJavaParser#codigo}.
	 * @param ctx the parse tree
	 */
	void enterCodigo(CodigoJavaParser.CodigoContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodigoJavaParser#codigo}.
	 * @param ctx the parse tree
	 */
	void exitCodigo(CodigoJavaParser.CodigoContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodigoJavaParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(CodigoJavaParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodigoJavaParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(CodigoJavaParser.ParamsContext ctx);
}