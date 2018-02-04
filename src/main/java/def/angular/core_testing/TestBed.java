package def.angular.core_testing;

public abstract class TestBed {
	public static native TestBed compileComponents();

	public static native TestBed configureTestingModule(TestModuleMetadata meta);
	
	public static native <T> T get(Class<T> cls);
	
	public static native <T> ComponentFixture<T> createComponent(Class<T> cls);
}
