package def.express.express_lib_router_index;
import def.express.express_lib_request.Request;
import def.express.express_lib_response.Response;
public interface ParamHandler {
    public Object apply(Request req, Response res, NextFunction next, Object value, String name);
}

