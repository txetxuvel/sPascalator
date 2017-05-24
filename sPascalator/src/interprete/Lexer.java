/* The following code was generated by JFlex 1.4.1 on 18/06/06 21:54 */

package interprete;

import java_cup.runtime.*;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.1
 * on 18/06/06 21:54 from the specification file
 * <tt>C:/tfc/eclipse/spascal/jflex-cup/jflex/mpascal.jflex</tt>
 */
public class Lexer implements java_cup.runtime.Scanner {

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
     0, 1
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\1\1\3\2\0\1\36\22\0\1\1\2\0\1\30\3\0"+
    "\1\2\2\0\1\34\2\0\1\31\1\33\1\0\12\32\2\0\1\35"+
    "\4\0\1\4\1\21\1\20\1\7\1\14\1\16\1\23\1\0\1\5"+
    "\1\25\1\0\1\11\1\24\1\6\1\12\1\26\1\0\1\13\1\15"+
    "\1\22\1\17\1\10\2\0\1\27\7\0\1\4\1\21\1\20\1\7"+
    "\1\14\1\16\1\23\1\0\1\5\1\25\1\0\1\11\1\24\1\6"+
    "\1\12\1\26\1\0\1\13\1\15\1\22\1\17\1\10\2\0\1\27"+
    "\u05e6\0\12\32\206\0\12\32\u026c\0\12\32\166\0\12\32\166\0\12\32"+
    "\166\0\12\32\166\0\12\32\167\0\11\32\166\0\12\32\166\0\12\32"+
    "\166\0\12\32\340\0\12\32\166\0\12\32\106\0\12\32\u0116\0\12\32"+
    "\u031f\0\11\32\u046e\0\12\32\46\0\12\32\u012c\0\12\32\ue5c0\0\12\32"+
    "\346\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\2\0\1\1\1\2\1\1\1\3\1\1\1\4\21\1"+
    "\1\5\1\0\1\6\15\0\1\7\20\0\1\10\1\11"+
    "\61\0\1\12\20\0\1\13\1\0\1\14\16\0\1\15"+
    "\15\0\1\16\1\0\1\17\16\0\1\20\25\0\1\21"+
    "\21\0\1\22\1\23\15\0\1\24\13\0\1\25\1\0"+
    "\1\26\1\27\1\30\1\31\6\0\1\32\2\0\1\33"+
    "\4\0\1\34\6\0\1\35\2\0\1\36\1\0\1\37"+
    "\2\0\1\40\1\41\3\0\1\42\4\0\1\43\1\44"+
    "\1\0\1\45\2\0\1\46\1\0\1\47\1\0\1\50"+
    "\1\0\1\51\2\0\1\52\4\0\1\53\1\54\1\55"+
    "\1\56\1\0\1\57\1\60\1\61\1\62\1\63\4\0"+
    "\1\64\3\0\1\65\1\0\1\66\1\0\1\67\5\0"+
    "\1\70\1\71\3\0\1\72\1\73\1\74\2\0\1\75"+
    "\1\76\2\0\1\77";

  private static int [] zzUnpackAction() {
    int [] result = new int[349];
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
    "\0\0\0\37\0\76\0\135\0\174\0\76\0\233\0\272"+
    "\0\331\0\370\0\u0117\0\u0136\0\u0155\0\u0174\0\u0193\0\u01b2"+
    "\0\u01d1\0\u01f0\0\u020f\0\u022e\0\u024d\0\u026c\0\u028b\0\u02aa"+
    "\0\u02c9\0\u02e8\0\174\0\u0307\0\u0326\0\u0345\0\u0364\0\u0383"+
    "\0\u03a2\0\u03c1\0\u03e0\0\u03ff\0\u041e\0\u043d\0\u045c\0\u047b"+
    "\0\u049a\0\u01b2\0\u04b9\0\u04d8\0\u04f7\0\u0516\0\u0535\0\u0554"+
    "\0\u0573\0\u0592\0\u05b1\0\u05d0\0\u05ef\0\u060e\0\u062d\0\u064c"+
    "\0\u066b\0\u068a\0\u02c9\0\u0326\0\u06a9\0\u06c8\0\u06e7\0\u0706"+
    "\0\u0725\0\u0744\0\u0763\0\u0782\0\u07a1\0\u07c0\0\u07df\0\u07fe"+
    "\0\u081d\0\u083c\0\u085b\0\u087a\0\u0899\0\u08b8\0\u08d7\0\u08f6"+
    "\0\u0915\0\u0934\0\u0953\0\u0972\0\u0991\0\u09b0\0\u09cf\0\u09ee"+
    "\0\u0a0d\0\u0a2c\0\u0a4b\0\u0a6a\0\u0a89\0\u0aa8\0\u0ac7\0\u0ae6"+
    "\0\u0b05\0\u0b24\0\u0b43\0\u0b62\0\u0b81\0\u0ba0\0\u0bbf\0\u0bde"+
    "\0\u0bfd\0\u0c1c\0\u0c3b\0\u0c5a\0\u0c79\0\u0c98\0\u0cb7\0\u0cd6"+
    "\0\u0cf5\0\u0d14\0\u0d33\0\u0d52\0\u0d71\0\u0d90\0\u0daf\0\u0dce"+
    "\0\u0ded\0\u0e0c\0\u0e2b\0\u0e4a\0\u0e69\0\u0e88\0\76\0\u0ea7"+
    "\0\u0ec6\0\u0ee5\0\u0f04\0\u0f23\0\u0f42\0\u0f61\0\u0f80\0\u0f9f"+
    "\0\u0fbe\0\u0fdd\0\u0ffc\0\u101b\0\u103a\0\u1059\0\u1078\0\u1097"+
    "\0\u10b6\0\u10d5\0\u10f4\0\u1113\0\u1132\0\u1151\0\u1170\0\u118f"+
    "\0\u11ae\0\u11cd\0\u11ec\0\u120b\0\u122a\0\u1249\0\u1268\0\u1287"+
    "\0\u12a6\0\u12c5\0\u12e4\0\u1303\0\u1322\0\u1341\0\u1360\0\u137f"+
    "\0\u139e\0\u13bd\0\u13dc\0\u13fb\0\u141a\0\u1439\0\76\0\u1458"+
    "\0\u1477\0\u1496\0\u14b5\0\u14d4\0\u14f3\0\u1512\0\u1531\0\u1550"+
    "\0\u156f\0\u158e\0\u15ad\0\u15cc\0\u15eb\0\u160a\0\u1629\0\u1648"+
    "\0\u1667\0\u1686\0\u16a5\0\u16c4\0\u16e3\0\u1702\0\u1721\0\u1740"+
    "\0\u175f\0\u177e\0\u179d\0\u17bc\0\u17db\0\u17fa\0\u1819\0\u1838"+
    "\0\u1857\0\u1876\0\u1895\0\u18b4\0\u18d3\0\u18f2\0\76\0\u1911"+
    "\0\u1930\0\u194f\0\u196e\0\u198d\0\u19ac\0\u19cb\0\u19ea\0\u1a09"+
    "\0\u1a28\0\u1a47\0\u1a66\0\u1a85\0\u1aa4\0\76\0\u1ac3\0\u1ae2"+
    "\0\u1b01\0\u1b20\0\u1b3f\0\u1b5e\0\u1b7d\0\u1b9c\0\u1bbb\0\u1bda"+
    "\0\u1bf9\0\76\0\u1c18\0\76\0\76\0\u1c37\0\76\0\u1c56"+
    "\0\u1c75\0\u1c94\0\u1cb3\0\u1cd2\0\u1cf1\0\76\0\u1d10\0\u1d2f"+
    "\0\76\0\u1d4e\0\u1d6d\0\u1d8c\0\u1dab\0\76\0\u1dca\0\u1de9"+
    "\0\u1e08\0\u1e27\0\u1e46\0\u1e65\0\u1e84\0\u1ea3\0\u1ec2\0\u1ee1"+
    "\0\u1f00\0\u1f1f\0\u1f3e\0\u1f5d\0\76\0\76\0\u1f7c\0\u1f9b"+
    "\0\u1fba\0\76\0\u1fd9\0\u1ff8\0\u2017\0\u2036\0\76\0\76"+
    "\0\u2055\0\76\0\u2074\0\u2093\0\76\0\u20b2\0\76\0\u20d1"+
    "\0\u20f0\0\u210f\0\76\0\u212e\0\u214d\0\76\0\u216c\0\u218b"+
    "\0\u21aa\0\u21c9\0\76\0\76\0\76\0\76\0\u21e8\0\76"+
    "\0\76\0\76\0\76\0\u2207\0\u2226\0\u2245\0\u2264\0\u2283"+
    "\0\76\0\u22a2\0\u22c1\0\u22e0\0\76\0\u22ff\0\76\0\u231e"+
    "\0\76\0\u233d\0\u235c\0\u237b\0\u239a\0\u23b9\0\76\0\76"+
    "\0\u23d8\0\u23f7\0\u2416\0\76\0\76\0\76\0\u2435\0\u2454"+
    "\0\76\0\76\0\u2473\0\u2492\0\76";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[349];
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
    "\1\3\1\4\1\5\1\6\25\3\1\7\1\10\3\3"+
    "\1\6\1\3\1\4\1\5\1\6\1\11\1\12\1\13"+
    "\1\14\1\3\1\15\1\16\1\17\1\20\1\21\2\3"+
    "\1\22\1\23\1\24\1\25\1\26\1\3\1\27\1\3"+
    "\1\30\1\7\1\10\1\3\1\31\1\32\1\6\40\0"+
    "\1\4\33\0\1\32\1\0\2\33\1\34\34\33\32\0"+
    "\1\10\36\0\1\10\1\35\10\0\1\36\5\0\1\37"+
    "\46\0\1\40\27\0\1\41\27\0\1\42\6\0\1\43"+
    "\3\0\1\44\23\0\1\45\3\0\1\46\2\0\1\47"+
    "\42\0\1\50\32\0\1\51\54\0\1\52\23\0\1\53"+
    "\24\0\1\54\1\0\1\55\1\0\1\56\1\57\1\60"+
    "\4\0\1\61\23\0\1\62\45\0\1\63\35\0\1\64"+
    "\27\0\1\65\5\0\1\66\1\0\1\67\35\0\1\70"+
    "\32\0\1\71\12\0\1\72\46\0\1\73\4\0\3\32"+
    "\1\0\33\32\2\0\1\33\66\0\1\74\12\0\1\75"+
    "\44\0\1\76\41\0\1\77\42\0\1\100\23\0\1\101"+
    "\4\0\1\102\31\0\1\103\1\104\4\0\1\105\24\0"+
    "\1\106\56\0\1\107\16\0\1\110\52\0\1\111\35\0"+
    "\1\112\34\0\1\113\45\0\1\114\20\0\1\115\35\0"+
    "\1\116\36\0\1\117\37\0\1\120\44\0\1\121\34\0"+
    "\1\122\42\0\1\123\33\0\1\124\27\0\1\125\61\0"+
    "\1\126\16\0\1\127\35\0\1\130\42\0\1\131\40\0"+
    "\1\132\26\0\1\133\41\0\1\134\33\0\1\135\10\0"+
    "\1\136\25\0\1\137\36\0\1\140\37\0\1\141\53\0"+
    "\1\142\4\0\1\143\21\0\1\144\40\0\1\145\33\0"+
    "\1\146\51\0\1\147\17\0\1\150\55\0\1\151\34\0"+
    "\1\152\42\0\1\153\24\0\1\154\5\0\1\155\20\0"+
    "\1\156\41\0\1\157\42\0\1\160\45\0\1\161\41\0"+
    "\1\162\34\0\1\163\21\0\1\164\35\0\1\165\12\0"+
    "\1\166\42\0\1\167\33\0\1\170\27\0\1\171\43\0"+
    "\1\172\31\0\1\173\33\0\1\174\45\0\1\105\44\0"+
    "\1\175\22\0\1\176\37\0\1\177\43\0\1\200\31\0"+
    "\1\201\45\0\1\202\1\0\1\203\31\0\1\204\26\0"+
    "\1\205\50\0\1\206\30\0\1\207\51\0\1\210\17\0"+
    "\1\211\57\0\1\212\32\0\1\213\20\0\1\214\51\0"+
    "\1\215\23\0\1\216\45\0\1\217\27\0\1\220\45\0"+
    "\1\221\33\0\1\222\33\0\1\223\3\0\1\224\11\0"+
    "\1\225\27\0\1\226\41\0\1\227\24\0\1\230\46\0"+
    "\1\231\27\0\1\232\42\0\1\233\31\0\1\234\35\0"+
    "\1\235\45\0\1\236\34\0\1\237\40\0\1\240\42\0"+
    "\1\241\35\0\1\242\4\0\1\243\17\0\1\244\51\0"+
    "\1\245\32\0\1\246\30\0\1\247\36\0\1\250\36\0"+
    "\1\251\37\0\1\252\36\0\1\253\47\0\1\254\33\0"+
    "\1\255\44\0\1\256\26\0\1\257\30\0\1\260\41\0"+
    "\1\261\42\0\1\262\37\0\1\263\32\0\1\264\41\0"+
    "\1\265\37\0\1\266\26\0\1\267\40\0\1\270\42\0"+
    "\1\271\35\0\1\272\40\0\1\273\31\0\1\274\45\0"+
    "\1\275\43\0\1\276\34\0\1\277\24\0\1\300\36\0"+
    "\1\301\50\0\1\302\23\0\1\303\5\0\1\304\35\0"+
    "\1\305\31\0\1\306\5\0\1\307\43\0\1\310\35\0"+
    "\1\311\30\0\1\312\36\0\1\313\33\0\1\314\44\0"+
    "\1\315\34\0\1\316\34\0\1\317\40\0\1\320\46\0"+
    "\1\321\34\0\1\322\36\0\1\323\24\0\1\324\44\0"+
    "\1\325\42\0\1\326\22\0\1\327\36\0\1\330\47\0"+
    "\1\331\25\0\1\332\46\0\1\333\26\0\1\334\43\0"+
    "\1\335\47\0\1\336\34\0\1\337\30\0\1\340\30\0"+
    "\1\341\52\0\1\342\40\0\1\343\20\0\1\344\44\0"+
    "\1\345\33\0\1\346\33\0\1\347\37\0\1\350\54\0"+
    "\1\351\27\0\1\352\35\0\1\353\46\0\1\354\27\0"+
    "\1\355\44\0\1\356\22\0\1\357\42\0\1\360\36\0"+
    "\1\361\44\0\1\362\22\0\1\363\40\0\1\364\42\0"+
    "\1\365\32\0\1\366\42\0\1\367\31\0\1\370\36\0"+
    "\1\371\53\0\1\372\27\0\1\373\30\0\1\374\44\0"+
    "\1\375\51\0\1\376\24\0\1\377\26\0\1\u0100\43\0"+
    "\1\u0101\37\0\1\u0102\40\0\1\u0103\26\0\1\u0104\53\0"+
    "\1\u0105\26\0\1\u0106\32\0\1\u0107\44\0\1\u0108\31\0"+
    "\1\u0109\36\0\1\u010a\50\0\1\u010b\30\0\1\u010c\43\0"+
    "\1\u010d\23\0\1\u010e\46\0\1\u010f\41\0\1\u0110\23\0"+
    "\1\u0111\44\0\1\u0112\44\0\1\u0113\37\0\1\u0114\30\0"+
    "\1\u0115\34\0\1\u0116\40\0\1\u0117\35\0\1\u0118\36\0"+
    "\1\u0119\36\0\1\u011a\30\0\1\u011b\44\0\1\u011c\40\0"+
    "\1\u011d\37\0\1\u011e\32\0\1\u011f\40\0\1\u0120\36\0"+
    "\1\u0121\34\0\1\u0122\31\0\1\u0123\44\0\1\u0124\36\0"+
    "\1\u0125\46\0\1\u0126\23\0\1\u0127\34\0\1\u0128\37\0"+
    "\1\u0129\43\0\1\u012a\34\0\1\u012b\31\0\1\u012c\45\0"+
    "\1\u012d\34\0\1\u012e\40\0\1\u012f\30\0\1\u0130\35\0"+
    "\1\u0131\46\0\1\u0132\30\0\1\u0133\36\0\1\u0134\41\0"+
    "\1\u0135\33\0\1\u0136\34\0\1\u0137\60\0\1\u0138\34\0"+
    "\1\u0139\23\0\1\u013a\33\0\1\u013b\44\0\1\u013c\34\0"+
    "\1\u013d\35\0\1\u013e\1\0\1\u013f\37\0\1\u0140\33\0"+
    "\1\u0141\41\0\1\u0142\36\0\1\u0143\34\0\1\u0144\35\0"+
    "\1\u0145\31\0\1\u0146\43\0\1\u0147\40\0\1\u0148\31\0"+
    "\1\u0149\35\0\1\u014a\45\0\1\u014b\26\0\1\u014c\36\0"+
    "\1\u014d\36\0\1\u014e\40\0\1\u014f\41\0\1\u0150\41\0"+
    "\1\u0151\44\0\1\u0152\20\0\1\u0153\43\0\1\u0154\36\0"+
    "\1\u0155\36\0\1\u0156\31\0\1\u0157\46\0\1\u0158\33\0"+
    "\1\u0159\36\0\1\u015a\40\0\1\u015b\27\0\1\u015c\43\0"+
    "\1\u015d\25\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[9393];
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
    "\2\0\1\11\2\1\1\11\24\1\1\0\1\1\15\0"+
    "\1\1\20\0\2\1\61\0\1\1\20\0\1\11\1\0"+
    "\1\1\16\0\1\1\15\0\1\1\1\0\1\1\16\0"+
    "\1\11\25\0\1\1\21\0\1\11\1\1\15\0\1\11"+
    "\13\0\1\11\1\0\2\11\1\1\1\11\6\0\1\11"+
    "\2\0\1\11\4\0\1\11\6\0\1\1\2\0\1\1"+
    "\1\0\1\1\2\0\2\11\3\0\1\11\4\0\2\11"+
    "\1\0\1\11\2\0\1\11\1\0\1\11\1\0\1\1"+
    "\1\0\1\11\2\0\1\11\4\0\4\11\1\0\4\11"+
    "\1\1\4\0\1\11\3\0\1\11\1\0\1\11\1\0"+
    "\1\11\5\0\2\11\3\0\3\11\2\0\2\11\2\0"+
    "\1\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[349];
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

  /** the textposition at the last state to be included in yytext */
  private int zzPushbackPos;

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

   public int getLine(){
      return this.yyline;
   }

   public int getColumn(){
      return this.yycolumn;
   }
   
   public boolean isEnteraValida(String cte){
		if ((new Integer(cte).intValue()) > JMPascalVM.MAXINT){
			//throw new ErrorLexicoException("Constante entera fuera de rango: " + cte);
			return false;
		}
		else
			return true;
   }
   

   private boolean isRealValida(String cteReal){
   		int entera = new Integer(cteReal.substring(0, cteReal.indexOf('.'))).intValue();
   		if (entera > JMPascalVM.MAXINT || cteReal.length() - cteReal.indexOf('.') - 1 > JMPascalVM.MAXDECIMALES){
			return false;
   		}
   		else
   			return true;
   }

/*   public String construyeReal(String cteReal){
   		String cte = null;
   		for(int i=JMPascalVM.MAXDECIMALES - (cteReal.length() - cteReal.indexOf('.') - 1);i>0;i--)
   		    cteReal+="0";
      	return cteReal;
   } */



  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Lexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public Lexer(java.io.InputStream in) {
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
    while (i < 222) {
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
      zzPushbackPos-= zzStartRead;
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

    if (numRead < 0) {
      return true;
    }
    else {
      zzEndRead+= numRead;
      return false;
    }
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
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = zzPushbackPos = 0;
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
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
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

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn++;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      if (zzMarkedPosL > zzStartRead) {
        switch (zzBufferL[zzMarkedPosL-1]) {
        case '\n':
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          zzAtBOL = true;
          break;
        case '\r': 
          if (zzMarkedPosL < zzEndReadL)
            zzAtBOL = zzBufferL[zzMarkedPosL] != '\n';
          else if (zzAtEOF)
            zzAtBOL = false;
          else {
            boolean eof = zzRefill();
            zzMarkedPosL = zzMarkedPos;
            zzEndReadL = zzEndRead;
            zzBufferL = zzBuffer;
            if (eof) 
              zzAtBOL = false;
            else 
              zzAtBOL = zzBufferL[zzMarkedPosL] != '\n';
          }
          break;
        default:
          zzAtBOL = false;
        }
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      if (zzAtBOL)
        zzState = ZZ_LEXSTATE[zzLexicalState+1];
      else
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
        case 44: 
          { return new Symbol(Sym.prDEVOLUCION, yyline, yycolumn);
          }
        case 64: break;
        case 17: 
          { return new Symbol(Sym.prMODULO, yyline, yycolumn);
          }
        case 65: break;
        case 32: 
          { return new Symbol(Sym.prAINDVALOR, yyline, yycolumn);
          }
        case 66: break;
        case 31: 
          { return new Symbol(Sym.prPRODUCTO, yyline, yycolumn);
          }
        case 67: break;
        case 54: 
          { return new Symbol(Sym.prLECTURAREAL, yyline, yycolumn);
          }
        case 68: break;
        case 18: 
          { return new Symbol(Sym.prLLAMADA, yyline, yycolumn);
          }
        case 69: break;
        case 40: 
          { return new Symbol(Sym.prGRABACION, yyline, yycolumn);
          }
        case 70: break;
        case 15: 
          { return new Symbol(Sym.prMENOR, yyline, yycolumn);
          }
        case 71: break;
        case 25: 
          { return new Symbol(Sym.prDISTINTO, yyline, yycolumn);
          }
        case 72: break;
        case 27: 
          { return new Symbol(Sym.prSUMAREAL, yyline, yycolumn);
          }
        case 73: break;
        case 33: 
          { return new Symbol(Sym.prIGUALREAL, yyline, yycolumn);
          }
        case 74: break;
        case 37: 
          { return new Symbol(Sym.prCDIRLOCAL, yyline, yycolumn);
          }
        case 75: break;
        case 5: 
          { System.out.println("Comentario: "+yytext()+"\n");
          }
        case 76: break;
        case 48: 
          { return new Symbol(Sym.prCDIRINTERM, yyline, yycolumn);
          }
        case 77: break;
        case 14: 
          { return new Symbol(Sym.prMAYOR, yyline, yycolumn);
          }
        case 78: break;
        case 20: 
          { return new Symbol(Sym.prBIFCOND, yyline, yycolumn);
          }
        case 79: break;
        case 38: 
          { return new Symbol(Sym.prCREGISTRO, yyline, yycolumn);
          }
        case 80: break;
        case 4: 
          { if (isEnteraValida(yytext())) return new Symbol(Sym.pCte, yyline, yycolumn, new Integer(yytext())); else throw new ErrorLexicoException("Constante entera fuera de rango: "+yytext()+" L�nea: "+yyline+" Columna: "+yycolumn);
          }
        case 81: break;
        case 11: 
          { return new Symbol(Sym.prAREAL, yyline, yycolumn);
          }
        case 82: break;
        case 45: 
          { return new Symbol(Sym.prDEFLITERAL, yyline, yycolumn);
          }
        case 83: break;
        case 26: 
          { return new Symbol(Sym.prOCUPAESP, yyline, yycolumn);
          }
        case 84: break;
        case 16: 
          { return new Symbol(Sym.prDCAMPO, yyline, yycolumn);
          }
        case 85: break;
        case 3: 
          { ;
          }
        case 86: break;
        case 36: 
          { return new Symbol(Sym.prCINDVALOR, yyline, yycolumn);
          }
        case 87: break;
        case 59: 
          { return new Symbol(Sym.prMENORIGUREAL, yyline, yycolumn);
          }
        case 88: break;
        case 61: 
          { return new Symbol(Sym.prGRABACIONREAL, yyline, yycolumn);
          }
        case 89: break;
        case 22: 
          { return new Symbol(Sym.prNEGACION, yyline, yycolumn);
          }
        case 90: break;
        case 28: 
          { return new Symbol(Sym.prCLITERAL, yyline, yycolumn);
          }
        case 91: break;
        case 50: 
          { return new Symbol(Sym.prCONJUNCION, yyline, yycolumn);
          }
        case 92: break;
        case 34: 
          { return new Symbol(Sym.prDELEMENTO, yyline, yycolumn);
          }
        case 93: break;
        case 57: 
          { return new Symbol(Sym.prDIVISIONREAL, yyline, yycolumn);
          }
        case 94: break;
        case 13: 
          { return new Symbol(Sym.prRESTA, yyline, yycolumn);
          }
        case 95: break;
        case 62: 
          { return new Symbol(Sym.prCCONSTANTEREAL, yyline, yycolumn);
          }
        case 96: break;
        case 60: 
          { return new Symbol(Sym.prPRODUCTOREAL, yyline, yycolumn);
          }
        case 97: break;
        case 24: 
          { return new Symbol(Sym.prDIVISION, yyline, yycolumn);
          }
        case 98: break;
        case 23: 
          { return new Symbol(Sym.prNEGATIVO, yyline, yycolumn);
          }
        case 99: break;
        case 12: 
          { return new Symbol(Sym.prIGUAL, yyline, yycolumn);
          }
        case 100: break;
        case 35: 
          { return new Symbol(Sym.prRESTAREAL, yyline, yycolumn);
          }
        case 101: break;
        case 39: 
          { return new Symbol(Sym.prBIFINCOND, yyline, yycolumn);
          }
        case 102: break;
        case 53: 
          { return new Symbol(Sym.prTAMGLOBAL, yyline, yycolumn);
          }
        case 103: break;
        case 7: 
          { return new Symbol(Sym.pEtqInst, yyline, yycolumn, new Integer(yytext().substring(1)));
          }
        case 104: break;
        case 9: 
          { if (isRealValida(yytext())) return new Symbol(Sym.pCteReal, yyline, yycolumn, new Float(yytext())); else throw new ErrorLexicoException("Constante real fuera de rango: "+yytext()+" L�nea: "+yyline+" Columna: "+yycolumn);
          }
        case 105: break;
        case 42: 
          { return new Symbol(Sym.prMENORREAL, yyline, yycolumn);
          }
        case 106: break;
        case 58: 
          { return new Symbol(Sym.prMAYORIGUREAL, yyline, yycolumn);
          }
        case 107: break;
        case 41: 
          { return new Symbol(Sym.prMAYORREAL, yyline, yycolumn);
          }
        case 108: break;
        case 2: 
          { return new Symbol(Sym.pSeparador, yyline, yycolumn);
          }
        case 109: break;
        case 30: 
          { return new Symbol(Sym.prMENORIGU, yyline, yycolumn);
          }
        case 110: break;
        case 56: 
          { return new Symbol(Sym.prTAMFUNCION, yyline, yycolumn);
          }
        case 111: break;
        case 1: 
          { return new Symbol(Sym.error, yyline, yycolumn);
          }
        case 112: break;
        case 19: 
          { return new Symbol(Sym.prLECTURA, yyline, yycolumn);
          }
        case 113: break;
        case 29: 
          { return new Symbol(Sym.prMAYORIGU, yyline, yycolumn);
          }
        case 114: break;
        case 55: 
          { return new Symbol(Sym.prTERMINACION, yyline, yycolumn);
          }
        case 115: break;
        case 6: 
          { String cadena = yytext();  String subcadena = new String(cadena.substring(1,cadena.length()-1)); return new Symbol(Sym.pCADENA, yyline, yycolumn,subcadena);
          }
        case 116: break;
        case 21: 
          { return new Symbol(Sym.prARESFUNC, yyline, yycolumn);
          }
        case 117: break;
        case 51: 
          { return new Symbol(Sym.prCCONSTANTE, yyline, yycolumn);
          }
        case 118: break;
        case 47: 
          { return new Symbol(Sym.prRESERVAESP, yyline, yycolumn);
          }
        case 119: break;
        case 46: 
          { return new Symbol(Sym.prLIMITACION, yyline, yycolumn);
          }
        case 120: break;
        case 63: 
          { return new Symbol(Sym.prGRABACIONLITERAL, yyline, yycolumn);
          }
        case 121: break;
        case 43: 
          { return new Symbol(Sym.prDISYUNCION, yyline, yycolumn);
          }
        case 122: break;
        case 8: 
          { return new Symbol(Sym.pEtqSubpr, yyline, yycolumn, new Integer(yytext().substring(1)));
          }
        case 123: break;
        case 52: 
          { return new Symbol(Sym.prMODULOREAL, yyline, yycolumn);
          }
        case 124: break;
        case 10: 
          { return new Symbol(Sym.prSUMA, yyline, yycolumn);
          }
        case 125: break;
        case 49: 
          { return new Symbol(Sym.prCDIRGLOBAL, yyline, yycolumn);
          }
        case 126: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
              { return new java_cup.runtime.Symbol(Sym.EOF); }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}