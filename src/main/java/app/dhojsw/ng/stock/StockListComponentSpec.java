package app.dhojsw.ng.stock;

import app.dhojsw.ng.AppRoutes;
import app.dhojsw.ng.PageNotFoundComponent;
import app.dhojsw.ng.command.CommandComponent;
import app.dhojsw.ng.my.MyComponent;
import app.dhojsw.ng.service.Logger;
import app.dhojsw.ng.util.ComponentUnitDescriber;
import app.dhojsw.ng.util.TestBedHelper;
import def.angular.common.Location;
import def.angular.common_http_testing.HttpClientTestingModule;
import def.angular.common_http_testing.HttpTestingController;
import def.angular.common_http_testing.RequestMatch;
import def.angular.common_http_testing.TestRequest;
import def.angular.core.DebugElement;
import def.angular.forms.FormsModule;
import def.angular.platform_browser.By;
import def.angular.router.Router;
import def.angular.router_testing.RouterTestingModule;
import def.js.JSON;

public class StockListComponentSpec extends ComponentUnitDescriber<StockListComponent> {

	public static class BeforeEach<T> implements Runnable {
		ComponentUnitDescriber<T> unit;

		public BeforeEach(ComponentUnitDescriber<T> unit) {
			this.unit = unit;
		}

		@SuppressWarnings("unchecked")
		@Override
		public void run() {

			TestBedHelper testBed = new TestBedHelper()//
					// see AppModule.java,except BrowserModule and RouterModule
					.imports(FormsModule.class, HttpClientTestingModule.class,
							RouterTestingModule.withRoutes(AppRoutes.getRoutes()))//
					.declarations(unit.compType, StockDetailComponent.class, CommandComponent.class, MyComponent.class,
							PageNotFoundComponent.class)//
					.providers(Logger.class)//
					.compileComponents();
			unit.httpMock = testBed.get(HttpTestingController.class);
			unit.fixture = testBed.createComponent(unit.compType);
			unit.de = unit.fixture.debugElement;
			unit.comp = (T) unit.de.componentInstance;
			unit.ne = unit.de.nativeElement;
			unit.router = testBed.get(Router.class);
			unit.location = testBed.get(Location.class);
		}

	};

	public StockListComponentSpec() {
		super(StockListComponent.class);
	}

	@Override
	public void run() {
		this.beforeEach(new BeforeEach<StockListComponent>(this));
		this.itFakeAsync("Test click refresh stock list.", () -> {
			expect(comp).toBeTruthy();
			String jsonS = ("{\r\n" + //
			"            'type': 'table',\r\n" + //
			"            'columnNames': ['corpId', 'corpName'],\r\n" + //
			"            'rowArray': [\r\n" + //
			"                ['000001', 'Name1'],\r\n" + //
			"                ['000002', 'Name2'],\r\n" + //
			"                ['000003', 'Name3'],\r\n" + //
			"                ['000004', 'Name4']\r\n" + //
			"            ]\r\n" + //
			"        }").replace('\'', '\"');
			Object response = JSON.parse(jsonS);

			expect(comp.responseArray.length).toEqual(0);
			{

				DebugElement button = fixture.debugElement.query(By.css("button"));
				boolean yes = true;

				button.triggerEventHandler("click", null);

				RequestMatch rm = new RequestMatch();
				rm.method = "POST";
				TestRequest req = httpMock.expectOne(rm);

				req.flush(response);

				fixture.detectChanges();
				tick();
				expect(comp.responseArray.length).toEqual(1);

				fixture.detectChanges();

			}
			{
				router.navigate(new Object[] {"/stockDetail/000001"});				
				tick(50);
				expect(location.path()).toBe("/stockDetail/000001");						
				
			}
			{
				//DebugElement archor = fixture.debugElement.query(By.css("a"));
				//archor.triggerEventHandler("click", null);
				//tick();
			}

		});
	}

	public static void main(String[] args) {
		new StockListComponentSpec().describe();
	}
}
