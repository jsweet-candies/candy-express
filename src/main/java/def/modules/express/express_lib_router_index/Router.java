package def.modules.express.express_lib_router_index;
import def.modules.express.express_lib_router_route.Route;
import def.js.RegExp;
@jsweet.lang.Interface
public abstract class Router extends def.js.Object implements RequestHandler {
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
    native public Router param(String name, ParamHandler handler);
    /**
         * @deprecated
         */
    native public Router param(java.util.function.BiFunction<String,RegExp,ParamHandler> callback);
    native public Router all(String path, RequestHandler... handlers);
    /**
         * The GET method means retrieve whatever information (in the form of an entity)
         * is identified by the Request-URI. If the Request-URI refers to a data-producing
         * process, it is the produced data which shall be returned as the entity in the
         * response and not the source text of the process, unless that text happens to be
         * the output of the process.
         */
    native public Router get(String path, RequestHandler... handlers);
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
    native public Router post(String path, RequestHandler... handlers);
    /**
         * The PUT method requests that the enclosed entity be stored under the supplied
         * Request-URI. If the Request-URI refers to an already existing resource, the
         * enclosed entity SHOULD be considered as a modified version of the one residing
         * on the origin server. If the Request-URI does not point to an existing
         * resource, and that URI is capable of being defined as a new resource by the
         * requesting user agent, the origin server can create the resource with that URI
         */
    native public Router put(String path, RequestHandler... handlers);
    /**
         * The HEAD method is identical to GET except that the server MUST NOT send a
         * message body in the response (i.e., the response terminates at the end of the
         * header section).
         */
    native public Router head(String path, RequestHandler... handlers);
    /**
         * The DELETE method requests that the origin server remove the association
         * between the target resource and its current functionality.  In effect, this
         * method is similar to the rm command in UNIX: it expresses a deletion operation
         * on the URI mapping of the origin server rather than an expectation that the
         * previously associated information be deleted.
         */
    native public Router delete(String path, RequestHandler... handlers);
    /**
         * The OPTIONS method requests information about the communication options
         * available for the target resource, at either the origin server or an
         * intervening intermediary.  This method allows a client to determine the options
         * and/or requirements associated with a resource, or the capabilities of a
         * server, without implying a resource action.
         *
         */
    native public Router options(String path, RequestHandler... handlers);
    /**
         * The final recipient of the request SHOULD reflect the message received,
         * excluding some fields described below, back to the client as the message body
         * of a 200 (OK) response with a Content-Type of "message/http" (Section 8.3.1 of
         * RFC7230).
         */
    native public Router trace(String path, RequestHandler... handlers);
    /**
         * The WebDAV COPY Method creates a duplicate of the source resource identified by
         * the Request-Uniform Resource Identifier (URI), in the destination resource
         * identified by the Destination Header. The COPY Method can be used to duplicate
         * collection and property resources.
         */
    native public Router copy(String path, RequestHandler... handlers);
    /**
         * The WebDAV LOCK method is used to take out a lock of any access type on a
         * resource so that another principal will not modify the resource while it is
         * being edited. The LOCK method may also be used to initiate transactions, which
         * allow clients to define groups of operations that are performed atomically.
         */
    native public Router lock(String path, RequestHandler... handlers);
    /**
         * The WebDAV MKCOL method creates a new collection at the location specified by
         * the Request-Uniform Resource Identifier (URI). When invoked without a request
         * body, the collection will be created without member resources. When used with a
         * request body, you can create members and properties on the collections or
         * members.
         */
    native public Router mkcol(String path, RequestHandler... handlers);
    /**
         * The WebDAV MOVE Method is used to move a resource to the location specified by
         * a request Uniform Resource Identifier (URI).
         */
    native public Router move(String path, RequestHandler... handlers);
    /**
         * A purge is what happens when you pick out an object from the cache and discard
         * it along with its variants. Usually a purge is invoked through HTTP with the
         * method PURGE. An HTTP purge is similar to an HTTP GET request, except that the
         * method is PURGE. Actually you can call the method whatever you'd like, but most
         * people refer to this as purging.
         */
    native public Router purge(String path, RequestHandler... handlers);
    /**
         * The WebDAV PROPFIND Method retrieves properties for a resource identified by
         * the request Uniform Resource Identifier (URI). The PROPFIND Method can be used
         * on collection and property resources.
         */
    native public Router propfind(String path, RequestHandler... handlers);
    /**
         * The WebDAVPROPPATCH method sets properties for the resource at the specified
         * destination Uniform Resource Identifier (URI). All property names must be
         * scoped in the XML body using namespace URI references.
         */
    native public Router proppatch(String path, RequestHandler... handlers);
    /**
         * The WebDAVUNLOCK Method is used to remove the lock on the resource at the
         * request Uniform Resource Identifier (URI). The UNLOCK Method may also be used
         * to end a transaction that was initiated by the LOCK Method.
         */
    native public Router unlock(String path, RequestHandler... handlers);
    /**
         * A REPORT request is an extensible mechanism for obtaining information about a
         * resource. Unlike a resource property, which has a single value, the value of a
         * report can depend on additional information specified in the REPORT request
         * body and in the REPORT request headers.
         */
    native public Router report(String path, RequestHandler... handlers);
    /**
         * A MKACTIVITY request creates a new activity resource. A server MAY restrict
         * activity creation to particular collections, but a client can determine the
         * location of these collections from a DAV:activity-collection-set OPTIONS
         * request.
         */
    native public Router mkactivity(String path, RequestHandler... handlers);
    /**
         * A CHECKOUT request can be applied to a checked-in version-controlled resource
         * to allow modifications to the content and dead properties of that
         * version-controlled resource.
         */
    native public Router checkout(String path, RequestHandler... handlers);
    /**
         * The MERGE method performs the logical merge of a specified version (the "merge
         * source") into a specified version-controlled resource (the "merge target").  If
         * the merge source is neither an ancestor nor a descendant of the DAV:checked-in
         * or DAV:checked-out version of the merge target, the MERGE checks out the merge
         * target (if it is not already checked out) and adds the URL of the merge source
         * to the DAV:merge-set of the merge target.
         */
    native public Router merge(String path, RequestHandler... handlers);
    /**
         * a HTTP SEARCH method enhanced with the ssdp:discover functionality will be
         * referred to as a ssdp:discover request.
         */
    @jsweet.lang.Name("m-search")
    native public Router m_search(String path, RequestHandler... handlers);
    /**
         *  The WebDAV NOTIFY method is called by the server whenever an event that the
         *  client has subscribed to fires. The NOTIFY method will send User Datagram
         *  Protocol (UDP) packets to the client until the subscription has timed out. The
         *  subscription to the resource will persist after the notification is sent by
         *  the server.
         */
    native public Router notify(String path, RequestHandler... handlers);
    /**
         * The WebDAV SUBSCRIBE method is used to create a subscription to a resource.
         * This method is used to specify the details about the event to be monitored:
         * where to look for it; how long the event should be monitored; what the
         * notification mechanism is; and how long to delay before generating a
         * notification of the event.
         */
    native public Router subscribe(String path, RequestHandler... handlers);
    /**
         * The WebDAV UNSUBSCRIBE method is used to end a subscription to a resource.
         */
    native public Router unsubscribe(String path, RequestHandler... handlers);
    /**
         * The PATCH method requests that a set of changes described in the request entity
         * be applied to the resource identified by the Request- URI. The set of changes
         * is represented in a format called a "patch document" identified by a media
         * type.
         */
    native public Router patch(String path, RequestHandler... handlers);
    /**
         * The client invokes the SEARCH method to initiate a server-side search. The body
         * of the request defines the query. The server MUST emit an entity matching the
         * RFC2518 PROPFIND response.
         */
    native public Router search(String path, RequestHandler... handlers);
    /**
         * This specification reserves the method name CONNECT for use with a proxy that
         * can dynamically switch to being a tunnel (e.g. SSL tunneling).
         */
    native public Router connect(String path, RequestHandler... handlers);
    native public Router use(RequestHandler... handlers);
    native public Router use(String mountPoint, RequestHandler... handlers);
    native public Route route(String prefix);
    native public Router all(String[] path, RequestHandler... handlers);
    native public Router all(RegExp path, RequestHandler[]... handlers);
    native public Router all(RegExp[] path, RequestHandler[]... handlers);
    native public Router all(String[] path, RequestHandler[]... handlers);
    native public Router all(RegExp[] path, ErrorHandler... handlers);
    native public Router all(String[] path, ErrorHandler[]... handlers);
    native public Router all(String[] path, ErrorHandler... handlers);
    native public Router all(String path, ErrorHandler... handlers);
    native public Router all(RegExp[] path, ErrorHandler[]... handlers);
    native public Router all(RegExp[] path, RequestHandler... handlers);
    native public Router all(RegExp path, ErrorHandler[]... handlers);
    native public Router all(RegExp path, ErrorHandler... handlers);
    native public Router all(String path, RequestHandler[]... handlers);
    native public Router all(String path, ErrorHandler[]... handlers);
    native public Router all(RegExp path, RequestHandler... handlers);
    /**
         * The GET method means retrieve whatever information (in the form of an entity)
         * is identified by the Request-URI. If the Request-URI refers to a data-producing
         * process, it is the produced data which shall be returned as the entity in the
         * response and not the source text of the process, unless that text happens to be
         * the output of the process.
         */
    native public Router get(RegExp[] path, ErrorHandler... handlers);
    /**
         * The GET method means retrieve whatever information (in the form of an entity)
         * is identified by the Request-URI. If the Request-URI refers to a data-producing
         * process, it is the produced data which shall be returned as the entity in the
         * response and not the source text of the process, unless that text happens to be
         * the output of the process.
         */
    native public Router get(RegExp path, RequestHandler... handlers);
    /**
         * The GET method means retrieve whatever information (in the form of an entity)
         * is identified by the Request-URI. If the Request-URI refers to a data-producing
         * process, it is the produced data which shall be returned as the entity in the
         * response and not the source text of the process, unless that text happens to be
         * the output of the process.
         */
    native public Router get(RegExp[] path, RequestHandler... handlers);
    /**
         * The GET method means retrieve whatever information (in the form of an entity)
         * is identified by the Request-URI. If the Request-URI refers to a data-producing
         * process, it is the produced data which shall be returned as the entity in the
         * response and not the source text of the process, unless that text happens to be
         * the output of the process.
         */
    native public Router get(String path, ErrorHandler[]... handlers);
    /**
         * The GET method means retrieve whatever information (in the form of an entity)
         * is identified by the Request-URI. If the Request-URI refers to a data-producing
         * process, it is the produced data which shall be returned as the entity in the
         * response and not the source text of the process, unless that text happens to be
         * the output of the process.
         */
    native public Router get(String[] path, RequestHandler... handlers);
    /**
         * The GET method means retrieve whatever information (in the form of an entity)
         * is identified by the Request-URI. If the Request-URI refers to a data-producing
         * process, it is the produced data which shall be returned as the entity in the
         * response and not the source text of the process, unless that text happens to be
         * the output of the process.
         */
    native public Router get(RegExp[] path, ErrorHandler[]... handlers);
    /**
         * The GET method means retrieve whatever information (in the form of an entity)
         * is identified by the Request-URI. If the Request-URI refers to a data-producing
         * process, it is the produced data which shall be returned as the entity in the
         * response and not the source text of the process, unless that text happens to be
         * the output of the process.
         */
    native public Router get(String[] path, RequestHandler[]... handlers);
    /**
         * The GET method means retrieve whatever information (in the form of an entity)
         * is identified by the Request-URI. If the Request-URI refers to a data-producing
         * process, it is the produced data which shall be returned as the entity in the
         * response and not the source text of the process, unless that text happens to be
         * the output of the process.
         */
    native public Router get(String path, ErrorHandler... handlers);
    /**
         * The GET method means retrieve whatever information (in the form of an entity)
         * is identified by the Request-URI. If the Request-URI refers to a data-producing
         * process, it is the produced data which shall be returned as the entity in the
         * response and not the source text of the process, unless that text happens to be
         * the output of the process.
         */
    native public Router get(RegExp path, RequestHandler[]... handlers);
    /**
         * The GET method means retrieve whatever information (in the form of an entity)
         * is identified by the Request-URI. If the Request-URI refers to a data-producing
         * process, it is the produced data which shall be returned as the entity in the
         * response and not the source text of the process, unless that text happens to be
         * the output of the process.
         */
    native public Router get(RegExp path, ErrorHandler... handlers);
    /**
         * The GET method means retrieve whatever information (in the form of an entity)
         * is identified by the Request-URI. If the Request-URI refers to a data-producing
         * process, it is the produced data which shall be returned as the entity in the
         * response and not the source text of the process, unless that text happens to be
         * the output of the process.
         */
    native public Router get(RegExp path, ErrorHandler[]... handlers);
    /**
         * The GET method means retrieve whatever information (in the form of an entity)
         * is identified by the Request-URI. If the Request-URI refers to a data-producing
         * process, it is the produced data which shall be returned as the entity in the
         * response and not the source text of the process, unless that text happens to be
         * the output of the process.
         */
    native public Router get(String[] path, ErrorHandler... handlers);
    /**
         * The GET method means retrieve whatever information (in the form of an entity)
         * is identified by the Request-URI. If the Request-URI refers to a data-producing
         * process, it is the produced data which shall be returned as the entity in the
         * response and not the source text of the process, unless that text happens to be
         * the output of the process.
         */
    native public Router get(String[] path, ErrorHandler[]... handlers);
    /**
         * The GET method means retrieve whatever information (in the form of an entity)
         * is identified by the Request-URI. If the Request-URI refers to a data-producing
         * process, it is the produced data which shall be returned as the entity in the
         * response and not the source text of the process, unless that text happens to be
         * the output of the process.
         */
    native public Router get(String path, RequestHandler[]... handlers);
    /**
         * The GET method means retrieve whatever information (in the form of an entity)
         * is identified by the Request-URI. If the Request-URI refers to a data-producing
         * process, it is the produced data which shall be returned as the entity in the
         * response and not the source text of the process, unless that text happens to be
         * the output of the process.
         */
    native public Router get(RegExp[] path, RequestHandler[]... handlers);
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
    native public Router post(RegExp[] path, RequestHandler[]... handlers);
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
    native public Router post(RegExp[] path, ErrorHandler... handlers);
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
    native public Router post(RegExp path, ErrorHandler... handlers);
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
    native public Router post(String[] path, ErrorHandler[]... handlers);
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
    native public Router post(RegExp[] path, ErrorHandler[]... handlers);
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
    native public Router post(RegExp[] path, RequestHandler... handlers);
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
    native public Router post(String[] path, RequestHandler[]... handlers);
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
    native public Router post(RegExp path, RequestHandler[]... handlers);
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
    native public Router post(String path, ErrorHandler... handlers);
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
    native public Router post(String[] path, RequestHandler... handlers);
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
    native public Router post(RegExp path, RequestHandler... handlers);
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
    native public Router post(String path, ErrorHandler[]... handlers);
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
    native public Router post(RegExp path, ErrorHandler[]... handlers);
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
    native public Router post(String[] path, ErrorHandler... handlers);
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
    native public Router post(String path, RequestHandler[]... handlers);
    /**
         * The PUT method requests that the enclosed entity be stored under the supplied
         * Request-URI. If the Request-URI refers to an already existing resource, the
         * enclosed entity SHOULD be considered as a modified version of the one residing
         * on the origin server. If the Request-URI does not point to an existing
         * resource, and that URI is capable of being defined as a new resource by the
         * requesting user agent, the origin server can create the resource with that URI
         */
    native public Router put(String path, RequestHandler[]... handlers);
    /**
         * The PUT method requests that the enclosed entity be stored under the supplied
         * Request-URI. If the Request-URI refers to an already existing resource, the
         * enclosed entity SHOULD be considered as a modified version of the one residing
         * on the origin server. If the Request-URI does not point to an existing
         * resource, and that URI is capable of being defined as a new resource by the
         * requesting user agent, the origin server can create the resource with that URI
         */
    native public Router put(String path, ErrorHandler... handlers);
    /**
         * The PUT method requests that the enclosed entity be stored under the supplied
         * Request-URI. If the Request-URI refers to an already existing resource, the
         * enclosed entity SHOULD be considered as a modified version of the one residing
         * on the origin server. If the Request-URI does not point to an existing
         * resource, and that URI is capable of being defined as a new resource by the
         * requesting user agent, the origin server can create the resource with that URI
         */
    native public Router put(RegExp path, RequestHandler... handlers);
    /**
         * The PUT method requests that the enclosed entity be stored under the supplied
         * Request-URI. If the Request-URI refers to an already existing resource, the
         * enclosed entity SHOULD be considered as a modified version of the one residing
         * on the origin server. If the Request-URI does not point to an existing
         * resource, and that URI is capable of being defined as a new resource by the
         * requesting user agent, the origin server can create the resource with that URI
         */
    native public Router put(String[] path, ErrorHandler... handlers);
    /**
         * The PUT method requests that the enclosed entity be stored under the supplied
         * Request-URI. If the Request-URI refers to an already existing resource, the
         * enclosed entity SHOULD be considered as a modified version of the one residing
         * on the origin server. If the Request-URI does not point to an existing
         * resource, and that URI is capable of being defined as a new resource by the
         * requesting user agent, the origin server can create the resource with that URI
         */
    native public Router put(RegExp path, ErrorHandler... handlers);
    /**
         * The PUT method requests that the enclosed entity be stored under the supplied
         * Request-URI. If the Request-URI refers to an already existing resource, the
         * enclosed entity SHOULD be considered as a modified version of the one residing
         * on the origin server. If the Request-URI does not point to an existing
         * resource, and that URI is capable of being defined as a new resource by the
         * requesting user agent, the origin server can create the resource with that URI
         */
    native public Router put(RegExp[] path, ErrorHandler... handlers);
    /**
         * The PUT method requests that the enclosed entity be stored under the supplied
         * Request-URI. If the Request-URI refers to an already existing resource, the
         * enclosed entity SHOULD be considered as a modified version of the one residing
         * on the origin server. If the Request-URI does not point to an existing
         * resource, and that URI is capable of being defined as a new resource by the
         * requesting user agent, the origin server can create the resource with that URI
         */
    native public Router put(RegExp[] path, RequestHandler[]... handlers);
    /**
         * The PUT method requests that the enclosed entity be stored under the supplied
         * Request-URI. If the Request-URI refers to an already existing resource, the
         * enclosed entity SHOULD be considered as a modified version of the one residing
         * on the origin server. If the Request-URI does not point to an existing
         * resource, and that URI is capable of being defined as a new resource by the
         * requesting user agent, the origin server can create the resource with that URI
         */
    native public Router put(RegExp path, ErrorHandler[]... handlers);
    /**
         * The PUT method requests that the enclosed entity be stored under the supplied
         * Request-URI. If the Request-URI refers to an already existing resource, the
         * enclosed entity SHOULD be considered as a modified version of the one residing
         * on the origin server. If the Request-URI does not point to an existing
         * resource, and that URI is capable of being defined as a new resource by the
         * requesting user agent, the origin server can create the resource with that URI
         */
    native public Router put(String[] path, RequestHandler... handlers);
    /**
         * The PUT method requests that the enclosed entity be stored under the supplied
         * Request-URI. If the Request-URI refers to an already existing resource, the
         * enclosed entity SHOULD be considered as a modified version of the one residing
         * on the origin server. If the Request-URI does not point to an existing
         * resource, and that URI is capable of being defined as a new resource by the
         * requesting user agent, the origin server can create the resource with that URI
         */
    native public Router put(String[] path, ErrorHandler[]... handlers);
    /**
         * The PUT method requests that the enclosed entity be stored under the supplied
         * Request-URI. If the Request-URI refers to an already existing resource, the
         * enclosed entity SHOULD be considered as a modified version of the one residing
         * on the origin server. If the Request-URI does not point to an existing
         * resource, and that URI is capable of being defined as a new resource by the
         * requesting user agent, the origin server can create the resource with that URI
         */
    native public Router put(String[] path, RequestHandler[]... handlers);
    /**
         * The PUT method requests that the enclosed entity be stored under the supplied
         * Request-URI. If the Request-URI refers to an already existing resource, the
         * enclosed entity SHOULD be considered as a modified version of the one residing
         * on the origin server. If the Request-URI does not point to an existing
         * resource, and that URI is capable of being defined as a new resource by the
         * requesting user agent, the origin server can create the resource with that URI
         */
    native public Router put(RegExp[] path, RequestHandler... handlers);
    /**
         * The PUT method requests that the enclosed entity be stored under the supplied
         * Request-URI. If the Request-URI refers to an already existing resource, the
         * enclosed entity SHOULD be considered as a modified version of the one residing
         * on the origin server. If the Request-URI does not point to an existing
         * resource, and that URI is capable of being defined as a new resource by the
         * requesting user agent, the origin server can create the resource with that URI
         */
    native public Router put(RegExp path, RequestHandler[]... handlers);
    /**
         * The PUT method requests that the enclosed entity be stored under the supplied
         * Request-URI. If the Request-URI refers to an already existing resource, the
         * enclosed entity SHOULD be considered as a modified version of the one residing
         * on the origin server. If the Request-URI does not point to an existing
         * resource, and that URI is capable of being defined as a new resource by the
         * requesting user agent, the origin server can create the resource with that URI
         */
    native public Router put(String path, ErrorHandler[]... handlers);
    /**
         * The PUT method requests that the enclosed entity be stored under the supplied
         * Request-URI. If the Request-URI refers to an already existing resource, the
         * enclosed entity SHOULD be considered as a modified version of the one residing
         * on the origin server. If the Request-URI does not point to an existing
         * resource, and that URI is capable of being defined as a new resource by the
         * requesting user agent, the origin server can create the resource with that URI
         */
    native public Router put(RegExp[] path, ErrorHandler[]... handlers);
    /**
         * The HEAD method is identical to GET except that the server MUST NOT send a
         * message body in the response (i.e., the response terminates at the end of the
         * header section).
         */
    native public Router head(RegExp[] path, ErrorHandler... handlers);
    /**
         * The HEAD method is identical to GET except that the server MUST NOT send a
         * message body in the response (i.e., the response terminates at the end of the
         * header section).
         */
    native public Router head(RegExp path, RequestHandler... handlers);
    /**
         * The HEAD method is identical to GET except that the server MUST NOT send a
         * message body in the response (i.e., the response terminates at the end of the
         * header section).
         */
    native public Router head(String path, RequestHandler[]... handlers);
    /**
         * The HEAD method is identical to GET except that the server MUST NOT send a
         * message body in the response (i.e., the response terminates at the end of the
         * header section).
         */
    native public Router head(RegExp[] path, RequestHandler[]... handlers);
    /**
         * The HEAD method is identical to GET except that the server MUST NOT send a
         * message body in the response (i.e., the response terminates at the end of the
         * header section).
         */
    native public Router head(RegExp[] path, RequestHandler... handlers);
    /**
         * The HEAD method is identical to GET except that the server MUST NOT send a
         * message body in the response (i.e., the response terminates at the end of the
         * header section).
         */
    native public Router head(String[] path, ErrorHandler... handlers);
    /**
         * The HEAD method is identical to GET except that the server MUST NOT send a
         * message body in the response (i.e., the response terminates at the end of the
         * header section).
         */
    native public Router head(String[] path, ErrorHandler[]... handlers);
    /**
         * The HEAD method is identical to GET except that the server MUST NOT send a
         * message body in the response (i.e., the response terminates at the end of the
         * header section).
         */
    native public Router head(RegExp path, ErrorHandler[]... handlers);
    /**
         * The HEAD method is identical to GET except that the server MUST NOT send a
         * message body in the response (i.e., the response terminates at the end of the
         * header section).
         */
    native public Router head(String path, ErrorHandler[]... handlers);
    /**
         * The HEAD method is identical to GET except that the server MUST NOT send a
         * message body in the response (i.e., the response terminates at the end of the
         * header section).
         */
    native public Router head(RegExp path, RequestHandler[]... handlers);
    /**
         * The HEAD method is identical to GET except that the server MUST NOT send a
         * message body in the response (i.e., the response terminates at the end of the
         * header section).
         */
    native public Router head(String[] path, RequestHandler... handlers);
    /**
         * The HEAD method is identical to GET except that the server MUST NOT send a
         * message body in the response (i.e., the response terminates at the end of the
         * header section).
         */
    native public Router head(String[] path, RequestHandler[]... handlers);
    /**
         * The HEAD method is identical to GET except that the server MUST NOT send a
         * message body in the response (i.e., the response terminates at the end of the
         * header section).
         */
    native public Router head(RegExp path, ErrorHandler... handlers);
    /**
         * The HEAD method is identical to GET except that the server MUST NOT send a
         * message body in the response (i.e., the response terminates at the end of the
         * header section).
         */
    native public Router head(RegExp[] path, ErrorHandler[]... handlers);
    /**
         * The HEAD method is identical to GET except that the server MUST NOT send a
         * message body in the response (i.e., the response terminates at the end of the
         * header section).
         */
    native public Router head(String path, ErrorHandler... handlers);
    /**
         * The DELETE method requests that the origin server remove the association
         * between the target resource and its current functionality.  In effect, this
         * method is similar to the rm command in UNIX: it expresses a deletion operation
         * on the URI mapping of the origin server rather than an expectation that the
         * previously associated information be deleted.
         */
    native public Router delete(String path, ErrorHandler[]... handlers);
    /**
         * The DELETE method requests that the origin server remove the association
         * between the target resource and its current functionality.  In effect, this
         * method is similar to the rm command in UNIX: it expresses a deletion operation
         * on the URI mapping of the origin server rather than an expectation that the
         * previously associated information be deleted.
         */
    native public Router delete(String[] path, RequestHandler[]... handlers);
    /**
         * The DELETE method requests that the origin server remove the association
         * between the target resource and its current functionality.  In effect, this
         * method is similar to the rm command in UNIX: it expresses a deletion operation
         * on the URI mapping of the origin server rather than an expectation that the
         * previously associated information be deleted.
         */
    native public Router delete(RegExp[] path, RequestHandler... handlers);
    /**
         * The DELETE method requests that the origin server remove the association
         * between the target resource and its current functionality.  In effect, this
         * method is similar to the rm command in UNIX: it expresses a deletion operation
         * on the URI mapping of the origin server rather than an expectation that the
         * previously associated information be deleted.
         */
    native public Router delete(String[] path, RequestHandler... handlers);
    /**
         * The DELETE method requests that the origin server remove the association
         * between the target resource and its current functionality.  In effect, this
         * method is similar to the rm command in UNIX: it expresses a deletion operation
         * on the URI mapping of the origin server rather than an expectation that the
         * previously associated information be deleted.
         */
    native public Router delete(RegExp path, RequestHandler... handlers);
    /**
         * The DELETE method requests that the origin server remove the association
         * between the target resource and its current functionality.  In effect, this
         * method is similar to the rm command in UNIX: it expresses a deletion operation
         * on the URI mapping of the origin server rather than an expectation that the
         * previously associated information be deleted.
         */
    native public Router delete(String[] path, ErrorHandler... handlers);
    /**
         * The DELETE method requests that the origin server remove the association
         * between the target resource and its current functionality.  In effect, this
         * method is similar to the rm command in UNIX: it expresses a deletion operation
         * on the URI mapping of the origin server rather than an expectation that the
         * previously associated information be deleted.
         */
    native public Router delete(RegExp path, RequestHandler[]... handlers);
    /**
         * The DELETE method requests that the origin server remove the association
         * between the target resource and its current functionality.  In effect, this
         * method is similar to the rm command in UNIX: it expresses a deletion operation
         * on the URI mapping of the origin server rather than an expectation that the
         * previously associated information be deleted.
         */
    native public Router delete(String path, ErrorHandler... handlers);
    /**
         * The DELETE method requests that the origin server remove the association
         * between the target resource and its current functionality.  In effect, this
         * method is similar to the rm command in UNIX: it expresses a deletion operation
         * on the URI mapping of the origin server rather than an expectation that the
         * previously associated information be deleted.
         */
    native public Router delete(RegExp path, ErrorHandler... handlers);
    /**
         * The DELETE method requests that the origin server remove the association
         * between the target resource and its current functionality.  In effect, this
         * method is similar to the rm command in UNIX: it expresses a deletion operation
         * on the URI mapping of the origin server rather than an expectation that the
         * previously associated information be deleted.
         */
    native public Router delete(String[] path, ErrorHandler[]... handlers);
    /**
         * The DELETE method requests that the origin server remove the association
         * between the target resource and its current functionality.  In effect, this
         * method is similar to the rm command in UNIX: it expresses a deletion operation
         * on the URI mapping of the origin server rather than an expectation that the
         * previously associated information be deleted.
         */
    native public Router delete(RegExp[] path, ErrorHandler... handlers);
    /**
         * The DELETE method requests that the origin server remove the association
         * between the target resource and its current functionality.  In effect, this
         * method is similar to the rm command in UNIX: it expresses a deletion operation
         * on the URI mapping of the origin server rather than an expectation that the
         * previously associated information be deleted.
         */
    native public Router delete(RegExp[] path, ErrorHandler[]... handlers);
    /**
         * The DELETE method requests that the origin server remove the association
         * between the target resource and its current functionality.  In effect, this
         * method is similar to the rm command in UNIX: it expresses a deletion operation
         * on the URI mapping of the origin server rather than an expectation that the
         * previously associated information be deleted.
         */
    native public Router delete(RegExp path, ErrorHandler[]... handlers);
    /**
         * The DELETE method requests that the origin server remove the association
         * between the target resource and its current functionality.  In effect, this
         * method is similar to the rm command in UNIX: it expresses a deletion operation
         * on the URI mapping of the origin server rather than an expectation that the
         * previously associated information be deleted.
         */
    native public Router delete(RegExp[] path, RequestHandler[]... handlers);
    /**
         * The DELETE method requests that the origin server remove the association
         * between the target resource and its current functionality.  In effect, this
         * method is similar to the rm command in UNIX: it expresses a deletion operation
         * on the URI mapping of the origin server rather than an expectation that the
         * previously associated information be deleted.
         */
    native public Router delete(String path, RequestHandler[]... handlers);
    /**
         * The OPTIONS method requests information about the communication options
         * available for the target resource, at either the origin server or an
         * intervening intermediary.  This method allows a client to determine the options
         * and/or requirements associated with a resource, or the capabilities of a
         * server, without implying a resource action.
         *
         */
    native public Router options(RegExp[] path, RequestHandler... handlers);
    /**
         * The OPTIONS method requests information about the communication options
         * available for the target resource, at either the origin server or an
         * intervening intermediary.  This method allows a client to determine the options
         * and/or requirements associated with a resource, or the capabilities of a
         * server, without implying a resource action.
         *
         */
    native public Router options(RegExp path, RequestHandler[]... handlers);
    /**
         * The OPTIONS method requests information about the communication options
         * available for the target resource, at either the origin server or an
         * intervening intermediary.  This method allows a client to determine the options
         * and/or requirements associated with a resource, or the capabilities of a
         * server, without implying a resource action.
         *
         */
    native public Router options(RegExp path, ErrorHandler... handlers);
    /**
         * The OPTIONS method requests information about the communication options
         * available for the target resource, at either the origin server or an
         * intervening intermediary.  This method allows a client to determine the options
         * and/or requirements associated with a resource, or the capabilities of a
         * server, without implying a resource action.
         *
         */
    native public Router options(String[] path, ErrorHandler... handlers);
    /**
         * The OPTIONS method requests information about the communication options
         * available for the target resource, at either the origin server or an
         * intervening intermediary.  This method allows a client to determine the options
         * and/or requirements associated with a resource, or the capabilities of a
         * server, without implying a resource action.
         *
         */
    native public Router options(RegExp[] path, RequestHandler[]... handlers);
    /**
         * The OPTIONS method requests information about the communication options
         * available for the target resource, at either the origin server or an
         * intervening intermediary.  This method allows a client to determine the options
         * and/or requirements associated with a resource, or the capabilities of a
         * server, without implying a resource action.
         *
         */
    native public Router options(RegExp path, ErrorHandler[]... handlers);
    /**
         * The OPTIONS method requests information about the communication options
         * available for the target resource, at either the origin server or an
         * intervening intermediary.  This method allows a client to determine the options
         * and/or requirements associated with a resource, or the capabilities of a
         * server, without implying a resource action.
         *
         */
    native public Router options(RegExp[] path, ErrorHandler[]... handlers);
    /**
         * The OPTIONS method requests information about the communication options
         * available for the target resource, at either the origin server or an
         * intervening intermediary.  This method allows a client to determine the options
         * and/or requirements associated with a resource, or the capabilities of a
         * server, without implying a resource action.
         *
         */
    native public Router options(String path, ErrorHandler[]... handlers);
    /**
         * The OPTIONS method requests information about the communication options
         * available for the target resource, at either the origin server or an
         * intervening intermediary.  This method allows a client to determine the options
         * and/or requirements associated with a resource, or the capabilities of a
         * server, without implying a resource action.
         *
         */
    native public Router options(String[] path, RequestHandler[]... handlers);
    /**
         * The OPTIONS method requests information about the communication options
         * available for the target resource, at either the origin server or an
         * intervening intermediary.  This method allows a client to determine the options
         * and/or requirements associated with a resource, or the capabilities of a
         * server, without implying a resource action.
         *
         */
    native public Router options(String[] path, RequestHandler... handlers);
    /**
         * The OPTIONS method requests information about the communication options
         * available for the target resource, at either the origin server or an
         * intervening intermediary.  This method allows a client to determine the options
         * and/or requirements associated with a resource, or the capabilities of a
         * server, without implying a resource action.
         *
         */
    native public Router options(RegExp path, RequestHandler... handlers);
    /**
         * The OPTIONS method requests information about the communication options
         * available for the target resource, at either the origin server or an
         * intervening intermediary.  This method allows a client to determine the options
         * and/or requirements associated with a resource, or the capabilities of a
         * server, without implying a resource action.
         *
         */
    native public Router options(String path, ErrorHandler... handlers);
    /**
         * The OPTIONS method requests information about the communication options
         * available for the target resource, at either the origin server or an
         * intervening intermediary.  This method allows a client to determine the options
         * and/or requirements associated with a resource, or the capabilities of a
         * server, without implying a resource action.
         *
         */
    native public Router options(RegExp[] path, ErrorHandler... handlers);
    /**
         * The OPTIONS method requests information about the communication options
         * available for the target resource, at either the origin server or an
         * intervening intermediary.  This method allows a client to determine the options
         * and/or requirements associated with a resource, or the capabilities of a
         * server, without implying a resource action.
         *
         */
    native public Router options(String[] path, ErrorHandler[]... handlers);
    /**
         * The OPTIONS method requests information about the communication options
         * available for the target resource, at either the origin server or an
         * intervening intermediary.  This method allows a client to determine the options
         * and/or requirements associated with a resource, or the capabilities of a
         * server, without implying a resource action.
         *
         */
    native public Router options(String path, RequestHandler[]... handlers);
    /**
         * The final recipient of the request SHOULD reflect the message received,
         * excluding some fields described below, back to the client as the message body
         * of a 200 (OK) response with a Content-Type of "message/http" (Section 8.3.1 of
         * RFC7230).
         */
    native public Router trace(String path, RequestHandler[]... handlers);
    /**
         * The final recipient of the request SHOULD reflect the message received,
         * excluding some fields described below, back to the client as the message body
         * of a 200 (OK) response with a Content-Type of "message/http" (Section 8.3.1 of
         * RFC7230).
         */
    native public Router trace(RegExp[] path, ErrorHandler[]... handlers);
    /**
         * The final recipient of the request SHOULD reflect the message received,
         * excluding some fields described below, back to the client as the message body
         * of a 200 (OK) response with a Content-Type of "message/http" (Section 8.3.1 of
         * RFC7230).
         */
    native public Router trace(String[] path, ErrorHandler... handlers);
    /**
         * The final recipient of the request SHOULD reflect the message received,
         * excluding some fields described below, back to the client as the message body
         * of a 200 (OK) response with a Content-Type of "message/http" (Section 8.3.1 of
         * RFC7230).
         */
    native public Router trace(RegExp path, RequestHandler[]... handlers);
    /**
         * The final recipient of the request SHOULD reflect the message received,
         * excluding some fields described below, back to the client as the message body
         * of a 200 (OK) response with a Content-Type of "message/http" (Section 8.3.1 of
         * RFC7230).
         */
    native public Router trace(String[] path, ErrorHandler[]... handlers);
    /**
         * The final recipient of the request SHOULD reflect the message received,
         * excluding some fields described below, back to the client as the message body
         * of a 200 (OK) response with a Content-Type of "message/http" (Section 8.3.1 of
         * RFC7230).
         */
    native public Router trace(RegExp[] path, ErrorHandler... handlers);
    /**
         * The final recipient of the request SHOULD reflect the message received,
         * excluding some fields described below, back to the client as the message body
         * of a 200 (OK) response with a Content-Type of "message/http" (Section 8.3.1 of
         * RFC7230).
         */
    native public Router trace(String[] path, RequestHandler... handlers);
    /**
         * The final recipient of the request SHOULD reflect the message received,
         * excluding some fields described below, back to the client as the message body
         * of a 200 (OK) response with a Content-Type of "message/http" (Section 8.3.1 of
         * RFC7230).
         */
    native public Router trace(RegExp path, RequestHandler... handlers);
    /**
         * The final recipient of the request SHOULD reflect the message received,
         * excluding some fields described below, back to the client as the message body
         * of a 200 (OK) response with a Content-Type of "message/http" (Section 8.3.1 of
         * RFC7230).
         */
    native public Router trace(String path, ErrorHandler[]... handlers);
    /**
         * The final recipient of the request SHOULD reflect the message received,
         * excluding some fields described below, back to the client as the message body
         * of a 200 (OK) response with a Content-Type of "message/http" (Section 8.3.1 of
         * RFC7230).
         */
    native public Router trace(RegExp path, ErrorHandler[]... handlers);
    /**
         * The final recipient of the request SHOULD reflect the message received,
         * excluding some fields described below, back to the client as the message body
         * of a 200 (OK) response with a Content-Type of "message/http" (Section 8.3.1 of
         * RFC7230).
         */
    native public Router trace(RegExp[] path, RequestHandler[]... handlers);
    /**
         * The final recipient of the request SHOULD reflect the message received,
         * excluding some fields described below, back to the client as the message body
         * of a 200 (OK) response with a Content-Type of "message/http" (Section 8.3.1 of
         * RFC7230).
         */
    native public Router trace(String path, ErrorHandler... handlers);
    /**
         * The final recipient of the request SHOULD reflect the message received,
         * excluding some fields described below, back to the client as the message body
         * of a 200 (OK) response with a Content-Type of "message/http" (Section 8.3.1 of
         * RFC7230).
         */
    native public Router trace(String[] path, RequestHandler[]... handlers);
    /**
         * The final recipient of the request SHOULD reflect the message received,
         * excluding some fields described below, back to the client as the message body
         * of a 200 (OK) response with a Content-Type of "message/http" (Section 8.3.1 of
         * RFC7230).
         */
    native public Router trace(RegExp[] path, RequestHandler... handlers);
    /**
         * The final recipient of the request SHOULD reflect the message received,
         * excluding some fields described below, back to the client as the message body
         * of a 200 (OK) response with a Content-Type of "message/http" (Section 8.3.1 of
         * RFC7230).
         */
    native public Router trace(RegExp path, ErrorHandler... handlers);
    /**
         * The WebDAV COPY Method creates a duplicate of the source resource identified by
         * the Request-Uniform Resource Identifier (URI), in the destination resource
         * identified by the Destination Header. The COPY Method can be used to duplicate
         * collection and property resources.
         */
    native public Router copy(String[] path, RequestHandler... handlers);
    /**
         * The WebDAV COPY Method creates a duplicate of the source resource identified by
         * the Request-Uniform Resource Identifier (URI), in the destination resource
         * identified by the Destination Header. The COPY Method can be used to duplicate
         * collection and property resources.
         */
    native public Router copy(String[] path, RequestHandler[]... handlers);
    /**
         * The WebDAV COPY Method creates a duplicate of the source resource identified by
         * the Request-Uniform Resource Identifier (URI), in the destination resource
         * identified by the Destination Header. The COPY Method can be used to duplicate
         * collection and property resources.
         */
    native public Router copy(RegExp[] path, ErrorHandler... handlers);
    /**
         * The WebDAV COPY Method creates a duplicate of the source resource identified by
         * the Request-Uniform Resource Identifier (URI), in the destination resource
         * identified by the Destination Header. The COPY Method can be used to duplicate
         * collection and property resources.
         */
    native public Router copy(String[] path, ErrorHandler[]... handlers);
    /**
         * The WebDAV COPY Method creates a duplicate of the source resource identified by
         * the Request-Uniform Resource Identifier (URI), in the destination resource
         * identified by the Destination Header. The COPY Method can be used to duplicate
         * collection and property resources.
         */
    native public Router copy(RegExp[] path, RequestHandler[]... handlers);
    /**
         * The WebDAV COPY Method creates a duplicate of the source resource identified by
         * the Request-Uniform Resource Identifier (URI), in the destination resource
         * identified by the Destination Header. The COPY Method can be used to duplicate
         * collection and property resources.
         */
    native public Router copy(String path, ErrorHandler[]... handlers);
    /**
         * The WebDAV COPY Method creates a duplicate of the source resource identified by
         * the Request-Uniform Resource Identifier (URI), in the destination resource
         * identified by the Destination Header. The COPY Method can be used to duplicate
         * collection and property resources.
         */
    native public Router copy(RegExp path, ErrorHandler... handlers);
    /**
         * The WebDAV COPY Method creates a duplicate of the source resource identified by
         * the Request-Uniform Resource Identifier (URI), in the destination resource
         * identified by the Destination Header. The COPY Method can be used to duplicate
         * collection and property resources.
         */
    native public Router copy(String[] path, ErrorHandler... handlers);
    /**
         * The WebDAV COPY Method creates a duplicate of the source resource identified by
         * the Request-Uniform Resource Identifier (URI), in the destination resource
         * identified by the Destination Header. The COPY Method can be used to duplicate
         * collection and property resources.
         */
    native public Router copy(RegExp[] path, ErrorHandler[]... handlers);
    /**
         * The WebDAV COPY Method creates a duplicate of the source resource identified by
         * the Request-Uniform Resource Identifier (URI), in the destination resource
         * identified by the Destination Header. The COPY Method can be used to duplicate
         * collection and property resources.
         */
    native public Router copy(RegExp path, ErrorHandler[]... handlers);
    /**
         * The WebDAV COPY Method creates a duplicate of the source resource identified by
         * the Request-Uniform Resource Identifier (URI), in the destination resource
         * identified by the Destination Header. The COPY Method can be used to duplicate
         * collection and property resources.
         */
    native public Router copy(RegExp path, RequestHandler[]... handlers);
    /**
         * The WebDAV COPY Method creates a duplicate of the source resource identified by
         * the Request-Uniform Resource Identifier (URI), in the destination resource
         * identified by the Destination Header. The COPY Method can be used to duplicate
         * collection and property resources.
         */
    native public Router copy(RegExp[] path, RequestHandler... handlers);
    /**
         * The WebDAV COPY Method creates a duplicate of the source resource identified by
         * the Request-Uniform Resource Identifier (URI), in the destination resource
         * identified by the Destination Header. The COPY Method can be used to duplicate
         * collection and property resources.
         */
    native public Router copy(String path, RequestHandler[]... handlers);
    /**
         * The WebDAV COPY Method creates a duplicate of the source resource identified by
         * the Request-Uniform Resource Identifier (URI), in the destination resource
         * identified by the Destination Header. The COPY Method can be used to duplicate
         * collection and property resources.
         */
    native public Router copy(String path, ErrorHandler... handlers);
    /**
         * The WebDAV COPY Method creates a duplicate of the source resource identified by
         * the Request-Uniform Resource Identifier (URI), in the destination resource
         * identified by the Destination Header. The COPY Method can be used to duplicate
         * collection and property resources.
         */
    native public Router copy(RegExp path, RequestHandler... handlers);
    /**
         * The WebDAV LOCK method is used to take out a lock of any access type on a
         * resource so that another principal will not modify the resource while it is
         * being edited. The LOCK method may also be used to initiate transactions, which
         * allow clients to define groups of operations that are performed atomically.
         */
    native public Router lock(RegExp[] path, RequestHandler... handlers);
    /**
         * The WebDAV LOCK method is used to take out a lock of any access type on a
         * resource so that another principal will not modify the resource while it is
         * being edited. The LOCK method may also be used to initiate transactions, which
         * allow clients to define groups of operations that are performed atomically.
         */
    native public Router lock(String path, ErrorHandler... handlers);
    /**
         * The WebDAV LOCK method is used to take out a lock of any access type on a
         * resource so that another principal will not modify the resource while it is
         * being edited. The LOCK method may also be used to initiate transactions, which
         * allow clients to define groups of operations that are performed atomically.
         */
    native public Router lock(RegExp[] path, ErrorHandler... handlers);
    /**
         * The WebDAV LOCK method is used to take out a lock of any access type on a
         * resource so that another principal will not modify the resource while it is
         * being edited. The LOCK method may also be used to initiate transactions, which
         * allow clients to define groups of operations that are performed atomically.
         */
    native public Router lock(RegExp path, ErrorHandler... handlers);
    /**
         * The WebDAV LOCK method is used to take out a lock of any access type on a
         * resource so that another principal will not modify the resource while it is
         * being edited. The LOCK method may also be used to initiate transactions, which
         * allow clients to define groups of operations that are performed atomically.
         */
    native public Router lock(RegExp[] path, RequestHandler[]... handlers);
    /**
         * The WebDAV LOCK method is used to take out a lock of any access type on a
         * resource so that another principal will not modify the resource while it is
         * being edited. The LOCK method may also be used to initiate transactions, which
         * allow clients to define groups of operations that are performed atomically.
         */
    native public Router lock(RegExp path, RequestHandler... handlers);
    /**
         * The WebDAV LOCK method is used to take out a lock of any access type on a
         * resource so that another principal will not modify the resource while it is
         * being edited. The LOCK method may also be used to initiate transactions, which
         * allow clients to define groups of operations that are performed atomically.
         */
    native public Router lock(RegExp[] path, ErrorHandler[]... handlers);
    /**
         * The WebDAV LOCK method is used to take out a lock of any access type on a
         * resource so that another principal will not modify the resource while it is
         * being edited. The LOCK method may also be used to initiate transactions, which
         * allow clients to define groups of operations that are performed atomically.
         */
    native public Router lock(String[] path, ErrorHandler... handlers);
    /**
         * The WebDAV LOCK method is used to take out a lock of any access type on a
         * resource so that another principal will not modify the resource while it is
         * being edited. The LOCK method may also be used to initiate transactions, which
         * allow clients to define groups of operations that are performed atomically.
         */
    native public Router lock(String path, RequestHandler[]... handlers);
    /**
         * The WebDAV LOCK method is used to take out a lock of any access type on a
         * resource so that another principal will not modify the resource while it is
         * being edited. The LOCK method may also be used to initiate transactions, which
         * allow clients to define groups of operations that are performed atomically.
         */
    native public Router lock(String[] path, RequestHandler... handlers);
    /**
         * The WebDAV LOCK method is used to take out a lock of any access type on a
         * resource so that another principal will not modify the resource while it is
         * being edited. The LOCK method may also be used to initiate transactions, which
         * allow clients to define groups of operations that are performed atomically.
         */
    native public Router lock(String[] path, RequestHandler[]... handlers);
    /**
         * The WebDAV LOCK method is used to take out a lock of any access type on a
         * resource so that another principal will not modify the resource while it is
         * being edited. The LOCK method may also be used to initiate transactions, which
         * allow clients to define groups of operations that are performed atomically.
         */
    native public Router lock(RegExp path, ErrorHandler[]... handlers);
    /**
         * The WebDAV LOCK method is used to take out a lock of any access type on a
         * resource so that another principal will not modify the resource while it is
         * being edited. The LOCK method may also be used to initiate transactions, which
         * allow clients to define groups of operations that are performed atomically.
         */
    native public Router lock(RegExp path, RequestHandler[]... handlers);
    /**
         * The WebDAV LOCK method is used to take out a lock of any access type on a
         * resource so that another principal will not modify the resource while it is
         * being edited. The LOCK method may also be used to initiate transactions, which
         * allow clients to define groups of operations that are performed atomically.
         */
    native public Router lock(String[] path, ErrorHandler[]... handlers);
    /**
         * The WebDAV LOCK method is used to take out a lock of any access type on a
         * resource so that another principal will not modify the resource while it is
         * being edited. The LOCK method may also be used to initiate transactions, which
         * allow clients to define groups of operations that are performed atomically.
         */
    native public Router lock(String path, ErrorHandler[]... handlers);
    /**
         * The WebDAV MKCOL method creates a new collection at the location specified by
         * the Request-Uniform Resource Identifier (URI). When invoked without a request
         * body, the collection will be created without member resources. When used with a
         * request body, you can create members and properties on the collections or
         * members.
         */
    native public Router mkcol(String path, ErrorHandler[]... handlers);
    /**
         * The WebDAV MKCOL method creates a new collection at the location specified by
         * the Request-Uniform Resource Identifier (URI). When invoked without a request
         * body, the collection will be created without member resources. When used with a
         * request body, you can create members and properties on the collections or
         * members.
         */
    native public Router mkcol(RegExp path, ErrorHandler[]... handlers);
    /**
         * The WebDAV MKCOL method creates a new collection at the location specified by
         * the Request-Uniform Resource Identifier (URI). When invoked without a request
         * body, the collection will be created without member resources. When used with a
         * request body, you can create members and properties on the collections or
         * members.
         */
    native public Router mkcol(RegExp path, RequestHandler[]... handlers);
    /**
         * The WebDAV MKCOL method creates a new collection at the location specified by
         * the Request-Uniform Resource Identifier (URI). When invoked without a request
         * body, the collection will be created without member resources. When used with a
         * request body, you can create members and properties on the collections or
         * members.
         */
    native public Router mkcol(String[] path, RequestHandler... handlers);
    /**
         * The WebDAV MKCOL method creates a new collection at the location specified by
         * the Request-Uniform Resource Identifier (URI). When invoked without a request
         * body, the collection will be created without member resources. When used with a
         * request body, you can create members and properties on the collections or
         * members.
         */
    native public Router mkcol(String[] path, ErrorHandler... handlers);
    /**
         * The WebDAV MKCOL method creates a new collection at the location specified by
         * the Request-Uniform Resource Identifier (URI). When invoked without a request
         * body, the collection will be created without member resources. When used with a
         * request body, you can create members and properties on the collections or
         * members.
         */
    native public Router mkcol(RegExp[] path, RequestHandler... handlers);
    /**
         * The WebDAV MKCOL method creates a new collection at the location specified by
         * the Request-Uniform Resource Identifier (URI). When invoked without a request
         * body, the collection will be created without member resources. When used with a
         * request body, you can create members and properties on the collections or
         * members.
         */
    native public Router mkcol(RegExp[] path, ErrorHandler[]... handlers);
    /**
         * The WebDAV MKCOL method creates a new collection at the location specified by
         * the Request-Uniform Resource Identifier (URI). When invoked without a request
         * body, the collection will be created without member resources. When used with a
         * request body, you can create members and properties on the collections or
         * members.
         */
    native public Router mkcol(String[] path, ErrorHandler[]... handlers);
    /**
         * The WebDAV MKCOL method creates a new collection at the location specified by
         * the Request-Uniform Resource Identifier (URI). When invoked without a request
         * body, the collection will be created without member resources. When used with a
         * request body, you can create members and properties on the collections or
         * members.
         */
    native public Router mkcol(RegExp[] path, RequestHandler[]... handlers);
    /**
         * The WebDAV MKCOL method creates a new collection at the location specified by
         * the Request-Uniform Resource Identifier (URI). When invoked without a request
         * body, the collection will be created without member resources. When used with a
         * request body, you can create members and properties on the collections or
         * members.
         */
    native public Router mkcol(RegExp path, RequestHandler... handlers);
    /**
         * The WebDAV MKCOL method creates a new collection at the location specified by
         * the Request-Uniform Resource Identifier (URI). When invoked without a request
         * body, the collection will be created without member resources. When used with a
         * request body, you can create members and properties on the collections or
         * members.
         */
    native public Router mkcol(String[] path, RequestHandler[]... handlers);
    /**
         * The WebDAV MKCOL method creates a new collection at the location specified by
         * the Request-Uniform Resource Identifier (URI). When invoked without a request
         * body, the collection will be created without member resources. When used with a
         * request body, you can create members and properties on the collections or
         * members.
         */
    native public Router mkcol(String path, RequestHandler[]... handlers);
    /**
         * The WebDAV MKCOL method creates a new collection at the location specified by
         * the Request-Uniform Resource Identifier (URI). When invoked without a request
         * body, the collection will be created without member resources. When used with a
         * request body, you can create members and properties on the collections or
         * members.
         */
    native public Router mkcol(String path, ErrorHandler... handlers);
    /**
         * The WebDAV MKCOL method creates a new collection at the location specified by
         * the Request-Uniform Resource Identifier (URI). When invoked without a request
         * body, the collection will be created without member resources. When used with a
         * request body, you can create members and properties on the collections or
         * members.
         */
    native public Router mkcol(RegExp[] path, ErrorHandler... handlers);
    /**
         * The WebDAV MKCOL method creates a new collection at the location specified by
         * the Request-Uniform Resource Identifier (URI). When invoked without a request
         * body, the collection will be created without member resources. When used with a
         * request body, you can create members and properties on the collections or
         * members.
         */
    native public Router mkcol(RegExp path, ErrorHandler... handlers);
    /**
         * The WebDAV MOVE Method is used to move a resource to the location specified by
         * a request Uniform Resource Identifier (URI).
         */
    native public Router move(String[] path, RequestHandler[]... handlers);
    /**
         * The WebDAV MOVE Method is used to move a resource to the location specified by
         * a request Uniform Resource Identifier (URI).
         */
    native public Router move(RegExp[] path, RequestHandler... handlers);
    /**
         * The WebDAV MOVE Method is used to move a resource to the location specified by
         * a request Uniform Resource Identifier (URI).
         */
    native public Router move(String[] path, ErrorHandler[]... handlers);
    /**
         * The WebDAV MOVE Method is used to move a resource to the location specified by
         * a request Uniform Resource Identifier (URI).
         */
    native public Router move(String path, RequestHandler[]... handlers);
    /**
         * The WebDAV MOVE Method is used to move a resource to the location specified by
         * a request Uniform Resource Identifier (URI).
         */
    native public Router move(String[] path, RequestHandler... handlers);
    /**
         * The WebDAV MOVE Method is used to move a resource to the location specified by
         * a request Uniform Resource Identifier (URI).
         */
    native public Router move(RegExp[] path, RequestHandler[]... handlers);
    /**
         * The WebDAV MOVE Method is used to move a resource to the location specified by
         * a request Uniform Resource Identifier (URI).
         */
    native public Router move(RegExp path, ErrorHandler... handlers);
    /**
         * The WebDAV MOVE Method is used to move a resource to the location specified by
         * a request Uniform Resource Identifier (URI).
         */
    native public Router move(String path, ErrorHandler... handlers);
    /**
         * The WebDAV MOVE Method is used to move a resource to the location specified by
         * a request Uniform Resource Identifier (URI).
         */
    native public Router move(RegExp[] path, ErrorHandler[]... handlers);
    /**
         * The WebDAV MOVE Method is used to move a resource to the location specified by
         * a request Uniform Resource Identifier (URI).
         */
    native public Router move(RegExp[] path, ErrorHandler... handlers);
    /**
         * The WebDAV MOVE Method is used to move a resource to the location specified by
         * a request Uniform Resource Identifier (URI).
         */
    native public Router move(RegExp path, RequestHandler[]... handlers);
    /**
         * The WebDAV MOVE Method is used to move a resource to the location specified by
         * a request Uniform Resource Identifier (URI).
         */
    native public Router move(String path, ErrorHandler[]... handlers);
    /**
         * The WebDAV MOVE Method is used to move a resource to the location specified by
         * a request Uniform Resource Identifier (URI).
         */
    native public Router move(RegExp path, ErrorHandler[]... handlers);
    /**
         * The WebDAV MOVE Method is used to move a resource to the location specified by
         * a request Uniform Resource Identifier (URI).
         */
    native public Router move(RegExp path, RequestHandler... handlers);
    /**
         * The WebDAV MOVE Method is used to move a resource to the location specified by
         * a request Uniform Resource Identifier (URI).
         */
    native public Router move(String[] path, ErrorHandler... handlers);
    /**
         * A purge is what happens when you pick out an object from the cache and discard
         * it along with its variants. Usually a purge is invoked through HTTP with the
         * method PURGE. An HTTP purge is similar to an HTTP GET request, except that the
         * method is PURGE. Actually you can call the method whatever you'd like, but most
         * people refer to this as purging.
         */
    native public Router purge(String[] path, RequestHandler... handlers);
    /**
         * A purge is what happens when you pick out an object from the cache and discard
         * it along with its variants. Usually a purge is invoked through HTTP with the
         * method PURGE. An HTTP purge is similar to an HTTP GET request, except that the
         * method is PURGE. Actually you can call the method whatever you'd like, but most
         * people refer to this as purging.
         */
    native public Router purge(String[] path, ErrorHandler... handlers);
    /**
         * A purge is what happens when you pick out an object from the cache and discard
         * it along with its variants. Usually a purge is invoked through HTTP with the
         * method PURGE. An HTTP purge is similar to an HTTP GET request, except that the
         * method is PURGE. Actually you can call the method whatever you'd like, but most
         * people refer to this as purging.
         */
    native public Router purge(RegExp path, ErrorHandler... handlers);
    /**
         * A purge is what happens when you pick out an object from the cache and discard
         * it along with its variants. Usually a purge is invoked through HTTP with the
         * method PURGE. An HTTP purge is similar to an HTTP GET request, except that the
         * method is PURGE. Actually you can call the method whatever you'd like, but most
         * people refer to this as purging.
         */
    native public Router purge(String[] path, ErrorHandler[]... handlers);
    /**
         * A purge is what happens when you pick out an object from the cache and discard
         * it along with its variants. Usually a purge is invoked through HTTP with the
         * method PURGE. An HTTP purge is similar to an HTTP GET request, except that the
         * method is PURGE. Actually you can call the method whatever you'd like, but most
         * people refer to this as purging.
         */
    native public Router purge(RegExp[] path, RequestHandler[]... handlers);
    /**
         * A purge is what happens when you pick out an object from the cache and discard
         * it along with its variants. Usually a purge is invoked through HTTP with the
         * method PURGE. An HTTP purge is similar to an HTTP GET request, except that the
         * method is PURGE. Actually you can call the method whatever you'd like, but most
         * people refer to this as purging.
         */
    native public Router purge(RegExp[] path, ErrorHandler... handlers);
    /**
         * A purge is what happens when you pick out an object from the cache and discard
         * it along with its variants. Usually a purge is invoked through HTTP with the
         * method PURGE. An HTTP purge is similar to an HTTP GET request, except that the
         * method is PURGE. Actually you can call the method whatever you'd like, but most
         * people refer to this as purging.
         */
    native public Router purge(RegExp[] path, ErrorHandler[]... handlers);
    /**
         * A purge is what happens when you pick out an object from the cache and discard
         * it along with its variants. Usually a purge is invoked through HTTP with the
         * method PURGE. An HTTP purge is similar to an HTTP GET request, except that the
         * method is PURGE. Actually you can call the method whatever you'd like, but most
         * people refer to this as purging.
         */
    native public Router purge(RegExp path, RequestHandler... handlers);
    /**
         * A purge is what happens when you pick out an object from the cache and discard
         * it along with its variants. Usually a purge is invoked through HTTP with the
         * method PURGE. An HTTP purge is similar to an HTTP GET request, except that the
         * method is PURGE. Actually you can call the method whatever you'd like, but most
         * people refer to this as purging.
         */
    native public Router purge(RegExp path, ErrorHandler[]... handlers);
    /**
         * A purge is what happens when you pick out an object from the cache and discard
         * it along with its variants. Usually a purge is invoked through HTTP with the
         * method PURGE. An HTTP purge is similar to an HTTP GET request, except that the
         * method is PURGE. Actually you can call the method whatever you'd like, but most
         * people refer to this as purging.
         */
    native public Router purge(String[] path, RequestHandler[]... handlers);
    /**
         * A purge is what happens when you pick out an object from the cache and discard
         * it along with its variants. Usually a purge is invoked through HTTP with the
         * method PURGE. An HTTP purge is similar to an HTTP GET request, except that the
         * method is PURGE. Actually you can call the method whatever you'd like, but most
         * people refer to this as purging.
         */
    native public Router purge(RegExp[] path, RequestHandler... handlers);
    /**
         * A purge is what happens when you pick out an object from the cache and discard
         * it along with its variants. Usually a purge is invoked through HTTP with the
         * method PURGE. An HTTP purge is similar to an HTTP GET request, except that the
         * method is PURGE. Actually you can call the method whatever you'd like, but most
         * people refer to this as purging.
         */
    native public Router purge(String path, ErrorHandler[]... handlers);
    /**
         * A purge is what happens when you pick out an object from the cache and discard
         * it along with its variants. Usually a purge is invoked through HTTP with the
         * method PURGE. An HTTP purge is similar to an HTTP GET request, except that the
         * method is PURGE. Actually you can call the method whatever you'd like, but most
         * people refer to this as purging.
         */
    native public Router purge(String path, RequestHandler[]... handlers);
    /**
         * A purge is what happens when you pick out an object from the cache and discard
         * it along with its variants. Usually a purge is invoked through HTTP with the
         * method PURGE. An HTTP purge is similar to an HTTP GET request, except that the
         * method is PURGE. Actually you can call the method whatever you'd like, but most
         * people refer to this as purging.
         */
    native public Router purge(RegExp path, RequestHandler[]... handlers);
    /**
         * A purge is what happens when you pick out an object from the cache and discard
         * it along with its variants. Usually a purge is invoked through HTTP with the
         * method PURGE. An HTTP purge is similar to an HTTP GET request, except that the
         * method is PURGE. Actually you can call the method whatever you'd like, but most
         * people refer to this as purging.
         */
    native public Router purge(String path, ErrorHandler... handlers);
    /**
         * The WebDAV PROPFIND Method retrieves properties for a resource identified by
         * the request Uniform Resource Identifier (URI). The PROPFIND Method can be used
         * on collection and property resources.
         */
    native public Router propfind(String[] path, ErrorHandler[]... handlers);
    /**
         * The WebDAV PROPFIND Method retrieves properties for a resource identified by
         * the request Uniform Resource Identifier (URI). The PROPFIND Method can be used
         * on collection and property resources.
         */
    native public Router propfind(String[] path, RequestHandler... handlers);
    /**
         * The WebDAV PROPFIND Method retrieves properties for a resource identified by
         * the request Uniform Resource Identifier (URI). The PROPFIND Method can be used
         * on collection and property resources.
         */
    native public Router propfind(String[] path, ErrorHandler... handlers);
    /**
         * The WebDAV PROPFIND Method retrieves properties for a resource identified by
         * the request Uniform Resource Identifier (URI). The PROPFIND Method can be used
         * on collection and property resources.
         */
    native public Router propfind(RegExp path, RequestHandler[]... handlers);
    /**
         * The WebDAV PROPFIND Method retrieves properties for a resource identified by
         * the request Uniform Resource Identifier (URI). The PROPFIND Method can be used
         * on collection and property resources.
         */
    native public Router propfind(String[] path, RequestHandler[]... handlers);
    /**
         * The WebDAV PROPFIND Method retrieves properties for a resource identified by
         * the request Uniform Resource Identifier (URI). The PROPFIND Method can be used
         * on collection and property resources.
         */
    native public Router propfind(RegExp path, ErrorHandler[]... handlers);
    /**
         * The WebDAV PROPFIND Method retrieves properties for a resource identified by
         * the request Uniform Resource Identifier (URI). The PROPFIND Method can be used
         * on collection and property resources.
         */
    native public Router propfind(RegExp path, ErrorHandler... handlers);
    /**
         * The WebDAV PROPFIND Method retrieves properties for a resource identified by
         * the request Uniform Resource Identifier (URI). The PROPFIND Method can be used
         * on collection and property resources.
         */
    native public Router propfind(String path, ErrorHandler[]... handlers);
    /**
         * The WebDAV PROPFIND Method retrieves properties for a resource identified by
         * the request Uniform Resource Identifier (URI). The PROPFIND Method can be used
         * on collection and property resources.
         */
    native public Router propfind(RegExp[] path, ErrorHandler[]... handlers);
    /**
         * The WebDAV PROPFIND Method retrieves properties for a resource identified by
         * the request Uniform Resource Identifier (URI). The PROPFIND Method can be used
         * on collection and property resources.
         */
    native public Router propfind(RegExp[] path, RequestHandler... handlers);
    /**
         * The WebDAV PROPFIND Method retrieves properties for a resource identified by
         * the request Uniform Resource Identifier (URI). The PROPFIND Method can be used
         * on collection and property resources.
         */
    native public Router propfind(String path, RequestHandler[]... handlers);
    /**
         * The WebDAV PROPFIND Method retrieves properties for a resource identified by
         * the request Uniform Resource Identifier (URI). The PROPFIND Method can be used
         * on collection and property resources.
         */
    native public Router propfind(RegExp path, RequestHandler... handlers);
    /**
         * The WebDAV PROPFIND Method retrieves properties for a resource identified by
         * the request Uniform Resource Identifier (URI). The PROPFIND Method can be used
         * on collection and property resources.
         */
    native public Router propfind(String path, ErrorHandler... handlers);
    /**
         * The WebDAV PROPFIND Method retrieves properties for a resource identified by
         * the request Uniform Resource Identifier (URI). The PROPFIND Method can be used
         * on collection and property resources.
         */
    native public Router propfind(RegExp[] path, ErrorHandler... handlers);
    /**
         * The WebDAV PROPFIND Method retrieves properties for a resource identified by
         * the request Uniform Resource Identifier (URI). The PROPFIND Method can be used
         * on collection and property resources.
         */
    native public Router propfind(RegExp[] path, RequestHandler[]... handlers);
    /**
         * The WebDAVPROPPATCH method sets properties for the resource at the specified
         * destination Uniform Resource Identifier (URI). All property names must be
         * scoped in the XML body using namespace URI references.
         */
    native public Router proppatch(RegExp[] path, ErrorHandler... handlers);
    /**
         * The WebDAVPROPPATCH method sets properties for the resource at the specified
         * destination Uniform Resource Identifier (URI). All property names must be
         * scoped in the XML body using namespace URI references.
         */
    native public Router proppatch(String path, ErrorHandler... handlers);
    /**
         * The WebDAVPROPPATCH method sets properties for the resource at the specified
         * destination Uniform Resource Identifier (URI). All property names must be
         * scoped in the XML body using namespace URI references.
         */
    native public Router proppatch(String[] path, RequestHandler... handlers);
    /**
         * The WebDAVPROPPATCH method sets properties for the resource at the specified
         * destination Uniform Resource Identifier (URI). All property names must be
         * scoped in the XML body using namespace URI references.
         */
    native public Router proppatch(String[] path, RequestHandler[]... handlers);
    /**
         * The WebDAVPROPPATCH method sets properties for the resource at the specified
         * destination Uniform Resource Identifier (URI). All property names must be
         * scoped in the XML body using namespace URI references.
         */
    native public Router proppatch(RegExp[] path, ErrorHandler[]... handlers);
    /**
         * The WebDAVPROPPATCH method sets properties for the resource at the specified
         * destination Uniform Resource Identifier (URI). All property names must be
         * scoped in the XML body using namespace URI references.
         */
    native public Router proppatch(String[] path, ErrorHandler... handlers);
    /**
         * The WebDAVPROPPATCH method sets properties for the resource at the specified
         * destination Uniform Resource Identifier (URI). All property names must be
         * scoped in the XML body using namespace URI references.
         */
    native public Router proppatch(String path, ErrorHandler[]... handlers);
    /**
         * The WebDAVPROPPATCH method sets properties for the resource at the specified
         * destination Uniform Resource Identifier (URI). All property names must be
         * scoped in the XML body using namespace URI references.
         */
    native public Router proppatch(RegExp[] path, RequestHandler... handlers);
    /**
         * The WebDAVPROPPATCH method sets properties for the resource at the specified
         * destination Uniform Resource Identifier (URI). All property names must be
         * scoped in the XML body using namespace URI references.
         */
    native public Router proppatch(RegExp path, ErrorHandler[]... handlers);
    /**
         * The WebDAVPROPPATCH method sets properties for the resource at the specified
         * destination Uniform Resource Identifier (URI). All property names must be
         * scoped in the XML body using namespace URI references.
         */
    native public Router proppatch(String path, RequestHandler[]... handlers);
    /**
         * The WebDAVPROPPATCH method sets properties for the resource at the specified
         * destination Uniform Resource Identifier (URI). All property names must be
         * scoped in the XML body using namespace URI references.
         */
    native public Router proppatch(RegExp path, RequestHandler[]... handlers);
    /**
         * The WebDAVPROPPATCH method sets properties for the resource at the specified
         * destination Uniform Resource Identifier (URI). All property names must be
         * scoped in the XML body using namespace URI references.
         */
    native public Router proppatch(RegExp path, ErrorHandler... handlers);
    /**
         * The WebDAVPROPPATCH method sets properties for the resource at the specified
         * destination Uniform Resource Identifier (URI). All property names must be
         * scoped in the XML body using namespace URI references.
         */
    native public Router proppatch(RegExp[] path, RequestHandler[]... handlers);
    /**
         * The WebDAVPROPPATCH method sets properties for the resource at the specified
         * destination Uniform Resource Identifier (URI). All property names must be
         * scoped in the XML body using namespace URI references.
         */
    native public Router proppatch(String[] path, ErrorHandler[]... handlers);
    /**
         * The WebDAVPROPPATCH method sets properties for the resource at the specified
         * destination Uniform Resource Identifier (URI). All property names must be
         * scoped in the XML body using namespace URI references.
         */
    native public Router proppatch(RegExp path, RequestHandler... handlers);
    /**
         * The WebDAVUNLOCK Method is used to remove the lock on the resource at the
         * request Uniform Resource Identifier (URI). The UNLOCK Method may also be used
         * to end a transaction that was initiated by the LOCK Method.
         */
    native public Router unlock(String[] path, ErrorHandler... handlers);
    /**
         * The WebDAVUNLOCK Method is used to remove the lock on the resource at the
         * request Uniform Resource Identifier (URI). The UNLOCK Method may also be used
         * to end a transaction that was initiated by the LOCK Method.
         */
    native public Router unlock(RegExp path, RequestHandler[]... handlers);
    /**
         * The WebDAVUNLOCK Method is used to remove the lock on the resource at the
         * request Uniform Resource Identifier (URI). The UNLOCK Method may also be used
         * to end a transaction that was initiated by the LOCK Method.
         */
    native public Router unlock(String[] path, RequestHandler[]... handlers);
    /**
         * The WebDAVUNLOCK Method is used to remove the lock on the resource at the
         * request Uniform Resource Identifier (URI). The UNLOCK Method may also be used
         * to end a transaction that was initiated by the LOCK Method.
         */
    native public Router unlock(RegExp path, ErrorHandler[]... handlers);
    /**
         * The WebDAVUNLOCK Method is used to remove the lock on the resource at the
         * request Uniform Resource Identifier (URI). The UNLOCK Method may also be used
         * to end a transaction that was initiated by the LOCK Method.
         */
    native public Router unlock(String path, RequestHandler[]... handlers);
    /**
         * The WebDAVUNLOCK Method is used to remove the lock on the resource at the
         * request Uniform Resource Identifier (URI). The UNLOCK Method may also be used
         * to end a transaction that was initiated by the LOCK Method.
         */
    native public Router unlock(RegExp[] path, RequestHandler... handlers);
    /**
         * The WebDAVUNLOCK Method is used to remove the lock on the resource at the
         * request Uniform Resource Identifier (URI). The UNLOCK Method may also be used
         * to end a transaction that was initiated by the LOCK Method.
         */
    native public Router unlock(String[] path, ErrorHandler[]... handlers);
    /**
         * The WebDAVUNLOCK Method is used to remove the lock on the resource at the
         * request Uniform Resource Identifier (URI). The UNLOCK Method may also be used
         * to end a transaction that was initiated by the LOCK Method.
         */
    native public Router unlock(RegExp[] path, RequestHandler[]... handlers);
    /**
         * The WebDAVUNLOCK Method is used to remove the lock on the resource at the
         * request Uniform Resource Identifier (URI). The UNLOCK Method may also be used
         * to end a transaction that was initiated by the LOCK Method.
         */
    native public Router unlock(String[] path, RequestHandler... handlers);
    /**
         * The WebDAVUNLOCK Method is used to remove the lock on the resource at the
         * request Uniform Resource Identifier (URI). The UNLOCK Method may also be used
         * to end a transaction that was initiated by the LOCK Method.
         */
    native public Router unlock(RegExp path, RequestHandler... handlers);
    /**
         * The WebDAVUNLOCK Method is used to remove the lock on the resource at the
         * request Uniform Resource Identifier (URI). The UNLOCK Method may also be used
         * to end a transaction that was initiated by the LOCK Method.
         */
    native public Router unlock(String path, ErrorHandler... handlers);
    /**
         * The WebDAVUNLOCK Method is used to remove the lock on the resource at the
         * request Uniform Resource Identifier (URI). The UNLOCK Method may also be used
         * to end a transaction that was initiated by the LOCK Method.
         */
    native public Router unlock(RegExp[] path, ErrorHandler[]... handlers);
    /**
         * The WebDAVUNLOCK Method is used to remove the lock on the resource at the
         * request Uniform Resource Identifier (URI). The UNLOCK Method may also be used
         * to end a transaction that was initiated by the LOCK Method.
         */
    native public Router unlock(RegExp path, ErrorHandler... handlers);
    /**
         * The WebDAVUNLOCK Method is used to remove the lock on the resource at the
         * request Uniform Resource Identifier (URI). The UNLOCK Method may also be used
         * to end a transaction that was initiated by the LOCK Method.
         */
    native public Router unlock(String path, ErrorHandler[]... handlers);
    /**
         * The WebDAVUNLOCK Method is used to remove the lock on the resource at the
         * request Uniform Resource Identifier (URI). The UNLOCK Method may also be used
         * to end a transaction that was initiated by the LOCK Method.
         */
    native public Router unlock(RegExp[] path, ErrorHandler... handlers);
    /**
         * A REPORT request is an extensible mechanism for obtaining information about a
         * resource. Unlike a resource property, which has a single value, the value of a
         * report can depend on additional information specified in the REPORT request
         * body and in the REPORT request headers.
         */
    native public Router report(RegExp path, RequestHandler[]... handlers);
    /**
         * A REPORT request is an extensible mechanism for obtaining information about a
         * resource. Unlike a resource property, which has a single value, the value of a
         * report can depend on additional information specified in the REPORT request
         * body and in the REPORT request headers.
         */
    native public Router report(String[] path, ErrorHandler[]... handlers);
    /**
         * A REPORT request is an extensible mechanism for obtaining information about a
         * resource. Unlike a resource property, which has a single value, the value of a
         * report can depend on additional information specified in the REPORT request
         * body and in the REPORT request headers.
         */
    native public Router report(String[] path, RequestHandler[]... handlers);
    /**
         * A REPORT request is an extensible mechanism for obtaining information about a
         * resource. Unlike a resource property, which has a single value, the value of a
         * report can depend on additional information specified in the REPORT request
         * body and in the REPORT request headers.
         */
    native public Router report(RegExp[] path, RequestHandler[]... handlers);
    /**
         * A REPORT request is an extensible mechanism for obtaining information about a
         * resource. Unlike a resource property, which has a single value, the value of a
         * report can depend on additional information specified in the REPORT request
         * body and in the REPORT request headers.
         */
    native public Router report(String path, ErrorHandler... handlers);
    /**
         * A REPORT request is an extensible mechanism for obtaining information about a
         * resource. Unlike a resource property, which has a single value, the value of a
         * report can depend on additional information specified in the REPORT request
         * body and in the REPORT request headers.
         */
    native public Router report(String[] path, RequestHandler... handlers);
    /**
         * A REPORT request is an extensible mechanism for obtaining information about a
         * resource. Unlike a resource property, which has a single value, the value of a
         * report can depend on additional information specified in the REPORT request
         * body and in the REPORT request headers.
         */
    native public Router report(String path, RequestHandler[]... handlers);
    /**
         * A REPORT request is an extensible mechanism for obtaining information about a
         * resource. Unlike a resource property, which has a single value, the value of a
         * report can depend on additional information specified in the REPORT request
         * body and in the REPORT request headers.
         */
    native public Router report(RegExp[] path, ErrorHandler[]... handlers);
    /**
         * A REPORT request is an extensible mechanism for obtaining information about a
         * resource. Unlike a resource property, which has a single value, the value of a
         * report can depend on additional information specified in the REPORT request
         * body and in the REPORT request headers.
         */
    native public Router report(RegExp path, RequestHandler... handlers);
    /**
         * A REPORT request is an extensible mechanism for obtaining information about a
         * resource. Unlike a resource property, which has a single value, the value of a
         * report can depend on additional information specified in the REPORT request
         * body and in the REPORT request headers.
         */
    native public Router report(String path, ErrorHandler[]... handlers);
    /**
         * A REPORT request is an extensible mechanism for obtaining information about a
         * resource. Unlike a resource property, which has a single value, the value of a
         * report can depend on additional information specified in the REPORT request
         * body and in the REPORT request headers.
         */
    native public Router report(RegExp[] path, ErrorHandler... handlers);
    /**
         * A REPORT request is an extensible mechanism for obtaining information about a
         * resource. Unlike a resource property, which has a single value, the value of a
         * report can depend on additional information specified in the REPORT request
         * body and in the REPORT request headers.
         */
    native public Router report(RegExp[] path, RequestHandler... handlers);
    /**
         * A REPORT request is an extensible mechanism for obtaining information about a
         * resource. Unlike a resource property, which has a single value, the value of a
         * report can depend on additional information specified in the REPORT request
         * body and in the REPORT request headers.
         */
    native public Router report(RegExp path, ErrorHandler... handlers);
    /**
         * A REPORT request is an extensible mechanism for obtaining information about a
         * resource. Unlike a resource property, which has a single value, the value of a
         * report can depend on additional information specified in the REPORT request
         * body and in the REPORT request headers.
         */
    native public Router report(String[] path, ErrorHandler... handlers);
    /**
         * A REPORT request is an extensible mechanism for obtaining information about a
         * resource. Unlike a resource property, which has a single value, the value of a
         * report can depend on additional information specified in the REPORT request
         * body and in the REPORT request headers.
         */
    native public Router report(RegExp path, ErrorHandler[]... handlers);
    /**
         * A MKACTIVITY request creates a new activity resource. A server MAY restrict
         * activity creation to particular collections, but a client can determine the
         * location of these collections from a DAV:activity-collection-set OPTIONS
         * request.
         */
    native public Router mkactivity(String[] path, RequestHandler[]... handlers);
    /**
         * A MKACTIVITY request creates a new activity resource. A server MAY restrict
         * activity creation to particular collections, but a client can determine the
         * location of these collections from a DAV:activity-collection-set OPTIONS
         * request.
         */
    native public Router mkactivity(String path, RequestHandler[]... handlers);
    /**
         * A MKACTIVITY request creates a new activity resource. A server MAY restrict
         * activity creation to particular collections, but a client can determine the
         * location of these collections from a DAV:activity-collection-set OPTIONS
         * request.
         */
    native public Router mkactivity(String[] path, RequestHandler... handlers);
    /**
         * A MKACTIVITY request creates a new activity resource. A server MAY restrict
         * activity creation to particular collections, but a client can determine the
         * location of these collections from a DAV:activity-collection-set OPTIONS
         * request.
         */
    native public Router mkactivity(String[] path, ErrorHandler... handlers);
    /**
         * A MKACTIVITY request creates a new activity resource. A server MAY restrict
         * activity creation to particular collections, but a client can determine the
         * location of these collections from a DAV:activity-collection-set OPTIONS
         * request.
         */
    native public Router mkactivity(RegExp path, RequestHandler[]... handlers);
    /**
         * A MKACTIVITY request creates a new activity resource. A server MAY restrict
         * activity creation to particular collections, but a client can determine the
         * location of these collections from a DAV:activity-collection-set OPTIONS
         * request.
         */
    native public Router mkactivity(RegExp[] path, ErrorHandler[]... handlers);
    /**
         * A MKACTIVITY request creates a new activity resource. A server MAY restrict
         * activity creation to particular collections, but a client can determine the
         * location of these collections from a DAV:activity-collection-set OPTIONS
         * request.
         */
    native public Router mkactivity(String[] path, ErrorHandler[]... handlers);
    /**
         * A MKACTIVITY request creates a new activity resource. A server MAY restrict
         * activity creation to particular collections, but a client can determine the
         * location of these collections from a DAV:activity-collection-set OPTIONS
         * request.
         */
    native public Router mkactivity(RegExp[] path, RequestHandler... handlers);
    /**
         * A MKACTIVITY request creates a new activity resource. A server MAY restrict
         * activity creation to particular collections, but a client can determine the
         * location of these collections from a DAV:activity-collection-set OPTIONS
         * request.
         */
    native public Router mkactivity(RegExp path, ErrorHandler... handlers);
    /**
         * A MKACTIVITY request creates a new activity resource. A server MAY restrict
         * activity creation to particular collections, but a client can determine the
         * location of these collections from a DAV:activity-collection-set OPTIONS
         * request.
         */
    native public Router mkactivity(String path, ErrorHandler... handlers);
    /**
         * A MKACTIVITY request creates a new activity resource. A server MAY restrict
         * activity creation to particular collections, but a client can determine the
         * location of these collections from a DAV:activity-collection-set OPTIONS
         * request.
         */
    native public Router mkactivity(String path, ErrorHandler[]... handlers);
    /**
         * A MKACTIVITY request creates a new activity resource. A server MAY restrict
         * activity creation to particular collections, but a client can determine the
         * location of these collections from a DAV:activity-collection-set OPTIONS
         * request.
         */
    native public Router mkactivity(RegExp[] path, ErrorHandler... handlers);
    /**
         * A MKACTIVITY request creates a new activity resource. A server MAY restrict
         * activity creation to particular collections, but a client can determine the
         * location of these collections from a DAV:activity-collection-set OPTIONS
         * request.
         */
    native public Router mkactivity(RegExp path, RequestHandler... handlers);
    /**
         * A MKACTIVITY request creates a new activity resource. A server MAY restrict
         * activity creation to particular collections, but a client can determine the
         * location of these collections from a DAV:activity-collection-set OPTIONS
         * request.
         */
    native public Router mkactivity(RegExp[] path, RequestHandler[]... handlers);
    /**
         * A MKACTIVITY request creates a new activity resource. A server MAY restrict
         * activity creation to particular collections, but a client can determine the
         * location of these collections from a DAV:activity-collection-set OPTIONS
         * request.
         */
    native public Router mkactivity(RegExp path, ErrorHandler[]... handlers);
    /**
         * A CHECKOUT request can be applied to a checked-in version-controlled resource
         * to allow modifications to the content and dead properties of that
         * version-controlled resource.
         */
    native public Router checkout(String path, ErrorHandler[]... handlers);
    /**
         * A CHECKOUT request can be applied to a checked-in version-controlled resource
         * to allow modifications to the content and dead properties of that
         * version-controlled resource.
         */
    native public Router checkout(String[] path, RequestHandler[]... handlers);
    /**
         * A CHECKOUT request can be applied to a checked-in version-controlled resource
         * to allow modifications to the content and dead properties of that
         * version-controlled resource.
         */
    native public Router checkout(RegExp path, RequestHandler[]... handlers);
    /**
         * A CHECKOUT request can be applied to a checked-in version-controlled resource
         * to allow modifications to the content and dead properties of that
         * version-controlled resource.
         */
    native public Router checkout(String[] path, RequestHandler... handlers);
    /**
         * A CHECKOUT request can be applied to a checked-in version-controlled resource
         * to allow modifications to the content and dead properties of that
         * version-controlled resource.
         */
    native public Router checkout(RegExp path, ErrorHandler... handlers);
    /**
         * A CHECKOUT request can be applied to a checked-in version-controlled resource
         * to allow modifications to the content and dead properties of that
         * version-controlled resource.
         */
    native public Router checkout(String path, ErrorHandler... handlers);
    /**
         * A CHECKOUT request can be applied to a checked-in version-controlled resource
         * to allow modifications to the content and dead properties of that
         * version-controlled resource.
         */
    native public Router checkout(RegExp[] path, RequestHandler[]... handlers);
    /**
         * A CHECKOUT request can be applied to a checked-in version-controlled resource
         * to allow modifications to the content and dead properties of that
         * version-controlled resource.
         */
    native public Router checkout(String[] path, ErrorHandler[]... handlers);
    /**
         * A CHECKOUT request can be applied to a checked-in version-controlled resource
         * to allow modifications to the content and dead properties of that
         * version-controlled resource.
         */
    native public Router checkout(RegExp path, RequestHandler... handlers);
    /**
         * A CHECKOUT request can be applied to a checked-in version-controlled resource
         * to allow modifications to the content and dead properties of that
         * version-controlled resource.
         */
    native public Router checkout(RegExp[] path, ErrorHandler[]... handlers);
    /**
         * A CHECKOUT request can be applied to a checked-in version-controlled resource
         * to allow modifications to the content and dead properties of that
         * version-controlled resource.
         */
    native public Router checkout(String path, RequestHandler[]... handlers);
    /**
         * A CHECKOUT request can be applied to a checked-in version-controlled resource
         * to allow modifications to the content and dead properties of that
         * version-controlled resource.
         */
    native public Router checkout(RegExp path, ErrorHandler[]... handlers);
    /**
         * A CHECKOUT request can be applied to a checked-in version-controlled resource
         * to allow modifications to the content and dead properties of that
         * version-controlled resource.
         */
    native public Router checkout(RegExp[] path, RequestHandler... handlers);
    /**
         * A CHECKOUT request can be applied to a checked-in version-controlled resource
         * to allow modifications to the content and dead properties of that
         * version-controlled resource.
         */
    native public Router checkout(RegExp[] path, ErrorHandler... handlers);
    /**
         * A CHECKOUT request can be applied to a checked-in version-controlled resource
         * to allow modifications to the content and dead properties of that
         * version-controlled resource.
         */
    native public Router checkout(String[] path, ErrorHandler... handlers);
    /**
         * The MERGE method performs the logical merge of a specified version (the "merge
         * source") into a specified version-controlled resource (the "merge target").  If
         * the merge source is neither an ancestor nor a descendant of the DAV:checked-in
         * or DAV:checked-out version of the merge target, the MERGE checks out the merge
         * target (if it is not already checked out) and adds the URL of the merge source
         * to the DAV:merge-set of the merge target.
         */
    native public Router merge(RegExp path, ErrorHandler[]... handlers);
    /**
         * The MERGE method performs the logical merge of a specified version (the "merge
         * source") into a specified version-controlled resource (the "merge target").  If
         * the merge source is neither an ancestor nor a descendant of the DAV:checked-in
         * or DAV:checked-out version of the merge target, the MERGE checks out the merge
         * target (if it is not already checked out) and adds the URL of the merge source
         * to the DAV:merge-set of the merge target.
         */
    native public Router merge(RegExp path, ErrorHandler... handlers);
    /**
         * The MERGE method performs the logical merge of a specified version (the "merge
         * source") into a specified version-controlled resource (the "merge target").  If
         * the merge source is neither an ancestor nor a descendant of the DAV:checked-in
         * or DAV:checked-out version of the merge target, the MERGE checks out the merge
         * target (if it is not already checked out) and adds the URL of the merge source
         * to the DAV:merge-set of the merge target.
         */
    native public Router merge(String path, RequestHandler[]... handlers);
    /**
         * The MERGE method performs the logical merge of a specified version (the "merge
         * source") into a specified version-controlled resource (the "merge target").  If
         * the merge source is neither an ancestor nor a descendant of the DAV:checked-in
         * or DAV:checked-out version of the merge target, the MERGE checks out the merge
         * target (if it is not already checked out) and adds the URL of the merge source
         * to the DAV:merge-set of the merge target.
         */
    native public Router merge(String path, ErrorHandler... handlers);
    /**
         * The MERGE method performs the logical merge of a specified version (the "merge
         * source") into a specified version-controlled resource (the "merge target").  If
         * the merge source is neither an ancestor nor a descendant of the DAV:checked-in
         * or DAV:checked-out version of the merge target, the MERGE checks out the merge
         * target (if it is not already checked out) and adds the URL of the merge source
         * to the DAV:merge-set of the merge target.
         */
    native public Router merge(String[] path, RequestHandler[]... handlers);
    /**
         * The MERGE method performs the logical merge of a specified version (the "merge
         * source") into a specified version-controlled resource (the "merge target").  If
         * the merge source is neither an ancestor nor a descendant of the DAV:checked-in
         * or DAV:checked-out version of the merge target, the MERGE checks out the merge
         * target (if it is not already checked out) and adds the URL of the merge source
         * to the DAV:merge-set of the merge target.
         */
    native public Router merge(String[] path, ErrorHandler... handlers);
    /**
         * The MERGE method performs the logical merge of a specified version (the "merge
         * source") into a specified version-controlled resource (the "merge target").  If
         * the merge source is neither an ancestor nor a descendant of the DAV:checked-in
         * or DAV:checked-out version of the merge target, the MERGE checks out the merge
         * target (if it is not already checked out) and adds the URL of the merge source
         * to the DAV:merge-set of the merge target.
         */
    native public Router merge(RegExp path, RequestHandler[]... handlers);
    /**
         * The MERGE method performs the logical merge of a specified version (the "merge
         * source") into a specified version-controlled resource (the "merge target").  If
         * the merge source is neither an ancestor nor a descendant of the DAV:checked-in
         * or DAV:checked-out version of the merge target, the MERGE checks out the merge
         * target (if it is not already checked out) and adds the URL of the merge source
         * to the DAV:merge-set of the merge target.
         */
    native public Router merge(RegExp[] path, ErrorHandler... handlers);
    /**
         * The MERGE method performs the logical merge of a specified version (the "merge
         * source") into a specified version-controlled resource (the "merge target").  If
         * the merge source is neither an ancestor nor a descendant of the DAV:checked-in
         * or DAV:checked-out version of the merge target, the MERGE checks out the merge
         * target (if it is not already checked out) and adds the URL of the merge source
         * to the DAV:merge-set of the merge target.
         */
    native public Router merge(String path, ErrorHandler[]... handlers);
    /**
         * The MERGE method performs the logical merge of a specified version (the "merge
         * source") into a specified version-controlled resource (the "merge target").  If
         * the merge source is neither an ancestor nor a descendant of the DAV:checked-in
         * or DAV:checked-out version of the merge target, the MERGE checks out the merge
         * target (if it is not already checked out) and adds the URL of the merge source
         * to the DAV:merge-set of the merge target.
         */
    native public Router merge(RegExp[] path, ErrorHandler[]... handlers);
    /**
         * The MERGE method performs the logical merge of a specified version (the "merge
         * source") into a specified version-controlled resource (the "merge target").  If
         * the merge source is neither an ancestor nor a descendant of the DAV:checked-in
         * or DAV:checked-out version of the merge target, the MERGE checks out the merge
         * target (if it is not already checked out) and adds the URL of the merge source
         * to the DAV:merge-set of the merge target.
         */
    native public Router merge(RegExp path, RequestHandler... handlers);
    /**
         * The MERGE method performs the logical merge of a specified version (the "merge
         * source") into a specified version-controlled resource (the "merge target").  If
         * the merge source is neither an ancestor nor a descendant of the DAV:checked-in
         * or DAV:checked-out version of the merge target, the MERGE checks out the merge
         * target (if it is not already checked out) and adds the URL of the merge source
         * to the DAV:merge-set of the merge target.
         */
    native public Router merge(RegExp[] path, RequestHandler... handlers);
    /**
         * The MERGE method performs the logical merge of a specified version (the "merge
         * source") into a specified version-controlled resource (the "merge target").  If
         * the merge source is neither an ancestor nor a descendant of the DAV:checked-in
         * or DAV:checked-out version of the merge target, the MERGE checks out the merge
         * target (if it is not already checked out) and adds the URL of the merge source
         * to the DAV:merge-set of the merge target.
         */
    native public Router merge(RegExp[] path, RequestHandler[]... handlers);
    /**
         * The MERGE method performs the logical merge of a specified version (the "merge
         * source") into a specified version-controlled resource (the "merge target").  If
         * the merge source is neither an ancestor nor a descendant of the DAV:checked-in
         * or DAV:checked-out version of the merge target, the MERGE checks out the merge
         * target (if it is not already checked out) and adds the URL of the merge source
         * to the DAV:merge-set of the merge target.
         */
    native public Router merge(String[] path, ErrorHandler[]... handlers);
    /**
         * The MERGE method performs the logical merge of a specified version (the "merge
         * source") into a specified version-controlled resource (the "merge target").  If
         * the merge source is neither an ancestor nor a descendant of the DAV:checked-in
         * or DAV:checked-out version of the merge target, the MERGE checks out the merge
         * target (if it is not already checked out) and adds the URL of the merge source
         * to the DAV:merge-set of the merge target.
         */
    native public Router merge(String[] path, RequestHandler... handlers);
    /**
         * a HTTP SEARCH method enhanced with the ssdp:discover functionality will be
         * referred to as a ssdp:discover request.
         */
    @jsweet.lang.Name("m-search")
    native public Router m_search(RegExp[] path, RequestHandler... handlers);
    /**
         * a HTTP SEARCH method enhanced with the ssdp:discover functionality will be
         * referred to as a ssdp:discover request.
         */
    @jsweet.lang.Name("m-search")
    native public Router m_search(RegExp[] path, ErrorHandler[]... handlers);
    /**
         * a HTTP SEARCH method enhanced with the ssdp:discover functionality will be
         * referred to as a ssdp:discover request.
         */
    @jsweet.lang.Name("m-search")
    native public Router m_search(RegExp path, ErrorHandler... handlers);
    /**
         * a HTTP SEARCH method enhanced with the ssdp:discover functionality will be
         * referred to as a ssdp:discover request.
         */
    @jsweet.lang.Name("m-search")
    native public Router m_search(String path, ErrorHandler[]... handlers);
    /**
         * a HTTP SEARCH method enhanced with the ssdp:discover functionality will be
         * referred to as a ssdp:discover request.
         */
    @jsweet.lang.Name("m-search")
    native public Router m_search(String[] path, ErrorHandler... handlers);
    /**
         * a HTTP SEARCH method enhanced with the ssdp:discover functionality will be
         * referred to as a ssdp:discover request.
         */
    @jsweet.lang.Name("m-search")
    native public Router m_search(RegExp path, RequestHandler[]... handlers);
    /**
         * a HTTP SEARCH method enhanced with the ssdp:discover functionality will be
         * referred to as a ssdp:discover request.
         */
    @jsweet.lang.Name("m-search")
    native public Router m_search(RegExp path, RequestHandler... handlers);
    /**
         * a HTTP SEARCH method enhanced with the ssdp:discover functionality will be
         * referred to as a ssdp:discover request.
         */
    @jsweet.lang.Name("m-search")
    native public Router m_search(String[] path, RequestHandler[]... handlers);
    /**
         * a HTTP SEARCH method enhanced with the ssdp:discover functionality will be
         * referred to as a ssdp:discover request.
         */
    @jsweet.lang.Name("m-search")
    native public Router m_search(RegExp path, ErrorHandler[]... handlers);
    /**
         * a HTTP SEARCH method enhanced with the ssdp:discover functionality will be
         * referred to as a ssdp:discover request.
         */
    @jsweet.lang.Name("m-search")
    native public Router m_search(RegExp[] path, ErrorHandler... handlers);
    /**
         * a HTTP SEARCH method enhanced with the ssdp:discover functionality will be
         * referred to as a ssdp:discover request.
         */
    @jsweet.lang.Name("m-search")
    native public Router m_search(String[] path, ErrorHandler[]... handlers);
    /**
         * a HTTP SEARCH method enhanced with the ssdp:discover functionality will be
         * referred to as a ssdp:discover request.
         */
    @jsweet.lang.Name("m-search")
    native public Router m_search(RegExp[] path, RequestHandler[]... handlers);
    /**
         * a HTTP SEARCH method enhanced with the ssdp:discover functionality will be
         * referred to as a ssdp:discover request.
         */
    @jsweet.lang.Name("m-search")
    native public Router m_search(String[] path, RequestHandler... handlers);
    /**
         * a HTTP SEARCH method enhanced with the ssdp:discover functionality will be
         * referred to as a ssdp:discover request.
         */
    @jsweet.lang.Name("m-search")
    native public Router m_search(String path, ErrorHandler... handlers);
    /**
         * a HTTP SEARCH method enhanced with the ssdp:discover functionality will be
         * referred to as a ssdp:discover request.
         */
    @jsweet.lang.Name("m-search")
    native public Router m_search(String path, RequestHandler[]... handlers);
    /**
         *  The WebDAV NOTIFY method is called by the server whenever an event that the
         *  client has subscribed to fires. The NOTIFY method will send User Datagram
         *  Protocol (UDP) packets to the client until the subscription has timed out. The
         *  subscription to the resource will persist after the notification is sent by
         *  the server.
         */
    native public Router notify(String path, RequestHandler[]... handlers);
    /**
         *  The WebDAV NOTIFY method is called by the server whenever an event that the
         *  client has subscribed to fires. The NOTIFY method will send User Datagram
         *  Protocol (UDP) packets to the client until the subscription has timed out. The
         *  subscription to the resource will persist after the notification is sent by
         *  the server.
         */
    native public Router notify(String[] path, ErrorHandler[]... handlers);
    /**
         *  The WebDAV NOTIFY method is called by the server whenever an event that the
         *  client has subscribed to fires. The NOTIFY method will send User Datagram
         *  Protocol (UDP) packets to the client until the subscription has timed out. The
         *  subscription to the resource will persist after the notification is sent by
         *  the server.
         */
    native public Router notify(RegExp[] path, ErrorHandler... handlers);
    /**
         *  The WebDAV NOTIFY method is called by the server whenever an event that the
         *  client has subscribed to fires. The NOTIFY method will send User Datagram
         *  Protocol (UDP) packets to the client until the subscription has timed out. The
         *  subscription to the resource will persist after the notification is sent by
         *  the server.
         */
    native public Router notify(String[] path, RequestHandler... handlers);
    /**
         *  The WebDAV NOTIFY method is called by the server whenever an event that the
         *  client has subscribed to fires. The NOTIFY method will send User Datagram
         *  Protocol (UDP) packets to the client until the subscription has timed out. The
         *  subscription to the resource will persist after the notification is sent by
         *  the server.
         */
    native public Router notify(RegExp[] path, RequestHandler[]... handlers);
    /**
         *  The WebDAV NOTIFY method is called by the server whenever an event that the
         *  client has subscribed to fires. The NOTIFY method will send User Datagram
         *  Protocol (UDP) packets to the client until the subscription has timed out. The
         *  subscription to the resource will persist after the notification is sent by
         *  the server.
         */
    native public Router notify(String[] path, RequestHandler[]... handlers);
    /**
         *  The WebDAV NOTIFY method is called by the server whenever an event that the
         *  client has subscribed to fires. The NOTIFY method will send User Datagram
         *  Protocol (UDP) packets to the client until the subscription has timed out. The
         *  subscription to the resource will persist after the notification is sent by
         *  the server.
         */
    native public Router notify(String path, ErrorHandler... handlers);
    /**
         *  The WebDAV NOTIFY method is called by the server whenever an event that the
         *  client has subscribed to fires. The NOTIFY method will send User Datagram
         *  Protocol (UDP) packets to the client until the subscription has timed out. The
         *  subscription to the resource will persist after the notification is sent by
         *  the server.
         */
    native public Router notify(RegExp[] path, ErrorHandler[]... handlers);
    /**
         *  The WebDAV NOTIFY method is called by the server whenever an event that the
         *  client has subscribed to fires. The NOTIFY method will send User Datagram
         *  Protocol (UDP) packets to the client until the subscription has timed out. The
         *  subscription to the resource will persist after the notification is sent by
         *  the server.
         */
    native public Router notify(String[] path, ErrorHandler... handlers);
    /**
         *  The WebDAV NOTIFY method is called by the server whenever an event that the
         *  client has subscribed to fires. The NOTIFY method will send User Datagram
         *  Protocol (UDP) packets to the client until the subscription has timed out. The
         *  subscription to the resource will persist after the notification is sent by
         *  the server.
         */
    native public Router notify(RegExp path, ErrorHandler[]... handlers);
    /**
         *  The WebDAV NOTIFY method is called by the server whenever an event that the
         *  client has subscribed to fires. The NOTIFY method will send User Datagram
         *  Protocol (UDP) packets to the client until the subscription has timed out. The
         *  subscription to the resource will persist after the notification is sent by
         *  the server.
         */
    native public Router notify(RegExp path, RequestHandler... handlers);
    /**
         *  The WebDAV NOTIFY method is called by the server whenever an event that the
         *  client has subscribed to fires. The NOTIFY method will send User Datagram
         *  Protocol (UDP) packets to the client until the subscription has timed out. The
         *  subscription to the resource will persist after the notification is sent by
         *  the server.
         */
    native public Router notify(RegExp path, ErrorHandler... handlers);
    /**
         *  The WebDAV NOTIFY method is called by the server whenever an event that the
         *  client has subscribed to fires. The NOTIFY method will send User Datagram
         *  Protocol (UDP) packets to the client until the subscription has timed out. The
         *  subscription to the resource will persist after the notification is sent by
         *  the server.
         */
    native public Router notify(RegExp path, RequestHandler[]... handlers);
    /**
         *  The WebDAV NOTIFY method is called by the server whenever an event that the
         *  client has subscribed to fires. The NOTIFY method will send User Datagram
         *  Protocol (UDP) packets to the client until the subscription has timed out. The
         *  subscription to the resource will persist after the notification is sent by
         *  the server.
         */
    native public Router notify(String path, ErrorHandler[]... handlers);
    /**
         *  The WebDAV NOTIFY method is called by the server whenever an event that the
         *  client has subscribed to fires. The NOTIFY method will send User Datagram
         *  Protocol (UDP) packets to the client until the subscription has timed out. The
         *  subscription to the resource will persist after the notification is sent by
         *  the server.
         */
    native public Router notify(RegExp[] path, RequestHandler... handlers);
    /**
         * The WebDAV SUBSCRIBE method is used to create a subscription to a resource.
         * This method is used to specify the details about the event to be monitored:
         * where to look for it; how long the event should be monitored; what the
         * notification mechanism is; and how long to delay before generating a
         * notification of the event.
         */
    native public Router subscribe(RegExp[] path, ErrorHandler[]... handlers);
    /**
         * The WebDAV SUBSCRIBE method is used to create a subscription to a resource.
         * This method is used to specify the details about the event to be monitored:
         * where to look for it; how long the event should be monitored; what the
         * notification mechanism is; and how long to delay before generating a
         * notification of the event.
         */
    native public Router subscribe(RegExp path, ErrorHandler[]... handlers);
    /**
         * The WebDAV SUBSCRIBE method is used to create a subscription to a resource.
         * This method is used to specify the details about the event to be monitored:
         * where to look for it; how long the event should be monitored; what the
         * notification mechanism is; and how long to delay before generating a
         * notification of the event.
         */
    native public Router subscribe(String[] path, RequestHandler... handlers);
    /**
         * The WebDAV SUBSCRIBE method is used to create a subscription to a resource.
         * This method is used to specify the details about the event to be monitored:
         * where to look for it; how long the event should be monitored; what the
         * notification mechanism is; and how long to delay before generating a
         * notification of the event.
         */
    native public Router subscribe(RegExp path, RequestHandler... handlers);
    /**
         * The WebDAV SUBSCRIBE method is used to create a subscription to a resource.
         * This method is used to specify the details about the event to be monitored:
         * where to look for it; how long the event should be monitored; what the
         * notification mechanism is; and how long to delay before generating a
         * notification of the event.
         */
    native public Router subscribe(String path, ErrorHandler... handlers);
    /**
         * The WebDAV SUBSCRIBE method is used to create a subscription to a resource.
         * This method is used to specify the details about the event to be monitored:
         * where to look for it; how long the event should be monitored; what the
         * notification mechanism is; and how long to delay before generating a
         * notification of the event.
         */
    native public Router subscribe(String[] path, RequestHandler[]... handlers);
    /**
         * The WebDAV SUBSCRIBE method is used to create a subscription to a resource.
         * This method is used to specify the details about the event to be monitored:
         * where to look for it; how long the event should be monitored; what the
         * notification mechanism is; and how long to delay before generating a
         * notification of the event.
         */
    native public Router subscribe(String[] path, ErrorHandler[]... handlers);
    /**
         * The WebDAV SUBSCRIBE method is used to create a subscription to a resource.
         * This method is used to specify the details about the event to be monitored:
         * where to look for it; how long the event should be monitored; what the
         * notification mechanism is; and how long to delay before generating a
         * notification of the event.
         */
    native public Router subscribe(String path, ErrorHandler[]... handlers);
    /**
         * The WebDAV SUBSCRIBE method is used to create a subscription to a resource.
         * This method is used to specify the details about the event to be monitored:
         * where to look for it; how long the event should be monitored; what the
         * notification mechanism is; and how long to delay before generating a
         * notification of the event.
         */
    native public Router subscribe(String[] path, ErrorHandler... handlers);
    /**
         * The WebDAV SUBSCRIBE method is used to create a subscription to a resource.
         * This method is used to specify the details about the event to be monitored:
         * where to look for it; how long the event should be monitored; what the
         * notification mechanism is; and how long to delay before generating a
         * notification of the event.
         */
    native public Router subscribe(RegExp[] path, RequestHandler[]... handlers);
    /**
         * The WebDAV SUBSCRIBE method is used to create a subscription to a resource.
         * This method is used to specify the details about the event to be monitored:
         * where to look for it; how long the event should be monitored; what the
         * notification mechanism is; and how long to delay before generating a
         * notification of the event.
         */
    native public Router subscribe(RegExp[] path, ErrorHandler... handlers);
    /**
         * The WebDAV SUBSCRIBE method is used to create a subscription to a resource.
         * This method is used to specify the details about the event to be monitored:
         * where to look for it; how long the event should be monitored; what the
         * notification mechanism is; and how long to delay before generating a
         * notification of the event.
         */
    native public Router subscribe(RegExp path, RequestHandler[]... handlers);
    /**
         * The WebDAV SUBSCRIBE method is used to create a subscription to a resource.
         * This method is used to specify the details about the event to be monitored:
         * where to look for it; how long the event should be monitored; what the
         * notification mechanism is; and how long to delay before generating a
         * notification of the event.
         */
    native public Router subscribe(String path, RequestHandler[]... handlers);
    /**
         * The WebDAV SUBSCRIBE method is used to create a subscription to a resource.
         * This method is used to specify the details about the event to be monitored:
         * where to look for it; how long the event should be monitored; what the
         * notification mechanism is; and how long to delay before generating a
         * notification of the event.
         */
    native public Router subscribe(RegExp path, ErrorHandler... handlers);
    /**
         * The WebDAV SUBSCRIBE method is used to create a subscription to a resource.
         * This method is used to specify the details about the event to be monitored:
         * where to look for it; how long the event should be monitored; what the
         * notification mechanism is; and how long to delay before generating a
         * notification of the event.
         */
    native public Router subscribe(RegExp[] path, RequestHandler... handlers);
    /**
         * The WebDAV UNSUBSCRIBE method is used to end a subscription to a resource.
         */
    native public Router unsubscribe(RegExp path, ErrorHandler... handlers);
    /**
         * The WebDAV UNSUBSCRIBE method is used to end a subscription to a resource.
         */
    native public Router unsubscribe(RegExp path, ErrorHandler[]... handlers);
    /**
         * The WebDAV UNSUBSCRIBE method is used to end a subscription to a resource.
         */
    native public Router unsubscribe(String path, ErrorHandler... handlers);
    /**
         * The WebDAV UNSUBSCRIBE method is used to end a subscription to a resource.
         */
    native public Router unsubscribe(String[] path, ErrorHandler... handlers);
    /**
         * The WebDAV UNSUBSCRIBE method is used to end a subscription to a resource.
         */
    native public Router unsubscribe(RegExp path, RequestHandler[]... handlers);
    /**
         * The WebDAV UNSUBSCRIBE method is used to end a subscription to a resource.
         */
    native public Router unsubscribe(RegExp path, RequestHandler... handlers);
    /**
         * The WebDAV UNSUBSCRIBE method is used to end a subscription to a resource.
         */
    native public Router unsubscribe(String[] path, RequestHandler[]... handlers);
    /**
         * The WebDAV UNSUBSCRIBE method is used to end a subscription to a resource.
         */
    native public Router unsubscribe(String[] path, ErrorHandler[]... handlers);
    /**
         * The WebDAV UNSUBSCRIBE method is used to end a subscription to a resource.
         */
    native public Router unsubscribe(RegExp[] path, ErrorHandler... handlers);
    /**
         * The WebDAV UNSUBSCRIBE method is used to end a subscription to a resource.
         */
    native public Router unsubscribe(String path, ErrorHandler[]... handlers);
    /**
         * The WebDAV UNSUBSCRIBE method is used to end a subscription to a resource.
         */
    native public Router unsubscribe(RegExp[] path, RequestHandler... handlers);
    /**
         * The WebDAV UNSUBSCRIBE method is used to end a subscription to a resource.
         */
    native public Router unsubscribe(RegExp[] path, ErrorHandler[]... handlers);
    /**
         * The WebDAV UNSUBSCRIBE method is used to end a subscription to a resource.
         */
    native public Router unsubscribe(String[] path, RequestHandler... handlers);
    /**
         * The WebDAV UNSUBSCRIBE method is used to end a subscription to a resource.
         */
    native public Router unsubscribe(RegExp[] path, RequestHandler[]... handlers);
    /**
         * The WebDAV UNSUBSCRIBE method is used to end a subscription to a resource.
         */
    native public Router unsubscribe(String path, RequestHandler[]... handlers);
    /**
         * The PATCH method requests that a set of changes described in the request entity
         * be applied to the resource identified by the Request- URI. The set of changes
         * is represented in a format called a "patch document" identified by a media
         * type.
         */
    native public Router patch(RegExp path, RequestHandler[]... handlers);
    /**
         * The PATCH method requests that a set of changes described in the request entity
         * be applied to the resource identified by the Request- URI. The set of changes
         * is represented in a format called a "patch document" identified by a media
         * type.
         */
    native public Router patch(RegExp path, ErrorHandler... handlers);
    /**
         * The PATCH method requests that a set of changes described in the request entity
         * be applied to the resource identified by the Request- URI. The set of changes
         * is represented in a format called a "patch document" identified by a media
         * type.
         */
    native public Router patch(RegExp path, RequestHandler... handlers);
    /**
         * The PATCH method requests that a set of changes described in the request entity
         * be applied to the resource identified by the Request- URI. The set of changes
         * is represented in a format called a "patch document" identified by a media
         * type.
         */
    native public Router patch(String[] path, ErrorHandler[]... handlers);
    /**
         * The PATCH method requests that a set of changes described in the request entity
         * be applied to the resource identified by the Request- URI. The set of changes
         * is represented in a format called a "patch document" identified by a media
         * type.
         */
    native public Router patch(String[] path, ErrorHandler... handlers);
    /**
         * The PATCH method requests that a set of changes described in the request entity
         * be applied to the resource identified by the Request- URI. The set of changes
         * is represented in a format called a "patch document" identified by a media
         * type.
         */
    native public Router patch(String path, ErrorHandler[]... handlers);
    /**
         * The PATCH method requests that a set of changes described in the request entity
         * be applied to the resource identified by the Request- URI. The set of changes
         * is represented in a format called a "patch document" identified by a media
         * type.
         */
    native public Router patch(String[] path, RequestHandler... handlers);
    /**
         * The PATCH method requests that a set of changes described in the request entity
         * be applied to the resource identified by the Request- URI. The set of changes
         * is represented in a format called a "patch document" identified by a media
         * type.
         */
    native public Router patch(String path, RequestHandler[]... handlers);
    /**
         * The PATCH method requests that a set of changes described in the request entity
         * be applied to the resource identified by the Request- URI. The set of changes
         * is represented in a format called a "patch document" identified by a media
         * type.
         */
    native public Router patch(RegExp[] path, RequestHandler[]... handlers);
    /**
         * The PATCH method requests that a set of changes described in the request entity
         * be applied to the resource identified by the Request- URI. The set of changes
         * is represented in a format called a "patch document" identified by a media
         * type.
         */
    native public Router patch(RegExp[] path, ErrorHandler[]... handlers);
    /**
         * The PATCH method requests that a set of changes described in the request entity
         * be applied to the resource identified by the Request- URI. The set of changes
         * is represented in a format called a "patch document" identified by a media
         * type.
         */
    native public Router patch(RegExp[] path, ErrorHandler... handlers);
    /**
         * The PATCH method requests that a set of changes described in the request entity
         * be applied to the resource identified by the Request- URI. The set of changes
         * is represented in a format called a "patch document" identified by a media
         * type.
         */
    native public Router patch(String path, ErrorHandler... handlers);
    /**
         * The PATCH method requests that a set of changes described in the request entity
         * be applied to the resource identified by the Request- URI. The set of changes
         * is represented in a format called a "patch document" identified by a media
         * type.
         */
    native public Router patch(RegExp path, ErrorHandler[]... handlers);
    /**
         * The PATCH method requests that a set of changes described in the request entity
         * be applied to the resource identified by the Request- URI. The set of changes
         * is represented in a format called a "patch document" identified by a media
         * type.
         */
    native public Router patch(RegExp[] path, RequestHandler... handlers);
    /**
         * The PATCH method requests that a set of changes described in the request entity
         * be applied to the resource identified by the Request- URI. The set of changes
         * is represented in a format called a "patch document" identified by a media
         * type.
         */
    native public Router patch(String[] path, RequestHandler[]... handlers);
    /**
         * The client invokes the SEARCH method to initiate a server-side search. The body
         * of the request defines the query. The server MUST emit an entity matching the
         * RFC2518 PROPFIND response.
         */
    native public Router search(RegExp[] path, RequestHandler... handlers);
    /**
         * The client invokes the SEARCH method to initiate a server-side search. The body
         * of the request defines the query. The server MUST emit an entity matching the
         * RFC2518 PROPFIND response.
         */
    native public Router search(RegExp[] path, ErrorHandler... handlers);
    /**
         * The client invokes the SEARCH method to initiate a server-side search. The body
         * of the request defines the query. The server MUST emit an entity matching the
         * RFC2518 PROPFIND response.
         */
    native public Router search(String[] path, ErrorHandler... handlers);
    /**
         * The client invokes the SEARCH method to initiate a server-side search. The body
         * of the request defines the query. The server MUST emit an entity matching the
         * RFC2518 PROPFIND response.
         */
    native public Router search(RegExp path, RequestHandler... handlers);
    /**
         * The client invokes the SEARCH method to initiate a server-side search. The body
         * of the request defines the query. The server MUST emit an entity matching the
         * RFC2518 PROPFIND response.
         */
    native public Router search(String[] path, ErrorHandler[]... handlers);
    /**
         * The client invokes the SEARCH method to initiate a server-side search. The body
         * of the request defines the query. The server MUST emit an entity matching the
         * RFC2518 PROPFIND response.
         */
    native public Router search(RegExp path, RequestHandler[]... handlers);
    /**
         * The client invokes the SEARCH method to initiate a server-side search. The body
         * of the request defines the query. The server MUST emit an entity matching the
         * RFC2518 PROPFIND response.
         */
    native public Router search(String path, ErrorHandler... handlers);
    /**
         * The client invokes the SEARCH method to initiate a server-side search. The body
         * of the request defines the query. The server MUST emit an entity matching the
         * RFC2518 PROPFIND response.
         */
    native public Router search(RegExp path, ErrorHandler... handlers);
    /**
         * The client invokes the SEARCH method to initiate a server-side search. The body
         * of the request defines the query. The server MUST emit an entity matching the
         * RFC2518 PROPFIND response.
         */
    native public Router search(RegExp path, ErrorHandler[]... handlers);
    /**
         * The client invokes the SEARCH method to initiate a server-side search. The body
         * of the request defines the query. The server MUST emit an entity matching the
         * RFC2518 PROPFIND response.
         */
    native public Router search(String[] path, RequestHandler[]... handlers);
    /**
         * The client invokes the SEARCH method to initiate a server-side search. The body
         * of the request defines the query. The server MUST emit an entity matching the
         * RFC2518 PROPFIND response.
         */
    native public Router search(String path, RequestHandler[]... handlers);
    /**
         * The client invokes the SEARCH method to initiate a server-side search. The body
         * of the request defines the query. The server MUST emit an entity matching the
         * RFC2518 PROPFIND response.
         */
    native public Router search(String[] path, RequestHandler... handlers);
    /**
         * The client invokes the SEARCH method to initiate a server-side search. The body
         * of the request defines the query. The server MUST emit an entity matching the
         * RFC2518 PROPFIND response.
         */
    native public Router search(RegExp[] path, RequestHandler[]... handlers);
    /**
         * The client invokes the SEARCH method to initiate a server-side search. The body
         * of the request defines the query. The server MUST emit an entity matching the
         * RFC2518 PROPFIND response.
         */
    native public Router search(String path, ErrorHandler[]... handlers);
    /**
         * The client invokes the SEARCH method to initiate a server-side search. The body
         * of the request defines the query. The server MUST emit an entity matching the
         * RFC2518 PROPFIND response.
         */
    native public Router search(RegExp[] path, ErrorHandler[]... handlers);
    /**
         * This specification reserves the method name CONNECT for use with a proxy that
         * can dynamically switch to being a tunnel (e.g. SSL tunneling).
         */
    native public Router connect(RegExp[] path, ErrorHandler... handlers);
    /**
         * This specification reserves the method name CONNECT for use with a proxy that
         * can dynamically switch to being a tunnel (e.g. SSL tunneling).
         */
    native public Router connect(String path, ErrorHandler... handlers);
    /**
         * This specification reserves the method name CONNECT for use with a proxy that
         * can dynamically switch to being a tunnel (e.g. SSL tunneling).
         */
    native public Router connect(RegExp path, RequestHandler[]... handlers);
    /**
         * This specification reserves the method name CONNECT for use with a proxy that
         * can dynamically switch to being a tunnel (e.g. SSL tunneling).
         */
    native public Router connect(RegExp path, ErrorHandler[]... handlers);
    /**
         * This specification reserves the method name CONNECT for use with a proxy that
         * can dynamically switch to being a tunnel (e.g. SSL tunneling).
         */
    native public Router connect(RegExp[] path, RequestHandler[]... handlers);
    /**
         * This specification reserves the method name CONNECT for use with a proxy that
         * can dynamically switch to being a tunnel (e.g. SSL tunneling).
         */
    native public Router connect(String[] path, RequestHandler[]... handlers);
    /**
         * This specification reserves the method name CONNECT for use with a proxy that
         * can dynamically switch to being a tunnel (e.g. SSL tunneling).
         */
    native public Router connect(String[] path, ErrorHandler[]... handlers);
    /**
         * This specification reserves the method name CONNECT for use with a proxy that
         * can dynamically switch to being a tunnel (e.g. SSL tunneling).
         */
    native public Router connect(RegExp[] path, ErrorHandler[]... handlers);
    /**
         * This specification reserves the method name CONNECT for use with a proxy that
         * can dynamically switch to being a tunnel (e.g. SSL tunneling).
         */
    native public Router connect(String path, RequestHandler[]... handlers);
    /**
         * This specification reserves the method name CONNECT for use with a proxy that
         * can dynamically switch to being a tunnel (e.g. SSL tunneling).
         */
    native public Router connect(RegExp path, ErrorHandler... handlers);
    /**
         * This specification reserves the method name CONNECT for use with a proxy that
         * can dynamically switch to being a tunnel (e.g. SSL tunneling).
         */
    native public Router connect(String[] path, RequestHandler... handlers);
    /**
         * This specification reserves the method name CONNECT for use with a proxy that
         * can dynamically switch to being a tunnel (e.g. SSL tunneling).
         */
    native public Router connect(RegExp[] path, RequestHandler... handlers);
    /**
         * This specification reserves the method name CONNECT for use with a proxy that
         * can dynamically switch to being a tunnel (e.g. SSL tunneling).
         */
    native public Router connect(String path, ErrorHandler[]... handlers);
    /**
         * This specification reserves the method name CONNECT for use with a proxy that
         * can dynamically switch to being a tunnel (e.g. SSL tunneling).
         */
    native public Router connect(String[] path, ErrorHandler... handlers);
    /**
         * This specification reserves the method name CONNECT for use with a proxy that
         * can dynamically switch to being a tunnel (e.g. SSL tunneling).
         */
    native public Router connect(RegExp path, RequestHandler... handlers);
    native public Router use(ErrorHandler... handlers);
    native public Router use(ErrorHandler[]... handlers);
    native public Router use(RequestHandler[]... handlers);
    native public Router use(String mountPoint, ErrorHandler[]... handlers);
    native public Router use(RegExp[] mountPoint, RequestHandler[]... handlers);
    native public Router use(String mountPoint, RequestHandler[]... handlers);
    native public Router use(String[] mountPoint, RequestHandler[]... handlers);
    native public Router use(String[] mountPoint, ErrorHandler... handlers);
    native public Router use(RegExp mountPoint, ErrorHandler... handlers);
    native public Router use(RegExp[] mountPoint, ErrorHandler[]... handlers);
    native public Router use(RegExp mountPoint, RequestHandler[]... handlers);
    native public Router use(String[] mountPoint, RequestHandler... handlers);
    native public Router use(String[] mountPoint, ErrorHandler[]... handlers);
    native public Router use(RegExp mountPoint, ErrorHandler[]... handlers);
    native public Router use(RegExp[] mountPoint, RequestHandler... handlers);
    native public Router use(RegExp[] mountPoint, ErrorHandler... handlers);
    native public Router use(RegExp mountPoint, RequestHandler... handlers);
    native public Router use(String mountPoint, ErrorHandler... handlers);
    native public Route route(RegExp[] prefix);
    native public Route route(String[] prefix);
    native public Route route(RegExp prefix);
}

