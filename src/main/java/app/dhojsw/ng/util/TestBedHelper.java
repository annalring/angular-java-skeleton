package app.dhojsw.ng.util;

import def.angular.core_testing.ComponentFixture;
import def.angular.core_testing.TestBed;
import def.angular.core_testing.TestModuleMetadata;

/**
 * Usage by example:<br>
 * <code>
 * 
 * TestBedHelper testBed = new TestBedHelper()
 *    	.imports(FormsModule.class, HttpClientTestingModule.class)
 *		.declarations(CommandComponent.class)
 *		.providers(Logger.class)
 *		.compileComponents();
 * HttpTestingController httpMock = testBed.get(HttpTestingController.class);
 * ComponentFixture<CommandComponent> fixture = testBed.createComponent(CommandComponent.class);
 * 
 * </code>
 * 
 * @author Wu
 *
 */
public class TestBedHelper {
	TestModuleMetadata meta = new TestModuleMetadata();

	public TestBedHelper imports(Object ... cls) {
		meta.imports = cls;
		return this;
	}

	public TestBedHelper declarations(Class<?>... cls) {
		meta.declarations = cls;
		return this;
	}

	public TestBedHelper providers(Class<?>... cls) {
		meta.providers = cls;
		return this;
	}

	public TestBedHelper compileComponents() {

		TestBed.configureTestingModule(meta);
		TestBed.compileComponents();
		return this;
	}

	public <T> T get(Class<T> class1) {
		//
		return TestBed.get(class1);
	}

	public <T> ComponentFixture<T> createComponent(Class<T> class1) {
		//
		return TestBed.createComponent(class1);
	}

}
