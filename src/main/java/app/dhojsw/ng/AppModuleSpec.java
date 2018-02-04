package app.dhojsw.ng;

import static def.jasmine.Globals.describe;
import static def.jasmine.Globals.it;

import app.dhojsw.ng.command.CommandComponent;
import app.dhojsw.ng.service.Logger;
import def.angular.common_http_testing.HttpClientTestingModule;
import def.angular.core_testing.TestBed;
import def.angular.core_testing.TestModuleMetadata;
import def.angular.forms.FormsModule;

public class AppModuleSpec {
	public static void main(String[] args) {

		describe("App Module Test1", () -> {
			it("1.1", (done) -> {
				
				TestModuleMetadata meta = new TestModuleMetadata();				
				meta.imports = new Class<?>[] { FormsModule.class, HttpClientTestingModule.class };
				meta.declarations = new Class<?>[] { CommandComponent.class };
				meta.providers = new Class[] { Logger.class };
				TestBed.configureTestingModule(meta);
				TestBed.compileComponents();
								
				done.$apply();
			});

		});
	}
}
