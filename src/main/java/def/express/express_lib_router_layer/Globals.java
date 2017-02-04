package def.express.express_lib_router_layer;
import def.express.express_path_to_regexp.Key;
import def.js.Function;
import def.js.RegExp;
import jsweet.util.union.Union;
/** This class holds all the global functions and variables of the ~express_lib_router_layer package. */
public final class Globals {
    private Globals(){}
    @jsweet.lang.Optional
    public static Function handle;
    public static String name;
    @jsweet.lang.Optional
    public static Object params;
    @jsweet.lang.Optional
    public static String path;
    public static Union<String, Key>[] keys;
    public static RegExp regexp;
    public static String method;
    native public static java.lang.Object handle(java.lang.Object... args);
}

