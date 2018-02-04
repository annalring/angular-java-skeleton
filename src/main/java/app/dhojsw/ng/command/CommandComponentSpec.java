package app.dhojsw.ng.command;

import app.dhojsw.ng.service.Logger;
import app.dhojsw.ng.util.ComponentUnitDescriber;
import app.dhojsw.ng.util.TestBedHelper;
import app.dhojsw.util.JasmineDescriber;
import def.angular.common_http_testing.HttpClientTestingModule;
import def.angular.common_http_testing.HttpTestingController;
import def.angular.common_http_testing.RequestMatch;
import def.angular.common_http_testing.TestRequest;
import def.angular.core.DebugElement;
import def.angular.forms.FormsModule;
import def.angular.platform_browser.By;
import def.dom.Element;
import def.js.JSON;

public class CommandComponentSpec {

	public static class FirstDescribeContext extends ComponentUnitDescriber<CommandComponent> {

		public FirstDescribeContext(String desc) {
			super(desc, CommandComponent.class);
		}

		@Override
		public void run() {
			beforeEach(() -> {

				TestBedHelper testBed = new TestBedHelper()//
						.imports(FormsModule.class, HttpClientTestingModule.class)//
						.declarations(CommandComponent.class)//
						.providers(Logger.class)//
						.compileComponents();

				httpMock = testBed.get(HttpTestingController.class);
				fixture = testBed.createComponent(CommandComponent.class);
				de = fixture.debugElement;
				comp = (CommandComponent) de.componentInstance;
				ne = de.nativeElement;

			});
			it("1.1.Should create the command", async(() -> {
				expect(comp).toBeTruthy();
			}));
			it("1.2.Title check", async(() -> {
				Element compiled = fixture.debugElement.nativeElement;
				it("Title should not be binded until fixture.detectChanges()", (done) -> {
					expect(compiled.querySelector("h1").textContent).toEqual("");
				});
				fixture.detectChanges();
				expect(compiled.querySelector("h1").textContent).toContain(comp.title);
			}));

			it("1.3.Response Processing", fakeAsync(() -> {
				String jsonS = ("{\r\n" + //
				"            'type': 'table',\r\n" + //
				"            'columnNames': ['corpId', 'corpName', 'highLight', 'ProfitMargin', 'AssetTurnover', 'EquityMultiplier'],\r\n"
						+ //
				"            'rowArray': [\r\n" + //
				"                ['000001', 'Name1', false, 0.01, 0.11, 1.1],\r\n" + //
				"                ['000002', 'Name2', true, 0.02, 0.12, 1.2],\r\n" + //
				"                ['000003', 'Name3', false, 0.03, 0.13, 1.3],\r\n" + //
				"                ['000004', 'Name4', false, 0.04, 0.14, 1.4]\r\n" + //
				"            ]\r\n" + //
				"        }").replace('\'', '\"');
				Object response = JSON.parse(jsonS);

				expect(comp.responseArray.length).toEqual(0);
				{
					comp.command = "dupont -r -c 000001 -y 2016 -f 0.01";
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

			}));
		}

	}

	public static void main(String[] args) {

		new FirstDescribeContext("Command Component Test1").describe();
		new JasmineDescriber("Command Component Test2").describe();

	}
}
