/* Generated By:JJTree&JavaCC: Do not edit this line. CdbParser.java */
package wci.frontend;

import java.util.ArrayList;
import java.io.*;

import wci.intermediate.*;
import wci.intermediate.symtabimpl.*;
import wci.backend.*;
import wci.backend.compiler.*;
import wci.util.*;

import static wci.intermediate.symtabimpl.SymTabKeyImpl.*;
import static wci.intermediate.symtabimpl.DefinitionImpl.*;
import static wci.intermediate.symtabimpl.RoutineCodeImpl.*;
import static wci.intermediate.symtabimpl.SymTabKeyImpl.*;
import static wci.intermediate.icodeimpl.ICodeKeyImpl.*;

public class CdbParser/*@bgen(jjtree)*/implements CdbParserTreeConstants, CdbParserConstants {/*@bgen(jjtree)*/
  protected static JJTCdbParserState jjtree = new JJTCdbParserState();private static final String SOURCE_SUFFIX = ".cdb";
    private static final String OUTPUT_SUFFIX = ".j";

    private static SymTabStack symTabStack;
    private static SymTabEntry programId;

    public static void main(String[] args)
        throws Exception
    {
        // Create and initialize the symbol table stack.
        symTabStack = SymTabFactory.createSymTabStack();
        Predefined.initialize(symTabStack);

        // Process the source file path which ends in .cdb
        // and create the output file path which ends in .j
        String sourceFilePath = args[0];
        int truncatedLength = sourceFilePath.length() - SOURCE_SUFFIX.length();
        int suffixIndex = sourceFilePath.lastIndexOf(SOURCE_SUFFIX);
        String objectFilePath = (suffixIndex == truncatedLength)
            ? sourceFilePath.substring(0, truncatedLength) + OUTPUT_SUFFIX
            : sourceFilePath + OUTPUT_SUFFIX;

        // Parse a Cdb program.
        Reader    reader = new FileReader(sourceFilePath);
        CdbParser parser = new CdbParser(reader);
        SimpleNode rootNode = parser.script();

        // Print the cross-reference table.
        CrossReferencer crossReferencer = new CrossReferencer();
        crossReferencer.print(symTabStack);

        // Visit the parse tree nodes to decorate them with type information.
        TypeSetterVisitor typeVisitor = new TypeSetterVisitor();
        rootNode.jjtAccept(typeVisitor, null);

        // Create and initialize the ICode wrapper for the parse tree.
        ICode iCode = ICodeFactory.createICode();
        iCode.setRoot(rootNode);
        programId.setAttribute(ROUTINE_ICODE, iCode);

        // Print the parse tree.
        ParseTreePrinter treePrinter = new ParseTreePrinter(System.out);
        treePrinter.print(symTabStack);

        // Compile the code.
        Backend cg = BackendFactory.createBackend("compile");
        (new File("dummy.j")).createNewFile();
        PrintWriter writer = new PrintWriter("dummy.j");
        cg.process(iCode, symTabStack, writer);
    }

  static final public SimpleNode script() throws ParseException {
                                 /*@bgen(jjtree) COMPOUND */
                                 ASTCOMPOUND jjtn000 = new ASTCOMPOUND(JJTCOMPOUND);
                                 boolean jjtc000 = true;
                                 jjtree.openNodeScope(jjtn000);SimpleNode rootNode;
    try {
    programId = symTabStack.enterLocal("CDB Program");
    programId.setDefinition(DefinitionImpl.PROGRAM);
    programId.setAttribute(ROUTINE_SYMTAB, symTabStack.push());
    symTabStack.setProgramId(programId);
      label_1:
      while (true) {
        try {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case IF:
          case WHILE:
          case FOR:
          case DO:
          case AT:
          case IDENTIFIER:
            statement();
            break;
          case ERROR:
            Error();
                 handleError(token);
            break;
          default:
            jj_la1[0] = jj_gen;
            jj_consume_token(-1);
            throw new ParseException();
          }
        } catch (ParseException ex) {
      handleError(token);
      System.out.println("Parse Exception");
        } catch (NullPointerException ex) {
          handleError(token);
      System.out.println("Undefined Variable");
        }
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case IF:
        case WHILE:
        case FOR:
        case DO:
        case AT:
        case IDENTIFIER:
        case ERROR:
          ;
          break;
        default:
          jj_la1[1] = jj_gen;
          break label_1;
        }
      }
      jj_consume_token(0);
    jjtree.closeNodeScope(jjtn000, true);
    jjtc000 = false;
    {if (true) return jjtn000;}
    } catch (Throwable jjte000) {
    if (jjtc000) {
      jjtree.clearNodeScope(jjtn000);
      jjtc000 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte000 instanceof RuntimeException) {
      {if (true) throw (RuntimeException)jjte000;}
    }
    if (jjte000 instanceof ParseException) {
      {if (true) throw (ParseException)jjte000;}
    }
    {if (true) throw (Error)jjte000;}
    } finally {
    if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
    }
    }
    throw new Error("Missing return statement in function");
  }

  static final public void statement() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDENTIFIER:
      assignmentStatement();
      break;
    case AT:
      declarationStatement();
      break;
    case IF:
      ifStatement();
      break;
    case DO:
      doLoop();
      break;
    case FOR:
      forLoop();
      break;
    case WHILE:
      whileLoop();
      break;
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public SimpleNode compoundStatement() throws ParseException {
                                  /*@bgen(jjtree) compoundStatement */
  ASTcompoundStatement jjtn000 = new ASTcompoundStatement(JJTCOMPOUNDSTATEMENT);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      jj_consume_token(LEFT_BRACE);
      label_2:
      while (true) {
        statement();
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case IF:
        case WHILE:
        case FOR:
        case DO:
        case AT:
        case IDENTIFIER:
          ;
          break;
        default:
          jj_la1[3] = jj_gen;
          break label_2;
        }
      }
      jj_consume_token(RIGHT_BRACE);
      jjtree.closeNodeScope(jjtn000, true);
      jjtc000 = false;
      {if (true) return jjtn000;}
    } catch (Throwable jjte000) {
      if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
    throw new Error("Missing return statement in function");
  }

  static final public void whileLoop() throws ParseException {
                    /*@bgen(jjtree) whileLoop */
  ASTwhileLoop jjtn000 = new ASTwhileLoop(JJTWHILELOOP);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      jj_consume_token(WHILE);
      jj_consume_token(LEFT_PAREN);
      expression();
      jj_consume_token(RIGHT_PAREN);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LEFT_BRACE:
        compoundStatement();
        break;
      case IF:
      case WHILE:
      case FOR:
      case DO:
      case AT:
      case IDENTIFIER:
        statement();
        break;
      default:
        jj_la1[4] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    } catch (Throwable jjte000) {
    if (jjtc000) {
      jjtree.clearNodeScope(jjtn000);
      jjtc000 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte000 instanceof RuntimeException) {
      {if (true) throw (RuntimeException)jjte000;}
    }
    if (jjte000 instanceof ParseException) {
      {if (true) throw (ParseException)jjte000;}
    }
    {if (true) throw (Error)jjte000;}
    } finally {
    if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
    }
    }
  }

  static final public void forLoop() throws ParseException {
                  /*@bgen(jjtree) forLoop */
  ASTforLoop jjtn000 = new ASTforLoop(JJTFORLOOP);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      jj_consume_token(FOR);
      jj_consume_token(LEFT_PAREN);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IDENTIFIER:
        assignment();
        break;
      default:
        jj_la1[5] = jj_gen;
        ;
      }
      jj_consume_token(SEMICOLON);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IDENTIFIER:
      case INTEGER:
      case REAL:
        expression();
        break;
      default:
        jj_la1[6] = jj_gen;
        ;
      }
      jj_consume_token(SEMICOLON);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IDENTIFIER:
        assignment();
        break;
      default:
        jj_la1[7] = jj_gen;
        ;
      }
      jj_consume_token(RIGHT_PAREN);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LEFT_BRACE:
        compoundStatement();
        break;
      case IF:
      case WHILE:
      case FOR:
      case DO:
      case AT:
      case IDENTIFIER:
        statement();
        break;
      default:
        jj_la1[8] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    } catch (Throwable jjte000) {
    if (jjtc000) {
      jjtree.clearNodeScope(jjtn000);
      jjtc000 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte000 instanceof RuntimeException) {
      {if (true) throw (RuntimeException)jjte000;}
    }
    if (jjte000 instanceof ParseException) {
      {if (true) throw (ParseException)jjte000;}
    }
    {if (true) throw (Error)jjte000;}
    } finally {
    if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
    }
    }
  }

  static final public void doLoop() throws ParseException {
                 /*@bgen(jjtree) doLoop */
  ASTdoLoop jjtn000 = new ASTdoLoop(JJTDOLOOP);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      jj_consume_token(DO);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LEFT_BRACE:
        compoundStatement();
        break;
      case IF:
      case WHILE:
      case FOR:
      case DO:
      case AT:
      case IDENTIFIER:
        statement();
        break;
      default:
        jj_la1[9] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      jj_consume_token(WHILE);
      jj_consume_token(LEFT_PAREN);
      expression();
      jj_consume_token(RIGHT_PAREN);
      jj_consume_token(SEMICOLON);
    } catch (Throwable jjte000) {
          if (jjtc000) {
            jjtree.clearNodeScope(jjtn000);
            jjtc000 = false;
          } else {
            jjtree.popNode();
          }
          if (jjte000 instanceof RuntimeException) {
            {if (true) throw (RuntimeException)jjte000;}
          }
          if (jjte000 instanceof ParseException) {
            {if (true) throw (ParseException)jjte000;}
          }
          {if (true) throw (Error)jjte000;}
    } finally {
          if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
          }
    }
  }

  static final public void ifStatement() throws ParseException {
                      /*@bgen(jjtree) ifStatement */
  ASTifStatement jjtn000 = new ASTifStatement(JJTIFSTATEMENT);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      jj_consume_token(IF);
      jj_consume_token(LEFT_PAREN);
      expression();
      jj_consume_token(RIGHT_PAREN);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LEFT_BRACE:
        compoundStatement();
        break;
      case IF:
      case WHILE:
      case FOR:
      case DO:
      case AT:
      case IDENTIFIER:
        statement();
        break;
      default:
        jj_la1[10] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ELSE:
        jj_consume_token(ELSE);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case LEFT_BRACE:
          compoundStatement();
          break;
        case IF:
        case WHILE:
        case FOR:
        case DO:
        case AT:
        case IDENTIFIER:
          statement();
          break;
        default:
          jj_la1[11] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        break;
      default:
        jj_la1[12] = jj_gen;
        ;
      }
    } catch (Throwable jjte000) {
          if (jjtc000) {
            jjtree.clearNodeScope(jjtn000);
            jjtc000 = false;
          } else {
            jjtree.popNode();
          }
          if (jjte000 instanceof RuntimeException) {
            {if (true) throw (RuntimeException)jjte000;}
          }
          if (jjte000 instanceof ParseException) {
            {if (true) throw (ParseException)jjte000;}
          }
          {if (true) throw (Error)jjte000;}
    } finally {
          if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
          }
    }
  }

  static final public void declarationStatement() throws ParseException {
                                     ArrayList<SymTabEntry> variableList;
                                         int index = 0;
    jj_consume_token(AT);
    jj_consume_token(IDENTIFIER);
                        SymTabEntry typeId = symTabStack.lookup(token.image);
            typeId.appendLineNumber(token.beginLine);
            TypeSpec type = typeId.getTypeSpec();
    jj_consume_token(IDENTIFIER);
            variableList = new ArrayList<SymTabEntry>();
            processVariableDecl(token, index++, variableList);
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMMA:
        ;
        break;
      default:
        jj_la1[13] = jj_gen;
        break label_3;
      }
      jj_consume_token(COMMA);
      jj_consume_token(IDENTIFIER);
                processVariableDecl(token, index++, variableList);
    }
                for (SymTabEntry variableId : variableList) {
                        variableId.setTypeSpec(type);
            }
    jj_consume_token(SEMICOLON);
  }

  static final public void assignmentStatement() throws ParseException {
    assignment();
    jj_consume_token(SEMICOLON);
  }

  static final public void assignment() throws ParseException {
                             /*@bgen(jjtree) ASSIGN */
  ASTASSIGN jjtn000 = new ASTASSIGN(JJTASSIGN);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      variable();
        SymTabEntry variableId = symTabStack.lookup(token.image);
        variableId.appendLineNumber(token.beginLine);
      jj_consume_token(EQUALS);
      expression();
    } catch (Throwable jjte000) {
          if (jjtc000) {
            jjtree.clearNodeScope(jjtn000);
            jjtc000 = false;
          } else {
            jjtree.popNode();
          }
          if (jjte000 instanceof RuntimeException) {
            {if (true) throw (RuntimeException)jjte000;}
          }
          if (jjte000 instanceof ParseException) {
            {if (true) throw (ParseException)jjte000;}
          }
          {if (true) throw (Error)jjte000;}
    } finally {
          if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
          }
    }
  }

  static final public void expression() throws ParseException {
    simpleExpression();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case EE:
    case NE:
    case LT:
    case LE:
    case GT:
    case GE:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case EE:
        jj_consume_token(EE);
                       ASTEE jjtn001 = new ASTEE(JJTEE);
                       boolean jjtc001 = true;
                       jjtree.openNodeScope(jjtn001);
        try {
          simpleExpression();
        } catch (Throwable jjte001) {
                       if (jjtc001) {
                         jjtree.clearNodeScope(jjtn001);
                         jjtc001 = false;
                       } else {
                         jjtree.popNode();
                       }
                       if (jjte001 instanceof RuntimeException) {
                         {if (true) throw (RuntimeException)jjte001;}
                       }
                       if (jjte001 instanceof ParseException) {
                         {if (true) throw (ParseException)jjte001;}
                       }
                       {if (true) throw (Error)jjte001;}
        } finally {
                       if (jjtc001) {
                         jjtree.closeNodeScope(jjtn001,  2);
                       }
        }
        break;
      case NE:
        jj_consume_token(NE);
               ASTNE jjtn002 = new ASTNE(JJTNE);
               boolean jjtc002 = true;
               jjtree.openNodeScope(jjtn002);
        try {
          simpleExpression();
        } catch (Throwable jjte002) {
               if (jjtc002) {
                 jjtree.clearNodeScope(jjtn002);
                 jjtc002 = false;
               } else {
                 jjtree.popNode();
               }
               if (jjte002 instanceof RuntimeException) {
                 {if (true) throw (RuntimeException)jjte002;}
               }
               if (jjte002 instanceof ParseException) {
                 {if (true) throw (ParseException)jjte002;}
               }
               {if (true) throw (Error)jjte002;}
        } finally {
               if (jjtc002) {
                 jjtree.closeNodeScope(jjtn002,  2);
               }
        }
        break;
      case LT:
        jj_consume_token(LT);
               ASTLT jjtn003 = new ASTLT(JJTLT);
               boolean jjtc003 = true;
               jjtree.openNodeScope(jjtn003);
        try {
          simpleExpression();
        } catch (Throwable jjte003) {
               if (jjtc003) {
                 jjtree.clearNodeScope(jjtn003);
                 jjtc003 = false;
               } else {
                 jjtree.popNode();
               }
               if (jjte003 instanceof RuntimeException) {
                 {if (true) throw (RuntimeException)jjte003;}
               }
               if (jjte003 instanceof ParseException) {
                 {if (true) throw (ParseException)jjte003;}
               }
               {if (true) throw (Error)jjte003;}
        } finally {
               if (jjtc003) {
                 jjtree.closeNodeScope(jjtn003,  2);
               }
        }
        break;
      case LE:
        jj_consume_token(LE);
               ASTLE jjtn004 = new ASTLE(JJTLE);
               boolean jjtc004 = true;
               jjtree.openNodeScope(jjtn004);
        try {
          simpleExpression();
        } catch (Throwable jjte004) {
               if (jjtc004) {
                 jjtree.clearNodeScope(jjtn004);
                 jjtc004 = false;
               } else {
                 jjtree.popNode();
               }
               if (jjte004 instanceof RuntimeException) {
                 {if (true) throw (RuntimeException)jjte004;}
               }
               if (jjte004 instanceof ParseException) {
                 {if (true) throw (ParseException)jjte004;}
               }
               {if (true) throw (Error)jjte004;}
        } finally {
               if (jjtc004) {
                 jjtree.closeNodeScope(jjtn004,  2);
               }
        }
        break;
      case GT:
        jj_consume_token(GT);
               ASTGT jjtn005 = new ASTGT(JJTGT);
               boolean jjtc005 = true;
               jjtree.openNodeScope(jjtn005);
        try {
          simpleExpression();
        } catch (Throwable jjte005) {
               if (jjtc005) {
                 jjtree.clearNodeScope(jjtn005);
                 jjtc005 = false;
               } else {
                 jjtree.popNode();
               }
               if (jjte005 instanceof RuntimeException) {
                 {if (true) throw (RuntimeException)jjte005;}
               }
               if (jjte005 instanceof ParseException) {
                 {if (true) throw (ParseException)jjte005;}
               }
               {if (true) throw (Error)jjte005;}
        } finally {
               if (jjtc005) {
                 jjtree.closeNodeScope(jjtn005,  2);
               }
        }
        break;
      case GE:
        jj_consume_token(GE);
               ASTGE jjtn006 = new ASTGE(JJTGE);
               boolean jjtc006 = true;
               jjtree.openNodeScope(jjtn006);
        try {
          simpleExpression();
        } catch (Throwable jjte006) {
               if (jjtc006) {
                 jjtree.clearNodeScope(jjtn006);
                 jjtc006 = false;
               } else {
                 jjtree.popNode();
               }
               if (jjte006 instanceof RuntimeException) {
                 {if (true) throw (RuntimeException)jjte006;}
               }
               if (jjte006 instanceof ParseException) {
                 {if (true) throw (ParseException)jjte006;}
               }
               {if (true) throw (Error)jjte006;}
        } finally {
               if (jjtc006) {
                 jjtree.closeNodeScope(jjtn006,  2);
               }
        }
        break;
      default:
        jj_la1[14] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
    default:
      jj_la1[15] = jj_gen;
      ;
    }
  }

  static final public void simpleExpression() throws ParseException {
    term();
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS:
      case MINUS:
        ;
        break;
      default:
        jj_la1[16] = jj_gen;
        break label_4;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS:
        jj_consume_token(PLUS);
              ASTadd jjtn001 = new ASTadd(JJTADD);
              boolean jjtc001 = true;
              jjtree.openNodeScope(jjtn001);
        try {
          term();
        } catch (Throwable jjte001) {
              if (jjtc001) {
                jjtree.clearNodeScope(jjtn001);
                jjtc001 = false;
              } else {
                jjtree.popNode();
              }
              if (jjte001 instanceof RuntimeException) {
                {if (true) throw (RuntimeException)jjte001;}
              }
              if (jjte001 instanceof ParseException) {
                {if (true) throw (ParseException)jjte001;}
              }
              {if (true) throw (Error)jjte001;}
        } finally {
              if (jjtc001) {
                jjtree.closeNodeScope(jjtn001,  2);
              }
        }
        break;
      case MINUS:
        jj_consume_token(MINUS);
              ASTsubtract jjtn002 = new ASTsubtract(JJTSUBTRACT);
              boolean jjtc002 = true;
              jjtree.openNodeScope(jjtn002);
        try {
          term();
        } catch (Throwable jjte002) {
              if (jjtc002) {
                jjtree.clearNodeScope(jjtn002);
                jjtc002 = false;
              } else {
                jjtree.popNode();
              }
              if (jjte002 instanceof RuntimeException) {
                {if (true) throw (RuntimeException)jjte002;}
              }
              if (jjte002 instanceof ParseException) {
                {if (true) throw (ParseException)jjte002;}
              }
              {if (true) throw (Error)jjte002;}
        } finally {
              if (jjtc002) {
                jjtree.closeNodeScope(jjtn002,  2);
              }
        }
        break;
      default:
        jj_la1[17] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  static final public void term() throws ParseException {
    factor();
    label_5:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case STAR:
      case SLASH:
        ;
        break;
      default:
        jj_la1[18] = jj_gen;
        break label_5;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case STAR:
        jj_consume_token(STAR);
              ASTmultiply jjtn001 = new ASTmultiply(JJTMULTIPLY);
              boolean jjtc001 = true;
              jjtree.openNodeScope(jjtn001);
        try {
          factor();
        } catch (Throwable jjte001) {
              if (jjtc001) {
                jjtree.clearNodeScope(jjtn001);
                jjtc001 = false;
              } else {
                jjtree.popNode();
              }
              if (jjte001 instanceof RuntimeException) {
                {if (true) throw (RuntimeException)jjte001;}
              }
              if (jjte001 instanceof ParseException) {
                {if (true) throw (ParseException)jjte001;}
              }
              {if (true) throw (Error)jjte001;}
        } finally {
              if (jjtc001) {
                jjtree.closeNodeScope(jjtn001,  2);
              }
        }
        break;
      case SLASH:
        jj_consume_token(SLASH);
              ASTdivide jjtn002 = new ASTdivide(JJTDIVIDE);
              boolean jjtc002 = true;
              jjtree.openNodeScope(jjtn002);
        try {
          factor();
        } catch (Throwable jjte002) {
              if (jjtc002) {
                jjtree.clearNodeScope(jjtn002);
                jjtc002 = false;
              } else {
                jjtree.popNode();
              }
              if (jjte002 instanceof RuntimeException) {
                {if (true) throw (RuntimeException)jjte002;}
              }
              if (jjte002 instanceof ParseException) {
                {if (true) throw (ParseException)jjte002;}
              }
              {if (true) throw (Error)jjte002;}
        } finally {
              if (jjtc002) {
                jjtree.closeNodeScope(jjtn002,  2);
              }
        }
        break;
      default:
        jj_la1[19] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  static final public void factor() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDENTIFIER:
      variable();
      break;
    case INTEGER:
      integerConstant();
      break;
    case REAL:
      realConstant();
      break;
    default:
      jj_la1[20] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void variable() throws ParseException {
                   /*@bgen(jjtree) variable */
  ASTvariable jjtn000 = new ASTvariable(JJTVARIABLE);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      jj_consume_token(IDENTIFIER);
                   jjtree.closeNodeScope(jjtn000, true);
                   jjtc000 = false;
        SymTabEntry variableId = symTabStack.lookup(token.image);
        variableId.appendLineNumber(token.beginLine);
        TypeSpec type = variableId.getTypeSpec();
        jjtn000.setTypeSpec(type);
        jjtn000.setAttribute(ID, token.image);
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
  }

  static final public void integerConstant() throws ParseException {
                          /*@bgen(jjtree) integerConstant */
  ASTintegerConstant jjtn000 = new ASTintegerConstant(JJTINTEGERCONSTANT);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      jj_consume_token(INTEGER);
                jjtree.closeNodeScope(jjtn000, true);
                jjtc000 = false;
        jjtn000.setTypeSpec(Predefined.integerType);
        jjtn000.setAttribute(VALUE, Integer.parseInt(token.image));
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
  }

  static final public void realConstant() throws ParseException {
                       /*@bgen(jjtree) realConstant */
  ASTrealConstant jjtn000 = new ASTrealConstant(JJTREALCONSTANT);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      jj_consume_token(REAL);
             jjtree.closeNodeScope(jjtn000, true);
             jjtc000 = false;
        jjtn000.setTypeSpec(Predefined.realType);
        jjtn000.setAttribute(VALUE, Float.parseFloat(token.image));
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
  }

  static final public void Error() throws ParseException {
    jj_consume_token(ERROR);
  }

  static void processVariableDecl(Token token, int index,
                         ArrayList<SymTabEntry> variableList) throws ParseException {
    SymTabEntry variableId = symTabStack.enterLocal(token.image);
    variableId.setIndex(index);
    variableId.setDefinition(DefinitionImpl.VARIABLE);
    variableId.appendLineNumber(token.beginLine);
    variableList.add(variableId);
  }

  static String handleError(Token token) throws ParseException {
    System.out.println("*** ERROR: Line " + token.beginLine +
                     " after \u005c"" + token.image + "\u005c"");

    do {
        token = getNextToken();
    } while (token.kind != SEMICOLON);

        //jjtree.popNode();
    return token.image;
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public CdbParserTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[21];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x5c400,0x5c400,0x5c400,0x5c400,0x5c400,0x0,0x0,0x0,0x5c400,0x5c400,0x5c400,0x5c400,0x800,0x4000000,0x3f00000,0x3f00000,0x60000000,0x60000000,0x80000000,0x80000000,0x0,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x200200,0x200200,0x200,0x200,0x220,0x200,0x1a00,0x200,0x220,0x220,0x220,0x220,0x0,0x0,0x0,0x0,0x0,0x0,0x1,0x1,0x1a00,};
   }

  /** Constructor with InputStream. */
  public CdbParser(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public CdbParser(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new CdbParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 21; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jjtree.reset();
    jj_gen = 0;
    for (int i = 0; i < 21; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public CdbParser(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new CdbParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 21; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jjtree.reset();
    jj_gen = 0;
    for (int i = 0; i < 21; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public CdbParser(CdbParserTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 21; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(CdbParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jjtree.reset();
    jj_gen = 0;
    for (int i = 0; i < 21; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[54];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 21; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 54; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}
