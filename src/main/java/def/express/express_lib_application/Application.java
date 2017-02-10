package def.express.express_lib_application;
import def.express.express_lib_router_index.ErrorHandler;
import def.express.express_lib_router_index.ParamHandler;
import def.express.express_lib_router_index.RequestHandler;
import def.express.express_lib_router_index.Router;
import def.express.express_lib_router_route.Route;
import def.js.Error;
import def.js.Function;
import def.js.RegExp;
import def.node.net.ListenOptions;
import def.node.net.Server;
import jsweet.util.union.Union;
import jsweet.util.union.Union4;

@jsweet.lang.Interface
@jsweet.lang.Extends({Router.class})
@SuppressWarnings("unchecked")
public abstract class Application extends def.js.Object {
    /**
         * Contains one or more path patterns on which a sub-app was mounted.
         */
    public jsweet.util.union.Union<String,String[]> mountpath;
    /**
         * Has properties that are local variables within the application.
         * Once set, the value of app.locals properties persist throughout the life of the application,
         * in contrast with res.locals properties that are valid only for the lifetime of the request.
         * You can access local variables in templates rendered within the application.
         * This is useful for providing helper functions to templates, as well as application-level data.
         * Local variables are available in middleware via req.app.locals (see req.app)
         */
    public Object locals;
    /**
         * Initialize the server.
         *
         *   - setup default configuration
         *   - setup default middleware
         *   - setup route reflection methods
         */
    native public void init();
    /**
         * Initialize application configuration.
         */
    native public void defaultConfiguration();
    /**
         * Register the given template engine callback `fn`
         * as `ext`.
         *
         * By default will `require()` the engine based on the
         * file extension. For example if you try to render
         * a "foo.jade" file Express will invoke the following internally:
         *
         *     app.engine('jade', require('jade').__express);
         *
         * For engines that do not provide `.__express` out of the box,
         * or if you wish to "map" a different extension to the template engine
         * you may use this method. For example mapping the EJS template engine to
         * ".html" files:
         *
         *     app.engine('html', require('ejs').renderFile);
         *
         * In this case EJS provides a `.renderFile()` method with
         * the same signature that Express expects: `(path, options, callback)`,
         * though note that it aliases this method as `ejs.__express` internally
         * so if you're using ".ejs" extensions you dont need to do anything.
         *
         * Some template engines do not follow this convention, the
         * [Consolidate.js](https://github.com/visionmedia/consolidate.js)
         * library was created to map all of node's popular template
         * engines to follow this convention, thus allowing them to
         * work seamlessly within Express.
         */
    native public Application engine(String ext, Function fn);
    /**
         * Assign `setting` to `val`, or return `setting`'s value.
         *
         *    app.set('foo', 'bar');
         *    app.get('foo');
         *    // => "bar"
         *    app.set('foo', ['bar', 'baz']);
         *    app.get('foo');
         *    // => ["bar", "baz"]
         *
         * Mounted servers inherit their parent server's settings.
         */
    native public Application set(String setting, Object val);
    native public Object get(String name);
    /**
         * Return the app's absolute pathname
         * based on the parent(s) that have
         * mounted it.
         *
         * For example if the application was
         * mounted as "/admin", which itself
         * was mounted as "/blog" then the
         * return value would be "/blog/admin".
         */
    native public String path();
    /**
         * Check if `setting` is enabled (truthy).
         *
         *    app.enabled('foo')
         *    // => false
         *
         *    app.enable('foo')
         *    app.enabled('foo')
         *    // => true
         */
    native public Boolean enabled(String setting);
    /**
         * Check if `setting` is disabled.
         *
         *    app.disabled('foo')
         *    // => true
         *
         *    app.enable('foo')
         *    app.disabled('foo')
         *    // => false
         */
    native public Boolean disabled(String setting);
    /**
         * Enable `setting`.
         */
    native public Application enable(String setting);
    /**
         * Disable `setting`.
         */
    native public Application disable(String setting);
    /**
         * Render the given view `name` name with `options`
         * and a callback accepting an error and the
         * rendered template string.
         *
         * Example:
         *
         *    app.render('email', { name: 'Tobi' }, function(err, html){
         *      // ...
         *    })
         */
    native public void render(String name, Locals locals, java.util.function.BiConsumer<Error,String> callback);
    native public void render(String name, java.util.function.BiConsumer<Error,String> callback);
    /**
         * Listen for connections.
         *
         * A node `http.Server` is returned, with this
         * application (which is a `Function`) as its
         * callback. If you wish to create both an HTTP
         * and HTTPS server you may do so with the "http"
         * and "https" modules as shown here:
         *
         *    var http = require('http')
         *      , https = require('https')
         *      , express = require('express')
         *      , app = express();
         *
         *    http.createServer(app).listen(80);
         *    https.createServer({ ... }, app).listen(443);
         */
    native public Server listen(double port, String hostname, double backlog, Function listeningListener);
    native public Server listen(double port, String hostname, Function listeningListener);
    native public Server listen(double port, double backlog, Function listeningListener);
    native public Server listen(double port, Function listeningListener);
    native public Server listen(String path, double backlog, Function listeningListener);
    native public Server listen(String path, Function listeningListener);
    native public Server listen(Object handle, double backlog, Function listeningListener);
    native public Server listen(Object handle, Function listeningListener);
    native public Server listen(ListenOptions options, Function listeningListener);
    /** This is an automatically generated object type (see the source definition). */
    @jsweet.lang.ObjectType
    public static class Locals extends def.js.Object {
        native public java.lang.Object $get(String local);
    }
    /**
         * Map the given param placeholder `name`(s) to the given callback(s).
         *
         * Parameter mapping is used to provide pre-conditions to routes
         * which use normalized placeholders. For example a _:user_id_ parameter
         * could automatically load a user's information from the database without
         * any additional code,
         *
         * The callback uses the samesignature as middleware, the only differencing
         * being that the value of the placeholder is passed, in this case the _id_
         * of the user. Once the `next()` function is invoked, just like middleware
         * it will continue on to execute the route, or subsequent parameter functions.
         *
         *      app.param('user_id', function(req, res, next, id){
         *        User.find(id, function(err, user){
         *          if (err) {
         *            next(err);
         *          } else if (user) {
         *            req.user = user;
         *            next();
         *          } else {
         *            next(new Error('failed to load user'));
         *          }
         *        });
         *      });
         */
    native public Application param(String name, ParamHandler handler);
    /**
         * @deprecated
         */
    native public Application param(java.util.function.BiFunction<String,RegExp,ParamHandler> callback);
    native public Application all(Union4<String, RegExp, String[], RegExp[]> path, Union4<RequestHandler, ErrorHandler, RequestHandler[], ErrorHandler[]>... handlers);
    /**
         * The GET method means retrieve whatever information (in the form of an entity)
         * is identified by the Request-URI. If the Request-URI refers to a data-producing
         * process, it is the produced data which shall be returned as the entity in the
         * response and not the source text of the process, unless that text happens to be
         * the output of the process.
         */
    native public Application get(String path, Union<RequestHandler, ErrorHandler>... handlers);
    native public Application get(RegExp path, Union<RequestHandler, ErrorHandler>... handlers);
    native public Application get(String path, RequestHandler... handlers);
    native public Application get(String path, ErrorHandler... handlers);
    native public Application get(RegExp path, RequestHandler... handlers);
    native public Application get(RegExp path, ErrorHandler... handlers);
    
    
    /**
         * The POST method is used to request that the origin server accept the entity
         * enclosed in the request as a new subordinate of the resource identified by the
         * Request-URI in the Request-Line. POST is designed to allow a uniform method to
         * cover the following functions:
         *  - Annotation of existing resources;
         *  - Posting a message to a bulletin board, newsgroup, mailing list,
         *      or similar group of articles;
         *  - Providing a block of data, such as the result of submitting a
         *      form, to a data-handling process;
         *  - Extending a database through an append operation.
         */
    native public Application post(Union4<String, RegExp, String[], RegExp[]> path, Union4<RequestHandler, ErrorHandler, RequestHandler[], ErrorHandler[]>... handlers);
    /**
         * The PUT method requests that the enclosed entity be stored under the supplied
         * Request-URI. If the Request-URI refers to an already existing resource, the
         * enclosed entity SHOULD be considered as a modified version of the one residing
         * on the origin server. If the Request-URI does not point to an existing
         * resource, and that URI is capable of being defined as a new resource by the
         * requesting user agent, the origin server can create the resource with that URI
         */
    native public Application put(Union4<String, RegExp, String[], RegExp[]> path, Union4<RequestHandler, ErrorHandler, RequestHandler[], ErrorHandler[]>... handlers);
    /**
         * The HEAD method is identical to GET except that the server MUST NOT send a
         * message body in the response (i.e., the response terminates at the end of the
         * header section).
         */
    native public Application head(Union4<String, RegExp, String[], RegExp[]> path, Union4<RequestHandler, ErrorHandler, RequestHandler[], ErrorHandler[]>... handlers);
    /**
         * The DELETE method requests that the origin server remove the association
         * between the target resource and its current functionality.  In effect, this
         * method is similar to the rm command in UNIX: it expresses a deletion operation
         * on the URI mapping of the origin server rather than an expectation that the
         * previously associated information be deleted.
         */
    native public Application delete(Union4<String, RegExp, String[], RegExp[]> path, Union4<RequestHandler, ErrorHandler, RequestHandler[], ErrorHandler[]>... handlers);
    /**
         * The OPTIONS method requests information about the communication options
         * available for the target resource, at either the origin server or an
         * intervening intermediary.  This method allows a client to determine the options
         * and/or requirements associated with a resource, or the capabilities of a
         * server, without implying a resource action.
         *
         */
    native public Application options(Union4<String, RegExp, String[], RegExp[]> path, Union4<RequestHandler, ErrorHandler, RequestHandler[], ErrorHandler[]>... handlers);
    /**
         * The final recipient of the request SHOULD reflect the message received,
         * excluding some fields described below, back to the client as the message body
         * of a 200 (OK) response with a Content-Type of "message/http" (Section 8.3.1 of
         * RFC7230).
         */
    native public Application trace(Union4<String, RegExp, String[], RegExp[]> path, Union4<RequestHandler, ErrorHandler, RequestHandler[], ErrorHandler[]>... handlers);
    /**
         * The WebDAV COPY Method creates a duplicate of the source resource identified by
         * the Request-Uniform Resource Identifier (URI), in the destination resource
         * identified by the Destination Header. The COPY Method can be used to duplicate
         * collection and property resources.
         */
    native public Application copy(Union4<String, RegExp, String[], RegExp[]> path, Union4<RequestHandler, ErrorHandler, RequestHandler[], ErrorHandler[]>... handlers);
    /**
         * The WebDAV LOCK method is used to take out a lock of any access type on a
         * resource so that another principal will not modify the resource while it is
         * being edited. The LOCK method may also be used to initiate transactions, which
         * allow clients to define groups of operations that are performed atomically.
         */
    native public Application lock(Union4<String, RegExp, String[], RegExp[]> path, Union4<RequestHandler, ErrorHandler, RequestHandler[], ErrorHandler[]>... handlers);
    /**
         * The WebDAV MKCOL method creates a new collection at the location specified by
         * the Request-Uniform Resource Identifier (URI). When invoked without a request
         * body, the collection will be created without member resources. When used with a
         * request body, you can create members and properties on the collections or
         * members.
         */
    native public Application mkcol(Union4<String, RegExp, String[], RegExp[]> path, Union4<RequestHandler, ErrorHandler, RequestHandler[], ErrorHandler[]>... handlers);
    /**
         * The WebDAV MOVE Method is used to move a resource to the location specified by
         * a request Uniform Resource Identifier (URI).
         */
    native public Application move(Union4<String, RegExp, String[], RegExp[]> path, Union4<RequestHandler, ErrorHandler, RequestHandler[], ErrorHandler[]>... handlers);
    /**
         * A purge is what happens when you pick out an object from the cache and discard
         * it along with its variants. Usually a purge is invoked through HTTP with the
         * method PURGE. An HTTP purge is similar to an HTTP GET request, except that the
         * method is PURGE. Actually you can call the method whatever you'd like, but most
         * people refer to this as purging.
         */
    native public Application purge(Union4<String, RegExp, String[], RegExp[]> path, Union4<RequestHandler, ErrorHandler, RequestHandler[], ErrorHandler[]>... handlers);
    /**
         * The WebDAV PROPFIND Method retrieves properties for a resource identified by
         * the request Uniform Resource Identifier (URI). The PROPFIND Method can be used
         * on collection and property resources.
         */
    native public Application propfind(Union4<String, RegExp, String[], RegExp[]> path, Union4<RequestHandler, ErrorHandler, RequestHandler[], ErrorHandler[]>... handlers);
    /**
         * The WebDAVPROPPATCH method sets properties for the resource at the specified
         * destination Uniform Resource Identifier (URI). All property names must be
         * scoped in the XML body using namespace URI references.
         */
    native public Application proppatch(Union4<String, RegExp, String[], RegExp[]> path, Union4<RequestHandler, ErrorHandler, RequestHandler[], ErrorHandler[]>... handlers);
    /**
         * The WebDAVUNLOCK Method is used to remove the lock on the resource at the
         * request Uniform Resource Identifier (URI). The UNLOCK Method may also be used
         * to end a transaction that was initiated by the LOCK Method.
         */
    native public Application unlock(Union4<String, RegExp, String[], RegExp[]> path, Union4<RequestHandler, ErrorHandler, RequestHandler[], ErrorHandler[]>... handlers);
    /**
         * A REPORT request is an extensible mechanism for obtaining information about a
         * resource. Unlike a resource property, which has a single value, the value of a
         * report can depend on additional information specified in the REPORT request
         * body and in the REPORT request headers.
         */
    native public Application report(Union4<String, RegExp, String[], RegExp[]> path, Union4<RequestHandler, ErrorHandler, RequestHandler[], ErrorHandler[]>... handlers);
    /**
         * A MKACTIVITY request creates a new activity resource. A server MAY restrict
         * activity creation to particular collections, but a client can determine the
         * location of these collections from a DAV:activity-collection-set OPTIONS
         * request.
         */
    native public Application mkactivity(Union4<String, RegExp, String[], RegExp[]> path, Union4<RequestHandler, ErrorHandler, RequestHandler[], ErrorHandler[]>... handlers);
    /**
         * A CHECKOUT request can be applied to a checked-in version-controlled resource
         * to allow modifications to the content and dead properties of that
         * version-controlled resource.
         */
    native public Application checkout(Union4<String, RegExp, String[], RegExp[]> path, Union4<RequestHandler, ErrorHandler, RequestHandler[], ErrorHandler[]>... handlers);
    /**
         * The MERGE method performs the logical merge of a specified version (the "merge
         * source") into a specified version-controlled resource (the "merge target").  If
         * the merge source is neither an ancestor nor a descendant of the DAV:checked-in
         * or DAV:checked-out version of the merge target, the MERGE checks out the merge
         * target (if it is not already checked out) and adds the URL of the merge source
         * to the DAV:merge-set of the merge target.
         */
    native public Application merge(Union4<String, RegExp, String[], RegExp[]> path, Union4<RequestHandler, ErrorHandler, RequestHandler[], ErrorHandler[]>... handlers);
    /**
         * a HTTP SEARCH method enhanced with the ssdp:discover functionality will be
         * referred to as a ssdp:discover request.
         */
    @jsweet.lang.Name("m-search")
    native public Application m_search(Union4<String, RegExp, String[], RegExp[]> path, Union4<RequestHandler, ErrorHandler, RequestHandler[], ErrorHandler[]>... handlers);
    /**
         *  The WebDAV NOTIFY method is called by the server whenever an event that the
         *  client has subscribed to fires. The NOTIFY method will send User Datagram
         *  Protocol (UDP) packets to the client until the subscription has timed out. The
         *  subscription to the resource will persist after the notification is sent by
         *  the server.
         */
    native public Application notify(Union4<String, RegExp, String[], RegExp[]> path, Union4<RequestHandler, ErrorHandler, RequestHandler[], ErrorHandler[]>... handlers);
    /**
         * The WebDAV SUBSCRIBE method is used to create a subscription to a resource.
         * This method is used to specify the details about the event to be monitored:
         * where to look for it; how long the event should be monitored; what the
         * notification mechanism is; and how long to delay before generating a
         * notification of the event.
         */
    native public Application subscribe(Union4<String, RegExp, String[], RegExp[]> path, Union4<RequestHandler, ErrorHandler, RequestHandler[], ErrorHandler[]>... handlers);
    /**
         * The WebDAV UNSUBSCRIBE method is used to end a subscription to a resource.
         */
    native public Application unsubscribe(Union4<String, RegExp, String[], RegExp[]> path, Union4<RequestHandler, ErrorHandler, RequestHandler[], ErrorHandler[]>... handlers);
    /**
         * The PATCH method requests that a set of changes described in the request entity
         * be applied to the resource identified by the Request- URI. The set of changes
         * is represented in a format called a "patch document" identified by a media
         * type.
         */
    native public Application patch(Union4<String, RegExp, String[], RegExp[]> path, Union4<RequestHandler, ErrorHandler, RequestHandler[], ErrorHandler[]>... handlers);
    /**
         * The client invokes the SEARCH method to initiate a server-side search. The body
         * of the request defines the query. The server MUST emit an entity matching the
         * RFC2518 PROPFIND response.
         */
    native public Application search(Union4<String, RegExp, String[], RegExp[]> path, Union4<RequestHandler, ErrorHandler, RequestHandler[], ErrorHandler[]>... handlers);
    /**
         * This specification reserves the method name CONNECT for use with a proxy that
         * can dynamically switch to being a tunnel (e.g. SSL tunneling).
         */
    native public Application connect(Union4<String, RegExp, String[], RegExp[]> path, Union4<RequestHandler, ErrorHandler, RequestHandler[], ErrorHandler[]>... handlers);
    
    native public Application use(ErrorHandler... handlers);
    native public Application use(RequestHandler... handlers);
    native public Application use(Union<RequestHandler, ErrorHandler>... handlers);
    native public Application use(String mountPoint, Union<RequestHandler, ErrorHandler>... handlers);
    native public Application use(String mountPoint, RequestHandler... handlers);
    native public Application use(String mountPoint, ErrorHandler... handlers);
    
    native public Application use(RegExp mountPoint, Union<RequestHandler, ErrorHandler>... handlers);
    native public Application use(String[] mountPoint, Union<RequestHandler, ErrorHandler>... handlers);
    native public Application use(RegExp[] mountPoint, Union<RequestHandler, ErrorHandler>... handlers);
    
    native public Route route(Union<String, RegExp>... prefix);
    /**
         * Render the given view `name` name with `options`
         * and a callback accepting an error and the
         * rendered template string.
         *
         * Example:
         *
         *    app.render('email', { name: 'Tobi' }, function(err, html){
         *      // ...
         *    })
         */
    native public void render(String name, Locals locals);
    /**
         * Render the given view `name` name with `options`
         * and a callback accepting an error and the
         * rendered template string.
         *
         * Example:
         *
         *    app.render('email', { name: 'Tobi' }, function(err, html){
         *      // ...
         *    })
         */
    native public void render(String name);
    /**
         * Listen for connections.
         *
         * A node `http.Server` is returned, with this
         * application (which is a `Function`) as its
         * callback. If you wish to create both an HTTP
         * and HTTPS server you may do so with the "http"
         * and "https" modules as shown here:
         *
         *    var http = require('http')
         *      , https = require('https')
         *      , express = require('express')
         *      , app = express();
         *
         *    http.createServer(app).listen(80);
         *    https.createServer({ ... }, app).listen(443);
         */
    native public Server listen(double port, String hostname, double backlog);
    /**
         * Listen for connections.
         *
         * A node `http.Server` is returned, with this
         * application (which is a `Function`) as its
         * callback. If you wish to create both an HTTP
         * and HTTPS server you may do so with the "http"
         * and "https" modules as shown here:
         *
         *    var http = require('http')
         *      , https = require('https')
         *      , express = require('express')
         *      , app = express();
         *
         *    http.createServer(app).listen(80);
         *    https.createServer({ ... }, app).listen(443);
         */
    native public Server listen(double port, String hostname);
    /**
         * Listen for connections.
         *
         * A node `http.Server` is returned, with this
         * application (which is a `Function`) as its
         * callback. If you wish to create both an HTTP
         * and HTTPS server you may do so with the "http"
         * and "https" modules as shown here:
         *
         *    var http = require('http')
         *      , https = require('https')
         *      , express = require('express')
         *      , app = express();
         *
         *    http.createServer(app).listen(80);
         *    https.createServer({ ... }, app).listen(443);
         */
    native public Server listen(double port);
    native public Server listen(double port, double backlog);
    native public Server listen(String path, double backlog);
    native public Server listen(String path);
    native public Server listen(Object handle, double backlog);
    native public Server listen(Object handle);
    native public Server listen(ListenOptions options);
    /**
         * Add callback triggers to route parameters, where name is the name of the parameter or an array of them,
         * and callback is the callback function. The parameters of the callback function are the request object,
         * the response object, the next middleware, the value of the parameter and the name of the parameter,
         * in that order.
         * If name is an array, the callback trigger is registered for each parameter declared in it,
         * in the order in which they are declared. Furthermore, for each declared parameter except the last one,
         * a call to next inside the callback will call the callback for the next declared parameter.
         * For the last parameter, a call to next will call the next middleware in place for the route currently
         * being processed, just like it would if name were just a string.
         * For example, when :user is present in a route path, you may map user loading logic to automatically
         * provide req.user to the route, or perform validations on the parameter input.
         */
    native public Application param(String[] name, ParamHandler handler);
    
}

