// Generated from CodigoJavaGuille.g4 by ANTLR 4.7

    import java.util.*;
    import java.io.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CodigoJavaGuilleParser}.
 */
public interface CodigoJavaGuilleListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CodigoJavaGuilleParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(CodigoJavaGuilleParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodigoJavaGuilleParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(CodigoJavaGuilleParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodigoJavaGuilleParser#idspc}.
	 * @param ctx the parse tree
	 */
	void enterIdspc(CodigoJavaGuilleParser.IdspcContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodigoJavaGuilleParser#idspc}.
	 * @param ctx the parse tree
	 */
	void exitIdspc(CodigoJavaGuilleParser.IdspcContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodigoJavaGuilleParser#clase}.
	 * @param ctx the parse tree
	 */
	void enterClase(CodigoJavaGuilleParser.ClaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodigoJavaGuilleParser#clase}.
	 * @param ctx the parse tree
	 */
	void exitClase(CodigoJavaGuilleParser.ClaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodigoJavaGuilleParser#resto}.
	 * @param ctx the parse tree
	 */
	void enterResto(CodigoJavaGuilleParser.RestoContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodigoJavaGuilleParser#resto}.
	 * @param ctx the parse tree
	 */
	void exitResto(CodigoJavaGuilleParser.RestoContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodigoJavaGuilleParser#def}.
	 * @param ctx the parse tree
	 */
	void enterDef(CodigoJavaGuilleParser.DefContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodigoJavaGuilleParser#def}.
	 * @param ctx the parse tree
	 */
	void exitDef(CodigoJavaGuilleParser.DefContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodigoJavaGuilleParser#ids}.
	 * @param ctx the parse tree
	 */
	void enterIds(CodigoJavaGuilleParser.IdsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodigoJavaGuilleParser#ids}.
	 * @param ctx the parse tree
	 */
	void exitIds(CodigoJavaGuilleParser.IdsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodigoJavaGuilleParser#codigo}.
	 * @param ctx the parse tree
	 */
	void enterCodigo(CodigoJavaGuilleParser.CodigoContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodigoJavaGuilleParser#codigo}.
	 * @param ctx the parse tree
	 */
	void exitCodigo(CodigoJavaGuilleParser.CodigoContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodigoJavaGuilleParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(CodigoJavaGuilleParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodigoJavaGuilleParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(CodigoJavaGuilleParser.ParamsContext ctx);
}