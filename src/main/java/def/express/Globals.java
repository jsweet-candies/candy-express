package def.express;

import def.express.express_lib_application.Application;
import def.express.express_lib_router_layer.Layer;
import def.node.http.IncomingMessage;
import def.node.http.ServerResponse;

/** This class holds all the global functions and variables of the def.modules.express package. */
public final class Globals {
    private Globals(){}
//    @jsweet.lang.Module("~express/lib/application")
//    public static final def.express.express_lib_application.Application express_lib_application=null;
//    @jsweet.lang.Module("~express/lib/request")
//    public static final def.express.express_lib_request.Request express_lib_request=null;
//    @jsweet.lang.Module("~express/lib/response")
//    public static final def.express.express_lib_response.Response express_lib_response=null;
    @jsweet.lang.Module("~express/lib/router/index")
    native public static def.express.express_lib_router_index.Router express_lib_router_index(def.express.express_lib_router_index.RouterOptions options);
    @jsweet.lang.Module("~express~path-to-regexp")
    native public static def.express.express_path_to_regexp.PathRegExp express_path_to_regexp(java.lang.String path, def.express.express_path_to_regexp.Options options);
    @jsweet.lang.Module("~express~path-to-regexp")
    native public static def.express.express_path_to_regexp.PathRegExp express_path_to_regexp(java.lang.String path, java.lang.String[] keys, def.express.express_path_to_regexp.Options options);
//    @jsweet.lang.Module("~express/lib/router/layer")
//    public static final ExpressLibRouterLayerModule express_lib_router_layer = null;
    /**
 * Create a new middleware function to serve files from within a given root directory.
 * The file to serve will be determined by combining req.url with the provided root directory.
 * When a file is not found, instead of sending a 404 response, this module will instead call next() to move on to the next middleware, allowing for stacking and fall-backs.
 */
    @jsweet.lang.Module("serve-static")
    native public static jsweet.util.function.TriConsumer<IncomingMessage,ServerResponse,java.util.function.Function<Object,Object>> express_serve_static(String root, def.express.express_serve_static.ServeStaticOptions options);
    @jsweet.lang.Module("express")
    public static final def.express.express_lib_express.Express express_lib_express=null;
    @jsweet.lang.Module("~express/lib/router/index")
    native public static def.express.express_lib_router_index.Router express_lib_router_index();
    @jsweet.lang.Module("~express~path-to-regexp")
    native public static def.express.express_path_to_regexp.PathRegExp express_path_to_regexp(java.lang.String path);
    @jsweet.lang.Module("~express~path-to-regexp")
    native public static def.express.express_path_to_regexp.PathRegExp express_path_to_regexp(java.lang.String path, java.lang.String[] keys);
    /**
 * Create a new middleware function to serve files from within a given root directory.
 * The file to serve will be determined by combining req.url with the provided root directory.
 * When a file is not found, instead of sending a 404 response, this module will instead call next() to move on to the next middleware, allowing for stacking and fall-backs.
 */
    @jsweet.lang.Module("serve-static")
    native public static jsweet.util.function.TriConsumer<IncomingMessage,ServerResponse,java.util.function.Function<Object,Object>> express_serve_static(String root);
    @jsweet.lang.Module("~express~path-to-regexp")
    native public static def.express.express_path_to_regexp.PathRegExp express_path_to_regexp(def.js.RegExp path, def.express.express_path_to_regexp.Options options);
    @jsweet.lang.Module("~express~path-to-regexp")
    native public static def.express.express_path_to_regexp.PathRegExp express_path_to_regexp(ArrayRegExp path, def.express.express_path_to_regexp.Options options);
    @jsweet.lang.Module("~express~path-to-regexp")
    native public static def.express.express_path_to_regexp.PathRegExp express_path_to_regexp(ArrayString path, def.express.express_path_to_regexp.Options options);
    @jsweet.lang.Module("~express~path-to-regexp")
    native public static def.express.express_path_to_regexp.PathRegExp express_path_to_regexp(ArrayRegExp2 path, def.express.express_path_to_regexp.Key[] keys, def.express.express_path_to_regexp.Options options);
    @jsweet.lang.Module("~express~path-to-regexp")
    native public static def.express.express_path_to_regexp.PathRegExp express_path_to_regexp(def.js.RegExp path, java.lang.String[] keys, def.express.express_path_to_regexp.Options options);
    @jsweet.lang.Module("~express~path-to-regexp")
    native public static def.express.express_path_to_regexp.PathRegExp express_path_to_regexp(java.lang.String path, def.express.express_path_to_regexp.Key[] keys, def.express.express_path_to_regexp.Options options);
    @jsweet.lang.Module("~express~path-to-regexp")
    native public static def.express.express_path_to_regexp.PathRegExp express_path_to_regexp(ArrayString3 path, java.lang.String[] keys, def.express.express_path_to_regexp.Options options);
    @jsweet.lang.Module("~express~path-to-regexp")
    native public static def.express.express_path_to_regexp.PathRegExp express_path_to_regexp(ArrayRegExp3 path, java.lang.String[] keys, def.express.express_path_to_regexp.Options options);
    @jsweet.lang.Module("~express~path-to-regexp")
    native public static def.express.express_path_to_regexp.PathRegExp express_path_to_regexp(ArrayString2 path, def.express.express_path_to_regexp.Key[] keys, def.express.express_path_to_regexp.Options options);
    @jsweet.lang.Module("~express~path-to-regexp")
    native public static def.express.express_path_to_regexp.PathRegExp express_path_to_regexp(def.js.RegExp path, def.express.express_path_to_regexp.Key[] keys, def.express.express_path_to_regexp.Options options);
    @jsweet.lang.Module("~express~path-to-regexp")
    native public static def.express.express_path_to_regexp.PathRegExp express_path_to_regexp(ArrayString4 path);
    @jsweet.lang.Module("~express~path-to-regexp")
    native public static def.express.express_path_to_regexp.PathRegExp express_path_to_regexp(def.js.RegExp path);
    @jsweet.lang.Module("~express~path-to-regexp")
    native public static def.express.express_path_to_regexp.PathRegExp express_path_to_regexp(ArrayRegExp4 path);
    @jsweet.lang.Module("~express~path-to-regexp")
    native public static def.express.express_path_to_regexp.PathRegExp express_path_to_regexp(ArrayRegExp5 path, def.express.express_path_to_regexp.Key[] keys);
    @jsweet.lang.Module("~express~path-to-regexp")
    native public static def.express.express_path_to_regexp.PathRegExp express_path_to_regexp(ArrayString6 path, java.lang.String[] keys);
    @jsweet.lang.Module("~express~path-to-regexp")
    native public static def.express.express_path_to_regexp.PathRegExp express_path_to_regexp(ArrayRegExp6 path, java.lang.String[] keys);
    @jsweet.lang.Module("~express~path-to-regexp")
    native public static def.express.express_path_to_regexp.PathRegExp express_path_to_regexp(def.js.RegExp path, java.lang.String[] keys);
    @jsweet.lang.Module("~express~path-to-regexp")
    native public static def.express.express_path_to_regexp.PathRegExp express_path_to_regexp(java.lang.String path, def.express.express_path_to_regexp.Key[] keys);
    @jsweet.lang.Module("~express~path-to-regexp")
    native public static def.express.express_path_to_regexp.PathRegExp express_path_to_regexp(def.js.RegExp path, def.express.express_path_to_regexp.Key[] keys);
    @jsweet.lang.Module("~express~path-to-regexp")
    native public static def.express.express_path_to_regexp.PathRegExp express_path_to_regexp(ArrayString5 path, def.express.express_path_to_regexp.Key[] keys);
    native public static def.express.express_path_to_regexp.PathRegExp express_path_to_regexp(def.js.RegExp[] path, def.express.express_path_to_regexp.Options options);
    native public static def.express.express_path_to_regexp.PathRegExp express_path_to_regexp(java.lang.String[] path, def.express.express_path_to_regexp.Options options);
    native public static def.express.express_path_to_regexp.PathRegExp express_path_to_regexp(def.js.RegExp[] path, def.express.express_path_to_regexp.Key[] keys, def.express.express_path_to_regexp.Options options);
    native public static def.express.express_path_to_regexp.PathRegExp express_path_to_regexp(java.lang.String[] path, java.lang.String[] keys, def.express.express_path_to_regexp.Options options);
    native public static def.express.express_path_to_regexp.PathRegExp express_path_to_regexp(def.js.RegExp[] path, java.lang.String[] keys, def.express.express_path_to_regexp.Options options);
    native public static def.express.express_path_to_regexp.PathRegExp express_path_to_regexp(java.lang.String[] path, def.express.express_path_to_regexp.Key[] keys, def.express.express_path_to_regexp.Options options);
    native public static def.express.express_path_to_regexp.PathRegExp express_path_to_regexp(java.lang.String[] path);
    native public static def.express.express_path_to_regexp.PathRegExp express_path_to_regexp(def.js.RegExp[] path);
    native public static def.express.express_path_to_regexp.PathRegExp express_path_to_regexp(def.js.RegExp[] path, def.express.express_path_to_regexp.Key[] keys);
    native public static def.express.express_path_to_regexp.PathRegExp express_path_to_regexp(java.lang.String[] path, java.lang.String[] keys);
    native public static def.express.express_path_to_regexp.PathRegExp express_path_to_regexp(def.js.RegExp[] path, java.lang.String[] keys);
    native public static def.express.express_path_to_regexp.PathRegExp express_path_to_regexp(java.lang.String[] path, def.express.express_path_to_regexp.Key[] keys);
    @jsweet.lang.Module("~express/lib/router/layer")
    native public static Layer express_lib_router_layer(java.lang.String path, def.express.express_path_to_regexp.Options options, def.js.Function fn);
    @jsweet.lang.Module("~express/lib/router/layer")
    native public static Layer express_lib_router_layer(java.lang.String path, def.express.express_path_to_regexp.Options options);
    @jsweet.lang.Module("~express/lib/router/layer")
    native public static Layer express_lib_router_layer(java.lang.String path);
    /** Create an express application. */
    @jsweet.lang.Module("express")
    native public static Application express_lib_express();
    /** This class was automatically generated for disambiguating erased method signatures. */
    @jsweet.lang.Erased
    public static class ArrayRegExp extends def.js.Object {
        public ArrayRegExp(def.js.Array<def.js.RegExp> path){}
    }
    /** This class was automatically generated for disambiguating erased method signatures. */
    @jsweet.lang.Erased
    public static class ArrayString extends def.js.Object {
        public ArrayString(def.js.Array<java.lang.String> path){}
    }
    /** This class was automatically generated for disambiguating erased method signatures. */
    @jsweet.lang.Erased
    public static class ArrayRegExp2 extends def.js.Object {
        public ArrayRegExp2(def.js.Array<def.js.RegExp> path){}
    }
    /** This class was automatically generated for disambiguating erased method signatures. */
    @jsweet.lang.Erased
    public static class ArrayString2 extends def.js.Object {
        public ArrayString2(def.js.Array<java.lang.String> path){}
    }
    /** This class was automatically generated for disambiguating erased method signatures. */
    @jsweet.lang.Erased
    public static class ArrayString3 extends def.js.Object {
        public ArrayString3(def.js.Array<java.lang.String> path){}
    }
    /** This class was automatically generated for disambiguating erased method signatures. */
    @jsweet.lang.Erased
    public static class ArrayRegExp3 extends def.js.Object {
        public ArrayRegExp3(def.js.Array<def.js.RegExp> path){}
    }
    /** This class was automatically generated for disambiguating erased method signatures. */
    @jsweet.lang.Erased
    public static class ArrayString4 extends def.js.Object {
        public ArrayString4(def.js.Array<java.lang.String> path){}
    }
    /** This class was automatically generated for disambiguating erased method signatures. */
    @jsweet.lang.Erased
    public static class ArrayRegExp4 extends def.js.Object {
        public ArrayRegExp4(def.js.Array<def.js.RegExp> path){}
    }
    /** This class was automatically generated for disambiguating erased method signatures. */
    @jsweet.lang.Erased
    public static class ArrayRegExp5 extends def.js.Object {
        public ArrayRegExp5(def.js.Array<def.js.RegExp> path){}
    }
    /** This class was automatically generated for disambiguating erased method signatures. */
    @jsweet.lang.Erased
    public static class ArrayString5 extends def.js.Object {
        public ArrayString5(def.js.Array<java.lang.String> path){}
    }
    /** This class was automatically generated for disambiguating erased method signatures. */
    @jsweet.lang.Erased
    public static class ArrayString6 extends def.js.Object {
        public ArrayString6(def.js.Array<java.lang.String> path){}
    }
    /** This class was automatically generated for disambiguating erased method signatures. */
    @jsweet.lang.Erased
    public static class ArrayRegExp6 extends def.js.Object {
        public ArrayRegExp6(def.js.Array<def.js.RegExp> path){}
    }
}

