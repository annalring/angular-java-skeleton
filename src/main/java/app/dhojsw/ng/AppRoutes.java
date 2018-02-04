package app.dhojsw.ng;

import app.dhojsw.ng.command.CommandComponent;
import app.dhojsw.ng.my.MyComponent;
import app.dhojsw.ng.stock.StockDetailComponent;
import app.dhojsw.ng.stock.StockListComponent;
import def.angular.router.Route;
import jsweet.lang.Array;

public class AppRoutes {

	public static boolean initialized;
	public static Array<Route> routes = new Array<>();

	public static Array<Route> getRoutes() {
		if (!initialized) {
			push(routes, "stockList", StockListComponent.class);
			push(routes, "stockDetail/:id", StockDetailComponent.class);
			push(routes, "command", CommandComponent.class);
			push(routes, "my", MyComponent.class);
			push(routes, "**", PageNotFoundComponent.class);
			initialized = true;
		}
		return routes;
	}

	public static void push(Array<Route> routes, String path, Class<?> component) {
		Route r = new Route();
		r.component = component;
		r.path = path;
		routes.push(r);
	}
}
