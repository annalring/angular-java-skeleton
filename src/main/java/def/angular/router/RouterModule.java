package def.angular.router;

import def.angular.core.ModuleWithProviders;
import jsweet.lang.Array;

public class RouterModule {
	
	public static native ModuleWithProviders forRoot(Array<Route> routes);
	
}
