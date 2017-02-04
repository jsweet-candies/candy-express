package def.modules.express.express_lib_express;

import def.modules.express.express_lib_application.Application;
import def.modules.express.express_lib_request.Request;
import def.modules.express.express_lib_response.Response;
import def.modules.express.express_serve_static.ServeStaticFunction;
import def.modules.express.express_serve_static.ServeStaticOptions;

@jsweet.lang.Interface
public abstract class Express extends def.js.Object {
    /** Create an express application. */
    native public Application apply();
    /** The Application prototype */
    public Application application;
    /** The Request prototype */
    public Request request;
    /** The Response prototype */
    public Response response;
    /** The Route constructor */
//    public RouteClass Route;
    /** The Router constructor */
    public def.modules.express.express_lib_router_index.Router Router;
    /** The serve-static middleware */
    @jsweet.lang.Name("static")
    public ServeStaticFunction Static;
}

