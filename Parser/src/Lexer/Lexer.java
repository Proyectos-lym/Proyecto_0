/* The following code was generated by JFlex 1.4.3 on 08/02/23, 00:02 */

package Lexer;
import static Lexer.Tokens.*;

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 08/02/23, 00:02 from the specification file
 * <tt>D:/Lym/Proyecto_0/Parser/src/Lexer/lexer.flex</tt>
 */
public class Lexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\3\1\32\2\0\1\3\22\0\1\3\7\0\1\41\1\42"+
    "\1\36\1\34\1\3\1\35\1\0\1\31\12\2\1\45\1\44\1\0"+
    "\1\33\3\0\32\1\1\37\1\0\1\40\1\0\1\47\1\0\1\15"+
    "\1\46\1\16\1\26\1\11\1\5\1\17\1\7\1\4\1\30\1\22"+
    "\1\10\1\23\1\13\1\24\1\20\1\1\1\27\1\14\1\12\1\21"+
    "\1\25\1\6\3\1\1\0\1\43\uff83\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\4\20\2\1\5\1\6"+
    "\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16"+
    "\1\17\1\20\1\21\15\2\1\22\1\2\1\23\3\2"+
    "\1\4\1\0\5\2\1\24\1\25\12\2\1\0\2\2"+
    "\1\26\5\2\1\25\1\27\3\2\1\3\6\2\1\30"+
    "\11\2\1\31\4\2\1\32\12\2";

  private static int [] zzUnpackAction() {
    int [] result = new int[119];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\50\0\120\0\170\0\240\0\310\0\360\0\u0118"+
    "\0\u0140\0\u0168\0\u0190\0\u01b8\0\u01e0\0\u0208\0\u0230\0\u0258"+
    "\0\u0280\0\u02a8\0\u02d0\0\u02f8\0\u0320\0\u0348\0\50\0\50"+
    "\0\50\0\50\0\50\0\50\0\u0370\0\50\0\50\0\50"+
    "\0\50\0\120\0\u0398\0\u03c0\0\u03e8\0\u0410\0\u0438\0\u0460"+
    "\0\u0488\0\u04b0\0\u04d8\0\u0500\0\u0528\0\u0550\0\u0578\0\120"+
    "\0\u05a0\0\120\0\u05c8\0\u05f0\0\u0618\0\u0640\0\u0668\0\u0690"+
    "\0\u06b8\0\u06e0\0\u0708\0\u0730\0\120\0\120\0\u0758\0\u0780"+
    "\0\u07a8\0\u07d0\0\u07f8\0\u0820\0\u0848\0\u0870\0\u0898\0\u08c0"+
    "\0\u08e8\0\u0910\0\u0938\0\120\0\u0960\0\u0988\0\u09b0\0\u09d8"+
    "\0\u0a00\0\u0a28\0\120\0\u0a50\0\u0a78\0\u0a28\0\50\0\u0aa0"+
    "\0\u0ac8\0\u0af0\0\u0b18\0\u0b40\0\u0b68\0\120\0\u0b90\0\u0bb8"+
    "\0\u0be0\0\u0c08\0\u0c30\0\u0c58\0\u0c80\0\u0ca8\0\u0cd0\0\120"+
    "\0\u0cf8\0\u0d20\0\u0d48\0\u0d70\0\120\0\u0d98\0\u0dc0\0\u0de8"+
    "\0\u0e10\0\u0e38\0\u0e60\0\u0e88\0\u0eb0\0\u0ed8\0\u0f00";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[119];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\5\1\6\1\7\1\10\2\3"+
    "\1\11\1\12\1\13\1\3\1\14\1\15\1\16\1\17"+
    "\2\3\1\20\1\21\1\22\1\23\1\24\1\25\1\26"+
    "\1\5\1\27\1\30\1\31\1\32\1\33\1\34\1\35"+
    "\1\36\1\37\1\40\1\41\2\3\51\0\2\3\1\0"+
    "\25\3\15\0\2\3\2\0\1\4\50\0\1\5\26\0"+
    "\1\5\16\0\2\3\1\0\1\3\1\42\23\3\15\0"+
    "\2\3\1\0\2\3\1\0\11\3\1\43\13\3\15\0"+
    "\2\3\1\0\2\3\1\0\3\3\1\44\21\3\15\0"+
    "\2\3\1\0\2\3\1\0\4\3\1\45\20\3\15\0"+
    "\2\3\1\0\2\3\1\0\3\3\1\46\11\3\1\47"+
    "\7\3\15\0\2\3\1\0\2\3\1\0\20\3\1\50"+
    "\4\3\15\0\2\3\1\0\2\3\1\0\10\3\1\51"+
    "\14\3\15\0\2\3\1\0\2\3\1\0\11\3\1\52"+
    "\13\3\15\0\2\3\1\0\2\3\1\0\20\3\1\53"+
    "\4\3\15\0\2\3\1\0\2\3\1\0\1\54\14\3"+
    "\1\55\5\3\1\56\1\3\15\0\2\3\1\0\2\3"+
    "\1\0\20\3\1\57\4\3\15\0\2\3\1\0\2\3"+
    "\1\0\22\3\1\60\2\3\15\0\2\3\1\0\2\3"+
    "\1\0\11\3\1\61\13\3\15\0\2\3\1\0\2\3"+
    "\1\0\20\3\1\62\4\3\15\0\2\3\1\0\2\3"+
    "\1\0\5\3\1\63\12\3\1\64\4\3\15\0\2\3"+
    "\1\0\2\3\1\0\15\3\1\65\7\3\15\0\2\3"+
    "\31\0\1\66\53\0\1\67\13\0\2\3\1\0\12\3"+
    "\1\70\12\3\15\0\2\3\1\0\2\3\1\0\1\71"+
    "\24\3\15\0\2\3\1\0\2\3\1\0\10\3\1\72"+
    "\14\3\15\0\2\3\1\0\2\3\1\0\5\3\1\73"+
    "\17\3\15\0\2\3\1\0\2\3\1\0\23\3\1\74"+
    "\1\3\15\0\2\3\1\0\2\3\1\0\6\3\1\75"+
    "\5\3\1\76\10\3\15\0\2\3\1\0\2\3\1\0"+
    "\10\3\1\77\14\3\15\0\2\3\1\0\2\3\1\0"+
    "\7\3\1\100\15\3\15\0\2\3\1\0\2\3\1\0"+
    "\6\3\1\101\16\3\15\0\2\3\1\0\2\3\1\0"+
    "\12\3\1\102\12\3\15\0\2\3\1\0\2\3\1\0"+
    "\6\3\1\76\16\3\15\0\2\3\1\0\2\3\1\0"+
    "\20\3\1\103\4\3\15\0\2\3\1\0\2\3\1\0"+
    "\21\3\1\104\3\3\15\0\2\3\1\0\2\3\1\0"+
    "\23\3\1\105\1\3\15\0\2\3\1\0\2\3\1\0"+
    "\14\3\1\106\10\3\15\0\2\3\1\0\2\3\1\0"+
    "\25\3\15\0\1\107\1\3\1\0\2\3\1\0\17\3"+
    "\1\110\5\3\15\0\2\3\32\66\1\0\15\66\2\0"+
    "\1\111\46\0\2\3\1\0\1\112\4\3\1\76\17\3"+
    "\15\0\2\3\1\0\2\3\1\0\4\3\1\113\20\3"+
    "\15\0\2\3\1\0\2\3\1\0\5\3\1\114\17\3"+
    "\15\0\2\3\1\0\2\3\1\0\7\3\1\114\15\3"+
    "\15\0\2\3\1\0\2\3\1\0\7\3\1\76\15\3"+
    "\15\0\2\3\1\0\2\3\1\0\1\115\24\3\15\0"+
    "\2\3\1\0\2\3\1\0\14\3\1\116\2\3\1\117"+
    "\4\3\1\120\15\0\2\3\1\0\2\3\1\0\20\3"+
    "\1\76\4\3\15\0\2\3\1\0\2\3\1\0\16\3"+
    "\1\76\6\3\15\0\2\3\1\0\2\3\1\0\12\3"+
    "\1\121\12\3\15\0\2\3\1\0\2\3\1\0\5\3"+
    "\1\122\17\3\15\0\2\3\1\0\2\3\1\0\10\3"+
    "\1\123\14\3\15\0\2\3\1\0\2\3\1\0\5\3"+
    "\1\124\17\3\15\0\2\3\1\0\2\3\1\0\20\3"+
    "\1\125\4\3\15\0\2\3\1\0\2\3\1\0\14\3"+
    "\1\126\10\3\15\0\2\3\2\0\1\111\37\0\1\127"+
    "\6\0\2\3\1\0\7\3\1\130\15\3\15\0\2\3"+
    "\1\0\2\3\1\0\5\3\1\42\17\3\15\0\2\3"+
    "\1\0\2\3\1\0\7\3\1\131\15\3\15\0\2\3"+
    "\1\0\2\3\1\0\1\132\14\3\1\133\7\3\15\0"+
    "\2\3\1\0\2\3\1\0\20\3\1\134\4\3\15\0"+
    "\2\3\1\0\2\3\1\0\15\3\1\135\7\3\15\0"+
    "\2\3\1\0\2\3\1\0\10\3\1\136\14\3\15\0"+
    "\2\3\1\0\2\3\1\0\1\137\5\3\1\140\16\3"+
    "\15\0\2\3\1\0\2\3\1\0\11\3\1\141\13\3"+
    "\15\0\2\3\1\0\2\3\1\0\6\3\1\142\16\3"+
    "\15\0\2\3\1\0\2\3\1\0\13\3\1\75\11\3"+
    "\15\0\2\3\1\0\2\3\1\0\13\3\1\53\11\3"+
    "\15\0\2\3\1\0\2\3\1\0\12\3\1\143\12\3"+
    "\15\0\2\3\1\0\2\3\1\0\6\3\1\75\16\3"+
    "\15\0\2\3\1\0\2\3\1\0\21\3\1\144\3\3"+
    "\15\0\2\3\1\0\2\3\1\0\17\3\1\145\5\3"+
    "\15\0\2\3\1\0\2\3\1\0\7\3\1\146\15\3"+
    "\15\0\2\3\1\0\2\3\1\0\20\3\1\147\4\3"+
    "\15\0\2\3\1\0\2\3\1\0\6\3\1\150\16\3"+
    "\15\0\2\3\1\0\2\3\1\0\25\3\15\0\1\3"+
    "\1\151\1\0\2\3\1\0\16\3\1\75\6\3\15\0"+
    "\2\3\1\0\2\3\1\0\5\3\1\152\17\3\15\0"+
    "\2\3\1\0\2\3\1\0\14\3\1\152\10\3\15\0"+
    "\2\3\1\0\2\3\1\0\22\3\1\153\2\3\15\0"+
    "\2\3\1\0\2\3\1\0\6\3\1\154\16\3\15\0"+
    "\2\3\1\0\2\3\1\0\23\3\1\155\1\3\15\0"+
    "\2\3\1\0\2\3\1\0\1\156\5\3\1\157\16\3"+
    "\15\0\2\3\1\0\2\3\1\0\1\160\24\3\15\0"+
    "\2\3\1\0\2\3\1\0\3\3\1\161\21\3\15\0"+
    "\2\3\1\0\2\3\1\0\7\3\1\162\15\3\15\0"+
    "\2\3\1\0\2\3\1\0\20\3\1\163\4\3\15\0"+
    "\2\3\1\0\2\3\1\0\23\3\1\76\1\3\15\0"+
    "\2\3\1\0\2\3\1\0\5\3\1\76\17\3\15\0"+
    "\2\3\1\0\2\3\1\0\22\3\1\164\2\3\15\0"+
    "\2\3\1\0\2\3\1\0\6\3\1\165\16\3\15\0"+
    "\2\3\1\0\2\3\1\0\1\166\24\3\15\0\2\3"+
    "\1\0\2\3\1\0\3\3\1\167\21\3\15\0\2\3"+
    "\1\0\2\3\1\0\23\3\1\75\1\3\15\0\2\3"+
    "\1\0\2\3\1\0\5\3\1\75\17\3\15\0\2\3";

  private static int [] zzUnpackTrans() {
    int [] result = new int[3880];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\24\1\6\11\1\1\4\11\25\1\1\0"+
    "\21\1\1\0\15\1\1\11\40\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[119];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
    public String lexeme;


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  Lexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  Lexer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 112) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public Tokens yylex() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 12: 
          { return parentesisi;
          }
        case 27: break;
        case 17: 
          { lexeme=yytext(); return reservadaCond;
          }
        case 28: break;
        case 11: 
          { return corcheted;
          }
        case 29: break;
        case 7: 
          { return suma;
          }
        case 30: break;
        case 14: 
          { return pipeline;
          }
        case 31: break;
        case 15: 
          { return semicolon;
          }
        case 32: break;
        case 26: 
          { return inicio;
          }
        case 33: break;
        case 13: 
          { return parentesisd;
          }
        case 34: break;
        case 21: 
          { lexeme=yytext(); return instruccion;
          }
        case 35: break;
        case 6: 
          { return igual;
          }
        case 36: break;
        case 18: 
          { return cerrardo;
          }
        case 37: break;
        case 25: 
          { return times;
          }
        case 38: break;
        case 5: 
          { return division;
          }
        case 39: break;
        case 22: 
          { lexeme=yytext(); return reservadaBlock;
          }
        case 40: break;
        case 23: 
          { return var;
          }
        case 41: break;
        case 3: 
          { lexeme=yytext(); return numero;
          }
        case 42: break;
        case 16: 
          { return colon;
          }
        case 43: break;
        case 20: 
          { lexeme=yytext(); return condicion;
          }
        case 44: break;
        case 9: 
          { return multiplicacion;
          }
        case 45: break;
        case 8: 
          { return resta;
          }
        case 46: break;
        case 10: 
          { return corchetei;
          }
        case 47: break;
        case 2: 
          { lexeme=yytext(); return identificador;
          }
        case 48: break;
        case 4: 
          { /*Ignore*/
          }
        case 49: break;
        case 24: 
          { return funcion;
          }
        case 50: break;
        case 19: 
          { return abrirdo;
          }
        case 51: break;
        case 1: 
          { return error;
          }
        case 52: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            return null;
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
