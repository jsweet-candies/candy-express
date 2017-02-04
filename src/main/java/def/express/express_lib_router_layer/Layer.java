package def.express.express_lib_router_layer;

import def.js.RegExp;
import jsweet.util.union.Union;
import def.express.express_path_to_regexp.Key;
import def.js.Function;

// TODO 
//@jsweet.lang.Module("~express/lib/router/layer")
@jsweet.lang.Interface
public abstract class Layer extends def.js.Object {
    @jsweet.lang.Optional
    public Function handle;
    public String name;
    @jsweet.lang.Optional
    public Object params;
    @jsweet.lang.Optional
    public String path;
    public Union<String, Key>[] keys;
    public RegExp regexp;
    public String method;
    native public java.lang.Object handle(java.lang.Object... args);
}

