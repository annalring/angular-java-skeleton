package def.angular.core_testing;

import jsweet.lang.ObjectType;
import jsweet.lang.Optional;

/**
 * @author wu
 *
 */
@ObjectType
public class TestModuleMetadata {
	@Optional
	public Object[] imports;//Type or ModuleWithProviders
	@Optional
	public Class<?>[] declarations;
	@Optional
	public Class<?>[] providers;
	
}
