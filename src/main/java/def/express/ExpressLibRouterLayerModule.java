package def.express;
import def.express.express_path_to_regexp.Options;
import def.js.Function;
/** This is an automatically generated object type (see the source definition). */
@jsweet.lang.ObjectType
public class ExpressLibRouterLayerModule extends def.js.Object {
    native public def.express.express_lib_router_layer.Layer $apply(String path, Options options, Function fn);
    
    public ExpressLibRouterLayerModule(String path, Options options, Function fn){}
    protected ExpressLibRouterLayerModule(){}
    
    native public def.express.express_lib_router_layer.Layer $apply(String path, Options options);
    native public def.express.express_lib_router_layer.Layer $apply(String path);
    public ExpressLibRouterLayerModule(String path, Options options){}
    public ExpressLibRouterLayerModule(String path){}
}

