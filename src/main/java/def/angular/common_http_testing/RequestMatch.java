package def.angular.common_http_testing;

import jsweet.lang.Interface;
import jsweet.lang.Optional;

@Interface
public class RequestMatch {
	@Optional
	public String method;
	@Optional
	public String url;
}
