package def.angular.router;

import jsweet.lang.Interface;
import jsweet.lang.Optional;

@Interface
public class Route {
	@Optional
	public String path;
	@Optional
	public Class<?> component;
}
