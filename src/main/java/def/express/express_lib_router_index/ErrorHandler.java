package def.express.express_lib_router_index;
import def.express.express_lib_request.Request;
import def.express.express_lib_response.Response;
public interface ErrorHandler {
    public Object apply(Object err, Request req, Response res, NextFunction next);
}

