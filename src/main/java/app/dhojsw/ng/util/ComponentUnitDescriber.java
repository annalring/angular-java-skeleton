package app.dhojsw.ng.util;

import app.dhojsw.ng.service.Logger;
import def.angular.common.Location;
import def.angular.common_http_testing.HttpClientTestingModule;
import def.angular.common_http_testing.HttpTestingController;
import def.angular.core.DebugElement;
import def.angular.core_testing.ComponentFixture;
import def.angular.forms.FormsModule;
import def.angular.router.Router;
import def.dom.Element;

public class ComponentUnitDescriber<C> extends AngularUnitDescriber {
	public HttpTestingController httpMock;

	public C comp;

	public ComponentFixture<C> fixture;

	public DebugElement de;

	public Element ne;

	public Class<C> compType;
	
	public Router router;
	
	public Location location;

	public ComponentUnitDescriber(Class<C> compType) {
		super();
		this.compType = compType;
	}

	public ComponentUnitDescriber(String desc, Class<C> compType) {
		super(desc);
		this.compType = compType;
	}

	public static class BeforeEach<T> implements Runnable {
		ComponentUnitDescriber<T> unit;

		public BeforeEach(ComponentUnitDescriber<T> unit) {
			this.unit = unit;
		}

		@SuppressWarnings("unchecked")
		@Override
		public void run() {
			TestBedHelper testBed = new TestBedHelper()//
					//see AppModule.java,except BrowserModule and RouterModule
					.imports(FormsModule.class, HttpClientTestingModule.class)//
					.declarations(unit.compType)//
					.providers(Logger.class)//
					.compileComponents();

			unit.httpMock = testBed.get(HttpTestingController.class);
			unit.fixture = testBed.createComponent(unit.compType);
			unit.de = unit.fixture.debugElement;
			unit.comp = (T) unit.de.componentInstance;
			unit.ne = unit.de.nativeElement;
		}

	};
	
}
