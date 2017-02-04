package def.modules.express.express_serve_static;

import java.util.function.Function;

import def.node.http.IncomingMessage;
import def.node.http.ServerResponse;
import jsweet.util.function.TriConsumer;

@FunctionalInterface
public interface ServeStaticFunction {
	TriConsumer<IncomingMessage, ServerResponse, Function<Object, Object>> serveStatic(String root, ServeStaticOptions options);
}