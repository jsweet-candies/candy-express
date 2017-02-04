package def.modules.express.express_lib_response;
import def.js.Error;
import def.modules.express.express_lib_application.Application;
import def.node.Buffer;
@jsweet.lang.Interface
public abstract class Response extends def.js.Object {
    public Application app;
    public Object locals;
    public String charset;
    /** Property indicating if HTTP headers has been sent for the response. */
    public Boolean headersSent;
    /**
         * Set status `code`.
         */
    native public Response status(double code);
    /**
         * Set the response HTTP status code to `statusCode` and send its string representation as the response body.
         *
         * Examples:
         *
         *    res.sendStatus(200); // equivalent to res.status(200).send('OK')
         *    res.sendStatus(403); // equivalent to res.status(403).send('Forbidden')
         *    res.sendStatus(404); // equivalent to res.status(404).send('Not Found')
         *    res.sendStatus(500); // equivalent to res.status(500).send('Internal Server Error')
         */
    native public Response sendStatus(double code);
    /**
         * Set Link header field with the given `links`.
         *
         * Examples:
         *
         *    res.links({
         *      next: 'http://api.example.com/users?page=2',
         *      last: 'http://api.example.com/users?page=5'
         *    });
         */
    native public Response links(Object links);
    /**
         * Send a response.
         *
         * Examples:
         *
         *     res.send(new Buffer('wahoo'));
         *     res.send({ some: 'json' });
         *     res.send('<p>some html</p>');
         *     res.send(404, 'Sorry, cant find that');
         *     res.send(404);
         */
    native public Response send(String body);
    /**
         * Send JSON response.
         *
         * Examples:
         *
         *     res.json(null);
         *     res.json({ user: 'tj' });
         *     res.json(500, 'oh noes!');
         *     res.json(404, 'I dont have that');
         */
    native public Response json(Object obj);
    /**
         * Send JSON response with JSONP callback support.
         *
         * Examples:
         *
         *     res.jsonp(null);
         *     res.jsonp({ user: 'tj' });
         *     res.jsonp(500, 'oh noes!');
         *     res.jsonp(404, 'I dont have that');
         */
    native public Response jsonp(Object obj);
    /**
         * Transfer the file at the given `path`.
         *
         * Automatically sets the _Content-Type_ response header field.
         * The callback `fn(err)` is invoked when the transfer is complete
         * or when an error occurs. Be sure to check `res.sentHeader`
         * if you wish to attempt responding, as the header and some data
         * may have already been transferred.
         *
         * Options:
         *
         *   - `maxAge`   defaulting to 0 (can be string converted by `ms`)
         *   - `root`     root directory for relative filenames
         *   - `headers`  object of headers to serve with file
         *   - `dotfiles` serve dotfiles, defaulting to false; can be `"allow"` to send them
         *
         * Other options are passed along to `send`.
         *
         * Examples:
         *
         *  The following example illustrates how `res.sendFile()` may
         *  be used as an alternative for the `static()` middleware for
         *  dynamic situations. The code backing `res.sendFile()` is actually
         *  the same code, so HTTP cache support etc is identical.
         *
         *     app.get('/user/:uid/photos/:file', function(req, res){
         *       var uid = req.params.uid
         *         , file = req.params.file;
         *
         *       req.user.mayViewFilesFrom(uid, function(yes){
         *         if (yes) {
         *           res.sendFile('/uploads/' + uid + '/' + file);
         *         } else {
         *           res.send(403, 'Sorry! you cant see that.');
         *         }
         *       });
         *     });
         *
         * @api public
         */
    native public void sendFile(String path);
    native public void sendFile(String path, Object options);
    native public void sendFile(String path, java.util.function.Function<Error,Object> fn);
    native public void sendFile(String path, Object options, java.util.function.Function<Error,Object> fn);
    /**
         * @deprecated Use sendFile instead.
         */
    native public void sendfile(String path);
    native public void sendfile(String path, Object options);
    native public void sendfile(String path, java.util.function.Function<Error,Object> fn);
    native public void sendfile(String path, Object options, java.util.function.Function<Error,Object> fn);
    /**
         * Transfer the file at the given `path` as an attachment.
         *
         * Optionally providing an alternate attachment `filename`,
         * and optional callback `fn(err)`. The callback is invoked
         * when the data transfer is complete, or when an error has
         * ocurred. Be sure to check `res.headerSent` if you plan to respond.
         *
         * This method uses `res.sendFile()`.
         */
    native public void download(String path);
    native public void download(String path, String filename);
    native public void download(String path, java.util.function.Function<Error,Object> fn);
    native public void download(String path, String filename, java.util.function.Function<Error,Object> fn);
    /**
         * Set _Content-Type_ response header with `type` through `mime.lookup()`
         * when it does not contain "/", or set the Content-Type to `type` otherwise.
         *
         * Examples:
         *
         *     res.type('.html');
         *     res.type('html');
         *     res.type('json');
         *     res.type('application/json');
         *     res.type('png');
         */
    native public Response contentType(String type);
    /**
         * Set _Content-Type_ response header with `type` through `mime.lookup()`
         * when it does not contain "/", or set the Content-Type to `type` otherwise.
         *
         * Examples:
         *
         *     res.type('.html');
         *     res.type('html');
         *     res.type('json');
         *     res.type('application/json');
         *     res.type('png');
         */
    native public Response type(String type);
    /**
         * Respond to the Acceptable formats using an `obj`
         * of mime-type callbacks.
         *
         * This method uses `req.accepted`, an array of
         * acceptable types ordered by their quality values.
         * When "Accept" is not present the _first_ callback
         * is invoked, otherwise the first match is used. When
         * no match is performed the server responds with
         * 406 "Not Acceptable".
         *
         * Content-Type is set for you, however if you choose
         * you may alter this within the callback using `res.type()`
         * or `res.set('Content-Type', ...)`.
         *
         *    res.format({
         *      'text/plain': function(){
         *        res.send('hey');
         *      },
         *
         *      'text/html': function(){
         *        res.send('<p>hey</p>');
         *      },
         *
         *      'appliation/json': function(){
         *        res.send({ message: 'hey' });
         *      }
         *    });
         *
         * In addition to canonicalized MIME types you may
         * also use extnames mapped to these types:
         *
         *    res.format({
         *      text: function(){
         *        res.send('hey');
         *      },
         *
         *      html: function(){
         *        res.send('<p>hey</p>');
         *      },
         *
         *      json: function(){
         *        res.send({ message: 'hey' });
         *      }
         *    });
         *
         * By default Express passes an `Error`
         * with a `.status` of 406 to `next(err)`
         * if a match is not made. If you provide
         * a `.default` callback it will be invoked
         * instead.
         */
    native public Response format(Object obj);
    /**
         * Set _Content-Disposition_ header to _attachment_ with optional `filename`.
         */
    native public Response attachment(String filename);
    /**
         * Set header `field` to `val`, or pass
         * an object of header fields.
         *
         * Examples:
         *
         *    res.set('Foo', ['bar', 'baz']);
         *    res.set('Accept', 'application/json');
         *    res.set({ Accept: 'text/plain', 'X-API-Key': 'tobi' });
         *
         * Aliased as `res.header()`.
         */
    native public Response set(Fields fields);
    native public Response set(String field, String value);
    native public Response header(Fields fields);
    native public Response header(String field, String value);
    /**
         * Get value for header `field`.
         */
    native public String get(String field);
    /**
         * Clear cookie `name`.
         */
    native public Response clearCookie(String name, CookieOptions options);
    /**
         * Set cookie `name` to `val`, with the given `options`.
         *
         * Options:
         *
         *    - `maxAge`   max-age in milliseconds, converted to `expires`
         *    - `signed`   sign the cookie
         *    - `path`     defaults to "/"
         *
         * Examples:
         *
         *    // "Remember Me" for 15 minutes
         *    res.cookie('rememberme', '1', { expires: new Date(Date.now() + 900000), httpOnly: true });
         *
         *    // save as above
         *    res.cookie('rememberme', '1', { maxAge: 900000, httpOnly: true })
         */
    native public Response cookie(String name, String val, CookieOptions options);
    /**
         * Set the location header to `url`.
         *
         * The given `url` can also be the name of a mapped url, for
         * example by default express supports "back" which redirects
         * to the _Referrer_ or _Referer_ headers or "/".
         *
         * Examples:
         *
         *    res.location('/foo/bar').;
         *    res.location('http://example.com');
         *    res.location('../login'); // /blog/post/1 -> /blog/login
         *
         * Mounting:
         *
         *   When an application is mounted and `res.location()`
         *   is given a path that does _not_ lead with "/" it becomes
         *   relative to the mount-point. For example if the application
         *   is mounted at "/blog", the following would become "/blog/login".
         *
         *      res.location('login');
         *
         *   While the leading slash would result in a location of "/login":
         *
         *      res.location('/login');
         */
    native public Response location(String url);
    /**
         * Redirect to the given `url` with optional response `status`
         * defaulting to 302.
         *
         * The resulting `url` is determined by `res.location()`, so
         * it will play nicely with mounted apps, relative paths,
         * `"back"` etc.
         *
         * Examples:
         *
         *    res.redirect('/foo/bar');
         *    res.redirect('http://example.com');
         *    res.redirect(301, 'http://example.com');
         *    res.redirect('http://example.com', 301);
         *    res.redirect('../login'); // /blog/post/1 -> /blog/login
         */
    native public void redirect(String url);
    native public void redirect(double status, String url);
    native public void redirect(String url, double status);
    /**
         * Render `view` with the given `options` and optional callback `fn`.
         * When a callback function is given a response will _not_ be made
         * automatically, otherwise a response of _200_ and _text/html_ is given.
         *
         * Options:
         *
         *  - `cache`     boolean hinting to the engine it should cache
         *  - `filename`  filename of the view being rendered
         */
    native public void render(String view, Locals locals, java.util.function.BiConsumer<Error,String> callback);
    native public void render(String view, java.util.function.BiConsumer<Error,String> callback);
    /**
         * Adds the field to the Vary response header, if it is not there already.
         * Examples:
         *
         *     res.vary('User-Agent').render('docs');
         *
         */
    native public Response vary(String field);
    /** This is an automatically generated object type (see the source definition). */
    @jsweet.lang.ObjectType
    public static class Fields extends def.js.Object {
        native public java.lang.String $get(String field);
    }
    /** This is an automatically generated object type (see the source definition). */
    @jsweet.lang.ObjectType
    public static class Locals extends def.js.Object {
        native public java.lang.Object $get(String local);
    }
    /**
         * Set _Content-Disposition_ header to _attachment_ with optional `filename`.
         */
    native public Response attachment();
    /**
         * Clear cookie `name`.
         */
    native public Response clearCookie(String name);
    /**
         * Set cookie `name` to `val`, with the given `options`.
         *
         * Options:
         *
         *    - `maxAge`   max-age in milliseconds, converted to `expires`
         *    - `signed`   sign the cookie
         *    - `path`     defaults to "/"
         *
         * Examples:
         *
         *    // "Remember Me" for 15 minutes
         *    res.cookie('rememberme', '1', { expires: new Date(Date.now() + 900000), httpOnly: true });
         *
         *    // save as above
         *    res.cookie('rememberme', '1', { maxAge: 900000, httpOnly: true })
         */
    native public Response cookie(String name, String val);
    /**
         * Render `view` with the given `options` and optional callback `fn`.
         * When a callback function is given a response will _not_ be made
         * automatically, otherwise a response of _200_ and _text/html_ is given.
         *
         * Options:
         *
         *  - `cache`     boolean hinting to the engine it should cache
         *  - `filename`  filename of the view being rendered
         */
    native public void render(String view, Locals locals);
    /**
         * Render `view` with the given `options` and optional callback `fn`.
         * When a callback function is given a response will _not_ be made
         * automatically, otherwise a response of _200_ and _text/html_ is given.
         *
         * Options:
         *
         *  - `cache`     boolean hinting to the engine it should cache
         *  - `filename`  filename of the view being rendered
         */
    native public void render(String view);
    native public void sendFile(String path, java.util.function.Supplier<Object> fn);
    native public void sendFile(String path, Object options, java.util.function.Supplier<Object> fn);
    native public void sendfile(String path, java.util.function.Supplier<Object> fn);
    native public void sendfile(String path, Object options, java.util.function.Supplier<Object> fn);
    native public void download(String path, java.util.function.Supplier<Object> fn);
    native public void download(String path, String filename, java.util.function.Supplier<Object> fn);
    /**
         * Render `view` with the given `options` and optional callback `fn`.
         * When a callback function is given a response will _not_ be made
         * automatically, otherwise a response of _200_ and _text/html_ is given.
         *
         * Options:
         *
         *  - `cache`     boolean hinting to the engine it should cache
         *  - `filename`  filename of the view being rendered
         */
    native public void render(String view, Locals locals, java.util.function.Consumer<Error> callback);
    /**
         * Send a response.
         *
         * Examples:
         *
         *     res.send(new Buffer('wahoo'));
         *     res.send({ some: 'json' });
         *     res.send('<p>some html</p>');
         *     res.send(404, 'Sorry, cant find that');
         *     res.send(404);
         */
    native public Response send(Buffer body);
    /**
         * Set cookie `name` to `val`, with the given `options`.
         *
         * Options:
         *
         *    - `maxAge`   max-age in milliseconds, converted to `expires`
         *    - `signed`   sign the cookie
         *    - `path`     defaults to "/"
         *
         * Examples:
         *
         *    // "Remember Me" for 15 minutes
         *    res.cookie('rememberme', '1', { expires: new Date(Date.now() + 900000), httpOnly: true });
         *
         *    // save as above
         *    res.cookie('rememberme', '1', { maxAge: 900000, httpOnly: true })
         */
    native public Response cookie(String name, Object val, CookieOptions options);
    /**
         * Set cookie `name` to `val`, with the given `options`.
         *
         * Options:
         *
         *    - `maxAge`   max-age in milliseconds, converted to `expires`
         *    - `signed`   sign the cookie
         *    - `path`     defaults to "/"
         *
         * Examples:
         *
         *    // "Remember Me" for 15 minutes
         *    res.cookie('rememberme', '1', { expires: new Date(Date.now() + 900000), httpOnly: true });
         *
         *    // save as above
         *    res.cookie('rememberme', '1', { maxAge: 900000, httpOnly: true })
         */
    native public Response cookie(String name, Object val);
}

